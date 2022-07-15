package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.sofire.utility.PermissionChecker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public final class SystemUtil {
    public static long a;
    public static long b;
    public static int c;
    public static LEVEL d;

    /* loaded from: classes5.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        public int value;

        LEVEL(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes5.dex */
    public static class a {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public int f;
    }

    public static long a() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(HardwareInfoUtils.MEM_INFO_FILE), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        com.kwad.sdk.crash.utils.b.a(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.a(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.a(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static String a(String str, String str2) {
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
        return d() >= i;
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return a(context, PermissionChecker.READ_PHONE_STATE);
    }

    public static boolean a(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i = 0; i <= 0; i++) {
            if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static String b(Context context) {
        return ak.a(context);
    }

    public static void b() {
    }

    public static a c() {
        String a2;
        a aVar = new a();
        RandomAccessFile randomAccessFile = null;
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
                                aVar.b = Long.valueOf(a3).longValue();
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
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.a(randomAccessFile);
                    return aVar;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.a(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.a(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return aVar;
    }

    public static boolean c(Context context) {
        return ak.b(context);
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    public static long d(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }
}
