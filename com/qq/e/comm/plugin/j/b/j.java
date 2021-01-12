package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
class j extends a {
    private final long e;

    public j(InputStream inputStream, long j, File file, c cVar) {
        super(inputStream, file, cVar);
        this.e = j;
    }

    @Override // com.qq.e.comm.plugin.j.b.a
    public int a() {
        if (this.e <= 0) {
            return 0;
        }
        return super.a();
    }

    @Override // com.qq.e.comm.plugin.j.b.a
    protected int a(FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = this.e;
        this.c.a(this.f12157b.length());
        while (j > 0) {
            int read = this.f12156a.read(bArr, 0, (int) Math.min(j, bArr.length));
            if (read <= 0) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
            this.c.a(this.f12157b.length());
            j -= read;
        }
        if (j != 0) {
            this.d = "NetworkErrInputStreamDoesNotSupportEnoughBytesAsExpected ";
            return 4194304;
        }
        return 0;
    }
}
