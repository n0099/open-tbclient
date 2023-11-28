package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
/* loaded from: classes10.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    public final BufferedOutputStream ahR;
    public final RandomAccessFile ahS;
    public final FileDescriptor fd;

    public b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.ahS = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.ahR = new BufferedOutputStream(new FileOutputStream(this.ahS.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j) {
        this.ahS.seek(j);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j) {
        this.ahS.setLength(j);
    }

    /* loaded from: classes10.dex */
    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.ahR.close();
        this.ahS.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void wy() {
        this.ahR.flush();
        this.fd.sync();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i, int i2) {
        this.ahR.write(bArr, 0, i2);
    }
}
