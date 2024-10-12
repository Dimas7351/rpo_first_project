install:
	mvn clean install

run:
	mvn exec:java -Dexec.mainClass="com.misis.rpo.Main" -Dexec.args=""
