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
/* loaded from: classes9.dex */
public class e {
    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] m59a;
        if (perfClientReport != null && (m59a = m59a(str)) != null) {
            perfClientReport.perfCounts = m59a[0];
            perfClientReport.perfLatencies = m59a[1];
            return perfClientReport;
        }
        return null;
    }

    private static PerfClientReport a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m60a = m60a(str);
            if (m60a == null || m60a.length < 4 || TextUtils.isEmpty(m60a[0]) || TextUtils.isEmpty(m60a[1]) || TextUtils.isEmpty(m60a[2]) || TextUtils.isEmpty(m60a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m60a[0]);
            perfClientReport.clientInterfaceId = m60a[1];
            perfClientReport.reportType = Integer.parseInt(m60a[2]);
            perfClientReport.code = Integer.parseInt(m60a[3]);
            return perfClientReport;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.c("parse per key error");
            return perfClientReport;
        }
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + "#" + perfClientReport.clientInterfaceId + "#" + perfClientReport.reportType + "#" + perfClientReport.code;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static HashMap<String, String> m58a(String str) {
        BufferedReader bufferedReader;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new File(str).exists()) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(str));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split("%%%");
                                if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                    hashMap.put(split[0], split[1]);
                                }
                            } catch (Exception e) {
                                e = e;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                y.a(bufferedReader);
                                return hashMap;
                            }
                        }
                        y.a(bufferedReader);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        y.a((Closeable) null);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(Context context, String str) {
        File file;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        BufferedReader bufferedReader;
        PerfClientReport a;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        r3 = null;
        bufferedReader2 = null;
        r3 = null;
        bufferedReader2 = null;
        FileLock fileLock2 = null;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            try {
                file = new File(str + ".lock");
                try {
                    y.m585a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        try {
                            BufferedReader bufferedReader3 = new BufferedReader(new FileReader(str));
                            while (true) {
                                try {
                                    String readLine = bufferedReader3.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    String[] split = readLine.split("%%%");
                                    if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (a = a(a(split[0]), split[1])) != null) {
                                        arrayList.add(a.toJsonString());
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    fileLock2 = fileLock;
                                    randomAccessFile2 = randomAccessFile;
                                    bufferedReader = bufferedReader3;
                                    try {
                                        com.xiaomi.channel.commonutils.logger.b.a(e);
                                        if (fileLock2 != null && fileLock2.isValid()) {
                                            try {
                                                fileLock2.release();
                                            } catch (IOException e2) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                            }
                                        }
                                        y.a(randomAccessFile2);
                                        y.a(bufferedReader);
                                        if (file != null) {
                                            file.delete();
                                        }
                                        return arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        FileLock fileLock3 = fileLock2;
                                        bufferedReader2 = bufferedReader;
                                        randomAccessFile = randomAccessFile2;
                                        fileLock = fileLock3;
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e3) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e3);
                                            }
                                        }
                                        y.a(randomAccessFile);
                                        y.a(bufferedReader2);
                                        if (file != null) {
                                            file.delete();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader2 = bufferedReader3;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    y.a(randomAccessFile);
                                    y.a(bufferedReader2);
                                    if (file != null) {
                                    }
                                    throw th;
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                }
                            }
                            y.a(randomAccessFile);
                            y.a(bufferedReader3);
                            if (file != null) {
                                file.delete();
                            }
                        } catch (Exception e5) {
                            e = e5;
                            randomAccessFile2 = randomAccessFile;
                            bufferedReader = null;
                            fileLock2 = fileLock;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        randomAccessFile2 = randomAccessFile;
                        bufferedReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileLock = null;
                    }
                } catch (Exception e7) {
                    e = e7;
                    randomAccessFile2 = null;
                    bufferedReader = null;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock = null;
                    randomAccessFile = null;
                }
            } catch (Exception e8) {
                e = e8;
                file = null;
                randomAccessFile2 = null;
                bufferedReader = null;
            } catch (Throwable th6) {
                th = th6;
                file = null;
                fileLock = null;
                randomAccessFile = null;
            }
        }
        return arrayList;
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
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
                for (String str2 : hashMap.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                    bufferedWriter.newLine();
                }
                y.a(bufferedWriter);
            } catch (Exception e) {
                e = e;
                bufferedWriter2 = bufferedWriter;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    y.a(bufferedWriter2);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    y.a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                y.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static void a(java.lang.String r16, com.xiaomi.clientreport.data.a[] r17) {
        /*
            r14 = 0
            r2 = 0
            if (r17 == 0) goto L10
            r0 = r17
            int r3 = r0.length
            if (r3 <= 0) goto L10
            boolean r3 = android.text.TextUtils.isEmpty(r16)
            if (r3 == 0) goto L11
        L10:
            return
        L11:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Ld0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld0
            r4.<init>()     // Catch: java.lang.Throwable -> Ld0
            r0 = r16
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r5 = ".lock"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Ld0
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Ld0
            com.xiaomi.push.y.m585a(r3)     // Catch: java.lang.Throwable -> Ld0
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r4 = "rw"
            r9.<init>(r3, r4)     // Catch: java.lang.Throwable -> Ld0
            java.nio.channels.FileChannel r3 = r9.getChannel()     // Catch: java.lang.Throwable -> Ld3
            java.nio.channels.FileLock r8 = r3.lock()     // Catch: java.lang.Throwable -> Ld3
            java.util.HashMap r2 = m58a(r16)     // Catch: java.lang.Throwable -> L76
            r0 = r17
            int r11 = r0.length     // Catch: java.lang.Throwable -> L76
            r3 = 0
            r10 = r3
        L48:
            if (r10 >= r11) goto L8e
            r6 = r17[r10]     // Catch: java.lang.Throwable -> L76
            if (r6 == 0) goto L6e
            r0 = r6
            com.xiaomi.clientreport.data.PerfClientReport r0 = (com.xiaomi.clientreport.data.PerfClientReport) r0     // Catch: java.lang.Throwable -> L76
            r3 = r0
            java.lang.String r3 = a(r3)     // Catch: java.lang.Throwable -> L76
            r0 = r6
            com.xiaomi.clientreport.data.PerfClientReport r0 = (com.xiaomi.clientreport.data.PerfClientReport) r0     // Catch: java.lang.Throwable -> L76
            r4 = r0
            long r4 = r4.perfCounts     // Catch: java.lang.Throwable -> L76
            com.xiaomi.clientreport.data.PerfClientReport r6 = (com.xiaomi.clientreport.data.PerfClientReport) r6     // Catch: java.lang.Throwable -> L76
            long r6 = r6.perfLatencies     // Catch: java.lang.Throwable -> L76
            boolean r12 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L76
            if (r12 != 0) goto L6e
            int r12 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r12 <= 0) goto L6e
            int r12 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r12 >= 0) goto L72
        L6e:
            int r3 = r10 + 1
            r10 = r3
            goto L48
        L72:
            a(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L76
            goto L6e
        L76:
            r2 = move-exception
            r2 = r8
            r3 = r9
        L79:
            java.lang.String r4 = "failed to write perf to file "
            com.xiaomi.channel.commonutils.logger.b.c(r4)     // Catch: java.lang.Throwable -> Lcb
            if (r2 == 0) goto L8a
            boolean r4 = r2.isValid()
            if (r4 == 0) goto L8a
            r2.release()     // Catch: java.io.IOException -> La8
        L8a:
            com.xiaomi.push.y.a(r3)
            goto L10
        L8e:
            r0 = r16
            a(r0, r2)     // Catch: java.lang.Throwable -> L76
            if (r8 == 0) goto L9e
            boolean r2 = r8.isValid()
            if (r2 == 0) goto L9e
            r8.release()     // Catch: java.io.IOException -> La3
        L9e:
            com.xiaomi.push.y.a(r9)
            goto L10
        La3:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            goto L9e
        La8:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            goto L8a
        Lad:
            r3 = move-exception
            r8 = r2
            r9 = r2
            r2 = r3
        Lb1:
            if (r8 == 0) goto Lbc
            boolean r3 = r8.isValid()
            if (r3 == 0) goto Lbc
            r8.release()     // Catch: java.io.IOException -> Lc0
        Lbc:
            com.xiaomi.push.y.a(r9)
            throw r2
        Lc0:
            r3 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r3)
            goto Lbc
        Lc5:
            r3 = move-exception
            r8 = r2
            r2 = r3
            goto Lb1
        Lc9:
            r2 = move-exception
            goto Lb1
        Lcb:
            r4 = move-exception
            r8 = r2
            r9 = r3
            r2 = r4
            goto Lb1
        Ld0:
            r3 = move-exception
            r3 = r2
            goto L79
        Ld3:
            r3 = move-exception
            r3 = r9
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.e.a(java.lang.String, com.xiaomi.clientreport.data.a[]):void");
    }

    private static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        String str2;
        String str3 = hashMap.get(str);
        if (TextUtils.isEmpty(str3)) {
            hashMap.put(str, j + "#" + j2);
            return;
        }
        long[] m59a = m59a(str3);
        if (m59a == null || m59a[0] <= 0 || m59a[1] < 0) {
            str2 = j + "#" + j2;
        } else {
            str2 = (m59a[0] + j) + "#" + (m59a[1] + j2);
        }
        hashMap.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    protected static long[] m59a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split("#");
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
                return jArr;
            }
            return jArr;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String[] m60a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
