package d.a.l0.a.h0.m.n;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.a2.i;
import d.a.l0.a.a2.l;
import d.a.l0.a.f1.e.f.c;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.n.i.g;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d extends d.a.l0.a.h0.m.n.a implements g, d.a.l0.a.v2.e1.b<i.a> {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46065f = k.f46875a;

    /* loaded from: classes2.dex */
    public class a implements e {
        public a() {
        }

        @Override // d.a.l0.a.h0.m.n.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            d.this.c(str, map, map2, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e {
        public b() {
        }

        @Override // d.a.l0.a.h0.m.n.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            d.this.a(str, map, map2, jSONObject, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements g.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46068e;

        public c(String str) {
            this.f46068e = str;
        }

        @Override // d.a.l0.n.i.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            d.this.D(this.f46068e, "pms_http_with_ipc_action_stat_record", new c.a().y("pms_http_with_ipc_key_url", str).y("pms_http_with_ipc_key_response", str2).y("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
        }

        @Override // d.a.l0.n.i.g.a
        public void b(String str, int i2) {
            d.this.D(this.f46068e, "pms_http_with_ipc_action_success", new c.a().y("pms_http_with_ipc_key_response", str).v("pms_http_with_ipc_key_status_code", i2));
        }

        @Override // d.a.l0.n.i.g.a
        public void onFail(Exception exc) {
            d dVar = d.this;
            String str = this.f46068e;
            dVar.E(str, "http: " + exc);
            if (d.f46065f) {
                exc.printStackTrace();
            }
        }

        @Override // d.a.l0.n.i.g.a
        public void onStart() {
            d.this.D(this.f46068e, "pms_http_with_ipc_action_on_start", null);
        }
    }

    /* renamed from: d.a.l0.a.h0.m.n.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0737d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46071f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a f46072g;

        public RunnableC0737d(String str, String str2, c.a aVar) {
            this.f46070e = str;
            this.f46071f = str2;
            this.f46072g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.a.l0.a.v1.b.c.g(this.f46070e, "pms_http_with_ipc")) {
                if (d.f46065f) {
                    d.this.H("callbackIpcSession", "return by topic pms_http_with_ipc");
                    return;
                }
                return;
            }
            d.a.l0.a.v1.b.b y = d.a.l0.a.v1.b.c.O(this.f46070e).y("pms_http_with_ipc_key_action", this.f46071f);
            c.a aVar = this.f46072g;
            if (aVar != null) {
                y.r(aVar.C());
            }
            if (d.f46065f) {
                d dVar = d.this;
                dVar.H("callbackIpcSession", "ipcSession= " + y);
            }
            y.L();
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar);
    }

    public d(l lVar) {
        super(lVar);
        d.a.l0.a.a2.b bVar = new d.a.l0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    public final void D(String str, String str2, c.a aVar) {
        if (f46065f) {
            H("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q0.b0(new RunnableC0737d(str, str2, aVar));
    }

    public final void E(String str, String str2) {
        D(str, "pms_http_with_ipc_action_fail", new c.a().y("pms_http_with_ipc_key_error", str2));
    }

    public final void F(i.a aVar) {
        if (f46065f) {
            H("handleIpcMsg", "msg=" + aVar);
        }
        if (aVar == null || !d.a.l0.a.v1.b.c.f(aVar.C(), "pms_http_with_ipc")) {
            return;
        }
        String n = aVar.n("ipc_session_id");
        if (f46065f) {
            H("handleIpcMsg", "session=" + n);
        }
        if (TextUtils.isEmpty(n)) {
            return;
        }
        String n2 = aVar.n("pms_http_with_ipc_key_action");
        if (f46065f) {
            H("handleIpcMsg", "action=" + n2);
        }
        if (TextUtils.isEmpty(n2)) {
            E(n, "empty action");
            return;
        }
        char c2 = 65535;
        int hashCode = n2.hashCode();
        if (hashCode != 646251642) {
            if (hashCode == 1779116731 && n2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                c2 = 1;
            }
        } else if (n2.equals("pms_http_with_ipc_action_build_get_request")) {
            c2 = 0;
        }
        if (c2 == 0) {
            k(n, aVar, new a());
        } else if (c2 != 1) {
            E(n, "no such action:" + n2);
        } else {
            k(n, aVar, new b());
        }
    }

    public final void G(String str) {
        if (f46065f) {
            Log.i("PmsHttpForService", str);
        }
    }

    public final void H(String str, String str2) {
        G(str + ": " + str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.v2.e1.b
    /* renamed from: I */
    public void onCallback(i.a aVar) {
        F(aVar);
    }

    public final void k(String str, @NonNull i.a aVar, @NonNull e eVar) {
        if (f46065f) {
            H("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
        }
        if (d.a.l0.a.v1.b.c.g(str, "pms_http_with_ipc")) {
            String n = aVar.n("pms_http_with_ipc_key_url");
            Map<String, String> e2 = d.a.l0.a.h0.m.n.a.e(aVar.f("pms_http_with_ipc_key_url_param_map"));
            Map<String, String> e3 = d.a.l0.a.h0.m.n.a.e(aVar.f("pms_http_with_ipc_key_header_param_map"));
            String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
            JSONObject jSONObject = null;
            try {
                if (!TextUtils.isEmpty(n2)) {
                    jSONObject = new JSONObject(n2);
                }
            } catch (JSONException e4) {
                if (f46065f) {
                    e4.printStackTrace();
                }
            }
            try {
                eVar.a(n, e2, e3, jSONObject, new c(str));
            } catch (Exception e5) {
                E(str, "catch: " + e5);
                if (f46065f) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
