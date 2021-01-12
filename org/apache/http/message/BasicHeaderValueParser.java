package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;
@Deprecated
/* loaded from: classes5.dex */
public class BasicHeaderValueParser implements HeaderValueParser {
    public static final BasicHeaderValueParser DEFAULT = null;

    public BasicHeaderValueParser() {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement[] parseElements(String str, HeaderValueParser headerValueParser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement parseHeaderElement(String str, HeaderValueParser headerValueParser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    protected HeaderElement createHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair[] parseParameters(String str, HeaderValueParser headerValueParser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair parseNameValuePair(String str, HeaderValueParser headerValueParser) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        throw new RuntimeException("Stub!");
    }

    protected NameValuePair createNameValuePair(String str, String str2) {
        throw new RuntimeException("Stub!");
    }
}
