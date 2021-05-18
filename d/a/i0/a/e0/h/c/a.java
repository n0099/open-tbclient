package d.a.i0.a.e0.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.google.zxing.common.StringUtils;
import d.a.i0.a.e0.h.a;
import d.a.i0.a.e0.h.c.c;
import d.a.i0.a.e0.h.d.a;
import d.a.i0.a.h;
import d.a.i0.a.h0.l.e;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
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
    public static final boolean l = k.f43025a;
    public static int m;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f41347e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f41348f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.a.e0.h.d.a f41349g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f41350h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f41351i;
    public d.a.i0.a.l0.a j;
    public a.b k;

    /* renamed from: d.a.i0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0594a implements a.InterfaceC0598a {

        /* renamed from: d.a.i0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0595a implements Runnable {
            public RunnableC0595a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) a.this.f41350h.poll();
                while (str != null) {
                    a.this.f41351i.dispatchProtocolMessage(str);
                    C0594a.this.e(str);
                    str = (String) a.this.f41350h.poll();
                }
            }
        }

        /* renamed from: d.a.i0.a.e0.h.c.a$a$b */
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

        public C0594a() {
        }

        @Override // d.a.i0.a.e0.h.d.a.InterfaceC0598a
        public void a(WebSocketFrame webSocketFrame) {
            a.this.f41350h.offer(webSocketFrame.g());
            a.this.j.postOnJSThread(new RunnableC0595a());
        }

        @Override // d.a.i0.a.e0.h.d.a.InterfaceC0598a
        public void b(IOException iOException) {
            d.a.i0.a.e0.d.c("ClientHandler", "V8 inspector exception", iOException);
            a.this.l();
        }

        @Override // d.a.i0.a.e0.h.d.a.InterfaceC0598a
        public void c() {
            d.a.i0.a.e0.d.g("ClientHandler", "V8 inspector opened");
            d.a.i0.a.h0.l.a P = g.N().P();
            if (P instanceof e) {
                a.this.j = (d.a.i0.a.l0.a) P.g();
            }
            if (a.this.j != null) {
                if (a.this.f41351i != null) {
                    a.this.f41351i.destroy();
                }
                a aVar = a.this;
                aVar.f41351i = aVar.j.r0(new b());
                int unused = a.m = 1;
                return;
            }
            d.a.i0.a.e0.d.g("ClientHandler", "inner error, V8 mEngine is null");
            a.this.l();
        }

        public final void e(String str) {
            if (TextUtils.isEmpty(str) || a.this.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.i0.a.a2.d g2 = d.a.i0.a.a2.d.g();
                    SwanAppActivity x = d.a.i0.a.a2.d.g().x();
                    if (g2.C() && x != null) {
                        x.runOnUiThread(new b());
                    }
                }
            } catch (JSONException e2) {
                if (a.l) {
                    Log.e("ClientHandler", "message is not a Json object", e2);
                }
            }
        }

        @Override // d.a.i0.a.e0.h.d.a.InterfaceC0598a
        public void onClose() {
            d.a.i0.a.e0.d.g("ClientHandler", "V8 inspector closed");
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
                return (String) a.this.f41350h.take();
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
                a.this.f41349g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception unused) {
                if (a.l) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this.f41347e = inputStream;
        this.f41348f = outputStream;
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
        LinkedBlockingQueue<String> linkedBlockingQueue = this.f41350h;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f41350h = null;
        }
        InspectorNativeClient inspectorNativeClient = this.f41351i;
        if (inspectorNativeClient != null) {
            inspectorNativeClient.destroy();
            this.f41351i = null;
        }
        InputStream inputStream = this.f41347e;
        if (inputStream != null) {
            d.a.i0.t.d.d(inputStream);
            this.f41347e = null;
        }
        OutputStream outputStream = this.f41348f;
        if (outputStream != null) {
            d.a.i0.t.d.d(outputStream);
            this.f41348f = null;
        }
        this.f41349g = null;
        this.j = null;
        m = 3;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(BufferedReader bufferedReader, c.a aVar) {
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
            if (stringTokenizer.hasMoreTokens()) {
                aVar.f41374b = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f41375c = n(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f41376d = stringTokenizer.nextToken();
                    } else {
                        aVar.f41376d = "HTTP/1.1";
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
                            aVar.f41373a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f41347e));
                c.a aVar = new c.a();
                m(bufferedReader, aVar);
                d.a(aVar).e(this.f41348f);
                if (aVar.f41377e) {
                    if (m != 0 && m != 3) {
                        d.a.i0.a.z1.b.f.e.f(d.a.i0.a.c1.a.b(), h.aiapps_debug_inspect_doing).F();
                        return;
                    }
                    d.a.i0.a.e0.h.d.a aVar2 = new d.a.i0.a.e0.h.d.a();
                    this.f41349g = aVar2;
                    aVar2.k(new C0594a());
                    this.f41349g.h(this.f41347e, this.f41348f);
                }
            } catch (RuntimeException e2) {
                if (l) {
                    Log.e("ClientHandler", "Request parse fail", e2);
                }
            }
        } finally {
            d.a.i0.t.d.d(this.f41347e);
            d.a.i0.t.d.d(this.f41348f);
        }
    }
}
