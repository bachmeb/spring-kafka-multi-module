# kafka

## References
* https://kafka.apache.org/quickstart


## Running Kafka Server Locally
### Get Kafka
The initial directory is the docs/ directory when running this in the IntelliJ terminal
```zsh
pwd
cd ..
PROJECT_HOME=`pwd`
echo $PROJECT_HOME
mkdir -p $PROJECT_HOME/kafka
cd $PROJECT_HOME/kafka
curl https://dlcdn.apache.org/kafka/3.4.0/kafka_2.13-3.4.0.tgz -o kafka_2.13-3.4.0.tgz
tar -xzf kafka_2.13-3.4.0.tgz
cd kafka_2.13-3.4.0
ls -la
pwd
```

### See what's running on port 2181
```zsh
lsof -i:2181
```

### Start the ZooKeeper service
```zsh
cd ..
PROJECT_HOME=`pwd`
cd $PROJECT_HOME/kafka/kafka_2.13-3.4.0/
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### See what's running on port 9092
```zsh
lsof -i:9092
```

### List the contents of the zookeeper logs directory
```zsh
ls -la /tmp/zookeeper/
```

### Start Kafka broker service
```zsh
cd ..
PROJECT_HOME=`pwd`
cd $PROJECT_HOME/kafka/kafka_2.13-3.4.0/
bin/kafka-server-start.sh config/server.properties
```

### List Kafka topics
```zsh
cd ..
PROJECT_HOME=`pwd`
cd $PROJECT_HOME/kafka/kafka_2.13-3.4.0/
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

### List the contents of the kafka logs directory
```zsh
ls -la /tmp/kafka-logs/
```

### Search the kafka logs for a message
```zsh
grep -r 'message1' /tmp/kafka-logs/
grep -r 'message1' /tmp/zookeeper/
```

### Stop Kafka broker service
```zsh
cd ..
PROJECT_HOME=`pwd`
cd $PROJECT_HOME/kafka/kafka_2.13-3.4.0/
bin/kafka-server-stop.sh config/server.properties
```

### Delete the contents of the kafka logs directory
```zsh
rm -fr /tmp/kafka-logs/
```

### Stop Zookeeper
```zsh
cd ..
PROJECT_HOME=`pwd`
cd $PROJECT_HOME/kafka/kafka_2.13-3.4.0/
bin/zookeeper-server-stop.sh config/zookeeper.properties
```

### Delete the contents of the zookeeper logs directory
```zsh
rm -fr /tmp/zookeeper/
```

### Delete the local Kafka installation
The initial directory is the docs/ directory when running this in the IntelliJ terminal
```zsh
pwd
cd ..
PROJECT_HOME=`pwd`
echo $PROJECT_HOME
ls -la $PROJECT_HOME/kafka
rm -fr $PROJECT_HOME/kafka
ls -la $PROJECT_HOME/kafka
```