package org.msgpack;

import java.lang.reflect.Type;
import org.msgpack.packer.BufferPacker;
import org.msgpack.packer.MessagePackBufferPacker;
import org.msgpack.template.d;
import org.msgpack.template.e;
import org.msgpack.type.r;
import org.msgpack.unpacker.BufferUnpacker;
import org.msgpack.unpacker.MessagePackBufferUnpacker;
/* loaded from: classes.dex */
public class a {
    private static final a b = new a();

    /* renamed from: a  reason: collision with root package name */
    private e f2873a = new e(null);

    public BufferPacker a() {
        return new MessagePackBufferPacker(this);
    }

    public BufferUnpacker b() {
        return new MessagePackBufferUnpacker(this);
    }

    public BufferUnpacker a(byte[] bArr, int i, int i2) {
        return b().a(bArr, i, i2);
    }

    public <T> byte[] a(T t) {
        BufferPacker a2 = a();
        if (t == null) {
            a2.d();
        } else {
            this.f2873a.a((Type) t.getClass()).a(a2, t);
        }
        return a2.c();
    }

    public r b(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2).b();
    }

    public <T> d<T> a(Class<T> cls) {
        return this.f2873a.a((Type) cls);
    }
}
