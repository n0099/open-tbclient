package com.bytedance.sdk.openadsdk.j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f7298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(File file, String str) throws a {
        try {
            this.f7298a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) throws a {
        try {
            this.f7298a.seek(j);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i, int i2) throws a {
        try {
            this.f7298a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(byte[] bArr) throws a {
        try {
            return this.f7298a.read(bArr);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        com.bytedance.sdk.openadsdk.j.g.d.a(this.f7298a);
    }

    /* loaded from: classes6.dex */
    static class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
