package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
class k extends a {
    public k(InputStream inputStream, File file, c cVar) {
        super(inputStream, file, cVar);
    }

    @Override // com.qq.e.comm.plugin.j.b.a
    protected int a(FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[8192];
        this.c.a(this.f12456b.length());
        while (true) {
            int read = this.f12455a.read(bArr);
            if (read <= 0) {
                return 0;
            }
            fileOutputStream.write(bArr, 0, read);
            this.c.a(this.f12456b.length());
        }
    }
}
