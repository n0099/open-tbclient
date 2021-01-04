package com.kwad.sdk.crash.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class SystemUtil {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f9953a;

    /* renamed from: b  reason: collision with root package name */
    private static long f9954b = 0;
    private static long c = 0;
    private static int d = 0;
    private static LEVEL e = null;

    /* loaded from: classes5.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        LEVEL(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f9955a;

        /* renamed from: b  reason: collision with root package name */
        public long f9956b;
        public long c;
        public long d;
        public long e;
        public int f;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a() {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Exception e2) {
            e = e2;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Exception e3) {
                e = e3;
                bufferedReader2 = bufferedReader;
                try {
                    com.kwad.sdk.core.d.a.b(e);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            com.kwad.sdk.core.d.a.b(e4);
                        }
                    }
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            com.kwad.sdk.core.d.a.b(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                }
                throw th;
            }
            if (readLine == null) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        com.kwad.sdk.core.d.a.b(e6);
                    }
                }
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                return longValue;
            } catch (IOException e7) {
                com.kwad.sdk.core.d.a.b(e7);
                return longValue;
            }
        }
        return longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x007c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0084 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0041 */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        com.kwad.sdk.crash.utils.SystemUtil.f9953a = r0.processName;
     */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        BufferedReader bufferedReader;
        int read;
        ?? myPid;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(f9953a)) {
            try {
                myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
                if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            break;
                        }
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (TextUtils.isEmpty(f9953a)) {
                BufferedReader bufferedReader2 = null;
                BufferedReader bufferedReader3 = null;
                try {
                    try {
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/cmdline")));
                        } catch (Throwable th) {
                            th = th;
                            b.a((Reader) bufferedReader2);
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        bufferedReader = null;
                    } catch (IOException e4) {
                        e = e4;
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            read = bufferedReader.read();
                            if (read <= 0) {
                                break;
                            }
                            sb.append((char) read);
                        }
                        f9953a = sb.toString();
                        b.a((Reader) bufferedReader);
                        bufferedReader2 = read;
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        com.kwad.sdk.core.d.a.b(e);
                        b.a((Reader) bufferedReader);
                        return f9953a;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader3 = bufferedReader;
                        com.kwad.sdk.core.d.a.b(e);
                        b.a((Reader) bufferedReader3);
                        bufferedReader2 = bufferedReader3;
                        return f9953a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = myPid;
                }
            }
            return f9953a;
        }
        return f9953a;
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int length = str2.length();
        int i = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (i != -1) {
                    break;
                }
            } else if (i == -1) {
                i = length;
            }
            length++;
        }
        if (i == -1) {
            return null;
        }
        return length == -1 ? str.substring(i) : str.substring(i, length);
    }

    public static boolean a(int i) {
        return b() >= i;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static a c() {
        RandomAccessFile randomAccessFile;
        String a2;
        a aVar = new a();
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/self/status", "r");
                while (true) {
                    try {
                        String readLine = randomAccessFile.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!TextUtils.isEmpty(readLine)) {
                            if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                                String a3 = a(readLine, "VmSize");
                                if (a3 != null) {
                                    aVar.f9956b = Long.valueOf(a3).longValue();
                                }
                            } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                                String a4 = a(readLine, "VmRSS:");
                                if (a4 != null) {
                                    aVar.c = Long.valueOf(a4).longValue();
                                }
                            } else if (readLine.startsWith("Threads:") && (a2 = a(readLine, "Threads:")) != null) {
                                aVar.f = Integer.valueOf(a2).intValue();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        com.kwad.sdk.core.d.a.b(e);
                        b.a(randomAccessFile);
                        return aVar;
                    }
                }
                b.a(randomAccessFile);
            } catch (Throwable th) {
                th = th;
                b.a((Closeable) null);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            b.a((Closeable) null);
            throw th;
        }
        return aVar;
    }
}
