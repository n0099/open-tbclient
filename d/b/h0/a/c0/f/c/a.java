package d.b.h0.a.c0.f.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.google.zxing.common.StringUtils;
import d.b.h0.a.c0.f.a;
import d.b.h0.a.c0.f.c.c;
import d.b.h0.a.c0.f.d.a;
import d.b.h0.a.e0.o.e;
import d.b.h0.a.h;
import d.b.h0.a.k;
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
    public static final boolean l = k.f45772a;
    public static int m;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f44407e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f44408f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.a.c0.f.d.a f44409g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f44410h = new LinkedBlockingQueue<>();
    public InspectorNativeClient i;
    public d.b.h0.g.i.a j;
    public a.b k;

    /* renamed from: d.b.h0.a.c0.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0657a implements a.InterfaceC0661a {

        /* renamed from: d.b.h0.a.c0.f.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0658a implements Runnable {
            public RunnableC0658a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) a.this.f44410h.poll();
                while (str != null) {
                    a.this.i.dispatchProtocolMessage(str);
                    C0657a.this.e(str);
                    str = (String) a.this.f44410h.poll();
                }
            }
        }

        /* renamed from: d.b.h0.a.c0.f.c.a$a$b */
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

        public C0657a() {
        }

        @Override // d.b.h0.a.c0.f.d.a.InterfaceC0661a
        public void a(WebSocketFrame webSocketFrame) {
            a.this.f44410h.offer(webSocketFrame.g());
            a.this.j.postOnJSThread(new RunnableC0658a());
        }

        @Override // d.b.h0.a.c0.f.d.a.InterfaceC0661a
        public void b(IOException iOException) {
            d.b.h0.a.c0.c.c("ClientHandler", "V8 inspector exception", iOException);
            a.this.l();
        }

        @Override // d.b.h0.a.c0.f.d.a.InterfaceC0661a
        public void c() {
            d.b.h0.a.c0.c.g("ClientHandler", "V8 inspector opened");
            d.b.h0.a.e0.o.a N = d.b.h0.a.e0.w.d.L().N();
            if (N instanceof e) {
                a.this.j = (d.b.h0.g.i.a) N.g();
            }
            if (a.this.j != null) {
                if (a.this.i != null) {
                    a.this.i.destroy();
                }
                a aVar = a.this;
                aVar.i = aVar.j.n0(new b());
                int unused = a.m = 1;
                return;
            }
            d.b.h0.a.c0.c.g("ClientHandler", "inner error, V8 mEngine is null");
            a.this.l();
        }

        public final void e(String str) {
            if (TextUtils.isEmpty(str) || a.this.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.b.h0.a.r1.d e2 = d.b.h0.a.r1.d.e();
                    SwanAppActivity n = d.b.h0.a.r1.d.e().n();
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

        @Override // d.b.h0.a.c0.f.d.a.InterfaceC0661a
        public void onClose() {
            d.b.h0.a.c0.c.g("ClientHandler", "V8 inspector closed");
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
                return (String) a.this.f44410h.take();
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
                a.this.f44409g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception unused) {
                if (a.l) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this.f44407e = inputStream;
        this.f44408f = outputStream;
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
        LinkedBlockingQueue<String> linkedBlockingQueue = this.f44410h;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f44410h = null;
        }
        InspectorNativeClient inspectorNativeClient = this.i;
        if (inspectorNativeClient != null) {
            inspectorNativeClient.destroy();
            this.i = null;
        }
        InputStream inputStream = this.f44407e;
        if (inputStream != null) {
            d.b.h0.p.d.a(inputStream);
            this.f44407e = null;
        }
        OutputStream outputStream = this.f44408f;
        if (outputStream != null) {
            d.b.h0.p.d.a(outputStream);
            this.f44408f = null;
        }
        this.f44409g = null;
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
                aVar.f44433b = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f44434c = n(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f44435d = stringTokenizer.nextToken();
                    } else {
                        aVar.f44435d = "HTTP/1.1";
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
                            aVar.f44432a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f44407e));
                c.a aVar = new c.a();
                m(bufferedReader, aVar);
                d.a(aVar).e(this.f44408f);
                if (aVar.f44436e) {
                    if (m != 0 && m != 3) {
                        d.b.h0.a.q1.b.f.d.e(d.b.h0.a.w0.a.c(), h.aiapps_debug_inspect_doing).C();
                        return;
                    }
                    d.b.h0.a.c0.f.d.a aVar2 = new d.b.h0.a.c0.f.d.a();
                    this.f44409g = aVar2;
                    aVar2.k(new C0657a());
                    this.f44409g.h(this.f44407e, this.f44408f);
                }
            } catch (RuntimeException e2) {
                if (l) {
                    Log.e("ClientHandler", "Request parse fail", e2);
                }
            }
        } finally {
            d.b.h0.p.d.a(this.f44407e);
            d.b.h0.p.d.a(this.f44408f);
        }
    }
}
