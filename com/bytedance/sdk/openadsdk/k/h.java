package com.bytedance.sdk.openadsdk.k;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final RandomAccessFile f29578a;

    /* loaded from: classes6.dex */
    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public h(File file, String str) throws a {
        try {
            this.f29578a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e2) {
            throw new a(e2);
        }
    }

    public void a(long j) throws a {
        try {
            this.f29578a.seek(j);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public void a(byte[] bArr, int i2, int i3) throws a {
        try {
            this.f29578a.write(bArr, i2, i3);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public int a(byte[] bArr) throws a {
        try {
            return this.f29578a.read(bArr);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public void a() {
        com.bytedance.sdk.openadsdk.k.g.d.a(this.f29578a);
    }
}
