package com.xiaomi.push;

import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class ja extends ByteArrayOutputStream {
    public ja() {
    }

    public ja(int i) {
        super(i);
    }

    public int a() {
        return this.count;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m479a() {
        return this.buf;
    }
}
