package com.kwad.sdk.glide.load.engine.b;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.bumptech.glide.load.engine.executor.RuntimeCompat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class b {
    public static int a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), availableProcessors) : availableProcessors;
    }

    public static int b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File("/sys/devices/system/cpu/");
            final Pattern compile = Pattern.compile(RuntimeCompat.CPU_NAME_REGEX);
            fileArr = file.listFiles(new FilenameFilter() { // from class: com.kwad.sdk.glide.load.engine.b.b.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return compile.matcher(str).matches();
                }
            });
        } catch (Throwable th) {
            try {
                if (Log.isLoggable(RuntimeCompat.TAG, 6)) {
                    Log.e(RuntimeCompat.TAG, "Failed to calculate accurate cpu count", th);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
