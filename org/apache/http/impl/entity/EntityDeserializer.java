package org.apache.http.impl.entity;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionInputBuffer;
@Deprecated
/* loaded from: classes7.dex */
public class EntityDeserializer {
    public EntityDeserializer(ContentLengthStrategy contentLengthStrategy) {
        throw new RuntimeException("Stub!");
    }

    public HttpEntity deserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntity doDeserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
