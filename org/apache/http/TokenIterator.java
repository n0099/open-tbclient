package org.apache.http;

import java.util.Iterator;
@Deprecated
/* loaded from: classes12.dex */
public interface TokenIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    String nextToken();
}
