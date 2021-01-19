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
/* loaded from: classes6.dex */
public class f {
    private static final Object pGy = new Object();
    private static final SimpleDateFormat pGz = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);
    private static final SimpleDateFormat pGA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public static String YD(String str) {
        String hn;
        synchronized (pGy) {
            hn = hn("looper", str);
        }
        return hn;
    }

    public static void eym() {
        e.eyl().post(new Runnable() { // from class: com.github.a.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                File[] amJ = c.amJ();
                if (amJ != null && amJ.length > 0) {
                    synchronized (f.pGy) {
                        for (File file : amJ) {
                            if (currentTimeMillis - file.lastModified() > 172800000) {
                                file.delete();
                            }
                        }
                    }
                }
            }
        });
    }

    private static String hn(String str, String str2) {
        BufferedWriter bufferedWriter;
        long currentTimeMillis;
        String str3 = "";
        try {
            File eyj = c.eyj();
            currentTimeMillis = System.currentTimeMillis();
            str3 = eyj.getAbsolutePath() + "/" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + pGz.format(Long.valueOf(currentTimeMillis)) + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX;
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
        } catch (Throwable th) {
            th = th;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write("\r\n");
            bufferedWriter.write("**********************");
            bufferedWriter.write("\r\n");
            bufferedWriter.write(pGA.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
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
        } catch (Throwable th2) {
            th = th2;
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
        return str3;
    }
}
