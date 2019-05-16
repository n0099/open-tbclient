package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
/* loaded from: classes3.dex */
public class a {
    private static volatile a f;
    private final Object a = new Object();
    private final String b = "mipush_region";
    private final String c = "mipush_region.lock";
    private volatile String d;
    private Context e;

    public a(Context context) {
        this.e = context;
    }

    public static a a(Context context) {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a(context);
                }
            }
        }
        return f;
    }

    private void a(Context context, String str) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        synchronized (this.a) {
            try {
                File file = new File(context.getFilesDir(), "mipush_region.lock");
                com.xiaomi.channel.commonutils.file.b.c(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        b(context, str);
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
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                        }
                    }
                    com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
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
                com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                throw th;
            }
        }
    }

    private String b(Context context) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str = null;
        if (new File(context.getFilesDir(), "mipush_region").exists()) {
            synchronized (this.a) {
                try {
                    File file = new File(context.getFilesDir(), "mipush_region.lock");
                    com.xiaomi.channel.commonutils.file.b.c(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e) {
                    e = e;
                    fileLock = null;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    fileLock = null;
                    randomAccessFile = null;
                    th = th2;
                }
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        try {
                            str = c(context);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                }
                            }
                            com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
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
                            com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                            return str;
                        }
                    } catch (Throwable th3) {
                        th = th3;
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
                } catch (Exception e6) {
                    e = e6;
                    fileLock = null;
                } catch (Throwable th4) {
                    fileLock = null;
                    th = th4;
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    com.xiaomi.channel.commonutils.file.b.a(randomAccessFile);
                    throw th;
                }
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("Region no ready file to get data.");
        }
        return str;
    }

    private void b(Context context, String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput("mipush_region", 32768);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        } finally {
            com.xiaomi.channel.commonutils.file.b.a(fileOutputStream);
        }
    }

    private String c(Context context) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        Exception e;
        String str;
        try {
            fileInputStream = context.openFileInput("mipush_region");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                str = "";
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        } catch (Exception e2) {
                            e = e2;
                            com.xiaomi.channel.commonutils.logger.b.a(e);
                            com.xiaomi.channel.commonutils.file.b.a(fileInputStream);
                            com.xiaomi.channel.commonutils.file.b.a(bufferedReader);
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.xiaomi.channel.commonutils.file.b.a(fileInputStream);
                        com.xiaomi.channel.commonutils.file.b.a(bufferedReader);
                        throw th;
                    }
                }
                com.xiaomi.channel.commonutils.file.b.a(fileInputStream);
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
                str = "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                com.xiaomi.channel.commonutils.file.b.a(fileInputStream);
                com.xiaomi.channel.commonutils.file.b.a(bufferedReader);
                throw th;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            fileInputStream = null;
            e = e4;
            str = "";
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileInputStream = null;
        }
        com.xiaomi.channel.commonutils.file.b.a(bufferedReader);
        return str;
    }

    public String a() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = b(this.e);
        }
        return this.d;
    }

    public void a(String str) {
        if (TextUtils.equals(str, this.d)) {
            return;
        }
        this.d = str;
        a(this.e, this.d);
    }
}
