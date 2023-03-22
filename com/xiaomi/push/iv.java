package com.xiaomi.push;

import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class iv extends ByteArrayOutputStream {
    public iv() {
    }

    public iv(int i) {
        super(i);
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m611a() {
        return ((ByteArrayOutputStream) this).buf;
    }
}
