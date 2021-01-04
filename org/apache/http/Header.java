package org.apache.http;
@Deprecated
/* loaded from: classes6.dex */
public interface Header {
    HeaderElement[] getElements() throws ParseException;

    String getName();

    String getValue();
}
