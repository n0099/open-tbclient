package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hq;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f8547a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hq f896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(Context context, hq hqVar) {
        this.f8547a = context;
        this.f896a = hqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        synchronized (bj.f8546a) {
            try {
                File file = new File(this.f8547a.getFilesDir(), "tiny_data.lock");
                com.xiaomi.push.y.m594a(file);
                randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        try {
                            bj.c(this.f8547a, this.f896a);
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
                    } catch (Throwable th) {
                        th = th;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                com.xiaomi.channel.commonutils.logger.b.a(e4);
                            }
                        }
                        com.xiaomi.push.y.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileLock = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileLock = null;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    com.xiaomi.push.y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileLock = null;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
                randomAccessFile = null;
            }
        }
    }
}
