package d.f.b.a.j;

import android.app.ActivityManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f66040a;

    /* renamed from: b  reason: collision with root package name */
    public static long f66041b;

    /* loaded from: classes6.dex */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static long a() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) d.f.b.a.c.d().provideContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static int b() {
        if (f66040a == 0) {
            try {
                f66040a = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Exception e2) {
                Log.e("PerformanceUtils", "getNumCores exception", e2);
                f66040a = 1;
            }
        }
        return f66040a;
    }

    public static long c() {
        FileReader fileReader;
        if (f66041b == 0) {
            FileReader fileReader2 = null;
            try {
                try {
                    try {
                        fileReader = new FileReader("/proc/meminfo");
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e3) {
                Log.e("PerformanceUtils", "close localFileReader exception = ", e3);
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
                String readLine = bufferedReader.readLine();
                r3 = readLine != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e4) {
                e = e4;
                fileReader2 = fileReader;
                Log.e("PerformanceUtils", "getTotalMemory exception = ", e);
                if (fileReader2 != null) {
                    fileReader2.close();
                }
                f66041b = r3;
                return f66041b;
            } catch (Throwable th2) {
                th = th2;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (IOException e5) {
                        Log.e("PerformanceUtils", "close localFileReader exception = ", e5);
                    }
                }
                throw th;
            }
            f66041b = r3;
        }
        return f66041b;
    }
}
