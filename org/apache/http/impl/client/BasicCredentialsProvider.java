package org.apache.http.impl.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
@Deprecated
/* loaded from: classes20.dex */
public class BasicCredentialsProvider implements CredentialsProvider {
    public BasicCredentialsProvider() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CredentialsProvider
    public synchronized void setCredentials(AuthScope authScope, Credentials credentials) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CredentialsProvider
    public synchronized Credentials getCredentials(AuthScope authScope) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CredentialsProvider
    public synchronized void clear() {
        throw new RuntimeException("Stub!");
    }
}
