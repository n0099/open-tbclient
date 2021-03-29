package d.b.g0.a.c0.f.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.google.zxing.common.StringUtils;
import d.b.g0.a.c0.f.a;
import d.b.g0.a.c0.f.c.c;
import d.b.g0.a.c0.f.d.a;
import d.b.g0.a.e0.o.e;
import d.b.g0.a.h;
import d.b.g0.a.k;
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
    public static final boolean l = k.f45051a;
    public static int m;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f43686e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f43687f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.a.c0.f.d.a f43688g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f43689h = new LinkedBlockingQueue<>();
    public InspectorNativeClient i;
    public d.b.g0.g.i.a j;
    public a.b k;

    /* renamed from: d.b.g0.a.c0.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0625a implements a.InterfaceC0629a {

        /* renamed from: d.b.g0.a.c0.f.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0626a implements Runnable {
            public RunnableC0626a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) a.this.f43689h.poll();
                while (str != null) {
                    a.this.i.dispatchProtocolMessage(str);
                    C0625a.this.e(str);
                    str = (String) a.this.f43689h.poll();
                }
            }
        }

        /* renamed from: d.b.g0.a.c0.f.c.a$a$b */
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

        public C0625a() {
        }

        @Override // d.b.g0.a.c0.f.d.a.InterfaceC0629a
        public void a(WebSocketFrame webSocketFrame) {
            a.this.f43689h.offer(webSocketFrame.g());
            a.this.j.postOnJSThread(new RunnableC0626a());
        }

        @Override // d.b.g0.a.c0.f.d.a.InterfaceC0629a
        public void b(IOException iOException) {
            d.b.g0.a.c0.c.c("ClientHandler", "V8 inspector exception", iOException);
            a.this.l();
        }

        @Override // d.b.g0.a.c0.f.d.a.InterfaceC0629a
        public void c() {
            d.b.g0.a.c0.c.g("ClientHandler", "V8 inspector opened");
            d.b.g0.a.e0.o.a N = d.b.g0.a.e0.w.d.L().N();
            if (N instanceof e) {
                a.this.j = (d.b.g0.g.i.a) N.g();
            }
            if (a.this.j != null) {
                if (a.this.i != null) {
                    a.this.i.destroy();
                }
                a aVar = a.this;
                aVar.i = aVar.j.m0(new b());
                int unused = a.m = 1;
                return;
            }
            d.b.g0.a.c0.c.g("ClientHandler", "inner error, V8 mEngine is null");
            a.this.l();
        }

        public final void e(String str) {
            if (TextUtils.isEmpty(str) || a.this.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
                    SwanAppActivity n = d.b.g0.a.r1.d.e().n();
                    if (e2.x() && n != null) {
                        n.runOnUiThread(new b());
                    }
                }
            } catch (JSONException e3) {
                if (a.l) {
                    Log.e("ClientHandler", "message is not a Json object", e3);
                }
            }
        }

        @Override // d.b.g0.a.c0.f.d.a.InterfaceC0629a
        public void onClose() {
            d.b.g0.a.c0.c.g("ClientHandler", "V8 inspector closed");
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
                return (String) a.this.f43689h.take();
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
                a.this.f43688g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception unused) {
                if (a.l) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this.f43686e = inputStream;
        this.f43687f = outputStream;
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
        LinkedBlockingQueue<String> linkedBlockingQueue = this.f43689h;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f43689h = null;
        }
        InspectorNativeClient inspectorNativeClient = this.i;
        if (inspectorNativeClient != null) {
            inspectorNativeClient.destroy();
            this.i = null;
        }
        InputStream inputStream = this.f43686e;
        if (inputStream != null) {
            d.b.g0.p.d.a(inputStream);
            this.f43686e = null;
        }
        OutputStream outputStream = this.f43687f;
        if (outputStream != null) {
            d.b.g0.p.d.a(outputStream);
            this.f43687f = null;
        }
        this.f43688g = null;
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
                aVar.f43712b = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f43713c = n(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f43714d = stringTokenizer.nextToken();
                    } else {
                        aVar.f43714d = "HTTP/1.1";
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
                            aVar.f43711a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f43686e));
                c.a aVar = new c.a();
                m(bufferedReader, aVar);
                d.a(aVar).e(this.f43687f);
                if (aVar.f43715e) {
                    if (m != 0 && m != 3) {
                        d.b.g0.a.q1.b.f.d.e(d.b.g0.a.w0.a.c(), h.aiapps_debug_inspect_doing).C();
                        return;
                    }
                    d.b.g0.a.c0.f.d.a aVar2 = new d.b.g0.a.c0.f.d.a();
                    this.f43688g = aVar2;
                    aVar2.k(new C0625a());
                    this.f43688g.h(this.f43686e, this.f43687f);
                }
            } catch (RuntimeException e2) {
                if (l) {
                    Log.e("ClientHandler", "Request parse fail", e2);
                }
            }
        } finally {
            d.b.g0.p.d.a(this.f43686e);
            d.b.g0.p.d.a(this.f43687f);
        }
    }
}
