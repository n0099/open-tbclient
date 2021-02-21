package com.github.a.a.a;

import android.app.ActivityManager;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class b {
    private static int sCoreNum = 0;
    private static long pRL = 0;

    /* loaded from: classes6.dex */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static int getNumCores() {
        if (sCoreNum == 0) {
            try {
                sCoreNum = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Exception e) {
                Log.e("PerformanceUtils", "getNumCores exception", e);
                sCoreNum = 1;
            }
        }
        return sCoreNum;
    }

    public static long getFreeMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) com.github.a.a.c.eAH().provideContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getTotalMemory() {
        FileReader fileReader;
        String readLine;
        if (pRL == 0) {
            FileReader fileReader2 = null;
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                        r0 = bufferedReader.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                        bufferedReader.close();
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e) {
                                Log.e("PerformanceUtils", "close localFileReader exception = ", e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        Log.e("PerformanceUtils", "getTotalMemory exception = ", e);
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e3) {
                                Log.e("PerformanceUtils", "close localFileReader exception = ", e3);
                            }
                        }
                        pRL = r0;
                        return pRL;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileReader2.close();
                        } catch (IOException e4) {
                            Log.e("PerformanceUtils", "close localFileReader exception = ", e4);
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                throw th;
            }
            pRL = r0;
        }
        return pRL;
    }
}
