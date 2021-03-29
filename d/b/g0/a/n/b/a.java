package d.b.g0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.v;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.q1.b.f.d;
import d.b.g0.a.v1.c.i.b;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.g0.a.t.b.d {

    /* renamed from: d.b.g0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0735a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45246e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45247f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45248g;

        /* renamed from: d.b.g0.a.n.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0736a implements d.b.g0.a.e0.n.b<d.b.g0.a.t.e.b> {
            public C0736a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.e0.n.b
            /* renamed from: b */
            public void a(d.b.g0.a.t.e.b bVar) {
                C0735a c0735a = C0735a.this;
                a.this.c(c0735a.f45248g, bVar);
            }
        }

        public C0735a(JSONArray jSONArray, String str, String str2) {
            this.f45246e = jSONArray;
            this.f45247f = str;
            this.f45248g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", d.b.g0.a.r1.e.T());
                hashMap.put("contentIds", this.f45246e);
                hashMap.put("category", this.f45247f);
                a.this.K("INSERT", hashMap, new C0736a());
                return;
            }
            a.this.c(this.f45248g, new d.b.g0.a.t.e.b(hVar.b(), d.b.g0.a.v1.c.c.f(hVar.b())));
            d.b.g0.a.q1.b.f.d.e(a.this.h(), d.b.g0.a.h.swan_bookshelf_authorize_fail).C();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.e0.n.b<d.b.g0.a.t.e.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45251a;

        public b(String str) {
            this.f45251a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.e0.n.b
        /* renamed from: b */
        public void a(d.b.g0.a.t.e.b bVar) {
            a.this.c(this.f45251a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.e0.n.b<d.b.g0.a.t.e.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45253a;

        public c(String str) {
            this.f45253a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.e0.n.b
        /* renamed from: b */
        public void a(d.b.g0.a.t.e.b bVar) {
            a.this.c(this.f45253a, bVar);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45255e;

        public d(String str) {
            this.f45255e = str;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                a.this.c(this.f45255e, new d.b.g0.a.t.e.b(1001, "user is not login"));
            } else {
                a.this.G(this.f45255e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements CallbackHandler {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45257e;

        public e(String str) {
            this.f45257e = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            return null;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            a.this.E(str2, this.f45257e);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45260f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45261g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45262h;

        /* renamed from: d.b.g0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class DialogInterface$OnClickListenerC0737a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0737a(f fVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* loaded from: classes2.dex */
        public class b implements DialogInterface.OnClickListener {
            public b(f fVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                d.b.g0.a.r1.d.e().s().R().D();
            }
        }

        public f(String str, String str2, String str3, String str4) {
            this.f45259e = str;
            this.f45260f = str2;
            this.f45261g = str3;
            this.f45262h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a aVar = new g.a(a.this.h());
            aVar.V(this.f45259e);
            aVar.y(this.f45260f);
            aVar.z();
            aVar.n(new d.b.g0.a.j2.g.a());
            aVar.m(false);
            aVar.P(this.f45261g, new b(this));
            aVar.D(this.f45262h, new DialogInterface$OnClickListenerC0737a(this));
            aVar.X();
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.q1.b.f.d e2 = d.b.g0.a.q1.b.f.d.e(a.this.h(), d.b.g0.a.h.swan_bookshelf_insert_async);
            e2.k(10);
            e2.q(false);
            e2.v();
        }
    }

    /* loaded from: classes2.dex */
    public class h extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45264a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.n.b f45265b;

        public h(boolean z, d.b.g0.a.e0.n.b bVar) {
            this.f45264a = z;
            this.f45265b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            if (this.f45264a) {
                d.b.g0.a.q1.b.f.d.a();
            }
            if (jSONObject == null) {
                a.this.B(this.f45265b, 1001, "server response fail", this.f45264a);
                return;
            }
            int optInt = jSONObject.optInt("errno", -1);
            if (optInt != 0) {
                if (this.f45264a) {
                    d.b.g0.a.q1.b.f.d.e(d.b.g0.a.w0.a.c(), d.b.g0.a.h.swan_bookshelf_insert_failed).C();
                }
                a.this.B(this.f45265b, optInt, jSONObject.optString("errmsg"), false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a.this.B(this.f45265b, 0, jSONObject.optString("errmsg"), this.f45264a);
            } else {
                a.this.C(this.f45265b, optJSONObject, this.f45264a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return v.b(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.f45264a) {
                d.b.g0.a.q1.b.f.d.a();
            }
            a aVar = a.this;
            d.b.g0.a.e0.n.b bVar = this.f45265b;
            aVar.B(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f45264a);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.a {
        public i(a aVar) {
        }

        @Override // d.b.g0.a.q1.b.f.d.a
        public void a() {
            k0.P(null);
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void A() {
        k0.X(new f(h().getString(d.b.g0.a.h.swan_bookshelf_setting_dialog_title), h().getString(d.b.g0.a.h.swan_bookshelf_setting_dialog_content), h().getString(d.b.g0.a.h.swan_bookshelf_setting_dialog_positive), h().getString(d.b.g0.a.h.swan_bookshelf_setting_dialog_negative)));
    }

    public final void B(d.b.g0.a.e0.n.b<d.b.g0.a.t.e.b> bVar, int i2, String str, boolean z) {
        if (bVar != null) {
            bVar.a(new d.b.g0.a.t.e.b(i2, str));
        }
        if (z) {
            d.b.g0.a.q1.b.f.d.f(d.b.g0.a.w0.a.c(), str).C();
        }
    }

    public final void C(d.b.g0.a.e0.n.b<d.b.g0.a.t.e.b> bVar, JSONObject jSONObject, boolean z) {
        if (bVar != null && jSONObject != null) {
            bVar.a(new d.b.g0.a.t.e.b(0, jSONObject));
        }
        if (z) {
            d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(h(), h().getString(d.b.g0.a.h.swan_bookshelf_insert_success));
            f2.o(1);
            f2.k(3);
            f2.s(new i(this));
            f2.t();
        }
    }

    public d.b.g0.a.t.e.b D(String str) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.b() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString)) {
                return new d.b.g0.a.t.e.b(201, "category is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.b.g0.a.t.e.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.h(h())) {
                d.b.g0.a.q1.b.f.d.e(h(), d.b.g0.a.h.aiapps_net_error).C();
                return new d.b.g0.a.t.e.b(1001, "network is not connected");
            } else if (F()) {
                A();
                return new d.b.g0.a.t.e.b(10003, d.b.g0.a.v1.c.c.f(10003));
            } else {
                y(optJSONArray, optString, optString2);
                return new d.b.g0.a.t.e.b(0);
            }
        }
        return new d.b.g0.a.t.e.b(201, "contentIds is invalid");
    }

    public final void E(String str, String str2) {
        int i2 = 1001;
        if (TextUtils.isEmpty(str)) {
            c(str2, new d.b.g0.a.t.e.b(1001, "navigateToBookshelf fail"));
        }
        try {
            i2 = new JSONObject(str).optInt("status", 1001);
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
        }
        if (i2 == 0) {
            c(str2, new d.b.g0.a.t.e.b(i2, "navigateToBookshelf success"));
        } else {
            c(str2, new d.b.g0.a.t.e.b(i2, "navigateToBookshelf fail"));
        }
    }

    public final boolean F() {
        d.b.g0.a.v1.c.e eVar = d.b.g0.a.g1.o.c.a.g(true).get("scope_insert_bookshelf");
        if (eVar != null) {
            return eVar.j < 0 && !eVar.f46771d;
        }
        return true;
    }

    public final void G(String str) {
        k0.P(new e(str));
    }

    public final void H(String str) {
        d.b.g0.a.r1.e s = d.b.g0.a.r1.d.e().s();
        s.z().f(s.n(), null, new d(str));
    }

    public d.b.g0.a.t.e.b I(String str) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.b() || jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.g0.a.t.e.b(202, "cb is invalid");
        }
        if (!d.b.g0.a.r1.d.e().s().z().e(h())) {
            H(optString);
            return new d.b.g0.a.t.e.b(0);
        }
        G(optString);
        return new d.b.g0.a.t.e.b(0);
    }

    public d.b.g0.a.t.e.b J(String str) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.b() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.b.g0.a.t.e.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.h(h())) {
                return new d.b.g0.a.t.e.b(1001, "network is not connected");
            }
            if (!d.b.g0.a.r1.d.e().s().z().e(h())) {
                return new d.b.g0.a.t.e.b(1001, "user is not login");
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", d.b.g0.a.r1.e.T());
            hashMap.put("contentIds", optJSONArray);
            K("QUERY", hashMap, new b(optString));
            return new d.b.g0.a.t.e.b(0);
        }
        return new d.b.g0.a.t.e.b(201, "contentIds is invalid");
    }

    public final void K(String str, HashMap<String, Object> hashMap, d.b.g0.a.e0.n.b<d.b.g0.a.t.e.b> bVar) {
        boolean equals = TextUtils.equals(str, "INSERT");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
        }
        RequestBody create = RequestBody.create(d.b.g0.a.g1.f.f44518a, jSONObject.toString());
        String z = z(str);
        if (TextUtils.isEmpty(z)) {
            B(bVar, 1001, "operation fail, msg = url is null", equals);
            return;
        }
        if (equals) {
            k0.X(new g());
        }
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.b.g0.k.e.a.f().postRequest().requestBody(create).url(z)).cookieManager(d.b.g0.a.w0.a.m().a())).build().executeAsync(new h(equals, bVar));
    }

    public d.b.g0.a.t.e.b L(String str) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.b() || jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("contentId");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.g0.a.t.e.b(201, "contentId is invalid");
        }
        String optString2 = jSONObject.optString("category");
        if (TextUtils.isEmpty(optString2)) {
            return new d.b.g0.a.t.e.b(201, "category is invalid");
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            return new d.b.g0.a.t.e.b(202, "cb is invalid");
        }
        if (!SwanAppNetworkUtils.h(h())) {
            return new d.b.g0.a.t.e.b(1001, "network is not connected");
        }
        if (!d.b.g0.a.r1.d.e().s().z().e(h())) {
            return new d.b.g0.a.t.e.b(1001, "user is not login");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("appKey", d.b.g0.a.r1.e.T());
        hashMap.put("contentId", optString);
        hashMap.put("category", optString2);
        K("UPDATE_READ_TIME", hashMap, new c(optString3));
        return new d.b.g0.a.t.e.b(0);
    }

    public final void y(JSONArray jSONArray, String str, String str2) {
        d.b.g0.a.r1.d.e().s().R().g(h(), "scope_insert_bookshelf", new C0735a(jSONArray, str, str2));
    }

    public final String z(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == -2130463047) {
            if (str.equals("INSERT")) {
                c2 = 0;
            }
            c2 = 65535;
        } else if (hashCode != 77406376) {
            if (hashCode == 1020968928 && str.equals("UPDATE_READ_TIME")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (str.equals("QUERY")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return null;
                }
                return d.b.g0.a.w0.a.l().E();
            }
            return d.b.g0.a.w0.a.l().h();
        }
        return d.b.g0.a.w0.a.l().e();
    }
}
