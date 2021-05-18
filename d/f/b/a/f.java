package d.f.b.a;

import android.util.Log;
import com.android.internal.http.multipart.Part;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f66105a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f66106b = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public static final SimpleDateFormat f66107c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            File[] g2 = c.g();
            if (g2 == null || g2.length <= 0) {
                return;
            }
            synchronized (f.f66105a) {
                for (File file : g2) {
                    if (currentTimeMillis - file.lastModified() > 172800000) {
                        file.delete();
                    }
                }
            }
        }
    }

    public static void b() {
        e.b().post(new a());
    }

    public static String c(String str) {
        String d2;
        synchronized (f66105a) {
            d2 = d("looper", str);
        }
        return d2;
    }

    public static String d(String str, String str2) {
        long currentTimeMillis;
        BufferedWriter bufferedWriter;
        String str3 = "";
        BufferedWriter bufferedWriter2 = null;
        try {
            File c2 = c.c();
            currentTimeMillis = System.currentTimeMillis();
            str3 = c2.getAbsolutePath() + "/" + str + "-" + f66106b.format(Long.valueOf(currentTimeMillis)) + ".log";
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(str3, true), "UTF-8"));
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(Part.CRLF);
            bufferedWriter.write("**********************");
            bufferedWriter.write(Part.CRLF);
            bufferedWriter.write(f66107c.format(Long.valueOf(currentTimeMillis)) + "(write log time)");
            bufferedWriter.write(Part.CRLF);
            bufferedWriter.write(Part.CRLF);
            bufferedWriter.write(str2);
            bufferedWriter.write(Part.CRLF);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            try {
                Log.e("LogWriter", "save: ", th);
                return str3;
            } finally {
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e2) {
                        Log.e("LogWriter", "save: ", e2);
                    }
                }
            }
        }
        return str3;
    }
}
