package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ag {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0061 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    public static boolean a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        ?? r2 = 23;
        if (Build.VERSION.SDK_INT >= 23 && !g.c(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            return true;
        }
        FileLock fileLock = null;
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp.lock");
                y.m631a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean b2 = b(context, str, j);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    y.a(randomAccessFile);
                    return b2;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    y.a(randomAccessFile);
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0 && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                y.a((Closeable) r2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            if (0 != 0) {
                fileLock.release();
            }
            y.a((Closeable) r2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2 A[Catch: all -> 0x00e6, IOException -> 0x00e9, LOOP:0: B:39:0x00cc->B:41:0x00d2, LOOP_END, TRY_LEAVE, TryCatch #9 {IOException -> 0x00e9, all -> 0x00e6, blocks: (B:38:0x00c8, B:39:0x00cc, B:41:0x00d2), top: B:64:0x00c8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, long j) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp");
        ArrayList<String> arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + "," + currentTimeMillis;
        if (file.exists()) {
            try {
                bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split(":");
                            if (split.length == 2) {
                                if (TextUtils.equals(split[0], String.valueOf(str))) {
                                    String[] split2 = split[1].split(",");
                                    if (split2.length == 2) {
                                        long parseLong = Long.parseLong(split2[1]);
                                        if (!TextUtils.equals(split2[0], context.getPackageName()) && ((float) Math.abs(currentTimeMillis - parseLong)) < ((float) (1000 * j)) * 0.9f) {
                                            y.a(bufferedReader2);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                            }
                        } catch (Exception unused) {
                            arrayList.clear();
                            y.a(bufferedReader2);
                            arrayList.add(str2);
                            bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                            try {
                                while (r0.hasNext()) {
                                }
                                y.a(bufferedWriter2);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedWriter = bufferedWriter2;
                                try {
                                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                                    y.a(bufferedWriter);
                                    return true;
                                } catch (Throwable th) {
                                    th = th;
                                    y.a(bufferedWriter);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter = bufferedWriter2;
                                y.a(bufferedWriter);
                                throw th;
                            }
                            return true;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader2;
                        y.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                bufferedReader2 = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                y.a(bufferedReader);
                throw th;
            }
        } else if (!y.m631a(file)) {
            return true;
        }
        arrayList.add(str2);
        try {
            bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            for (String str3 : arrayList) {
                bufferedWriter2.write(str3);
                bufferedWriter2.newLine();
                bufferedWriter2.flush();
            }
            y.a(bufferedWriter2);
        } catch (IOException e3) {
            e = e3;
            bufferedWriter = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
        }
        return true;
    }
}
