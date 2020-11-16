package org.apache.http;
@Deprecated
/* loaded from: classes12.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
