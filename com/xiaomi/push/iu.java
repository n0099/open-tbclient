package com.xiaomi.push;

import java.io.ByteArrayOutputStream;
/* loaded from: classes3.dex */
public class iu extends ByteArrayOutputStream {
    public iu() {
    }

    public iu(int i) {
        super(i);
    }

    public int a() {
        return this.count;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m447a() {
        return this.buf;
    }
}
