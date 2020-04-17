package com.xiaomi.push;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes8.dex */
public class ea extends dx {
    public ea(Context context, int i) {
        super(context, i);
    }

    private double a(double d) {
        int i = 1;
        while (i < d) {
            i <<= 1;
        }
        return i;
    }

    private long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * statFs.getBlockCount();
    }

    private String b() {
        BufferedReader bufferedReader;
        String[] split;
        String str = "0";
        File file = new File("/proc/meminfo");
        if (file != null && file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            } catch (Exception e) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2) {
                    double doubleValue = (Double.valueOf(split[1]).doubleValue() / 1024.0d) / 1024.0d;
                    if (doubleValue > 0.5d) {
                        doubleValue = Math.ceil(doubleValue);
                    }
                    str = doubleValue + "";
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                str = "0";
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
                return str + "GB";
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }
        return str + "GB";
    }

    private String c() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo160a() {
        return 23;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hi mo160a() {
        return hi.Storage;
    }

    @Override // com.xiaomi.push.dx, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo160a() {
        return "ram:" + b() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + c();
    }
}
