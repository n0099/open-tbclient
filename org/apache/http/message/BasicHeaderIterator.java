package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
@Deprecated
/* loaded from: classes9.dex */
public class BasicHeaderIterator implements HeaderIterator {
    public final Header[] allHeaders = null;
    public int currentIndex;
    public String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        throw new RuntimeException("Stub!");
    }

    public boolean filterHeader(int i) {
        throw new RuntimeException("Stub!");
    }

    public int findNext(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }
}
