package com.xiaomi.push;

import java.io.IOException;
/* loaded from: classes8.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i, int i2) {
        try {
            b a = b.a(bArr, i, i2);
            a(a);
            a.m194a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public void m366a(byte[] bArr, int i, int i2) {
        try {
            c a = c.a(bArr, i, i2);
            a(a);
            a.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(b bVar, int i) {
        return bVar.m196a(i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m367a() {
        int b = b();
        byte[] bArr = new byte[b];
        m366a(bArr, 0, b);
        return bArr;
    }

    public abstract int b();
}
