package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        InterceptResult invokeLL;
        long[] m144a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, perfClientReport, str)) == null) {
            if (perfClientReport == null || (m144a = m144a(str)) == null) {
                return null;
            }
            perfClientReport.perfCounts = m144a[0];
            perfClientReport.perfLatencies = m144a[1];
            return perfClientReport;
        }
        return (PerfClientReport) invokeLL.objValue;
    }

    public static PerfClientReport a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PerfClientReport perfClientReport = null;
            try {
                String[] m145a = m145a(str);
                if (m145a == null || m145a.length < 4 || TextUtils.isEmpty(m145a[0]) || TextUtils.isEmpty(m145a[1]) || TextUtils.isEmpty(m145a[2]) || TextUtils.isEmpty(m145a[3])) {
                    return null;
                }
                perfClientReport = PerfClientReport.getBlankInstance();
                perfClientReport.production = Integer.parseInt(m145a[0]);
                perfClientReport.clientInterfaceId = m145a[1];
                perfClientReport.reportType = Integer.parseInt(m145a[2]);
                perfClientReport.code = Integer.parseInt(m145a[3]);
                return perfClientReport;
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
                return perfClientReport;
            }
        }
        return (PerfClientReport) invokeL.objValue;
    }

    public static String a(PerfClientReport perfClientReport) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, perfClientReport)) == null) {
            return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HashMap<String, String> m143a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (HashMap) invokeL.objValue;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = null;
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
                        if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                            hashMap.put(split[0], split[1]);
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
            } catch (Exception e3) {
                e = e3;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x009f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x00df */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d9, code lost:
        if (r1 != null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f8  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(Context context, String str) {
        InterceptResult invokeLL;
        File file;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        PerfClientReport a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return arrayList;
            }
            FileLock fileLock = null;
            try {
                file = new File(str + ".lock");
                try {
                    y.m706a(file);
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
                                    if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (a = a(a(split[0]), split[1])) != null) {
                                        arrayList.add(a.toJsonString());
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
        return (List) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0071 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    public static void a(String str, HashMap<String, String> hashMap) {
        ?? r1;
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r1 = interceptable;
            if (r1.invokeLL(65541, null, str, hashMap) != null) {
                return;
            }
        }
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
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
                y.a((Closeable) r1);
                throw th;
            }
        } catch (Exception e4) {
            bufferedWriter = null;
            e2 = e4;
        } catch (Throwable th3) {
            r1 = 0;
            th = th3;
            y.a((Closeable) r1);
            throw th;
        }
        y.a(bufferedWriter);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE] complete} */
    public static void a(String str, com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, str, aVarArr) == null) || aVarArr == null || aVarArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            y.m706a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            fileLock = randomAccessFile.getChannel().lock();
            HashMap<String, String> m143a = m143a(str);
            for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                if (aVar != null) {
                    String a = a((PerfClientReport) aVar);
                    long j2 = ((PerfClientReport) aVar).perfCounts;
                    long j3 = ((PerfClientReport) aVar).perfLatencies;
                    if (!TextUtils.isEmpty(a) && j2 > 0 && j3 >= 0) {
                        a(m143a, a, j2, j3);
                    }
                }
            }
            a(str, m143a);
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

    public static void a(HashMap<String, String> hashMap, String str, long j2, long j3) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{hashMap, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            String str2 = hashMap.get(str);
            if (TextUtils.isEmpty(str2)) {
                sb = new StringBuilder();
            } else {
                long[] m144a = m144a(str2);
                if (m144a == null || m144a[0] <= 0 || m144a[1] < 0) {
                    sb = new StringBuilder();
                } else {
                    j2 += m144a[0];
                    j3 += m144a[1];
                    sb = new StringBuilder();
                }
            }
            sb.append(j2);
            sb.append("#");
            sb.append(j3);
            hashMap.put(str, sb.toString());
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static long[] m144a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
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
        return (long[]) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String[] m145a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.split("#");
        }
        return (String[]) invokeL.objValue;
    }
}
