package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f40925a;

    /* renamed from: a  reason: collision with other field name */
    public Context f864a;

    /* renamed from: e  reason: collision with root package name */
    public volatile String f40929e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f40930f;

    /* renamed from: a  reason: collision with other field name */
    public final Object f865a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Object f40926b = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final String f866a = "mipush_region";

    /* renamed from: b  reason: collision with other field name */
    public final String f867b = "mipush_country_code";

    /* renamed from: c  reason: collision with root package name */
    public final String f40927c = "mipush_region.lock";

    /* renamed from: d  reason: collision with root package name */
    public final String f40928d = "mipush_country_code.lock";

    public a(Context context) {
        this.f864a = context;
    }

    public static a a(Context context) {
        if (f40925a == null) {
            synchronized (a.class) {
                if (f40925a == null) {
                    f40925a = new a(context);
                }
            }
        }
        return f40925a;
    }

    private String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.m51a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                com.xiaomi.push.y.m624a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
            } catch (Exception e2) {
                e = e2;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    try {
                        String a2 = com.xiaomi.push.y.a(file);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                            }
                        }
                        com.xiaomi.push.y.a(randomAccessFile);
                        return a2;
                    } catch (Exception e4) {
                        e = e4;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        com.xiaomi.push.y.a(randomAccessFile);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                        } catch (IOException e6) {
                            com.xiaomi.channel.commonutils.logger.b.a(e6);
                        }
                    }
                    com.xiaomi.push.y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                fileLock = null;
            } catch (Throwable th3) {
                th = th3;
                if (fileLock2 != null) {
                    fileLock2.release();
                }
                com.xiaomi.push.y.a(randomAccessFile);
                throw th;
            }
        }
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    com.xiaomi.push.y.m624a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            com.xiaomi.push.y.a(new File(context.getFilesDir(), str2), str);
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

    public String a() {
        if (TextUtils.isEmpty(this.f40929e)) {
            this.f40929e = a(this.f864a, "mipush_region", "mipush_region.lock", this.f865a);
        }
        return this.f40929e;
    }

    public void a(String str) {
        if (TextUtils.equals(str, this.f40929e)) {
            return;
        }
        this.f40929e = str;
        a(this.f864a, this.f40929e, "mipush_region", "mipush_region.lock", this.f865a);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f40930f)) {
            this.f40930f = a(this.f864a, "mipush_country_code", "mipush_country_code.lock", this.f40926b);
        }
        return this.f40930f;
    }

    public void b(String str) {
        if (TextUtils.equals(str, this.f40930f)) {
            return;
        }
        this.f40930f = str;
        a(this.f864a, this.f40930f, "mipush_country_code", "mipush_country_code.lock", this.f40926b);
    }
}
