package d.a.l0.a.e0.h.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.e0.h.a;
import d.a.l0.a.h0.l.e;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import g.c.i.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a.c {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45206g = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public final a.b f45207a;

    /* renamed from: b  reason: collision with root package name */
    public g.c.e.a f45208b;

    /* renamed from: c  reason: collision with root package name */
    public InspectorNativeClient f45209c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.l0.a f45210d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedBlockingQueue<String> f45211e = new LinkedBlockingQueue<>();

    /* renamed from: f  reason: collision with root package name */
    public String f45212f;

    /* loaded from: classes2.dex */
    public class a extends InspectorNativeChannel {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (b.f45206g) {
                Log.d("V8InspectorClient", "getInspectorMessage");
            }
            try {
                return (String) b.this.f45211e.take();
            } catch (InterruptedException e2) {
                if (b.f45206g) {
                    Log.e("V8InspectorClient", "awaitMessage on Debugger", e2);
                    return "";
                }
                return "";
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                if (b.this.f45208b != null) {
                    b.this.f45208b.send(str);
                }
            } catch (Exception unused) {
                if (b.f45206g) {
                    Log.d("V8InspectorClient", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    /* renamed from: d.a.l0.a.e0.h.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0663b extends g.c.e.a {

        /* renamed from: d.a.l0.a.e0.h.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) b.this.f45211e.poll();
                while (str != null) {
                    b.this.f45209c.dispatchProtocolMessage(str);
                    C0663b.this.c(str);
                    C0663b.this.d(str);
                    str = (String) b.this.f45211e.poll();
                }
            }
        }

        /* renamed from: d.a.l0.a.e0.h.c.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0664b implements Runnable {
            public RunnableC0664b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f45207a.onConnected();
            }
        }

        public C0663b(URI uri) {
            super(uri);
        }

        public final void c(String str) {
            if (TextUtils.isEmpty(str) || b.this.f45207a == null) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.a.l0.a.a2.d g2 = d.a.l0.a.a2.d.g();
                    SwanAppActivity x = g2.x();
                    if (g2.C() && x != null) {
                        x.runOnUiThread(new RunnableC0664b());
                    }
                }
            } catch (JSONException e2) {
                if (b.f45206g) {
                    Log.e("V8InspectorClient", "message is not a Json object", e2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
            if (r2 == 1) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
            d.a.l0.a.e0.d.b("V8InspectorClient", "Undefined command");
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
            d.a.l0.a.e0.d.g("V8InspectorClient", "v8 inspector close");
            d.a.l0.a.e0.f.f.d.d();
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void d(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("command");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                char c2 = 65535;
                int hashCode = optString.hashCode();
                if (hashCode != -934641255) {
                    if (hashCode == 94756344 && optString.equals(IntentConfig.CLOSE)) {
                        c2 = 1;
                    }
                } else if (optString.equals("reload")) {
                    c2 = 0;
                }
                d.a.l0.a.e0.d.g("V8InspectorClient", "v8 inspector reload");
                String optString2 = jSONObject.optString("value");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                }
            } catch (JSONException e2) {
                if (b.f45206g) {
                    Log.e("V8InspectorClient", "message is not a json object", e2);
                }
            }
        }

        @Override // g.c.e.a
        public void onClose(int i2, String str, boolean z) {
            d.a.l0.a.e0.d.g("V8InspectorClient", "V8 inspector closed");
        }

        @Override // g.c.e.a
        public void onError(Exception exc) {
            d.a.l0.a.e0.d.c("V8InspectorClient", "V8 inspector error", exc);
        }

        @Override // g.c.e.a
        public void onMessage(String str) {
            b.this.f45211e.offer(str);
            b.this.f45210d.postOnJSThread(new a());
        }

        @Override // g.c.e.a
        public void onOpen(h hVar) {
            d.a.l0.a.e0.d.g("V8InspectorClient", "V8 inspector opened");
            d.a.l0.a.h0.l.a P = g.N().P();
            if (P instanceof e) {
                b.this.f45210d = (d.a.l0.a.l0.a) P.g();
            }
            if (b.this.f45210d == null) {
                d.a.l0.a.e0.d.g("V8InspectorClient", "inner error, V8 mEngine is null");
                close();
                return;
            }
            b bVar = b.this;
            bVar.f45209c = bVar.f45210d.r0(new a());
        }
    }

    public b(String str, a.b bVar) {
        this.f45212f = str;
        this.f45207a = bVar;
    }

    @Override // d.a.l0.a.e0.h.a.c
    public void start() {
        try {
            C0663b c0663b = new C0663b(new URI(this.f45212f));
            this.f45208b = c0663b;
            c0663b.connect();
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.a.l0.a.e0.h.a.c
    public void stop() {
        g.c.e.a aVar = this.f45208b;
        if (aVar != null) {
            aVar.close();
            this.f45208b = null;
        }
    }
}
