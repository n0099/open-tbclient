package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.y;
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
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    public static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] m62a;
        if (perfClientReport == null || (m62a = m62a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = m62a[0];
        perfClientReport.perfLatencies = m62a[1];
        return perfClientReport;
    }

    public static PerfClientReport a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m63a = m63a(str);
            if (m63a == null || m63a.length < 4 || TextUtils.isEmpty(m63a[0]) || TextUtils.isEmpty(m63a[1]) || TextUtils.isEmpty(m63a[2]) || TextUtils.isEmpty(m63a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m63a[0]);
            perfClientReport.clientInterfaceId = m63a[1];
            perfClientReport.reportType = Integer.parseInt(m63a[2]);
            perfClientReport.code = Integer.parseInt(m63a[3]);
            return perfClientReport;
        } catch (Exception unused) {
            com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
            return perfClientReport;
        }
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0022 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0022 */
    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.HashMap, java.util.HashMap<java.lang.String, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a  reason: collision with other method in class */
    public static HashMap<String, String> m61a(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = 0;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("%%%");
                        bufferedReader = split.length;
                        if (bufferedReader >= 2) {
                            bufferedReader = 0;
                            bufferedReader = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                bufferedReader = split[0];
                                hashMap.put(bufferedReader, split[1]);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        y.a(bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        y.a(bufferedReader);
                        throw th;
                    }
                }
                y.a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return hashMap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x009b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x00db */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(Context context, String str) {
        File file;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        PerfClientReport a2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return arrayList;
        }
        FileLock fileLock = null;
        try {
            file = new File(str + ".lock");
            try {
                y.m624a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        randomAccessFile2 = new BufferedReader(new FileReader(str));
                        while (true) {
                            try {
                                String readLine = randomAccessFile2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split("%%%");
                                if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (a2 = a(a(split[0]), split[1])) != null) {
                                    arrayList.add(a2.toJsonString());
                                }
                            } catch (Exception e2) {
                                e = e2;
                                fileLock = lock;
                                randomAccessFile2 = randomAccessFile2;
                                try {
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    y.a(randomAccessFile2);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e4) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    y.a(randomAccessFile2);
                                    if (file != null) {
                                        file.delete();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                }
                                y.a(randomAccessFile);
                                y.a(randomAccessFile2);
                                if (file != null) {
                                }
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException e5) {
                                com.xiaomi.channel.commonutils.logger.b.a(e5);
                            }
                        }
                        y.a(randomAccessFile);
                        y.a((Closeable) randomAccessFile2);
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile2 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile2 = 0;
                    }
                } catch (Exception e7) {
                    e = e7;
                    randomAccessFile2 = null;
                } catch (Throwable th4) {
                    th = th4;
                    randomAccessFile2 = null;
                }
            } catch (Exception e8) {
                e = e8;
                randomAccessFile = null;
                randomAccessFile2 = randomAccessFile;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                y.a(randomAccessFile2);
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                randomAccessFile2 = randomAccessFile;
                if (fileLock != null) {
                    fileLock.release();
                }
                y.a(randomAccessFile);
                y.a(randomAccessFile2);
                if (file != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            file = null;
            randomAccessFile = null;
        } catch (Throwable th6) {
            th = th6;
            file = null;
            randomAccessFile = null;
        }
        file.delete();
        return arrayList;
    }

    public static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e2;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                try {
                    for (String str2 : hashMap.keySet()) {
                        bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                        bufferedWriter.newLine();
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    y.a(bufferedWriter);
                }
            } catch (Throwable th2) {
                th = th2;
                y.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e4) {
            bufferedWriter = null;
            e2 = e4;
        } catch (Throwable th3) {
            bufferedWriter = null;
            th = th3;
            y.a(bufferedWriter);
            throw th;
        }
        y.a(bufferedWriter);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE] complete} */
    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        if (aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            y.m624a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            fileLock = randomAccessFile.getChannel().lock();
            HashMap<String, String> m61a = m61a(str);
            for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                if (aVar != null) {
                    String a2 = a((PerfClientReport) aVar);
                    long j = ((PerfClientReport) aVar).perfCounts;
                    long j2 = ((PerfClientReport) aVar).perfLatencies;
                    if (!TextUtils.isEmpty(a2) && j > 0 && j2 >= 0) {
                        a(m61a, a2, j, j2);
                    }
                }
            }
            a(str, m61a);
            if (fileLock != null && fileLock.isValid()) {
                try {
                    fileLock.release();
                } catch (IOException e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    y.a(randomAccessFile);
                }
            }
        } catch (Throwable unused2) {
            try {
                com.xiaomi.channel.commonutils.logger.b.c("failed to write perf to file ");
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e3) {
                        e = e3;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        y.a(randomAccessFile);
                    }
                }
                y.a(randomAccessFile);
            } catch (Throwable th) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e4) {
                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                    }
                }
                y.a(randomAccessFile);
                throw th;
            }
        }
        y.a(randomAccessFile);
    }

    public static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] m62a = m62a(str2);
            if (m62a == null || m62a[0] <= 0 || m62a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j += m62a[0];
                j2 += m62a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j);
        sb.append("#");
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static long[] m62a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String[] m63a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
