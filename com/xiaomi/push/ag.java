package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ag {
    private static final String a = Environment.getExternalStorageDirectory().getPath() + "/mipush/";
    private static final String b = a + "lcfp";
    private static final String c = a + "lcfp.lock";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0054 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x005a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x005c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0001 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0013 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static boolean a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        ?? e = 0;
        e = 0;
        e = 0;
        e = 0;
        try {
            try {
                File file = new File(c);
                y.m554a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    e = randomAccessFile.getChannel().lock();
                    boolean b2 = b(context, str, j);
                    if (e != 0 && e.isValid()) {
                        try {
                            e.release();
                        } catch (IOException e2) {
                            e = e2;
                        }
                    }
                    y.a(randomAccessFile);
                    return b2;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (e != 0 && e.isValid()) {
                        try {
                            e.release();
                        } catch (IOException e4) {
                        }
                    }
                    y.a(randomAccessFile);
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                if (e != 0 && e.isValid()) {
                    try {
                        e.release();
                    } catch (IOException e5) {
                    }
                }
                y.a(randomAccessFile);
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (e != 0) {
                e.release();
            }
            y.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0113 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x0118 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x011f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6 A[Catch: IOException -> 0x00e6, all -> 0x0113, LOOP:1: B:35:0x00d0->B:37:0x00d6, LOOP_END, TRY_LEAVE, TryCatch #1 {all -> 0x0113, blocks: (B:34:0x00cc, B:35:0x00d0, B:37:0x00d6, B:40:0x00e7), top: B:66:0x00c2 }] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(Context context, String str, long j) {
        ?? r1;
        BufferedWriter bufferedWriter;
        ?? e;
        Throwable th;
        if (Build.VERSION.SDK_INT < 23 || g.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file = new File(b);
            ArrayList<String> arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder append = new StringBuilder().append(str).append(":").append(context.getPackageName());
            String str2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
            String sb = append.append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(currentTimeMillis).toString();
            if (file.exists()) {
                Closeable closeable = null;
                try {
                    e = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = e.readLine();
                            if (readLine == null) {
                                y.a((Closeable) e);
                                r1 = e;
                                break;
                            }
                            String[] split = readLine.split(":");
                            if (split.length == 2) {
                                if (TextUtils.equals(split[0], String.valueOf(str))) {
                                    String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    if (split2.length == 2) {
                                        long parseLong = Long.parseLong(split2[1]);
                                        if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                            y.a((Closeable) e);
                                            return false;
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                            }
                        } catch (Exception e2) {
                            closeable = e;
                            try {
                                arrayList.clear();
                                y.a(closeable);
                                r1 = e;
                                arrayList.add(sb);
                                try {
                                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                                    try {
                                        while (r2.hasNext()) {
                                        }
                                        y.a(bufferedWriter);
                                    } catch (IOException e3) {
                                        e = e3;
                                        com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                                        y.a(bufferedWriter);
                                        return true;
                                    }
                                    return true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    y.a((Closeable) r1);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                e = closeable;
                                th = th3;
                                y.a((Closeable) e);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            y.a((Closeable) e);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th5) {
                    e = 0;
                    th = th5;
                }
            } else {
                r1 = str2;
                if (!y.m554a(file)) {
                    return true;
                }
            }
            arrayList.add(sb);
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (String str3 : arrayList) {
                    bufferedWriter.write(str3);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                y.a(bufferedWriter);
            } catch (IOException e5) {
                e = e5;
                bufferedWriter = null;
            } catch (Throwable th6) {
                th = th6;
                r1 = 0;
                y.a((Closeable) r1);
                throw th;
            }
            return true;
        }
        return true;
    }
}
