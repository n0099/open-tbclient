package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes9.dex */
public abstract class AbstractMessageParser implements HttpMessageParser {
    protected final LineParser lineParser;

    protected abstract HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.HttpMessageParser
    public HttpMessage parse() throws IOException, HttpException {
        throw new RuntimeException("Stub!");
    }
}
