log = new File(basedir, 'build.log')
latin1Pom = new File(basedir, 'latin1-pom.xml')
backup = new File(basedir, 'latin1-pom.xml.bak')

assert log.exists()
assert log.text.contains('Could not read pom file ' + latin1Pom.absolutePath + ' with encoding UTF-8. Please set the encoding parameter to match the pom file')
assert log.text.contains('[INFO] BUILD FAILURE')
assert latin1Pom.getText('ISO-8859-1').contains('<name>M\u00fcller</name>')
assert !backup.exists()

return true
