package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
@Deprecated
/* loaded from: classes20.dex */
public abstract class AbstractHttpEntity implements HttpEntity {
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractHttpEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(Header header) {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(String str) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(Header header) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(String str) {
        throw new RuntimeException("Stub!");
    }

    public void setChunked(boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException, UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }
}
