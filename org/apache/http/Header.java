package org.apache.http;
@Deprecated
/* loaded from: classes5.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
