package d.b.g0.a.c0.f.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.c0.f.a;
import d.b.g0.a.e0.o.e;
import d.b.g0.a.k;
import g.c.i.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements a.c {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f44086g = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public final a.b f44087a;

    /* renamed from: b  reason: collision with root package name */
    public g.c.e.a f44088b;

    /* renamed from: c  reason: collision with root package name */
    public InspectorNativeClient f44089c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.g.i.a f44090d;

    /* renamed from: e  reason: collision with root package name */
    public LinkedBlockingQueue<String> f44091e = new LinkedBlockingQueue<>();

    /* renamed from: f  reason: collision with root package name */
    public String f44092f;

    /* loaded from: classes2.dex */
    public class a extends InspectorNativeChannel {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public String awaitMessage() {
            if (b.f44086g) {
                Log.d("V8InspectorClient", "getInspectorMessage");
            }
            try {
                return (String) b.this.f44091e.take();
            } catch (InterruptedException e2) {
                if (b.f44086g) {
                    Log.e("V8InspectorClient", "awaitMessage on Debugger", e2);
                    return "";
                }
                return "";
            }
        }

        @Override // com.baidu.searchbox.v8engine.InspectorNativeChannel
        public void sendMessage(String str) {
            try {
                if (b.this.f44088b != null) {
                    b.this.f44088b.send(str);
                }
            } catch (Exception unused) {
                if (b.f44086g) {
                    Log.d("V8InspectorClient", "V8 send message fail, try to check if websocket has opened");
                }
            }
        }
    }

    /* renamed from: d.b.g0.a.c0.f.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0639b extends g.c.e.a {

        /* renamed from: d.b.g0.a.c0.f.c.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = (String) b.this.f44091e.poll();
                while (str != null) {
                    b.this.f44089c.dispatchProtocolMessage(str);
                    C0639b.this.c(str);
                    C0639b.this.d(str);
                    str = (String) b.this.f44091e.poll();
                }
            }
        }

        /* renamed from: d.b.g0.a.c0.f.c.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0640b implements Runnable {
            public RunnableC0640b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f44087a.onConnected();
            }
        }

        public C0639b(URI uri) {
            super(uri);
        }

        public final void c(String str) {
            if (TextUtils.isEmpty(str) || b.this.f44087a == null) {
                return;
            }
            try {
                if (TextUtils.equals(new JSONObject(str).optString("method"), "Debugger.enable")) {
                    d.b.g0.a.r1.d e2 = d.b.g0.a.r1.d.e();
                    SwanAppActivity n = e2.n();
                    if (e2.x() && n != null) {
                        n.runOnUiThread(new RunnableC0640b());
                    }
                }
            } catch (JSONException e3) {
                if (b.f44086g) {
                    Log.e("V8InspectorClient", "message is not a Json object", e3);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
            if (r2 == 1) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
            d.b.g0.a.c0.c.b("V8InspectorClient", "Undefined command");
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
            d.b.g0.a.c0.c.g("V8InspectorClient", "v8 inspector close");
            d.b.g0.a.c0.d.e.d.d();
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
                d.b.g0.a.c0.c.g("V8InspectorClient", "v8 inspector reload");
                String optString2 = jSONObject.optString("value");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(Uri.parse(optString2).getHost(), "swanAPI")) {
                    SchemeRouter.invoke(AppRuntime.getAppContext(), optString2);
                }
            } catch (JSONException e2) {
                if (b.f44086g) {
                    Log.e("V8InspectorClient", "message is not a json object", e2);
                }
            }
        }

        @Override // g.c.e.a
        public void onClose(int i, String str, boolean z) {
            d.b.g0.a.c0.c.g("V8InspectorClient", "V8 inspector closed");
        }

        @Override // g.c.e.a
        public void onError(Exception exc) {
            d.b.g0.a.c0.c.c("V8InspectorClient", "V8 inspector error", exc);
        }

        @Override // g.c.e.a
        public void onMessage(String str) {
            b.this.f44091e.offer(str);
            b.this.f44090d.postOnJSThread(new a());
        }

        @Override // g.c.e.a
        public void onOpen(h hVar) {
            d.b.g0.a.c0.c.g("V8InspectorClient", "V8 inspector opened");
            d.b.g0.a.e0.o.a N = d.b.g0.a.e0.w.d.L().N();
            if (N instanceof e) {
                b.this.f44090d = (d.b.g0.g.i.a) N.g();
            }
            if (b.this.f44090d == null) {
                d.b.g0.a.c0.c.g("V8InspectorClient", "inner error, V8 mEngine is null");
                close();
                return;
            }
            b bVar = b.this;
            bVar.f44089c = bVar.f44090d.n0(new a());
        }
    }

    public b(String str, a.b bVar) {
        this.f44092f = str;
        this.f44087a = bVar;
    }

    @Override // d.b.g0.a.c0.f.a.c
    public void start() {
        try {
            C0639b c0639b = new C0639b(new URI(this.f44092f));
            this.f44088b = c0639b;
            c0639b.connect();
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.b.g0.a.c0.f.a.c
    public void stop() {
        g.c.e.a aVar = this.f44088b;
        if (aVar != null) {
            aVar.close();
            this.f44088b = null;
        }
    }
}
