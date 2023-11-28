package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes10.dex */
public final class SystemUtil {
    public static long aOE;
    public static long aOF;
    public static int aOG;
    public static LEVEL aOH;

    /* loaded from: classes10.dex */
    public static class a {
        public long aOI;
        public long aOJ;
        public long aOK;
        public long aOL;
        public long aOM;
        public int mThreadsCount;
    }

    public static void checkUiThread() {
    }

    public static long Lo() {
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
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!readLine.contains("MemTotal"));
            long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return longValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* loaded from: classes10.dex */
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

    public static a Lp() {
        String aw;
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
                            String aw2 = aw(readLine, "VmSize");
                            if (aw2 != null) {
                                aVar.aOJ = Long.valueOf(aw2).longValue();
                            }
                        } else if (readLine.startsWith("VmRSS:") && readLine.contains("kB")) {
                            String aw3 = aw(readLine, "VmRSS:");
                            if (aw3 != null) {
                                aVar.aOK = Long.valueOf(aw3).longValue();
                            }
                        } else if (readLine.startsWith("Threads:") && (aw = aw(readLine, "Threads:")) != null) {
                            aVar.mThreadsCount = Integer.valueOf(aw).intValue();
                        }
                    }
                } catch (IOException unused) {
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    return aVar;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return aVar;
    }

    public static String aw(String str, String str2) {
        int length = str2.length();
        int i = -1;
        while (true) {
            if (length < str.length()) {
                char charAt = str.charAt(length);
                if (charAt >= '0' && charAt <= '9') {
                    if (i == -1) {
                        i = length;
                    }
                } else if (i != -1) {
                    break;
                }
                length++;
            } else {
                length = -1;
                break;
            }
        }
        if (i == -1) {
            return null;
        }
        if (length == -1) {
            return str.substring(i);
        }
        return str.substring(i, length);
    }

    public static boolean b(Context context, @NonNull String... strArr) {
        if (context == null) {
            return false;
        }
        for (int i = 0; i <= 0; i++) {
            try {
                if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static boolean cU(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return false;
        }
        return b(context, com.kuaishou.weapon.p0.g.c);
    }

    public static long cV(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static boolean dF(int i) {
        if (getApiLevel() >= i) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String getProcessName(Context context) {
        return aq.getProcessName(context);
    }

    public static boolean isInMainProcess(Context context) {
        return aq.isInMainProcess(context);
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }
}
