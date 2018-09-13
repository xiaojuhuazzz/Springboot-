package com.example.spring06.log;

/*
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

import java.io.Serializable;

@Data
public class MongoAppender extends AbstractAppender {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<BasicDBObject> logsCollection;

    private String connectionUrl;
    private String databaseName;
    private String collectionName;
    /*
        定义MongoDB的配置参数，可通过log4j.properties配置：
        connectionUrl：连接mongodb的串
        databaseName：数据库名
        collectionName：集合名

        定义MongoDB的连接和操作对象，根据log4j.properties配置的参数初始化：
        mongoClient：mongodb的连接客户端
        mongoDatabase：记录日志的数据库
        logsCollection：记录日志的集合
     */
/*
    protected MongoAppender(final String name, final Filter filter, final Layout<? extends Serializable> layout,
                            final boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }
    /*
        重写append函数：
        根据log4j.properties中的配置创建mongodb连接
        LoggingEvent提供getMessage()函数来获取日志消息
        往配置的记录日志的collection中插入日志消息
    */
/*
    @Override
    public void append(LogEvent loggingEvent) {

        if (mongoDatabase == null) {
            MongoClientURI connectionString = new MongoClientURI(connectionUrl);
            mongoClient = new MongoClient(connectionString);
            mongoDatabase = mongoClient.getDatabase(databaseName);
            logsCollection = mongoDatabase.getCollection(collectionName, BasicDBObject.class);
        }

        logsCollection.insertOne((BasicDBObject) loggingEvent.getMessage());

    }
}
*/
