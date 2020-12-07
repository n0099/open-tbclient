package org.apache.http;
@Deprecated
/* loaded from: classes11.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException;
}
