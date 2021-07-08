package org.apache.http;
@Deprecated
/* loaded from: classes9.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
