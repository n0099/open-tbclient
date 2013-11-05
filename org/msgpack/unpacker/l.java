package org.msgpack.unpacker;

import java.io.EOFException;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.msgpack.packer.Unconverter;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class l implements Iterator<r> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractUnpacker f2930a;
    private final Unconverter b;
    private IOException c;

    public l(AbstractUnpacker abstractUnpacker) {
        this.f2930a = abstractUnpacker;
        this.b = new Unconverter(abstractUnpacker.f2920a);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.b.c() != null) {
            return true;
        }
        try {
            this.f2930a.a(this.b);
            return this.b.c() != null;
        } catch (EOFException e) {
            return false;
        } catch (IOException e2) {
            this.c = e2;
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    /* renamed from: a */
    public r next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        r c = this.b.c();
        this.b.e();
        return c;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
