package d.a.i0.a.e0.h.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.i0.a.e0.h.a;
import d.a.i0.a.k;
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
    public static final boolean f41367f = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public a.b f41368a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f41369b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.a.e0.h.c.a f41370c;

    /* renamed from: d  reason: collision with root package name */
    public String f41371d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41372e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f41373a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public String f41374b;

        /* renamed from: c  reason: collision with root package name */
        public String f41375c;

        /* renamed from: d  reason: collision with root package name */
        public String f41376d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41377e;
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a f41378a;

        public b(a aVar) {
            this.f41378a = aVar;
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
        this.f41371d = str;
        this.f41368a = bVar;
    }

    @Override // d.a.i0.a.e0.h.a.c
    public void start() {
        if (this.f41372e) {
            return;
        }
        try {
            this.f41369b = new LocalServerSocket(this.f41371d);
            this.f41372e = true;
            int i2 = 0;
            while (this.f41372e) {
                LocalSocket accept = this.f41369b.accept();
                d.a.i0.a.e0.h.c.a aVar = new d.a.i0.a.e0.h.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f41370c = aVar;
                aVar.o(this.f41368a);
                ExecutorUtilsExt.postOnSerial(this.f41370c, "V8InspectorServer");
                if (d.a.i0.a.u1.a.a.G() && (i2 = i2 + 1) > 10) {
                    if (f41367f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e2) {
            d.a.i0.a.e0.d.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // d.a.i0.a.e0.h.a.c
    public void stop() {
        this.f41372e = false;
        LocalServerSocket localServerSocket = this.f41369b;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (IOException e2) {
                d.a.i0.a.e0.d.c("V8InspectorServer", "stop local server fail", e2);
            }
            this.f41369b = null;
        }
        d.a.i0.a.e0.h.c.a aVar = this.f41370c;
        if (aVar != null) {
            aVar.l();
            this.f41370c = null;
        }
        this.f41368a = null;
    }
}
