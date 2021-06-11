package d.a.l0.a.h0.m.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.i;
import d.a.l0.a.a2.j;
import d.a.l0.a.k;
import d.a.l0.a.v2.w;
import d.a.l0.n.i.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.a.l0.a.h0.m.n.a implements g {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46059f = k.f46875a;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.v1.b.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0736b f46060e;

        public a(b bVar, C0736b c0736b) {
            this.f46060e = c0736b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.v1.b.b bVar) {
            this.f46060e.onFail(bVar.P());
        }
    }

    /* renamed from: d.a.l0.a.h0.m.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0736b implements g.a, d.a.l0.a.v2.e1.b<i.a> {

        /* renamed from: e  reason: collision with root package name */
        public final g.a f46061e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f46062f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f46063g = false;

        public C0736b(g.a aVar) {
            this.f46061e = aVar;
            this.f46062f = aVar != null;
            if (b.f46059f) {
                b.this.k("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // d.a.l0.n.i.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f46059f) {
                    b bVar = b.this;
                    bVar.k("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e2 + " url=" + str + " statRecord=" + jSONObject);
                }
                if (e2) {
                    this.f46061e.a(str, str2, jSONObject);
                }
            }
        }

        @Override // d.a.l0.n.i.g.a
        public void b(String str, int i2) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f46059f) {
                    b bVar = b.this;
                    bVar.k("IpcHttpCallbackWrapper#onSuccess", "valid=" + e2 + " statusCode=" + i2 + " response=" + str);
                }
                if (e2) {
                    c();
                    this.f46061e.b(str, i2);
                }
            }
        }

        public synchronized void c() {
            this.f46063g = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: d */
        public void onCallback(i.a aVar) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f46059f) {
                    b bVar = b.this;
                    bVar.k("IpcHttpCallbackWrapper#onCallback", "valid=" + e2 + " msg=" + aVar);
                }
                if (e2) {
                    String o = aVar.o("pms_http_with_ipc_key_action", "");
                    char c2 = 65535;
                    switch (o.hashCode()) {
                        case -2080875416:
                            if (o.equals("pms_http_with_ipc_action_success")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -898655015:
                            if (o.equals("pms_http_with_ipc_action_fail")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -480804291:
                            if (o.equals("pms_http_with_ipc_action_on_start")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1737801345:
                            if (o.equals("pms_http_with_ipc_action_stat_record")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    if (c2 == 0) {
                        a(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), w.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                    } else if (c2 == 1) {
                        b(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                    } else if (c2 == 2) {
                        onFail(new Exception(aVar.n("pms_http_with_ipc_key_error")));
                    } else if (c2 == 3) {
                        onStart();
                    }
                }
            }
        }

        public synchronized boolean e() {
            boolean z;
            if (this.f46062f) {
                z = this.f46063g ? false : true;
            }
            return z;
        }

        @Override // d.a.l0.n.i.g.a
        public void onFail(Exception exc) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f46059f) {
                    b bVar = b.this;
                    bVar.k("IpcHttpCallbackWrapper#onFail", "valid=" + e2 + " exception=" + exc);
                }
                if (e2) {
                    c();
                    g.a aVar = this.f46061e;
                    if (exc == null) {
                        exc = new Exception("onFail");
                    }
                    aVar.onFail(exc);
                }
            }
        }

        @Override // d.a.l0.n.i.g.a
        public void onStart() {
            synchronized (this) {
                boolean e2 = e();
                if (b.f46059f) {
                    b bVar = b.this;
                    bVar.k("IpcHttpCallbackWrapper#onStart", "valid=" + e2);
                }
                if (e2) {
                    this.f46061e.onStart();
                }
            }
        }
    }

    public b(j jVar) {
        super(jVar);
    }

    @Override // d.a.l0.a.h0.m.n.a, d.a.l0.n.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        if (f46059f) {
            j("buildJsonPostRequest");
        }
        i("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
    }

    @Override // d.a.l0.a.h0.m.n.a, d.a.l0.n.i.g
    public void c(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        if (f46059f) {
            j("buildGetRequest");
        }
        String a2 = d.a.l0.a.r1.l.d.a();
        if (a2 != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("launchid", a2);
        }
        i("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
    }

    public final void i(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        if (f46059f) {
            j("ipcHttp");
        }
        String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
        C0736b c0736b = new C0736b(aVar);
        d.a.l0.a.v1.b.b y = d.a.l0.a.v1.b.c.E("pms_http_with_ipc").y("pms_http_with_ipc_key_action", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        d.a.l0.a.v1.b.b t = y.y("pms_http_with_ipc_key_url", str2).y("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).t("pms_http_with_ipc_key_url_param_map", d.a.l0.a.h0.m.n.a.f(map)).t("pms_http_with_ipc_key_header_param_map", d.a.l0.a.h0.m.n.a.f(map2));
        t.K(true);
        t.G(c0736b);
        t.F(new a(this, c0736b));
        if (f46059f) {
            k("ipcHttp", "session=" + t);
        }
        t.M(e.H0);
    }

    public final void j(String str) {
        if (f46059f) {
            Log.i("PmsHttpForClient", str);
        }
    }

    public final void k(String str, String str2) {
        j(str + ": " + str2);
    }
}
