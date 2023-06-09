# kafka

## References
* https://kafka.apache.org/quickstart


## Running Kafka Server Locally
### Get Kafka
The initial directory is the docs/ directory when running this in the IntelliJ terminal
```zsh
pwd
KAFKA_HOME="$(pwd)/kafka_2.13-3.4.0"
curl https://dlcdn.apache.org/kafka/3.4.0/kafka_2.13-3.4.0.tgz -o kafka_2.13-3.4.0.tgz
tar -xzf kafka_2.13-3.4.0.tgz
cd $KAFKA_HOME
ls -la
pwd
```

### See what's running on port 2181
```zsh
lsof -i:2181
```

### Start the ZooKeeper service
```zsh
cd kafka_2.13-3.4.0/
bin/zookeeper-server-start.sh config/zookeeper.properties
```

### List the contents of the zookeeper logs directory
```zsh
ls -la /tmp/zookeeper/
```

### See what's running on port 9092
```zsh
lsof -i:9092
```

### Start Kafka broker service
```zsh
cd kafka_2.13-3.4.0/
bin/kafka-server-start.sh config/server.properties
```

### List the contents of the kafka logs directory
```zsh
ls -la /tmp/kafka-logs/
```

### List Kafka topics
```zsh
cd kafka_2.13-3.4.0/
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

### Search the logs for a message
```zsh
grep -r 'message1' /tmp/kafka-logs/
grep -r 'message1' /tmp/zookeeper/
```

### Stop Kafka broker service
```zsh
cd kafka_2.13-3.4.0/
bin/kafka-server-stop.sh config/server.properties
```

### Delete the contents of the kafka logs directory
```zsh
rm -fr /tmp/kafka-logs/
```

### Stop Zookeeper
```zsh
cd kafka_2.13-3.4.0/
bin/zookeeper-server-stop.sh config/zookeeper.properties
```

### Delete the contents of the zookeeper logs directory
```zsh
rm -fr /tmp/zookeeper/
```

### Delete the local Kafka installation
The initial directory is the docs/ directory when running this in the IntelliJ terminal
```zsh
KAFKA_HOME="$(pwd)/kafka_2.13-3.4.0"
echo $KAFKA_HOME
ls -la $KAFKA_HOME
rm -fr $KAFKA_HOME
ls -la $KAFKA_HOME
```