package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hk;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bg implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(Context context, hk hkVar) {
        this.a = context;
        this.f898a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        synchronized (bf.a) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                com.xiaomi.push.y.m568a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    bf.c(this.a, this.f898a);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e) {
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                        }
                    }
                    com.xiaomi.push.y.a(randomAccessFile);
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
                    com.xiaomi.push.y.a(randomAccessFile);
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
                com.xiaomi.push.y.a(randomAccessFile);
                throw th;
            }
        }
    }
}
