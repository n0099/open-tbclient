package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ag {
    public static boolean a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23 || g.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp.lock");
                y.m585a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        z = b(context, str, j);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e) {
                            }
                        }
                        y.a(randomAccessFile);
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                            }
                        }
                        y.a(randomAccessFile);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                        }
                    }
                    y.a(randomAccessFile);
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                if (fileLock != null) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                throw th;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1 A[Catch: IOException -> 0x00e1, all -> 0x010c, LOOP:1: B:30:0x00cb->B:32:0x00d1, LOOP_END, TRY_LEAVE, TryCatch #4 {IOException -> 0x00e1, blocks: (B:29:0x00c7, B:30:0x00cb, B:32:0x00d1), top: B:63:0x00c7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, long j) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        Throwable th;
        File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp");
        ArrayList<String> arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + currentTimeMillis;
        if (file.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            y.a(bufferedReader);
                            break;
                        }
                        String[] split = readLine.split(":");
                        if (split.length == 2) {
                            if (TextUtils.equals(split[0], String.valueOf(str))) {
                                String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (split2.length == 2) {
                                    long parseLong = Long.parseLong(split2[1]);
                                    if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                        y.a(bufferedReader);
                                        return false;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                arrayList.add(readLine);
                            }
                        }
                    } catch (Exception e) {
                        bufferedReader2 = bufferedReader;
                        try {
                            arrayList.clear();
                            y.a(bufferedReader2);
                            arrayList.add(str2);
                            bufferedWriter = new BufferedWriter(new FileWriter(file));
                            try {
                                try {
                                    while (r2.hasNext()) {
                                    }
                                    y.a(bufferedWriter);
                                } catch (IOException e2) {
                                    e = e2;
                                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                                    y.a(bufferedWriter);
                                    return true;
                                }
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                y.a(bufferedWriter);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            bufferedReader = bufferedReader2;
                            th = th3;
                            y.a(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        y.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception e3) {
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } else if (!y.m585a(file)) {
            return true;
        }
        arrayList.add(str2);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String str3 : arrayList) {
                bufferedWriter.write(str3);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            y.a(bufferedWriter);
        } catch (IOException e4) {
            e = e4;
            bufferedWriter = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedWriter = null;
            y.a(bufferedWriter);
            throw th;
        }
        return true;
    }
}
