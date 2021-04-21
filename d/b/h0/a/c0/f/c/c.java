package d.b.h0.a.c0.f.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.h0.a.c0.f.a;
import d.b.h0.a.k;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class c implements a.c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44426f = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public a.b f44427a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f44428b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.a.c0.f.c.a f44429c;

    /* renamed from: d  reason: collision with root package name */
    public String f44430d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44431e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f44432a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public String f44433b;

        /* renamed from: c  reason: collision with root package name */
        public String f44434c;

        /* renamed from: d  reason: collision with root package name */
        public String f44435d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44436e;
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a f44437a;

        public b(a aVar) {
            this.f44437a = aVar;
        }

        public String a() {
            return "";
        }

        public abstract Map<String, String> b();

        public abstract String c();

        public final void d(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append(Part.CRLF);
        }

        public void e(OutputStream outputStream) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            printWriter.append("HTTP/1.1").append(' ').append((CharSequence) c()).append(" \r\n");
            d(printWriter, "Date", simpleDateFormat.format(new Date()));
            printWriter.print("Content-Length: " + a().getBytes().length + Part.CRLF);
            Map<String, String> b2 = b();
            if (b2 != null && b2.size() > 0) {
                for (Map.Entry<String, String> entry : b().entrySet()) {
                    d(printWriter, entry.getKey(), entry.getValue());
                }
            }
            printWriter.append(Part.CRLF);
            printWriter.append((CharSequence) a());
            printWriter.flush();
        }
    }

    public c(String str, a.b bVar) {
        this.f44430d = str;
        this.f44427a = bVar;
    }

    @Override // d.b.h0.a.c0.f.a.c
    public void start() {
        if (this.f44431e) {
            return;
        }
        try {
            this.f44428b = new LocalServerSocket(this.f44430d);
            this.f44431e = true;
            int i = 0;
            while (this.f44431e) {
                LocalSocket accept = this.f44428b.accept();
                d.b.h0.a.c0.f.c.a aVar = new d.b.h0.a.c0.f.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f44429c = aVar;
                aVar.o(this.f44427a);
                ExecutorUtilsExt.postOnSerial(this.f44429c, "V8InspectorServer");
                if (d.b.h0.a.m1.a.a.C() && (i = i + 1) > 10) {
                    if (f44426f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e2) {
            d.b.h0.a.c0.c.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // d.b.h0.a.c0.f.a.c
    public void stop() {
        this.f44431e = false;
        LocalServerSocket localServerSocket = this.f44428b;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (IOException e2) {
                d.b.h0.a.c0.c.c("V8InspectorServer", "stop local server fail", e2);
            }
            this.f44428b = null;
        }
        d.b.h0.a.c0.f.c.a aVar = this.f44429c;
        if (aVar != null) {
            aVar.l();
            this.f44429c = null;
        }
        this.f44427a = null;
    }
}
