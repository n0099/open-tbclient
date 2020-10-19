package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hq;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f5084a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(Context context, hq hqVar) {
        this.f5084a = context;
        this.f897a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        synchronized (bj.f5083a) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                File file = new File(this.f5084a.getFilesDir(), "tiny_data.lock");
                com.xiaomi.push.y.m591a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    bj.c(this.f5084a, this.f897a);
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
