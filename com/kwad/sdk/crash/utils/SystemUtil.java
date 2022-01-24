package com.kwad.sdk.crash.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.kuaishou.weapon.adsdk.DeviceInfo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class SystemUtil {
    public static volatile String a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Boolean f56598b;

    /* renamed from: c  reason: collision with root package name */
    public static long f56599c;

    /* renamed from: d  reason: collision with root package name */
    public static long f56600d;

    /* renamed from: e  reason: collision with root package name */
    public static int f56601e;

    /* renamed from: f  reason: collision with root package name */
    public static LEVEL f56602f;

    /* loaded from: classes3.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        public int value;

        LEVEL(int i2) {
            this.value = i2;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f56603b;

        /* renamed from: c  reason: collision with root package name */
        public long f56604c;

        /* renamed from: d  reason: collision with root package name */
        public long f56605d;

        /* renamed from: e  reason: collision with root package name */
        public long f56606e;

        /* renamed from: f  reason: collision with root package name */
        public int f56607f;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a() {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        String readLine;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            } catch (IOException e3) {
                com.kwad.sdk.core.d.a.b(e3);
                return 0L;
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e2 = e4;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
            if (bufferedReader != null) {
            }
            throw th;
        }
        do {
            try {
                try {
                    readLine = bufferedReader.readLine();
                } catch (Exception e5) {
                    e2 = e5;
                    com.kwad.sdk.core.d.a.b(e2);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        return 0L;
                    }
                    return 0L;
                }
                if (readLine == null) {
                    bufferedReader.close();
                    return 0L;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        com.kwad.sdk.core.d.a.b(e6);
                    }
                }
                throw th;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
        try {
            bufferedReader.close();
        } catch (IOException e7) {
            com.kwad.sdk.core.d.a.b(e7);
        }
        return longValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x000b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x003c */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        com.kwad.sdk.crash.utils.SystemUtil.a = r1.processName;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ?? isEmpty = TextUtils.isEmpty(a);
        if (isEmpty == 0) {
            return a;
        }
        try {
            isEmpty = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == isEmpty) {
                        break;
                    }
                }
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b(e3);
        }
        if (TextUtils.isEmpty(a)) {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(ProcessUtils.CMD_LINE_NAME)));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = bufferedReader.read();
                            if (read <= 0) {
                                break;
                            }
                            sb.append((char) read);
                        }
                        a = sb.toString();
                    } catch (FileNotFoundException e4) {
                        e2 = e4;
                        com.kwad.sdk.core.d.a.b(e2);
                        b.a((Reader) bufferedReader);
                        return a;
                    } catch (IOException e5) {
                        e2 = e5;
                        com.kwad.sdk.core.d.a.b(e2);
                        b.a((Reader) bufferedReader);
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.a((Reader) isEmpty);
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                bufferedReader = null;
                e2 = e6;
            } catch (IOException e7) {
                bufferedReader = null;
                e2 = e7;
            } catch (Throwable th3) {
                isEmpty = 0;
                th = th3;
                b.a((Reader) isEmpty);
                throw th;
            }
            b.a((Reader) bufferedReader);
        }
        return a;
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        int length = str2.length();
        int i2 = -1;
        while (true) {
            if (length >= str.length()) {
                length = -1;
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (i2 != -1) {
                    break;
                }
            } else if (i2 == -1) {
                i2 = length;
            }
            length++;
        }
        if (i2 == -1) {
            return null;
        }
        return length == -1 ? str.substring(i2) : str.substring(i2, length);
    }

    public static boolean a(int i2) {
        return b() >= i2;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean b(Context context) {
        if (f56598b == null) {
            String a2 = a(context);
            f56598b = Boolean.valueOf(!TextUtils.isEmpty(a2) && a2.equals(context.getPackageName()));
        }
        return f56598b.booleanValue();
    }

    public static long c(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static a c() {
        String a2;
        a aVar = new a();
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile("/proc/self/status", "r");
                while (true) {
                    try {
                        String readLine = randomAccessFile2.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!TextUtils.isEmpty(readLine)) {
                            if (readLine.startsWith("VmSize") && readLine.contains("kB")) {
                                String a3 = a(readLine, "VmSize");
                                if (a3 != null) {
                                    aVar.f56603b = Long.valueOf(a3).longValue();
                                }
                            } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                                String a4 = a(readLine, "VmRSS:");
                                if (a4 != null) {
                                    aVar.f56604c = Long.valueOf(a4).longValue();
                                }
                            } else if (readLine.startsWith("Threads:") && (a2 = a(readLine, "Threads:")) != null) {
                                aVar.f56607f = Integer.valueOf(a2).intValue();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        randomAccessFile = randomAccessFile2;
                        com.kwad.sdk.core.d.a.b(e);
                        b.a(randomAccessFile);
                        return aVar;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = randomAccessFile2;
                        b.a(randomAccessFile);
                        throw th;
                    }
                }
                b.a(randomAccessFile2);
            } catch (IOException e3) {
                e = e3;
            }
            return aVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int d(Context context) {
        if (com.kwad.sdk.b.a.booleanValue()) {
            return (int) DeviceInfo.getScreenBrightness(context);
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return -1;
        }
    }

    public static int e(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            applicationInfo = context.getApplicationInfo();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        if (applicationInfo != null) {
            return applicationInfo.targetSdkVersion;
        }
        ApplicationInfo applicationInfo2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        if (applicationInfo2 != null) {
            return applicationInfo2.targetSdkVersion;
        }
        return 0;
    }
}
