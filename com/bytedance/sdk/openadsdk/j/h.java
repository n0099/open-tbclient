package com.bytedance.sdk.openadsdk.j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f7296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(File file, String str) throws a {
        try {
            this.f7296a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) throws a {
        try {
            this.f7296a.seek(j);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr, int i, int i2) throws a {
        try {
            this.f7296a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(byte[] bArr) throws a {
        try {
            return this.f7296a.read(bArr);
        } catch (IOException e) {
            throw new a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        com.bytedance.sdk.openadsdk.j.g.d.a(this.f7296a);
    }

    /* loaded from: classes4.dex */
    static class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
