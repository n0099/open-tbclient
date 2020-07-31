package org.apache.http;
@Deprecated
/* loaded from: classes20.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
