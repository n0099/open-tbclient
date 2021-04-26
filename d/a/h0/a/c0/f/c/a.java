package d.a.h0.a.c0.f.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.google.zxing.common.StringUtils;
import d.a.h0.a.c0.f.a;
import d.a.h0.a.c0.f.c.c;
import d.a.h0.a.c0.f.d.a;
import d.a.h0.a.e0.o.e;
import d.a.h0.a.h;
import d.a.h0.a.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements Runnable {
    public static final boolean l = k.f43101a;
    public static int m;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f41696e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f41697f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.a.c0.f.d.a f41698g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f41699h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f41700i;
    public d.a.h0.g.i.a j;
    public a.b k;

    /* renamed from: d.a.h0.a.c0.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0596a implements a.InterfaceC0600a {

        /* renamed from: d.a.h0.a.c0.f.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0597a implements Runnable {
            public RunnableC0597a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) a.this.f41699h.poll();
                while (str != null) {
                    a.this.f41700i.dispatchProtocolMessage(str);
                    C0596a.this.e(str);
                    str = (String) a.this.f41699h.poll();
                }
            }
        }

        /* renamed from: d.a.h0.a.c0.f.c.a$a$b */
        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.k.onConnected();
                a.this.k = null;
                int unused = a.m = 2;
            }
        }

        public C0596a() {
        }

        @Override // d.a.h0.a.c0.f.d.a.InterfaceC0600a
        public void a(WebSocketFrame webSocketFrame) {
            a.this.f41699h.offer(webSocketFrame.g());
            a.this.j.postOnJSThread(new RunnableC0597a());
        }

        @Override // d.a.h0.a.c0.f.d.a.InterfaceC0600a
        public void b(IOException iOException) {
            d.a.h0.a.c0.c.c("ClientHandler", "V8 inspector exception", iOException);
            a.this.l();
        }

        @Override // d.a.h0.a.c0.f.d.a.InterfaceC0600a
        public void c() {
            d.a.h0.a.c0.c.g("ClientHandler", "V8 inspector opened");
            d.a.h0.a.e0.o.a N = d.a.h0.a.e0.w.d.L().N();
            if (N instanceof e) {
                a.this.j = (d.a.h0.g.i.a) N.g();
            }
            if (a.this.j != null) {
                if (a.this.f41700i != null) {
                    a.this.f41700i.destroy();
                }
                a aVar = a.this;
                aVar.f41700i = aVar.j.n0(new b());
                int unused = a.m = 1;
                return;
            }
            d.a.h0.a.c0.c.g("ClientHandler", "inner error, V8 mEngine is null");
            a.this.l();
        }

        public final void e(String str) {
            if (TextUtils.isEmpty(str) || a.this.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
                    SwanAppActivity v = d.a.h0.a.r1.d.e().v();
                    if (e2.z() && v != null) {
                        v.runOnUiThread(new b());
                    }
                }
            } catch (JSONException e3) {
                if (a.l) {
                    Log.e("ClientHandler", "message is not a Json object", e3);
                }
            }
        }

        @Override // d.a.h0.a.c0.f.d.a.InterfaceC0600a
        public void onClose() {
            d.a.h0.a.c0.c.g("ClientHandler", "V8 inspector closed");
            a.this.l();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends InspectorNativeChannel {
        public b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (a.l) {
                Log.d("ClientHandler", "getInspectorMessage");
            }
            try {
                return (String) a.this.f41699h.take();
            } catch (InterruptedException e2) {
                if (a.l) {
                    Log.e("ClientHandler", "awaitMessage on Debugger", e2);
                    return "";
                }
                return "";
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                a.this.f41698g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception unused) {
                if (a.l) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this.f41696e = inputStream;
        this.f41697f = outputStream;
    }

    public static String n(String str) {
        try {
            return URLDecoder.decode(str, StringUtils.UTF8);
        } catch (UnsupportedEncodingException unused) {
            if (l) {
                Log.d("ClientHandler", "Encoding not supported, ignored");
            }
            return null;
        }
    }

    public void l() {
        LinkedBlockingQueue<String> linkedBlockingQueue = this.f41699h;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f41699h = null;
        }
        InspectorNativeClient inspectorNativeClient = this.f41700i;
        if (inspectorNativeClient != null) {
            inspectorNativeClient.destroy();
            this.f41700i = null;
        }
        InputStream inputStream = this.f41696e;
        if (inputStream != null) {
            d.a.h0.p.d.a(inputStream);
            this.f41696e = null;
        }
        OutputStream outputStream = this.f41697f;
        if (outputStream != null) {
            d.a.h0.p.d.a(outputStream);
            this.f41697f = null;
        }
        this.f41698g = null;
        this.j = null;
        m = 3;
    }

    public final void m(BufferedReader bufferedReader, c.a aVar) {
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
            if (stringTokenizer.hasMoreTokens()) {
                aVar.f41723b = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f41724c = n(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f41725d = stringTokenizer.nextToken();
                    } else {
                        aVar.f41725d = "HTTP/1.1";
                        if (l) {
                            Log.d("ClientHandler", "no protocol version specified, Assuming HTTP/1.1.");
                        }
                    }
                    String readLine2 = bufferedReader.readLine();
                    while (readLine2 != null && !readLine2.trim().isEmpty()) {
                        if (l) {
                            Log.d("ClientHandler", "Http header :" + readLine2);
                        }
                        int indexOf = readLine2.indexOf(58);
                        if (indexOf >= 0) {
                            aVar.f41722a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
                        }
                        readLine2 = bufferedReader.readLine();
                    }
                    return;
                }
                throw new RuntimeException("BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            throw new RuntimeException("BAD REQUEST: Syntax error. Usage: GET /example/file.html");
        } catch (IOException e2) {
            if (l) {
                Log.e("ClientHandler", "Decode header exception", e2);
            }
        }
    }

    public void o(a.b bVar) {
        if (m == 0) {
            this.k = bVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f41696e));
                c.a aVar = new c.a();
                m(bufferedReader, aVar);
                d.a(aVar).e(this.f41697f);
                if (aVar.f41726e) {
                    if (m != 0 && m != 3) {
                        d.a.h0.a.q1.b.f.d.e(d.a.h0.a.w0.a.c(), h.aiapps_debug_inspect_doing).C();
                        return;
                    }
                    d.a.h0.a.c0.f.d.a aVar2 = new d.a.h0.a.c0.f.d.a();
                    this.f41698g = aVar2;
                    aVar2.k(new C0596a());
                    this.f41698g.h(this.f41696e, this.f41697f);
                }
            } catch (RuntimeException e2) {
                if (l) {
                    Log.e("ClientHandler", "Request parse fail", e2);
                }
            }
        } finally {
            d.a.h0.p.d.a(this.f41696e);
            d.a.h0.p.d.a(this.f41697f);
        }
    }
}
