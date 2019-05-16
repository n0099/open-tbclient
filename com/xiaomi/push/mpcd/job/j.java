package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes3.dex */
public class j extends g {
    public j(Context context, int i) {
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

    private String f() {
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

    private String g() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 23;
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public String b() {
        return "ram:" + f() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + g();
    }

    @Override // com.xiaomi.push.mpcd.job.g
    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.Storage;
    }
}
