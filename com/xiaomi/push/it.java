package com.xiaomi.push;

import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public class it extends ByteArrayOutputStream {
    public it() {
    }

    public it(int i) {
        super(i);
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m497a() {
        return ((ByteArrayOutputStream) this).buf;
    }
}
