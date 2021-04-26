package d.a.h0.a.c0.f.c;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.h0.a.c0.f.a;
import d.a.h0.a.k;
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
    public static final boolean f41716f = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public a.b f41717a;

    /* renamed from: b  reason: collision with root package name */
    public LocalServerSocket f41718b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.c0.f.c.a f41719c;

    /* renamed from: d  reason: collision with root package name */
    public String f41720d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f41721e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f41722a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public String f41723b;

        /* renamed from: c  reason: collision with root package name */
        public String f41724c;

        /* renamed from: d  reason: collision with root package name */
        public String f41725d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41726e;
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public a f41727a;

        public b(a aVar) {
            this.f41727a = aVar;
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
        this.f41720d = str;
        this.f41717a = bVar;
    }

    @Override // d.a.h0.a.c0.f.a.c
    public void start() {
        if (this.f41721e) {
            return;
        }
        try {
            this.f41718b = new LocalServerSocket(this.f41720d);
            this.f41721e = true;
            int i2 = 0;
            while (this.f41721e) {
                LocalSocket accept = this.f41718b.accept();
                d.a.h0.a.c0.f.c.a aVar = new d.a.h0.a.c0.f.c.a(accept.getInputStream(), accept.getOutputStream());
                this.f41719c = aVar;
                aVar.o(this.f41717a);
                ExecutorUtilsExt.postOnSerial(this.f41719c, "V8InspectorServer");
                if (d.a.h0.a.m1.a.a.C() && (i2 = i2 + 1) > 10) {
                    if (f41716f) {
                        Log.e("V8InspectorServer", "v8 inspector handshake exceeding the maximum limit");
                        return;
                    }
                    return;
                }
            }
        } catch (IOException e2) {
            d.a.h0.a.c0.c.c("V8InspectorServer", "launch local server fail", e2);
        }
    }

    @Override // d.a.h0.a.c0.f.a.c
    public void stop() {
        this.f41721e = false;
        LocalServerSocket localServerSocket = this.f41718b;
        if (localServerSocket != null) {
            try {
                localServerSocket.close();
            } catch (IOException e2) {
                d.a.h0.a.c0.c.c("V8InspectorServer", "stop local server fail", e2);
            }
            this.f41718b = null;
        }
        d.a.h0.a.c0.f.c.a aVar = this.f41719c;
        if (aVar != null) {
            aVar.l();
            this.f41719c = null;
        }
        this.f41717a = null;
    }
}
