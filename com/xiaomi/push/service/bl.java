package com.xiaomi.push.service;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class bl implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ com.xiaomi.xmpush.thrift.f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(Context context, com.xiaomi.xmpush.thrift.f fVar) {
        this.a = context;
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        synchronized (bk.a) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                com.xiaomi.channel.commonutils.file.b.c(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    bk.c(this.a, this.b);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                } catch (Exception e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                        }
                    }
                    com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                    }
                }
                com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                throw th;
            }
        }
    }
}
