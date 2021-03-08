package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.y;
import com.yy.mediaframework.stat.VideoDataStatistic;
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
/* loaded from: classes5.dex */
public class e {
    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] m68a;
        if (perfClientReport != null && (m68a = m68a(str)) != null) {
            perfClientReport.perfCounts = m68a[0];
            perfClientReport.perfLatencies = m68a[1];
            return perfClientReport;
        }
        return null;
    }

    private static PerfClientReport a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m69a = m69a(str);
            if (m69a == null || m69a.length < 4 || TextUtils.isEmpty(m69a[0]) || TextUtils.isEmpty(m69a[1]) || TextUtils.isEmpty(m69a[2]) || TextUtils.isEmpty(m69a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m69a[0]);
            perfClientReport.clientInterfaceId = m69a[1];
            perfClientReport.reportType = Integer.parseInt(m69a[2]);
            perfClientReport.code = Integer.parseInt(m69a[3]);
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
    private static HashMap<String, String> m67a(String str) {
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

    public static List<String> a(Context context, String str) {
        Closeable closeable;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file;
        BufferedReader bufferedReader;
        PerfClientReport a2;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (new File(str).exists()) {
                    try {
                        file = new File(str + ".lock");
                        try {
                            y.m594a(file);
                            randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
                            try {
                                fileLock = randomAccessFile.getChannel().lock();
                                try {
                                    bufferedReader = new BufferedReader(new FileReader(str));
                                    while (true) {
                                        try {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine == null) {
                                                break;
                                            }
                                            String[] split = readLine.split("%%%");
                                            if (split.length >= 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1]) && (a2 = a(a(split[0]), split[1])) != null) {
                                                arrayList.add(a2.toJsonString());
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            com.xiaomi.channel.commonutils.logger.b.a(e);
                                            if (fileLock != null && fileLock.isValid()) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e2) {
                                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                                }
                                            }
                                            y.a(randomAccessFile);
                                            y.a(bufferedReader);
                                            if (file != null) {
                                                file.delete();
                                            }
                                            return arrayList;
                                        }
                                    }
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    y.a(bufferedReader);
                                    if (file != null) {
                                        file.delete();
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    bufferedReader = null;
                                } catch (Throwable th) {
                                    th = th;
                                    closeable = null;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e5) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    y.a(closeable);
                                    if (file != null) {
                                        file.delete();
                                    }
                                    throw th;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                fileLock = null;
                                bufferedReader = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = null;
                                closeable = null;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            fileLock = null;
                            randomAccessFile = null;
                            bufferedReader = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = null;
                            randomAccessFile = null;
                            closeable = null;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        file = null;
                        fileLock = null;
                        randomAccessFile = null;
                        bufferedReader = null;
                    } catch (Throwable th4) {
                        th = th4;
                        file = null;
                        fileLock = null;
                        randomAccessFile = null;
                        closeable = null;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
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
            r3 = 0
            if (r17 == 0) goto L10
            r0 = r17
            int r2 = r0.length
            if (r2 <= 0) goto L10
            boolean r2 = android.text.TextUtils.isEmpty(r16)
            if (r2 == 0) goto L11
        L10:
            return
        L11:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Ld1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld1
            r4.<init>()     // Catch: java.lang.Throwable -> Ld1
            r0 = r16
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r5 = ".lock"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Ld1
            r2.<init>(r4)     // Catch: java.lang.Throwable -> Ld1
            com.xiaomi.push.y.m594a(r2)     // Catch: java.lang.Throwable -> Ld1
            java.io.RandomAccessFile r9 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r4 = "rw"
            r9.<init>(r2, r4)     // Catch: java.lang.Throwable -> Ld1
            java.nio.channels.FileChannel r2 = r9.getChannel()     // Catch: java.lang.Throwable -> Ld5
            java.nio.channels.FileLock r8 = r2.lock()     // Catch: java.lang.Throwable -> Ld5
            java.util.HashMap r2 = m67a(r16)     // Catch: java.lang.Throwable -> L76
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
            r4 = r9
        L79:
            java.lang.String r3 = "failed to write perf to file "
            com.xiaomi.channel.commonutils.logger.b.c(r3)     // Catch: java.lang.Throwable -> Lcc
            if (r2 == 0) goto L8a
            boolean r3 = r2.isValid()
            if (r3 == 0) goto L8a
            r2.release()     // Catch: java.io.IOException -> La8
        L8a:
            com.xiaomi.push.y.a(r4)
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
            r2 = move-exception
            r5 = r2
            r8 = r3
            r9 = r3
        Lb1:
            if (r8 == 0) goto Lbc
            boolean r2 = r8.isValid()
            if (r2 == 0) goto Lbc
            r8.release()     // Catch: java.io.IOException -> Lc0
        Lbc:
            com.xiaomi.push.y.a(r9)
            throw r5
        Lc0:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            goto Lbc
        Lc5:
            r2 = move-exception
            r5 = r2
            r8 = r3
            goto Lb1
        Lc9:
            r2 = move-exception
            r5 = r2
            goto Lb1
        Lcc:
            r3 = move-exception
            r5 = r3
            r8 = r2
            r9 = r4
            goto Lb1
        Ld1:
            r2 = move-exception
            r2 = r3
            r4 = r3
            goto L79
        Ld5:
            r2 = move-exception
            r2 = r3
            r4 = r9
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
        long[] m68a = m68a(str3);
        if (m68a == null || m68a[0] <= 0 || m68a[1] < 0) {
            str2 = j + "#" + j2;
        } else {
            str2 = (m68a[0] + j) + "#" + (m68a[1] + j2);
        }
        hashMap.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    protected static long[] m68a(String str) {
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
    private static String[] m69a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("#");
    }
}
