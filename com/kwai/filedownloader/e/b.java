package com.kwai.filedownloader.e;

import com.kwai.filedownloader.f.c;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
/* loaded from: classes3.dex */
public class b implements com.kwai.filedownloader.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedOutputStream f7205a;
    private final FileDescriptor b;
    private final RandomAccessFile c;

    /* loaded from: classes3.dex */
    public static class a implements c.e {
        @Override // com.kwai.filedownloader.f.c.e
        public com.kwai.filedownloader.e.a a(File file) {
            return new b(file);
        }

        @Override // com.kwai.filedownloader.f.c.e
        public boolean a() {
            return true;
        }
    }

    b(File file) {
        this.c = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
        this.b = this.c.getFD();
        this.f7205a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
    }

    @Override // com.kwai.filedownloader.e.a
    public void a() {
        this.f7205a.flush();
        this.b.sync();
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(long j) {
        this.c.seek(j);
    }

    @Override // com.kwai.filedownloader.e.a
    public void a(byte[] bArr, int i, int i2) {
        this.f7205a.write(bArr, i, i2);
    }

    @Override // com.kwai.filedownloader.e.a
    public void b() {
        this.f7205a.close();
        this.c.close();
    }

    @Override // com.kwai.filedownloader.e.a
    public void b(long j) {
        this.c.setLength(j);
    }
}
