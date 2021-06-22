package d.a.m0.a.e0.h.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.m0.a.e0.h.a;
import d.a.m0.a.k;
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
    public static final boolean f45325f = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public a.b f45326a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f45327b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.a.e0.h.c.a f45328c;

    /* renamed from: d  reason: collision with root package name */
    public String f45329d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45330e;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f45331a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public String f45332b;

        /* renamed from: c  reason: collision with root package name */
        public String f45333c;

        /* renamed from: d  reason: collision with root package name */
        public String f45334d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f45335e;
    }

    /* loaded from: classes3.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a f45336a;

        public b(a aVar) {
            this.f45336a = aVar;
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
            printWriter.close();
        }
    }

    public c(String str, a.b bVar) {
        this.f45329d = str;
        this.f45326a = bVar;
    }

    @Override // d.a.m0.a.e0.h.a.c
    public void start() {
        if (this.f45330e) {
            return;
        }
        try {
            this.f45327b = new LocalServerSocket(this.f45329d);
            this.f45330e = true;
            int i2 = 0;
            while (this.f45330e) {
                LocalSocket accept = this.f45327b.accept();
                d.a.m0.a.e0.h.c.a aVar = new d.a.m0.a.e0.h.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f45328c = aVar;
                aVar.o(this.f45326a);
                ExecutorUtilsExt.postOnSerial(this.f45328c, "V8InspectorServer");
                if (d.a.m0.a.u1.a.a.G() && (i2 = i2 + 1) > 10) {
                    if (f45325f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e2) {
            d.a.m0.a.e0.d.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // d.a.m0.a.e0.h.a.c
    public void stop() {
        this.f45330e = false;
        LocalServerSocket localServerSocket = this.f45327b;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (IOException e2) {
                d.a.m0.a.e0.d.c("V8InspectorServer", "stop local server fail", e2);
            }
            this.f45327b = null;
        }
        d.a.m0.a.e0.h.c.a aVar = this.f45328c;
        if (aVar != null) {
            aVar.l();
            this.f45328c = null;
        }
        this.f45326a = null;
    }
}
