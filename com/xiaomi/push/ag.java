package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes8.dex */
public class ag {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0065 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    public static boolean a(Context context, String str, long j) {
        InterceptResult invokeCommon;
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, Long.valueOf(j)})) != null) {
            return invokeCommon.booleanValue;
        }
        ?? r2 = 23;
        if (Build.VERSION.SDK_INT >= 23 && !g.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        FileLock fileLock = null;
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp.lock");
                y.m682a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    boolean b = b(context, str, j);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    y.a(randomAccessFile);
                    return b;
                } catch (IOException e) {
                    e = e;
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
        } catch (IOException e2) {
            e = e2;
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

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6 A[Catch: all -> 0x00ea, IOException -> 0x00ed, LOOP:0: B:41:0x00d0->B:43:0x00d6, LOOP_END, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ed, all -> 0x00ea, blocks: (B:40:0x00cc, B:41:0x00d0, B:43:0x00d6), top: B:74:0x00cc }] */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Closeable closeable;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j)})) != null) {
            return invokeCommon.booleanValue;
        }
        File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp");
        ArrayList<String> arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = str + ":" + context.getPackageName() + "," + currentTimeMillis;
        ?? exists = file.exists();
        try {
            if (exists != 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
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
                                            y.a(bufferedReader);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                            }
                        } catch (Exception unused) {
                            arrayList.clear();
                            y.a(bufferedReader);
                            arrayList.add(str2);
                            bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                            while (r0.hasNext()) {
                            }
                            y.a(bufferedWriter2);
                            return true;
                        }
                    }
                } catch (Exception unused2) {
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    y.a(closeable);
                    throw th;
                }
            } else if (!y.m682a(file)) {
                return true;
            }
            arrayList.add(str2);
            try {
                bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                e = e;
                bufferedWriter = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
            try {
                for (String str3 : arrayList) {
                    bufferedWriter2.write(str3);
                    bufferedWriter2.newLine();
                    bufferedWriter2.flush();
                }
                y.a(bufferedWriter2);
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = bufferedWriter2;
                try {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                    y.a(bufferedWriter);
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    y.a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = bufferedWriter2;
                y.a(bufferedWriter);
                throw th;
            }
            return true;
        } catch (Throwable th5) {
            th = th5;
            closeable = exists;
        }
    }
}
