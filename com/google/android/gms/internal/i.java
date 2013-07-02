package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class i implements Iterator {
    private final DataBuffer a;
    private int b = -1;

    public i(DataBuffer dataBuffer) {
        this.a = (DataBuffer) x.a(dataBuffer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.a() + (-1);
    }

    @Override // java.util.Iterator
    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.a;
            int i = this.b + 1;
            this.b = i;
            return dataBuffer.b(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.b);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
