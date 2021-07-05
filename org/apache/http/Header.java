package org.apache.http;
@Deprecated
/* loaded from: classes10.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
