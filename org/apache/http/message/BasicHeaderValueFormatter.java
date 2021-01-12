package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes5.dex */
public class BasicHeaderValueFormatter implements HeaderValueFormatter {
    public static final BasicHeaderValueFormatter DEFAULT = null;
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    public BasicHeaderValueFormatter() {
        throw new RuntimeException("Stub!");
    }

    public static final String formatElements(HeaderElement[] headerElementArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer charArrayBuffer, HeaderElement[] headerElementArr, boolean z) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateElementsLen(HeaderElement[] headerElementArr) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatHeaderElement(HeaderElement headerElement, boolean z, HeaderValueFormatter headerValueFormatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer charArrayBuffer, HeaderElement headerElement, boolean z) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateHeaderElementLen(HeaderElement headerElement) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatParameters(NameValuePair[] nameValuePairArr, boolean z, HeaderValueFormatter headerValueFormatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair[] nameValuePairArr, boolean z) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateParametersLen(NameValuePair[] nameValuePairArr) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatNameValuePair(NameValuePair nameValuePair, boolean z, HeaderValueFormatter headerValueFormatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer charArrayBuffer, NameValuePair nameValuePair, boolean z) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateNameValuePairLen(NameValuePair nameValuePair) {
        throw new RuntimeException("Stub!");
    }

    protected void doFormatValue(CharArrayBuffer charArrayBuffer, String str, boolean z) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isSeparator(char c) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isUnsafe(char c) {
        throw new RuntimeException("Stub!");
    }
}
