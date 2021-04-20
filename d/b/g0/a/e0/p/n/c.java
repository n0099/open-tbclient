package d.b.g0.a.e0.p.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.r1.i;
import d.b.g0.a.r1.l;
import d.b.g0.a.y0.e.f.c;
import d.b.g0.l.l.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends d.b.g0.a.e0.p.n.a implements f, d.b.g0.a.i2.u0.b<i.a> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f44599f = k.f45443a;

    /* loaded from: classes2.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.b.g0.a.e0.p.n.c.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
            c.this.b(str, map, map2, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e {
        public b() {
        }

        @Override // d.b.g0.a.e0.p.n.c.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar) {
            c.this.a(str, map, map2, jSONObject, aVar);
        }
    }

    /* renamed from: d.b.g0.a.e0.p.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0685c implements f.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44602e;

        public C0685c(String str) {
            this.f44602e = str;
        }

        @Override // d.b.g0.l.l.f.a
        public void a(String str, String str2, JSONObject jSONObject) {
            c.this.B(this.f44602e, "pms_http_with_ipc_action_stat_record", new c.a().w("pms_http_with_ipc_key_url", str).w("pms_http_with_ipc_key_response", str2).w("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
        }

        @Override // d.b.g0.l.l.f.a
        public void b(String str, int i) {
            c.this.B(this.f44602e, "pms_http_with_ipc_action_success", new c.a().w("pms_http_with_ipc_key_response", str).t("pms_http_with_ipc_key_status_code", i));
        }

        @Override // d.b.g0.l.l.f.a
        public void onFail(Exception exc) {
            c cVar = c.this;
            String str = this.f44602e;
            cVar.C(str, "http: " + exc);
            if (c.f44599f) {
                exc.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44605f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a f44606g;

        public d(String str, String str2, c.a aVar) {
            this.f44604e = str;
            this.f44605f = str2;
            this.f44606g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.b.g0.a.n1.b.c.f(this.f44604e, "pms_http_with_ipc")) {
                if (c.f44599f) {
                    c.this.F("callbackIpcSession", "return by topic pms_http_with_ipc");
                    return;
                }
                return;
            }
            d.b.g0.a.n1.b.b w = d.b.g0.a.n1.b.c.M(this.f44604e).w("pms_http_with_ipc_key_action", this.f44605f);
            c.a aVar = this.f44606g;
            if (aVar != null) {
                w.p(aVar.A());
            }
            if (c.f44599f) {
                c cVar = c.this;
                cVar.F("callbackIpcSession", "ipcSession= " + w);
            }
            w.J();
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, f.a aVar);
    }

    public c(l lVar) {
        super(lVar);
        d.b.g0.a.r1.b bVar = new d.b.g0.a.r1.b();
        bVar.e(this, "event_messenger_call");
        i(bVar);
    }

    public final void A(String str, @NonNull i.a aVar, @NonNull e eVar) {
        if (f44599f) {
            F("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
        }
        if (d.b.g0.a.n1.b.c.f(str, "pms_http_with_ipc")) {
            String m = aVar.m("pms_http_with_ipc_key_url");
            Map<String, String> d2 = d.b.g0.a.e0.p.n.a.d(aVar.e("pms_http_with_ipc_key_url_param_map"));
            Map<String, String> d3 = d.b.g0.a.e0.p.n.a.d(aVar.e("pms_http_with_ipc_key_header_param_map"));
            String m2 = aVar.m("pms_http_with_ipc_keyjson_body");
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(m2)) {
                    jSONObject = new JSONObject(m2);
                }
            } catch (JSONException e2) {
                if (f44599f) {
                    e2.printStackTrace();
                }
            }
            try {
                eVar.a(m, d2, d3, jSONObject, new C0685c(str));
            } catch (Exception e3) {
                C(str, "catch: " + e3);
                if (f44599f) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public final void B(String str, String str2, c.a aVar) {
        if (f44599f) {
            F("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        k0.X(new d(str, str2, aVar));
    }

    public final void C(String str, String str2) {
        B(str, "pms_http_with_ipc_action_fail", new c.a().w("pms_http_with_ipc_key_error", str2));
    }

    public final void D(i.a aVar) {
        if (f44599f) {
            F("handleIpcMsg", "msg=" + aVar);
        }
        if (aVar == null || !d.b.g0.a.n1.b.c.e(aVar.A(), "pms_http_with_ipc")) {
            return;
        }
        String m = aVar.m("ipc_session_id");
        if (f44599f) {
            F("handleIpcMsg", "session=" + m);
        }
        if (TextUtils.isEmpty(m)) {
            return;
        }
        String m2 = aVar.m("pms_http_with_ipc_key_action");
        if (f44599f) {
            F("handleIpcMsg", "action=" + m2);
        }
        if (TextUtils.isEmpty(m2)) {
            C(m, "empty action");
            return;
        }
        char c2 = 65535;
        int hashCode = m2.hashCode();
        if (hashCode != 646251642) {
            if (hashCode == 1779116731 && m2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                c2 = 1;
            }
        } else if (m2.equals("pms_http_with_ipc_action_build_get_request")) {
            c2 = 0;
        }
        if (c2 == 0) {
            A(m, aVar, new a());
        } else if (c2 != 1) {
            C(m, "no such action:" + m2);
        } else {
            A(m, aVar, new b());
        }
    }

    public final void E(String str) {
        if (f44599f) {
            Log.i("PmsHttpForService", str);
        }
    }

    public final void F(String str, String str2) {
        E(str + ": " + str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.i2.u0.b
    /* renamed from: G */
    public void onCallback(i.a aVar) {
        D(aVar);
    }
}
