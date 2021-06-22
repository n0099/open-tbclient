package d.a.m0.a.e0.h.c;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.google.zxing.common.StringUtils;
import d.a.m0.a.e0.h.a;
import d.a.m0.a.e0.h.c.c;
import d.a.m0.a.e0.h.d.a;
import d.a.m0.a.h;
import d.a.m0.a.h0.l.e;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
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
/* loaded from: classes3.dex */
public class a implements Runnable {
    public static final boolean l = k.f46983a;
    public static int m;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f45305e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f45306f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.a.e0.h.d.a f45307g;

    /* renamed from: h  reason: collision with root package name */
    public LinkedBlockingQueue<String> f45308h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    public InspectorNativeClient f45309i;
    public d.a.m0.a.l0.a j;
    public a.b k;

    /* renamed from: d.a.m0.a.e0.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0664a implements a.InterfaceC0668a {

        /* renamed from: d.a.m0.a.e0.h.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0665a implements Runnable {
            public RunnableC0665a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) a.this.f45308h.poll();
                while (str != null) {
                    a.this.f45309i.dispatchProtocolMessage(str);
                    C0664a.this.e(str);
                    str = (String) a.this.f45308h.poll();
                }
            }
        }

        /* renamed from: d.a.m0.a.e0.h.c.a$a$b */
        /* loaded from: classes3.dex */
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

        public C0664a() {
        }

        @Override // d.a.m0.a.e0.h.d.a.InterfaceC0668a
        public void a(WebSocketFrame webSocketFrame) {
            a.this.f45308h.offer(webSocketFrame.g());
            a.this.j.postOnJSThread(new RunnableC0665a());
        }

        @Override // d.a.m0.a.e0.h.d.a.InterfaceC0668a
        public void b(IOException iOException) {
            d.a.m0.a.e0.d.c("ClientHandler", "V8 inspector exception", iOException);
            a.this.l();
        }

        @Override // d.a.m0.a.e0.h.d.a.InterfaceC0668a
        public void c() {
            d.a.m0.a.e0.d.g("ClientHandler", "V8 inspector opened");
            d.a.m0.a.h0.l.a P = g.N().P();
            if (P instanceof e) {
                a.this.j = (d.a.m0.a.l0.a) P.g();
            }
            if (a.this.j != null) {
                if (a.this.f45309i != null) {
                    a.this.f45309i.destroy();
                }
                a aVar = a.this;
                aVar.f45309i = aVar.j.r0(new b());
                int unused = a.m = 1;
                return;
            }
            d.a.m0.a.e0.d.g("ClientHandler", "inner error, V8 mEngine is null");
            a.this.l();
        }

        public final void e(String str) {
            if (TextUtils.isEmpty(str) || a.this.k == null || a.m == 2) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.m0.a.a2.d g2 = d.a.m0.a.a2.d.g();
                    SwanAppActivity x = d.a.m0.a.a2.d.g().x();
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

        @Override // d.a.m0.a.e0.h.d.a.InterfaceC0668a
        public void onClose() {
            d.a.m0.a.e0.d.g("ClientHandler", "V8 inspector closed");
            a.this.l();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends InspectorNativeChannel {
        public b() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (a.l) {
                Log.d("ClientHandler", "getInspectorMessage");
            }
            try {
                return (String) a.this.f45308h.take();
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
                a.this.f45307g.j(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, str));
            } catch (Exception unused) {
                if (a.l) {
                    Log.d("ClientHandler", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this.f45305e = inputStream;
        this.f45306f = outputStream;
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
        LinkedBlockingQueue<String> linkedBlockingQueue = this.f45308h;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
            this.f45308h = null;
        }
        InspectorNativeClient inspectorNativeClient = this.f45309i;
        if (inspectorNativeClient != null) {
            inspectorNativeClient.destroy();
            this.f45309i = null;
        }
        InputStream inputStream = this.f45305e;
        if (inputStream != null) {
            d.a.m0.t.d.d(inputStream);
            this.f45305e = null;
        }
        OutputStream outputStream = this.f45306f;
        if (outputStream != null) {
            d.a.m0.t.d.d(outputStream);
            this.f45306f = null;
        }
        this.f45307g = null;
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
                aVar.f45332b = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    aVar.f45333c = n(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        aVar.f45334d = stringTokenizer.nextToken();
                    } else {
                        aVar.f45334d = "HTTP/1.1";
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
                            aVar.f45331a.put(readLine2.substring(0, indexOf).trim().toLowerCase(), readLine2.substring(indexOf + 1).trim());
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f45305e));
                c.a aVar = new c.a();
                m(bufferedReader, aVar);
                d.a(aVar).e(this.f45306f);
                if (aVar.f45335e) {
                    if (m != 0 && m != 3) {
                        d.a.m0.a.z1.b.f.e.f(d.a.m0.a.c1.a.b(), h.aiapps_debug_inspect_doing).F();
                        return;
                    }
                    d.a.m0.a.e0.h.d.a aVar2 = new d.a.m0.a.e0.h.d.a();
                    this.f45307g = aVar2;
                    aVar2.k(new C0664a());
                    this.f45307g.h(this.f45305e, this.f45306f);
                }
            } catch (RuntimeException e2) {
                if (l) {
                    Log.e("ClientHandler", "Request parse fail", e2);
                }
            }
        } finally {
            d.a.m0.t.d.d(this.f45305e);
            d.a.m0.t.d.d(this.f45306f);
        }
    }
}
