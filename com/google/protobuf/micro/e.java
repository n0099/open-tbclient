package com.google.protobuf.micro;

import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public e a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public abstract void a(c cVar);

    public void a(byte[] bArr, int i, int i2) {
        try {
            c m = c.m(bArr, i, i2);
            a(m);
            m.c();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(b bVar, int i) {
        return bVar.b(i);
    }

    public abstract int b();

    public e b(byte[] bArr, int i, int i2) {
        try {
            b l = b.l(bArr, i, i2);
            a(l);
            l.a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public byte[] c() {
        byte[] bArr = new byte[b()];
        a(bArr, 0, bArr.length);
        return bArr;
    }
}
