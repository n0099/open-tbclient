package com.xiaomi.push;

import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i2, int i3) {
        try {
            b a2 = b.a(bArr, i2, i3);
            a(a2);
            a2.m148a(0);
            return this;
        } catch (d e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public void m266a(byte[] bArr, int i2, int i3) {
        try {
            c a2 = c.a(bArr, i2, i3);
            a(a2);
            a2.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(b bVar, int i2) {
        return bVar.m150a(i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m267a() {
        int b2 = b();
        byte[] bArr = new byte[b2];
        m266a(bArr, 0, b2);
        return bArr;
    }

    public abstract int b();
}
