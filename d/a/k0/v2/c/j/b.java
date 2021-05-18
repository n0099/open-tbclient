package d.a.k0.v2.c.j;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.down.request.db.DownloadDataConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes5.dex */
public class b extends Thread {

    /* renamed from: f  reason: collision with root package name */
    public final String f62528f;

    /* renamed from: g  reason: collision with root package name */
    public Process f62529g;

    /* renamed from: i  reason: collision with root package name */
    public FileOutputStream f62531i;
    public a j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62527e = true;

    /* renamed from: h  reason: collision with root package name */
    public BufferedReader f62530h = null;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public b(String str, String str2, boolean z) {
        this.f62531i = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.f62531i = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e2) {
            BdLog.e(Log.getStackTraceString(e2));
        }
        if (z) {
            this.f62528f = "logcat -v threadtime *:v -d";
        } else {
            this.f62528f = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Process process = this.f62529g;
        if (process != null) {
            process.destroy();
            this.f62529g = null;
        }
        BufferedReader bufferedReader = this.f62530h;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.f62530h = null;
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
        }
        FileOutputStream fileOutputStream = this.f62531i;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                BdLog.e(Log.getStackTraceString(e3));
            }
            this.f62531i = null;
        }
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b(a aVar) {
        this.j = aVar;
    }

    public void c() {
        this.f62527e = false;
        a();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            try {
                this.f62529g = Runtime.getRuntime().exec(this.f62528f);
                this.f62530h = new BufferedReader(new InputStreamReader(this.f62529g.getInputStream()), 1024);
                while (this.f62527e && (readLine = this.f62530h.readLine()) != null && this.f62527e) {
                    if (readLine.length() != 0 && this.f62531i != null) {
                        FileOutputStream fileOutputStream = this.f62531i;
                        fileOutputStream.write((readLine + "\n").getBytes());
                    }
                }
                BdLog.d("collector complete.");
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
        } finally {
            a();
        }
    }
}
