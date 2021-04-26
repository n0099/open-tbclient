package org.apache.http;

import java.util.Locale;
@Deprecated
/* loaded from: classes7.dex */
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity httpEntity);

    void setLocale(Locale locale);

    void setReasonPhrase(String str) throws IllegalStateException;

    void setStatusCode(int i2) throws IllegalStateException;

    void setStatusLine(ProtocolVersion protocolVersion, int i2);

    void setStatusLine(ProtocolVersion protocolVersion, int i2, String str);

    void setStatusLine(StatusLine statusLine);
}
