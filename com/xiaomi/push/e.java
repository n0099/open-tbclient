package com.xiaomi.push;

import java.io.IOException;
/* loaded from: classes18.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i, int i2) {
        try {
            b a2 = b.a(bArr, i, i2);
            a(a2);
            a2.m142a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract void a(c cVar);

    /* renamed from: a  reason: collision with other method in class */
    public void m228a(byte[] bArr, int i, int i2) {
        try {
            c a2 = c.a(bArr, i, i2);
            a(a2);
            a2.b();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(b bVar, int i) {
        return bVar.m144a(i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m229a() {
        byte[] bArr = new byte[b()];
        m228a(bArr, 0, bArr.length);
        return bArr;
    }

    public abstract int b();
}
