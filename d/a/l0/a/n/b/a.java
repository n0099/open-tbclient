package d.a.l0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
import d.a.l0.a.z1.b.b.h;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.client.methods.HttpDelete;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.u.c.d {

    /* renamed from: d  reason: collision with root package name */
    public static String f47210d;

    /* renamed from: d.a.l0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0807a implements Runnable {
        public RunnableC0807a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(a.this.i(), d.a.l0.a.h.swan_bookshelf_insert_async);
            f2.l(10);
            f2.r(false);
            f2.y();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f47212a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.j.b f47213b;

        /* renamed from: d.a.l0.a.n.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0808a implements Runnable {
            public RunnableC0808a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.z1.b.f.e.a();
            }
        }

        /* renamed from: d.a.l0.a.n.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0809b implements Runnable {
            public RunnableC0809b(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.z1.b.f.e.f(d.a.l0.a.c1.a.b(), d.a.l0.a.h.swan_bookshelf_insert_failed).F();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {
            public c(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.z1.b.f.e.a();
            }
        }

        public b(boolean z, d.a.l0.a.h0.j.b bVar) {
            this.f47212a = z;
            this.f47213b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (this.f47212a) {
                q0.b0(new RunnableC0808a(this));
            }
            if (jSONObject == null) {
                a.this.H(this.f47213b, 1001, "server response fail", this.f47212a);
                return;
            }
            int optInt = jSONObject.optInt("errno", -1);
            if (optInt != 0) {
                if (this.f47212a) {
                    q0.b0(new RunnableC0809b(this));
                }
                a.this.H(this.f47213b, optInt, jSONObject.optString("errmsg"), false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a.this.H(this.f47213b, 0, jSONObject.optString("errmsg"), this.f47212a);
            } else {
                a.this.I(this.f47213b, optJSONObject, this.f47212a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return w.d(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.f47212a) {
                q0.b0(new c(this));
            }
            a aVar = a.this;
            d.a.l0.a.h0.j.b bVar = this.f47213b;
            aVar.H(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f47212a);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47215e;

        public c(a aVar, String str) {
            this.f47215e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e.g(d.a.l0.a.c1.a.b(), this.f47215e).F();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e.f(a.this.i(), d.a.l0.a.h.aiapps_net_error).F();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e.f(a.this.i(), d.a.l0.a.h.aiapps_net_error).F();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47218e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47219f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47220g;

        /* renamed from: d.a.l0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0810a implements d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> {
            public C0810a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.h0.j.b
            /* renamed from: b */
            public void a(d.a.l0.a.u.h.b bVar) {
                f fVar = f.this;
                a.this.d(fVar.f47220g, bVar);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.z1.b.f.e.f(a.this.i(), d.a.l0.a.h.swan_bookshelf_authorize_fail).F();
            }
        }

        public f(JSONArray jSONArray, String str, String str2) {
            this.f47218e = jSONArray;
            this.f47219f = str;
            this.f47220g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                int t1 = d.a.l0.a.a2.d.g().r().L().t1();
                String u1 = d.a.l0.a.a2.d.g().r().L().u1();
                String D = d.a.l0.a.a2.d.g().r().D();
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", D);
                hashMap.put("contentIds", this.f47218e);
                hashMap.put("category", this.f47219f);
                hashMap.put("pkg_type", Integer.valueOf(t1));
                hashMap.put("version_code", u1);
                a.this.Q("INSERT", hashMap, new C0810a());
                return;
            }
            a.this.d(this.f47220g, new d.a.l0.a.u.h.b(iVar.b(), d.a.l0.a.e2.c.d.f(iVar.b())));
            q0.b0(new b());
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47225f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47226g;

        /* renamed from: d.a.l0.a.n.b.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0811a implements d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> {
            public C0811a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.h0.j.b
            /* renamed from: b */
            public void a(d.a.l0.a.u.h.b bVar) {
                g gVar = g.this;
                a.this.d(gVar.f47226g, bVar);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.a.l0.a.z1.b.f.e.f(a.this.i(), d.a.l0.a.h.swan_bookshelf_authorize_fail).F();
            }
        }

        public g(JSONArray jSONArray, String str, String str2) {
            this.f47224e = jSONArray;
            this.f47225f = str;
            this.f47226g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                int t1 = d.a.l0.a.a2.d.g().r().L().t1();
                String u1 = d.a.l0.a.a2.d.g().r().L().u1();
                String D = d.a.l0.a.a2.d.g().r().D();
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", D);
                hashMap.put("contentIds", this.f47224e);
                hashMap.put("category", this.f47225f);
                hashMap.put("pkg_type", Integer.valueOf(t1));
                hashMap.put("version_code", u1);
                a.this.Q(HttpDelete.METHOD_NAME, hashMap, new C0811a());
                return;
            }
            a.this.d(this.f47226g, new d.a.l0.a.u.h.b(iVar.b(), d.a.l0.a.e2.c.d.f(iVar.b())));
            q0.b0(new b());
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47230a;

        public h(String str) {
            this.f47230a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.l0.a.u.h.b bVar) {
            a.this.d(this.f47230a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47232a;

        public i(String str) {
            this.f47232a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(d.a.l0.a.u.h.b bVar) {
            a.this.d(this.f47232a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47235f;

        public j(boolean z, String str) {
            this.f47234e = z;
            this.f47235f = str;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                if (!this.f47234e) {
                    d.a.l0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.b.g0, 10, RetrieveTaskManager.KEY);
                }
                a.this.d(this.f47235f, new d.a.l0.a.u.h.b(1001, "user is not login"));
                return;
            }
            if (!this.f47234e) {
                d.a.l0.a.j2.k.M("success", 10, RetrieveTaskManager.KEY);
            }
            a.this.M(this.f47235f);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements CallbackHandler {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47237e;

        public k(String str) {
            this.f47237e = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            return null;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            a.this.K(str2, this.f47237e);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47240f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47241g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47242h;

        /* renamed from: d.a.l0.a.n.b.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0812a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0812a(l lVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b(l lVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d.a.l0.a.a2.d.g().r().T().E();
            }
        }

        public l(String str, String str2, String str3, String str4) {
            this.f47239e = str;
            this.f47240f = str2;
            this.f47241g = str3;
            this.f47242h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a aVar = new h.a(a.this.i());
            aVar.V(this.f47239e);
            aVar.x(this.f47240f);
            aVar.y();
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.m(false);
            aVar.P(this.f47241g, new b(this));
            aVar.C(this.f47242h, new DialogInterface$OnClickListenerC0812a(this));
            aVar.X();
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public final void C(JSONArray jSONArray, String str, String str2) {
        d.a.l0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new g(jSONArray, str, str2));
    }

    public final void D(JSONArray jSONArray, String str, String str2) {
        d.a.l0.a.a2.d.g().r().T().g(i(), "scope_insert_bookshelf", new f(jSONArray, str, str2));
    }

    public d.a.l0.a.u.h.b E(String str) {
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (!bVar.isSuccess() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(201, "category is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.l0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(i())) {
                q0.b0(new e());
                return new d.a.l0.a.u.h.b(1001, "network is not connected");
            } else if (L()) {
                G();
                return new d.a.l0.a.u.h.b(10003, d.a.l0.a.e2.c.d.f(10003));
            } else {
                C(optJSONArray, optString, optString2);
                return new d.a.l0.a.u.h.b(0);
            }
        }
        return new d.a.l0.a.u.h.b(201, "contentIds is invalid");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String F(String str) {
        char c2;
        switch (str.hashCode()) {
            case -2130463047:
                if (str.equals("INSERT")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 77406376:
                if (str.equals("QUERY")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1020968928:
                if (str.equals("UPDATE_READ_TIME")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 2012838315:
                if (str.equals(HttpDelete.METHOD_NAME)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return null;
                    }
                    return d.a.l0.a.c1.a.n().E();
                }
                return d.a.l0.a.c1.a.n().w();
            }
            return d.a.l0.a.c1.a.n().h();
        }
        return d.a.l0.a.c1.a.n().u();
    }

    public final void G() {
        q0.b0(new l(i().getString(d.a.l0.a.h.swan_bookshelf_setting_dialog_title), i().getString(d.a.l0.a.h.swan_bookshelf_setting_dialog_content), i().getString(d.a.l0.a.h.swanapp_string_go_settings), i().getString(d.a.l0.a.h.swanapp_close)));
    }

    public final void H(d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> bVar, int i2, String str, boolean z) {
        if (bVar != null) {
            bVar.a(new d.a.l0.a.u.h.b(i2, str));
        }
        if (z) {
            q0.b0(new c(this, str));
        }
    }

    public final void I(d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> bVar, JSONObject jSONObject, boolean z) {
        if (bVar != null && jSONObject != null) {
            bVar.a(new d.a.l0.a.u.h.b(0, jSONObject));
        }
        if (z) {
            d.a.l0.a.c1.a.e0().b(i());
        }
    }

    public d.a.l0.a.u.h.b J(String str) {
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (!bVar.isSuccess() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("category");
            f47210d = optString;
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(201, "category is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.l0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(i())) {
                q0.b0(new d());
                return new d.a.l0.a.u.h.b(1001, "network is not connected");
            } else if (L()) {
                G();
                return new d.a.l0.a.u.h.b(10003, d.a.l0.a.e2.c.d.f(10003));
            } else {
                D(optJSONArray, f47210d, optString2);
                return new d.a.l0.a.u.h.b(0);
            }
        }
        return new d.a.l0.a.u.h.b(201, "contentIds is invalid");
    }

    public final void K(String str, String str2) {
        int i2 = 1001;
        if (TextUtils.isEmpty(str)) {
            d(str2, new d.a.l0.a.u.h.b(1001, "navigateToBookshelf fail"));
        }
        try {
            i2 = new JSONObject(str).optInt("status", 1001);
        } catch (JSONException e2) {
            if (d.a.l0.a.u.c.d.f48486c) {
                e2.printStackTrace();
            }
        }
        if (i2 == 0) {
            d(str2, new d.a.l0.a.u.h.b(i2, "navigateToBookshelf success"));
        } else {
            d(str2, new d.a.l0.a.u.h.b(i2, "navigateToBookshelf fail"));
        }
    }

    public final boolean L() {
        d.a.l0.a.e2.c.f fVar = d.a.l0.a.n1.q.c.a.g(true).get("scope_insert_bookshelf");
        if (fVar != null) {
            return fVar.j < 0 && !fVar.f45373d;
        }
        return true;
    }

    public final void M(String str) {
        d.a.l0.a.c1.a.e0().d(new k(str));
    }

    public final void N(String str) {
        d.a.l0.a.a2.e r = d.a.l0.a.a2.d.g().r();
        r.j().f(r.x(), null, new j(r.j().e(i()), str));
    }

    public d.a.l0.a.u.h.b O(String str) {
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (!bVar.isSuccess() || jSONObject == null) {
            return bVar;
        }
        f47210d = jSONObject.optString("category");
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(202, "cb is invalid");
        }
        if (!d.a.l0.a.a2.d.g().r().j().e(i())) {
            d.a.l0.a.j2.k.M("show", 10, RetrieveTaskManager.KEY);
            N(optString);
            return new d.a.l0.a.u.h.b(0);
        }
        M(optString);
        return new d.a.l0.a.u.h.b(0);
    }

    public d.a.l0.a.u.h.b P(String str) {
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (!bVar.isSuccess() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.l0.a.u.h.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.i(i())) {
                return new d.a.l0.a.u.h.b(1001, "network is not connected");
            }
            if (!d.a.l0.a.a2.d.g().r().j().e(i())) {
                return new d.a.l0.a.u.h.b(1001, "user is not login");
            }
            Object D = d.a.l0.a.a2.d.g().r().D();
            int t1 = d.a.l0.a.a2.d.g().r().L().t1();
            Object u1 = d.a.l0.a.a2.d.g().r().L().u1();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", D);
            hashMap.put("contentIds", optJSONArray);
            hashMap.put("pkg_type", Integer.valueOf(t1));
            hashMap.put("version_code", u1);
            Q("QUERY", hashMap, new h(optString));
            return new d.a.l0.a.u.h.b(0);
        }
        return new d.a.l0.a.u.h.b(201, "contentIds is invalid");
    }

    public final void Q(String str, HashMap<String, Object> hashMap, d.a.l0.a.h0.j.b<d.a.l0.a.u.h.b> bVar) {
        boolean equals = TextUtils.equals(str, "INSERT");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            if (d.a.l0.a.u.c.d.f48486c) {
                e2.printStackTrace();
            }
        }
        RequestBody create = RequestBody.create(d.a.l0.a.n1.f.f47369a, jSONObject.toString());
        String F = F(str);
        if (TextUtils.isEmpty(F)) {
            H(bVar, 1001, "operation fail, msg = url is null", equals);
            return;
        }
        if (equals) {
            q0.b0(new RunnableC0807a());
        }
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(F, create, new b(equals, bVar));
        if (d.a.l0.m.e.a.g().c()) {
            aVar.f51648f = true;
        }
        aVar.f51649g = true;
        d.a.l0.m.e.a.g().e(aVar);
    }

    public d.a.l0.a.u.h.b R(String str) {
        Pair<d.a.l0.a.u.h.b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        d.a.l0.a.u.h.b bVar = (d.a.l0.a.u.h.b) b2.first;
        JSONObject jSONObject = (JSONObject) b2.second;
        if (!bVar.isSuccess() || jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("contentId");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.l0.a.u.h.b(201, "contentId is invalid");
        }
        String optString2 = jSONObject.optString("category");
        if (TextUtils.isEmpty(optString2)) {
            return new d.a.l0.a.u.h.b(201, "category is invalid");
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            return new d.a.l0.a.u.h.b(202, "cb is invalid");
        }
        if (!SwanAppNetworkUtils.i(i())) {
            return new d.a.l0.a.u.h.b(1001, "network is not connected");
        }
        if (!d.a.l0.a.a2.d.g().r().j().e(i())) {
            return new d.a.l0.a.u.h.b(1001, "user is not login");
        }
        Object D = d.a.l0.a.a2.d.g().r().D();
        int t1 = d.a.l0.a.a2.d.g().r().L().t1();
        Object u1 = d.a.l0.a.a2.d.g().r().L().u1();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("appKey", D);
        hashMap.put("contentId", optString);
        hashMap.put("category", optString2);
        hashMap.put("pkg_type", Integer.valueOf(t1));
        hashMap.put("version_code", u1);
        Q("UPDATE_READ_TIME", hashMap, new i(optString3));
        return new d.a.l0.a.u.h.b(0);
    }
}
