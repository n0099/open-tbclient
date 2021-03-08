package com.ss.android.socialbase.downloader.g;

import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes6.dex */
public class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private BufferedOutputStream f7837a;
    private FileDescriptor b;
    private RandomAccessFile c;

    public f(File file, int i) throws com.ss.android.socialbase.downloader.e.a {
        try {
            this.c = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            this.b = this.c.getFD();
            if (i > 0) {
                if (i < 8192) {
                    i = 8192;
                } else if (i > 131072) {
                    i = 131072;
                }
                this.f7837a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()), i);
                return;
            }
            this.f7837a = new BufferedOutputStream(new FileOutputStream(this.c.getFD()));
        } catch (IOException e) {
            throw new com.ss.android.socialbase.downloader.e.a(1039, e);
        }
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        this.f7837a.write(bArr, i, i2);
    }

    public void a() throws IOException {
        if (this.f7837a != null) {
            this.f7837a.flush();
        }
        if (this.b != null) {
            this.b.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.ss.android.socialbase.downloader.m.d.a(this.c, this.f7837a);
    }

    public void a(long j) throws IOException {
        this.c.seek(j);
    }

    public void b(long j) throws IOException {
        this.c.setLength(j);
    }
}
