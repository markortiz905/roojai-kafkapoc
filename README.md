
sample test curl command 
```shell
 curl -X POST -H "Content-Type: application/json" --verbose --data "{\"test\":{\"val\":\"3\"}}" http://localhost:9001/
```

Sure! In Kafka, a transaction is a sequence of operations that are executed as a single, atomic unit of work. A transaction may include producing messages to one or more topics, and consuming messages from one or more topics. Kafka transactions are supported starting from version 0.11.

Kafka transactions provide the following guarantees:

1. Atomicity: All operations in a transaction are executed as a single, atomic unit of work. Either all the operations in the transaction are completed successfully, or none of them are. This ensures that the state of the Kafka cluster remains consistent.

2. Durability: Once a transaction is committed, all the messages produced as part of the transaction are guaranteed to be persisted to disk and made available for consumption by the consumers.

3. Isolation: Transactions are isolated from each other, which means that the effects of one transaction are not visible to other transactions until the transaction is committed.

When using Kafka transactions, producers can enable the `transactional.id` configuration property to enable transactional support. Within a transaction, producers can use the `sendOffsetsToTransaction()` method to ensure that message offsets are committed to the transaction before the messages are actually produced. This ensures that messages are produced and committed to Kafka in the correct order, even if there are failures or retries.

Consumers can also participate in transactions by using the `isolation.level` configuration property to specify the level of isolation required for consuming messages from Kafka. When a consumer reads messages in `read_committed` isolation level, it only reads messages that have been committed by the producer transaction. This ensures that messages are consumed in the same order as they were produced by the producer transaction.

In summary, Kafka transactions provide a mechanism for atomic and durable transactions of Kafka messages. They also ensure that messages are produced and consumed in the correct order, which helps to maintain message ordering guarantees.
