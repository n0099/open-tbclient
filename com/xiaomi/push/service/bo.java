package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hj;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes7.dex */
public final class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f38185a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hj f939a;

    public bo(Context context, hj hjVar) {
        this.f38185a = context;
        this.f939a = hjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        synchronized (bn.f38184a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(this.f38185a.getFilesDir(), "tiny_data.lock");
                    com.xiaomi.push.y.m630a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            bn.c(this.f38185a, this.f939a);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                }
                            }
                            com.xiaomi.push.y.a(randomAccessFile);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        com.xiaomi.push.y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                com.xiaomi.push.y.a(randomAccessFile);
                throw th;
            }
            com.xiaomi.push.y.a(randomAccessFile);
        }
    }
}
