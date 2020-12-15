package com.github.a.a;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes7.dex */
public class f {
    private static final Object pso = new Object();
    private static final SimpleDateFormat psp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);
    private static final SimpleDateFormat psq = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public static String Zz(String str) {
        String hi;
        synchronized (pso) {
            hi = hi("looper", str);
        }
        return hi;
    }

    public static void exP() {
        e.exO().post(new Runnable() { // from class: com.github.a.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                File[] apr = c.apr();
                if (apr != null && apr.length > 0) {
                    synchronized (f.pso) {
                        for (File file : apr) {
                            if (currentTimeMillis - file.lastModified() > 172800000) {
                                file.delete();
                            }
                        }
                    }
                }
            }
        });
    }

    private static String hi(String str, String str2) {
        BufferedWriter bufferedWriter;
        String str3;
        Throwable th;
        try {
            File exM = c.exM();
            long currentTimeMillis = System.currentTimeMillis();
            str3 = exM.getAbsolutePath() + "/" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + psp.format(Long.valueOf(currentTimeMillis)) + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
            try {
                bufferedWriter.write("\r\n");
                bufferedWriter.write("**********************");
                bufferedWriter.write("\r\n");
                bufferedWriter.write(psq.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
                bufferedWriter.write("\r\n");
                bufferedWriter.write("\r\n");
                bufferedWriter.write(str2);
                bufferedWriter.write("\r\n");
                bufferedWriter.flush();
                bufferedWriter.close();
                BufferedWriter bufferedWriter2 = null;
                if (0 != 0) {
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e) {
                        Log.e("LogWriter", "save: ", e);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    Log.e("LogWriter", "save: ", th);
                    return str3;
                } finally {
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (Exception e2) {
                            Log.e("LogWriter", "save: ", e2);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            bufferedWriter = null;
            str3 = "";
            th = th4;
        }
        return str3;
    }
}
