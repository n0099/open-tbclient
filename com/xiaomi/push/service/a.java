package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes8.dex */
public class a {
    private static volatile a a;

    /* renamed from: a  reason: collision with other field name */
    private Context f824a;
    private volatile String e;
    private volatile String f;

    /* renamed from: a  reason: collision with other field name */
    private final Object f825a = new Object();
    private final Object b = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final String f826a = "mipush_region";

    /* renamed from: b  reason: collision with other field name */
    private final String f827b = "mipush_country_code";
    private final String c = "mipush_region.lock";
    private final String d = "mipush_country_code.lock";

    public a(Context context) {
        this.f824a = context;
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private String a(Context context, String str, String str2, Object obj) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str3 = null;
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            synchronized (obj) {
                try {
                    File file2 = new File(context.getFilesDir(), str2);
                    com.xiaomi.push.y.m588a(file2);
                    randomAccessFile = new RandomAccessFile(file2, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        try {
                            try {
                                str3 = com.xiaomi.push.y.a(file);
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
                                return str3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
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
                    } catch (Throwable th3) {
                        fileLock = null;
                        th = th3;
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
                } catch (Throwable th4) {
                    fileLock = null;
                    randomAccessFile = null;
                    th = th4;
                }
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m52a("No ready file to get data from " + str);
        }
        return str3;
    }

    private void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        synchronized (obj) {
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
                    com.xiaomi.push.y.m588a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        com.xiaomi.push.y.a(new File(context.getFilesDir(), str2), str);
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
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                com.xiaomi.push.y.a(randomAccessFile);
                throw th;
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = a(this.f824a, "mipush_region", "mipush_region.lock", this.f825a);
        }
        return this.e;
    }

    public void a(String str) {
        if (TextUtils.equals(str, this.e)) {
            return;
        }
        this.e = str;
        a(this.f824a, this.e, "mipush_region", "mipush_region.lock", this.f825a);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = a(this.f824a, "mipush_country_code", "mipush_country_code.lock", this.b);
        }
        return this.f;
    }

    public void b(String str) {
        if (TextUtils.equals(str, this.f)) {
            return;
        }
        this.f = str;
        a(this.f824a, this.f, "mipush_country_code", "mipush_country_code.lock", this.b);
    }
}
