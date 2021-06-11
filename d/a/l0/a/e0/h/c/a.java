package d.a.l0.a.e0.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.google.zxing.common.StringUtils;
import d.a.l0.a.e0.h.a;
import d.a.l0.a.e0.h.c.c;
import d.a.l0.a.e0.h.d.a;
import d.a.l0.a.h;
import d.a.l0.a.h0.l.e;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
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
    public static final boolean l = k.f46875a;
    public static int m;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f45197e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f45198f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.a.e0.h.d.a f45199g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f45200h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f45201i;
    public d.a.l0.a.l0.a j;
    public a.b k;

    /* renamed from: d.a.l0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0661a implements a.InterfaceC0665a {

        /* renamed from: d.a.l0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0662a implements Runnable {
            public RunnableC0662a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) a.this.f45200h.poll();
                while (str != null) {
                    a.this.f45201i.dispatchProtocolMessage(str);
                    C0661a.this.e(str);
                    str = (String) a.this.f45200h.poll();
                }
            }
        }

        /* renamed from: d.a.l0.a.e0.h.c.a$a$b */
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

        public C0661a() {
        }

        @Override // d.a.l0.a.e0.h.d.a.InterfaceC0665a
        public void a(WebSocketFrame webSocketFrame) {
            a.this.f45200h.offer(webSocketFrame.g());
            a.this.j.postOnJSThread(new RunnableC0662a());
        }

        @Override // d.a.l0.a.e0.h.d.a.InterfaceC0665a
        public void b(IOException iOException) {
            d.a.l0.a.e0.d.c("ClientHandler", "V8 inspector exception", iOException);
            a.this.l();
        }

        @Override // d.a.l0.a.e0.h.d.a.InterfaceC0665a
        public void c() {
            d.a.l0.a.e0.d.g("ClientHandler", "V8 inspector opened");
            d.a.l0.a.h0.l.a P = g.N().P();
            if (P instanceof e) {
                a.this.j = (d.a.l0.a.l0.a) P.g();
            }
            if (a.this.j != null) {
                if (a.this.f45201i != null) {
                    a.this.f45201i.destroy();
                }
                a aVar = a.this;
                aVar.f45201i = aVar.j.r0(new b());
                int unused = a.m = 1;
                return;
            }
            d.a.l0.a.e0.d.g("ClientHandler", "inner error, V8 mEngine is null");
            a.this.l();
        }

        public final void e(String str) {
            if (TextUtils.isEmpty(str) || a.this.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
                    SwanAppActivity x = d.a.l0.a.a2.d.g().x();
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

        @Override // d.a.l0.a.e0.h.d.a.InterfaceC0665a
        public void onClose() {
            d.a.l0.a.e0.d.g("ClientHandler", "V8 inspector closed");
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
                return (String) a.this.f45200h.take();
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
                a.this.f45199g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception unused) {
                if (a.l) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this.f45197e = inputStream;
        this.f45198f = outputStream;
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
        LinkedBlockingQueue<String> linkedBlockingQueue = this.f45200h;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f45200h = null;
        }
        InspectorNativeClient inspectorNativeClient = this.f45201i;
        if (inspectorNativeClient != null) {
            inspectorNativeClient.destroy();
            this.f45201i = null;
        }
        InputStream inputStream = this.f45197e;
        if (inputStream != null) {
            d.a.l0.t.d.d(inputStream);
            this.f45197e = null;
        }
        OutputStream outputStream = this.f45198f;
        if (outputStream != null) {
            d.a.l0.t.d.d(outputStream);
            this.f45198f = null;
        }
        this.f45199g = null;
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
                aVar.f45224b = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f45225c = n(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f45226d = stringTokenizer.nextToken();
                    } else {
                        aVar.f45226d = "HTTP/1.1";
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
                            aVar.f45223a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f45197e));
                c.a aVar = new c.a();
                m(bufferedReader, aVar);
                d.a(aVar).e(this.f45198f);
                if (aVar.f45227e) {
                    if (m != 0 && m != 3) {
                        d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), h.aiapps_debug_inspect_doing).F();
                        return;
                    }
                    d.a.l0.a.e0.h.d.a aVar2 = new d.a.l0.a.e0.h.d.a();
                    this.f45199g = aVar2;
                    aVar2.k(new C0661a());
                    this.f45199g.h(this.f45197e, this.f45198f);
                }
            } catch (RuntimeException e2) {
                if (l) {
                    Log.e("ClientHandler", "Request parse fail", e2);
                }
            }
        } finally {
            d.a.l0.t.d.d(this.f45197e);
            d.a.l0.t.d.d(this.f45198f);
        }
    }
}
