package d.b.i0.u2.c.j;

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
    public final String f61401f;

    /* renamed from: g  reason: collision with root package name */
    public Process f61402g;
    public FileOutputStream i;
    public a j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61400e = true;

    /* renamed from: h  reason: collision with root package name */
    public BufferedReader f61403h = null;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public b(String str, String str2, boolean z) {
        this.i = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.ENGLISH);
            this.i = new FileOutputStream(new File(str, str2 + "-" + simpleDateFormat.format(new Date()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION), true);
        } catch (FileNotFoundException e2) {
            BdLog.e(Log.getStackTraceString(e2));
        }
        if (z) {
            this.f61401f = "logcat -v threadtime *:v -d";
        } else {
            this.f61401f = "logcat -v threadtime *:v";
        }
    }

    public final void a() {
        Process process = this.f61402g;
        if (process != null) {
            process.destroy();
            this.f61402g = null;
        }
        BufferedReader bufferedReader = this.f61403h;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                this.f61403h = null;
            } catch (IOException e2) {
                BdLog.e(Log.getStackTraceString(e2));
            }
        }
        FileOutputStream fileOutputStream = this.i;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                BdLog.e(Log.getStackTraceString(e3));
            }
            this.i = null;
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
        this.f61400e = false;
        a();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String readLine;
        try {
            try {
                this.f61402g = Runtime.getRuntime().exec(this.f61401f);
                this.f61403h = new BufferedReader(new InputStreamReader(this.f61402g.getInputStream()), 1024);
                while (this.f61400e && (readLine = this.f61403h.readLine()) != null && this.f61400e) {
                    if (readLine.length() != 0 && this.i != null) {
                        FileOutputStream fileOutputStream = this.i;
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
