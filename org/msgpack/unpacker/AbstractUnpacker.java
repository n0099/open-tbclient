package org.msgpack.unpacker;

import org.msgpack.packer.Unconverter;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public abstract class AbstractUnpacker implements k {

    /* renamed from: a  reason: collision with root package name */
    protected org.msgpack.a f2952a;
    protected int b = 134217728;
    protected int c = 4194304;
    protected int d = 2097152;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(Unconverter unconverter);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractUnpacker(org.msgpack.a aVar) {
        this.f2952a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: a */
    public l iterator() {
        return new l(this);
    }

    @Override // org.msgpack.unpacker.k
    public r b() {
        Unconverter unconverter = new Unconverter(this.f2952a);
        a(unconverter);
        return unconverter.c();
    }
}
