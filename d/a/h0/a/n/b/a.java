package d.a.h0.a.n.b;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.v;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.q1.b.f.d;
import d.a.h0.a.v1.c.i.b;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d.a.h0.a.t.b.d {

    /* renamed from: d.a.h0.a.n.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0706a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f43306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43307f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43308g;

        /* renamed from: d.a.h0.a.n.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0707a implements d.a.h0.a.e0.n.b<d.a.h0.a.t.e.b> {
            public C0707a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.e0.n.b
            /* renamed from: b */
            public void a(d.a.h0.a.t.e.b bVar) {
                C0706a c0706a = C0706a.this;
                a.this.c(c0706a.f43308g, bVar);
            }
        }

        public C0706a(JSONArray jSONArray, String str, String str2) {
            this.f43306e = jSONArray;
            this.f43307f = str;
            this.f43308g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", d.a.h0.a.r1.e.T());
                hashMap.put("contentIds", this.f43306e);
                hashMap.put("category", this.f43307f);
                a.this.K("INSERT", hashMap, new C0707a());
                return;
            }
            a.this.c(this.f43308g, new d.a.h0.a.t.e.b(hVar.b(), d.a.h0.a.v1.c.c.f(hVar.b())));
            d.a.h0.a.q1.b.f.d.e(a.this.h(), d.a.h0.a.h.swan_bookshelf_authorize_fail).C();
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.h0.a.e0.n.b<d.a.h0.a.t.e.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43311a;

        public b(String str) {
            this.f43311a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.e0.n.b
        /* renamed from: b */
        public void a(d.a.h0.a.t.e.b bVar) {
            a.this.c(this.f43311a, bVar);
        }
    }

    /* loaded from: classes.dex */
    public class c implements d.a.h0.a.e0.n.b<d.a.h0.a.t.e.b> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43313a;

        public c(String str) {
            this.f43313a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.e0.n.b
        /* renamed from: b */
        public void a(d.a.h0.a.t.e.b bVar) {
            a.this.c(this.f43313a, bVar);
        }
    }

    /* loaded from: classes.dex */
    public class d implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43315e;

        public d(String str) {
            this.f43315e = str;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                a.this.c(this.f43315e, new d.a.h0.a.t.e.b(1001, "user is not login"));
            } else {
                a.this.G(this.f43315e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements CallbackHandler {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43317e;

        public e(String str) {
            this.f43317e = str;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public String getCurrentPageUrl() {
            return null;
        }

        @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
        public void handleSchemeDispatchCallback(String str, String str2) {
            a.this.E(str2, this.f43317e);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43319e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43320f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43321g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43322h;

        /* renamed from: d.a.h0.a.n.b.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class DialogInterface$OnClickListenerC0708a implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC0708a(f fVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }

        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnClickListener {
            public b(f fVar) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                d.a.h0.a.r1.d.e().p().R().D();
            }
        }

        public f(String str, String str2, String str3, String str4) {
            this.f43319e = str;
            this.f43320f = str2;
            this.f43321g = str3;
            this.f43322h = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a aVar = new g.a(a.this.h());
            aVar.V(this.f43319e);
            aVar.y(this.f43320f);
            aVar.z();
            aVar.n(new d.a.h0.a.j2.g.a());
            aVar.m(false);
            aVar.P(this.f43321g, new b(this));
            aVar.D(this.f43322h, new DialogInterface$OnClickListenerC0708a(this));
            aVar.X();
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.q1.b.f.d e2 = d.a.h0.a.q1.b.f.d.e(a.this.h(), d.a.h0.a.h.swan_bookshelf_insert_async);
            e2.k(10);
            e2.q(false);
            e2.v();
        }
    }

    /* loaded from: classes.dex */
    public class h extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f43325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.n.b f43326b;

        public h(boolean z, d.a.h0.a.e0.n.b bVar) {
            this.f43325a = z;
            this.f43326b = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            if (this.f43325a) {
                d.a.h0.a.q1.b.f.d.a();
            }
            if (jSONObject == null) {
                a.this.B(this.f43326b, 1001, "server response fail", this.f43325a);
                return;
            }
            int optInt = jSONObject.optInt("errno", -1);
            if (optInt != 0) {
                if (this.f43325a) {
                    d.a.h0.a.q1.b.f.d.e(d.a.h0.a.w0.a.c(), d.a.h0.a.h.swan_bookshelf_insert_failed).C();
                }
                a.this.B(this.f43326b, optInt, jSONObject.optString("errmsg"), false);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a.this.B(this.f43326b, 0, jSONObject.optString("errmsg"), this.f43325a);
            } else {
                a.this.C(this.f43326b, optJSONObject, this.f43325a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return v.b(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.f43325a) {
                d.a.h0.a.q1.b.f.d.a();
            }
            a aVar = a.this;
            d.a.h0.a.e0.n.b bVar = this.f43326b;
            aVar.B(bVar, 1001, "operation fail, msg = " + exc.getMessage(), this.f43325a);
        }
    }

    /* loaded from: classes.dex */
    public class i implements d.a {
        public i(a aVar) {
        }

        @Override // d.a.h0.a.q1.b.f.d.a
        public void a() {
            k0.P(null);
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void A() {
        k0.X(new f(h().getString(d.a.h0.a.h.swan_bookshelf_setting_dialog_title), h().getString(d.a.h0.a.h.swan_bookshelf_setting_dialog_content), h().getString(d.a.h0.a.h.swan_bookshelf_setting_dialog_positive), h().getString(d.a.h0.a.h.swan_bookshelf_setting_dialog_negative)));
    }

    public final void B(d.a.h0.a.e0.n.b<d.a.h0.a.t.e.b> bVar, int i2, String str, boolean z) {
        if (bVar != null) {
            bVar.a(new d.a.h0.a.t.e.b(i2, str));
        }
        if (z) {
            d.a.h0.a.q1.b.f.d.f(d.a.h0.a.w0.a.c(), str).C();
        }
    }

    public final void C(d.a.h0.a.e0.n.b<d.a.h0.a.t.e.b> bVar, JSONObject jSONObject, boolean z) {
        if (bVar != null && jSONObject != null) {
            bVar.a(new d.a.h0.a.t.e.b(0, jSONObject));
        }
        if (z) {
            d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(h(), h().getString(d.a.h0.a.h.swan_bookshelf_insert_success));
            f2.o(1);
            f2.k(3);
            f2.s(new i(this));
            f2.t();
        }
    }

    public d.a.h0.a.t.e.b D(String str) {
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Base", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.a() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("category");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.h0.a.t.e.b(201, "category is invalid");
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                return new d.a.h0.a.t.e.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.h(h())) {
                d.a.h0.a.q1.b.f.d.e(h(), d.a.h0.a.h.aiapps_net_error).C();
                return new d.a.h0.a.t.e.b(1001, "network is not connected");
            } else if (F()) {
                A();
                return new d.a.h0.a.t.e.b(10003, d.a.h0.a.v1.c.c.f(10003));
            } else {
                y(optJSONArray, optString, optString2);
                return new d.a.h0.a.t.e.b(0);
            }
        }
        return new d.a.h0.a.t.e.b(201, "contentIds is invalid");
    }

    public final void E(String str, String str2) {
        int i2 = 1001;
        if (TextUtils.isEmpty(str)) {
            c(str2, new d.a.h0.a.t.e.b(1001, "navigateToBookshelf fail"));
        }
        try {
            i2 = new JSONObject(str).optInt("status", 1001);
        } catch (JSONException e2) {
            if (d.a.h0.a.t.b.d.f44021c) {
                e2.printStackTrace();
            }
        }
        if (i2 == 0) {
            c(str2, new d.a.h0.a.t.e.b(i2, "navigateToBookshelf success"));
        } else {
            c(str2, new d.a.h0.a.t.e.b(i2, "navigateToBookshelf fail"));
        }
    }

    public final boolean F() {
        d.a.h0.a.v1.c.e eVar = d.a.h0.a.g1.o.c.a.g(true).get("scope_insert_bookshelf");
        if (eVar != null) {
            return eVar.j < 0 && !eVar.f44913d;
        }
        return true;
    }

    public final void G(String str) {
        k0.P(new e(str));
    }

    public final void H(String str) {
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        p.i().f(p.v(), null, new d(str));
    }

    public d.a.h0.a.t.e.b I(String str) {
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Base", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.a() || jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.h0.a.t.e.b(202, "cb is invalid");
        }
        if (!d.a.h0.a.r1.d.e().p().i().e(h())) {
            H(optString);
            return new d.a.h0.a.t.e.b(0);
        }
        G(optString);
        return new d.a.h0.a.t.e.b(0);
    }

    public d.a.h0.a.t.e.b J(String str) {
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Base", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.a() || jSONObject == null) {
            return bVar;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("contentIds");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.h0.a.t.e.b(202, "cb is invalid");
            }
            if (!SwanAppNetworkUtils.h(h())) {
                return new d.a.h0.a.t.e.b(1001, "network is not connected");
            }
            if (!d.a.h0.a.r1.d.e().p().i().e(h())) {
                return new d.a.h0.a.t.e.b(1001, "user is not login");
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appKey", d.a.h0.a.r1.e.T());
            hashMap.put("contentIds", optJSONArray);
            K("QUERY", hashMap, new b(optString));
            return new d.a.h0.a.t.e.b(0);
        }
        return new d.a.h0.a.t.e.b(201, "contentIds is invalid");
    }

    public final void K(String str, HashMap<String, Object> hashMap, d.a.h0.a.e0.n.b<d.a.h0.a.t.e.b> bVar) {
        boolean equals = TextUtils.equals(str, "INSERT");
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            if (d.a.h0.a.t.b.d.f44021c) {
                e2.printStackTrace();
            }
        }
        RequestBody create = RequestBody.create(d.a.h0.a.g1.f.f42552a, jSONObject.toString());
        String z = z(str);
        if (TextUtils.isEmpty(z)) {
            B(bVar, 1001, "operation fail, msg = url is null", equals);
            return;
        }
        if (equals) {
            k0.X(new g());
        }
        ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) d.a.h0.k.e.a.f().postRequest().requestBody(create).url(z)).cookieManager(d.a.h0.a.w0.a.m().a())).build().executeAsync(new h(equals, bVar));
    }

    public d.a.h0.a.t.e.b L(String str) {
        Pair<d.a.h0.a.t.e.b, JSONObject> a2 = d.a.h0.a.t.f.b.a("Api-Base", str);
        d.a.h0.a.t.e.b bVar = (d.a.h0.a.t.e.b) a2.first;
        JSONObject jSONObject = (JSONObject) a2.second;
        if (!bVar.a() || jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("contentId");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.h0.a.t.e.b(201, "contentId is invalid");
        }
        String optString2 = jSONObject.optString("category");
        if (TextUtils.isEmpty(optString2)) {
            return new d.a.h0.a.t.e.b(201, "category is invalid");
        }
        String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            return new d.a.h0.a.t.e.b(202, "cb is invalid");
        }
        if (!SwanAppNetworkUtils.h(h())) {
            return new d.a.h0.a.t.e.b(1001, "network is not connected");
        }
        if (!d.a.h0.a.r1.d.e().p().i().e(h())) {
            return new d.a.h0.a.t.e.b(1001, "user is not login");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("appKey", d.a.h0.a.r1.e.T());
        hashMap.put("contentId", optString);
        hashMap.put("category", optString2);
        K("UPDATE_READ_TIME", hashMap, new c(optString3));
        return new d.a.h0.a.t.e.b(0);
    }

    public final void y(JSONArray jSONArray, String str, String str2) {
        d.a.h0.a.r1.d.e().p().R().g(h(), "scope_insert_bookshelf", new C0706a(jSONArray, str, str2));
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
                return d.a.h0.a.w0.a.l().L();
            }
            return d.a.h0.a.w0.a.l().y();
        }
        return d.a.h0.a.w0.a.l().x();
    }
}
