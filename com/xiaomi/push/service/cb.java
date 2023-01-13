package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.hn;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes8.dex */
public final class cb implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ hn f989a;

    public cb(Context context, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hnVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.f989a = hnVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0042 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0061 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x001f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable, java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    @Override // java.lang.Runnable
    public void run() {
        ?? r3;
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r3 = interceptable;
            if (r3.invokeV(1048576, this) != null) {
                return;
            }
        }
        synchronized (ca.a) {
            FileLock fileLock = null;
            r1 = null;
            FileLock fileLock2 = null;
            fileLock = null;
            try {
                try {
                    try {
                        File file = new File(this.a.getFilesDir(), "tiny_data.lock");
                        com.xiaomi.push.ab.m175a(file);
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            fileLock2 = randomAccessFile.getChannel().lock();
                            ca.c(this.a, this.f989a);
                            fileLock = fileLock2;
                            r3 = randomAccessFile;
                            if (fileLock2 != null) {
                                boolean isValid = fileLock2.isValid();
                                fileLock = fileLock2;
                                r3 = randomAccessFile;
                                if (isValid) {
                                    try {
                                        fileLock2.release();
                                        fileLock = fileLock2;
                                        r3 = randomAccessFile;
                                    } catch (IOException e) {
                                        com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                                        fileLock = e;
                                        r3 = randomAccessFile;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            fileLock = fileLock2;
                            r3 = randomAccessFile;
                            if (fileLock2 != null) {
                                boolean isValid2 = fileLock2.isValid();
                                fileLock = fileLock2;
                                r3 = randomAccessFile;
                                if (isValid2) {
                                    try {
                                        fileLock2.release();
                                        fileLock = fileLock2;
                                        r3 = randomAccessFile;
                                    } catch (IOException e3) {
                                        com.xiaomi.channel.commonutils.logger.b.a((Throwable) e3);
                                        fileLock = e3;
                                        r3 = randomAccessFile;
                                    }
                                }
                            }
                            com.xiaomi.push.ab.a((Closeable) r3);
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
                        com.xiaomi.push.ab.a((Closeable) r3);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    r3 = 0;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    com.xiaomi.push.ab.a((Closeable) r3);
                    throw th;
                }
                com.xiaomi.push.ab.a((Closeable) r3);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
