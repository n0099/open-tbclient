package d.a.m0.a.u.e.p;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import d.a.m0.a.h0.i.a;
import d.a.m0.a.h0.i.g;
import d.a.m0.a.h0.i.i;
import d.a.m0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements g.a {
        public a(c cVar) {
        }

        @Override // d.a.m0.a.h0.i.g.a
        public void a(@NonNull d.a.m0.a.h0.i.g gVar) {
            d.a.m0.a.h0.i.f.a("exit_skeleton");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements g.a {
        public b(c cVar) {
        }

        @Override // d.a.m0.a.h0.i.g.a
        public void a(@NonNull d.a.m0.a.h0.i.g gVar) {
            int d2 = gVar.d();
            if (d2 == 0) {
                i.i(d.a.m0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                d.a.m0.a.h0.i.f.d("data_init", FrsActivityConfig.GOOD);
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_waiting_and_retry);
            } else if (d2 == 1) {
                i.i(d.a.m0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                d.a.m0.a.h0.i.f.d("data_init", "bad");
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_net_unavailable);
            } else if (d2 != 2) {
                i.i(d.a.m0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                d.a.m0.a.h0.i.f.d("data_init", "unknown");
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_waiting_and_retry);
            } else {
                i.i(d.a.m0.a.h0.i.c.b("业务数据初始化异常；", gVar));
                d.a.m0.a.h0.i.f.d("data_init", "offline");
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* renamed from: d.a.m0.a.u.e.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0928c implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48980a;

        public C0928c(c cVar, String str) {
            this.f48980a = str;
        }

        @Override // d.a.m0.a.h0.i.g.a
        public void a(@NonNull d.a.m0.a.h0.i.g gVar) {
            d.a.m0.a.h0.i.d.b(this.f48980a);
            i.q(1);
            d.a.m0.a.h0.i.f.c("skeleton", gVar);
            i.i(d.a.m0.a.h0.i.c.b("5秒内未触发骨架屏移除；", gVar));
            i.k();
        }
    }

    public c(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public final d.a.m0.a.u.h.b r(JSONObject jSONObject) {
        i.d(new b(this));
        return new d.a.m0.a.u.h.b(0);
    }

    public d.a.m0.a.u.h.b s(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-HandleException", "params = " + str);
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-HandleException", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-HandleException", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("code");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.m0.a.u.h.b(202, "code is required");
        }
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-HandleException", "code: " + optString + "msg: " + jSONObject.optString("msg"));
        }
        char c2 = 65535;
        switch (optString.hashCode()) {
            case 48:
                if (optString.equals("0")) {
                    c2 = 0;
                    break;
                }
                break;
            case 49:
                if (optString.equals("1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 50:
                if (optString.equals("2")) {
                    c2 = 2;
                    break;
                }
                break;
            case 51:
                if (optString.equals("3")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return new d.a.m0.a.u.h.b(202, "unsupported code");
                    }
                    return u(jSONObject);
                }
                return t(jSONObject);
            }
            return r(jSONObject);
        }
        return v(jSONObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (r2 == 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        return new d.a.m0.a.u.h.b(202, "status value is invalid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
        d.a.m0.a.h0.i.d.c();
        d.a.m0.a.h0.i.i.q(0);
        d.a.m0.a.h0.i.i.d(new d.a.m0.a.u.e.p.c.a(r7));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.m0.a.u.h.b t(JSONObject jSONObject) {
        String optString = jSONObject.optString("data");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.m0.a.u.h.b(202, "data is required");
        }
        try {
            String optString2 = new JSONObject(optString).optString("status");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.m0.a.u.h.b(202, "status is required");
            }
            char c2 = 65535;
            int hashCode = optString2.hashCode();
            if (hashCode != 48) {
                if (hashCode == 49 && optString2.equals("1")) {
                    c2 = 0;
                }
            } else if (optString2.equals("0")) {
                c2 = 1;
            }
            return new d.a.m0.a.u.h.b(0);
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e2.printStackTrace();
            }
            return new d.a.m0.a.u.h.b(202, "invalid json data: " + optString);
        }
    }

    public final d.a.m0.a.u.h.b u(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return new d.a.m0.a.u.h.b(202);
        }
        String optString = optJSONObject.optString("content");
        String optString2 = optJSONObject.optString("type");
        String optString3 = optJSONObject.optString("source");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
            d.a.m0.a.e0.d.h("Api-HandleException", String.format("发生jserror: type = %s, source = %s, content = %s", optString2, optString3, optString));
            i.m(a.C0725a.a(optString2, optString, optString3));
            return new d.a.m0.a.u.h.b(0);
        }
        return new d.a.m0.a.u.h.b(202);
    }

    public final d.a.m0.a.u.h.b v(JSONObject jSONObject) {
        if (w()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-HandleException", "has triggered fmp before remove skeleton");
            }
            return new d.a.m0.a.u.h.b(0);
        }
        String optString = jSONObject.optString("data");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.m0.a.u.h.b(202, "data is required");
        }
        try {
            String optString2 = new JSONObject(optString).optString("path");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.m0.a.u.h.b(202, "path is required");
            }
            if (q0.I(optString2) && q0.H()) {
                i.s(new C0928c(this, optString2));
            } else if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-HandleException", "path is not first page: " + optString2);
            }
            return new d.a.m0.a.u.h.b(0);
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e2.printStackTrace();
            }
            return new d.a.m0.a.u.h.b(202, "invalid json data: " + optString);
        }
    }

    public final boolean w() {
        d.a.m0.a.h0.g.f o;
        d.a.m0.a.p.e.b b3;
        d.a.m0.a.h0.g.g W = d.a.m0.a.g1.f.V().W();
        if (W == null || (o = W.o()) == null || (b3 = o.b3()) == null) {
            return false;
        }
        return b3.i0();
    }
}
