package d.b.g0.a.c0.f.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.g0.a.c0.f.a;
import d.b.g0.a.k;
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
/* loaded from: classes3.dex */
public class c implements a.c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43704f = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public a.b f43705a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f43706b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.g0.a.c0.f.c.a f43707c;

    /* renamed from: d  reason: collision with root package name */
    public String f43708d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43709e;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f43710a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public String f43711b;

        /* renamed from: c  reason: collision with root package name */
        public String f43712c;

        /* renamed from: d  reason: collision with root package name */
        public String f43713d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f43714e;
    }

    /* loaded from: classes3.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a f43715a;

        public b(a aVar) {
            this.f43715a = aVar;
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
        this.f43708d = str;
        this.f43705a = bVar;
    }

    @Override // d.b.g0.a.c0.f.a.c
    public void start() {
        if (this.f43709e) {
            return;
        }
        try {
            this.f43706b = new LocalServerSocket(this.f43708d);
            this.f43709e = true;
            int i = 0;
            while (this.f43709e) {
                LocalSocket accept = this.f43706b.accept();
                d.b.g0.a.c0.f.c.a aVar = new d.b.g0.a.c0.f.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f43707c = aVar;
                aVar.o(this.f43705a);
                ExecutorUtilsExt.postOnSerial(this.f43707c, "V8InspectorServer");
                if (d.b.g0.a.m1.a.a.C() && (i = i + 1) > 10) {
                    if (f43704f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e2) {
            d.b.g0.a.c0.c.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // d.b.g0.a.c0.f.a.c
    public void stop() {
        this.f43709e = false;
        LocalServerSocket localServerSocket = this.f43706b;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (IOException e2) {
                d.b.g0.a.c0.c.c("V8InspectorServer", "stop local server fail", e2);
            }
            this.f43706b = null;
        }
        d.b.g0.a.c0.f.c.a aVar = this.f43707c;
        if (aVar != null) {
            aVar.l();
            this.f43707c = null;
        }
        this.f43705a = null;
    }
}
