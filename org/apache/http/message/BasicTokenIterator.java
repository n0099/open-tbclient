package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
@Deprecated
/* loaded from: classes9.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    public String currentHeader;
    public String currentToken;
    public final HeaderIterator headerIt;
    public int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator) {
        throw new RuntimeException("Stub!");
    }

    public int findNext(int i) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    public int findTokenEnd(int i) {
        throw new RuntimeException("Stub!");
    }

    public int findTokenSeparator(int i) {
        throw new RuntimeException("Stub!");
    }

    public int findTokenStart(int i) {
        throw new RuntimeException("Stub!");
    }

    public boolean isHttpSeparator(char c) {
        throw new RuntimeException("Stub!");
    }

    public boolean isTokenChar(char c) {
        throw new RuntimeException("Stub!");
    }

    public boolean isTokenSeparator(char c) {
        throw new RuntimeException("Stub!");
    }

    public boolean isWhitespace(char c) {
        throw new RuntimeException("Stub!");
    }

    public String createToken(String str, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }
}
