package d.b.g0.a.e0.p.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.v;
import d.b.g0.a.k;
import d.b.g0.a.r1.i;
import d.b.g0.a.r1.j;
import d.b.g0.l.l.f;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b extends d.b.g0.a.e0.p.n.a implements f {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44200f = k.f45050a;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.n1.b.b> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0671b f44201e;

        public a(b bVar, C0671b c0671b) {
            this.f44201e = c0671b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.n1.b.b bVar) {
            this.f44201e.onFail(bVar.N());
        }
    }

    /* renamed from: d.b.g0.a.e0.p.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0671b implements f.a, d.b.g0.a.i2.u0.b<i.a> {

        /* renamed from: e  reason: collision with root package name */
        public final f.a f44202e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f44203f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f44204g = false;

        public C0671b(f.a aVar) {
            this.f44202e = aVar;
            this.f44203f = aVar != null;
            if (b.f44200f) {
                b.this.A("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // d.b.g0.l.l.f.a
        public void a(String str, String str2, JSONObject jSONObject) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f44200f) {
                    b bVar = b.this;
                    bVar.A("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e2 + " url=" + str + " statRecord=" + jSONObject);
                }
                if (e2) {
                    this.f44202e.a(str, str2, jSONObject);
                }
            }
        }

        @Override // d.b.g0.l.l.f.a
        public void b(String str, int i) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f44200f) {
                    b bVar = b.this;
                    bVar.A("IpcHttpCallbackWrapper#onSuccess", "valid=" + e2 + " statusCode=" + i + " response=" + str);
                }
                if (e2) {
                    c();
                    this.f44202e.b(str, i);
                }
            }
        }

        public synchronized void c() {
            this.f44204g = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
            if (r1 == 1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
            if (r1 == 2) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
            onFail(new java.lang.Exception(r7.m("pms_http_with_ipc_key_error")));
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
            b(r7.m("pms_http_with_ipc_key_response"), r7.h("pms_http_with_ipc_key_status_code"));
         */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCallback(i.a aVar) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f44200f) {
                    b bVar = b.this;
                    bVar.A("IpcHttpCallbackWrapper#onCallback", "valid=" + e2 + " msg=" + aVar);
                }
                if (e2) {
                    String n = aVar.n("pms_http_with_ipc_key_action", "");
                    char c2 = 65535;
                    int hashCode = n.hashCode();
                    if (hashCode != -2080875416) {
                        if (hashCode != -898655015) {
                            if (hashCode == 1737801345 && n.equals("pms_http_with_ipc_action_stat_record")) {
                                c2 = 0;
                            }
                        } else if (n.equals("pms_http_with_ipc_action_fail")) {
                            c2 = 2;
                        }
                    } else if (n.equals("pms_http_with_ipc_action_success")) {
                        c2 = 1;
                    }
                    a(aVar.m("pms_http_with_ipc_key_url"), aVar.m("pms_http_with_ipc_key_response"), v.b(aVar.m("pms_http_with_ipc_key_stat_record")));
                }
            }
        }

        public synchronized boolean e() {
            boolean z;
            if (this.f44203f) {
                z = this.f44204g ? false : true;
            }
            return z;
        }

        @Override // d.b.g0.l.l.f.a
        public void onFail(Exception exc) {
            synchronized (this) {
                boolean e2 = e();
                if (b.f44200f) {
                    b bVar = b.this;
                    bVar.A("IpcHttpCallbackWrapper#onFail", "valid=" + e2 + " exception=" + exc);
                }
                if (e2) {
                    c();
                    f.a aVar = this.f44202e;
                    if (exc == null) {
                        exc = new Exception("onFail");
                    }
                    aVar.onFail(exc);
                }
            }
        }
    }

    public b(j jVar) {
        super(jVar);
    }

    public final void A(String str, String str2) {
        z(str + ": " + str2);
    }

    @Override // d.b.g0.a.e0.p.n.a, d.b.g0.l.l.f
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        if (f44200f) {
            z("buildJsonPostRequest");
        }
        y("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
    }

    @Override // d.b.g0.a.e0.p.n.a, d.b.g0.l.l.f
    public void b(String str, Map<String, String> map, Map<String, String> map2, f.a aVar) {
        if (f44200f) {
            z("buildGetRequest");
        }
        y("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
    }

    public final void y(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
        if (f44200f) {
            z("ipcHttp");
        }
        String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
        C0671b c0671b = new C0671b(aVar);
        d.b.g0.a.n1.b.b w = d.b.g0.a.n1.b.c.C("pms_http_with_ipc").w("pms_http_with_ipc_key_action", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        d.b.g0.a.n1.b.b r = w.w("pms_http_with_ipc_key_url", str2).w("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).r("pms_http_with_ipc_key_url_param_map", d.b.g0.a.e0.p.n.a.e(map)).r("pms_http_with_ipc_key_header_param_map", d.b.g0.a.e0.p.n.a.e(map2));
        r.I(true);
        r.F(c0671b);
        r.E(new a(this, c0671b));
        if (f44200f) {
            A("ipcHttp", "session=" + r);
        }
        r.K(d.F0);
    }

    public final void z(String str) {
        if (f44200f) {
            Log.i("PmsHttpForClient", str);
        }
    }
}
