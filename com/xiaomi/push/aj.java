package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
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
public class aj {
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
        if (Build.VERSION.SDK_INT >= 23 && !h.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        FileLock fileLock = null;
        try {
            try {
                File file = new File(new File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp.lock");
                ab.m1099a(file);
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
                    ab.a(randomAccessFile);
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
                    ab.a(randomAccessFile);
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
                ab.a((Closeable) r2);
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
            ab.a((Closeable) r2);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x00fe */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x00b1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:73:0x00b4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x0055 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v29, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc A[Catch: IOException -> 0x00ec, all -> 0x00fe, LOOP:0: B:41:0x00d6->B:43:0x00dc, LOOP_END, TRY_LEAVE, TryCatch #4 {all -> 0x00fe, blocks: (B:40:0x00d2, B:41:0x00d6, B:43:0x00dc, B:51:0x00f3), top: B:63:0x00c8 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j)})) != null) {
            return invokeCommon.booleanValue;
        }
        Closeable closeable3 = null;
        closeable3 = null;
        File file = new File(new File(context.getExternalFilesDir(null), "/.vdevdir/"), "lcfp");
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
                                            ab.a(bufferedReader);
                                            return false;
                                        }
                                    }
                                } else {
                                    arrayList.add(readLine);
                                }
                                closeable3 = null;
                            }
                        } catch (Exception unused) {
                            arrayList.clear();
                            ab.a(bufferedReader);
                            closeable2 = closeable3;
                            arrayList.add(str2);
                            try {
                                bufferedWriter = new BufferedWriter(new FileWriter(file));
                                try {
                                    while (r0.hasNext()) {
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                                    ab.a(bufferedWriter);
                                    return true;
                                }
                                ab.a(bufferedWriter);
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                ab.a(closeable2);
                                throw th;
                            }
                        }
                    }
                } catch (Exception unused2) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    ab.a(closeable);
                    throw th;
                }
                ab.a(bufferedReader);
                closeable2 = closeable3;
            } else {
                boolean m1099a = ab.m1099a(file);
                closeable2 = m1099a;
                if (m1099a == 0) {
                    return true;
                }
            }
            arrayList.add(str2);
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (String str3 : arrayList) {
                    bufferedWriter.write(str3);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            } catch (IOException e2) {
                e = e2;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                closeable2 = null;
                ab.a(closeable2);
                throw th;
            }
            ab.a(bufferedWriter);
            return true;
        } catch (Throwable th4) {
            th = th4;
            closeable = exists;
        }
    }
}
