package org.apache.http;

import java.util.Iterator;
@Deprecated
/* loaded from: classes9.dex */
public interface HeaderIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    Header nextHeader();
}
