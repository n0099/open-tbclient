package d.a.m0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.j2.k;
import d.a.m0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45404e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45405f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45406g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f45407h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45408i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.a.m0.a.a2.e eVar, JSONArray jSONArray) {
            this.f45404e = callbackHandler;
            this.f45405f = str;
            this.f45406g = context;
            this.f45407h = eVar;
            this.f45408i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                h.this.x((Activity) this.f45406g, this.f45407h, this.f45404e, this.f45408i, this.f45405f);
            } else {
                d.a.m0.a.e2.c.d.p(iVar, this.f45404e, this.f45405f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45411c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f45412d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45413e;

        /* loaded from: classes3.dex */
        public class a implements d.a.m0.a.v2.e1.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.e2.c.f f45415e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f45416f;

            /* renamed from: d.a.m0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0674a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f45418e;

                public RunnableC0674a(Boolean bool) {
                    this.f45418e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.a.m0.a.e2.c.f fVar = aVar.f45415e;
                    List list = aVar.f45416f;
                    boolean booleanValue = this.f45418e.booleanValue();
                    b bVar = b.this;
                    hVar.P(fVar, list, booleanValue, bVar.f45413e, bVar.f45412d, bVar.f45409a, bVar.f45410b);
                }
            }

            public a(d.a.m0.a.e2.c.f fVar, List list) {
                this.f45415e = fVar;
                this.f45416f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f45413e, this.f45415e, bool);
                q0.X(new RunnableC0674a(bool));
            }
        }

        /* renamed from: d.a.m0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0675b implements d.a.m0.a.v2.e1.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.e2.c.f f45420e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f45421f;

            /* renamed from: d.a.m0.a.e2.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0675b c0675b = C0675b.this;
                    b bVar = b.this;
                    h.this.P(c0675b.f45420e, c0675b.f45421f, false, bVar.f45413e, bVar.f45412d, bVar.f45409a, bVar.f45410b);
                }
            }

            public C0675b(d.a.m0.a.e2.c.f fVar, List list) {
                this.f45420e = fVar;
                this.f45421f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f45413e, this.f45420e, str);
                q0.X(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.m0.a.a2.e eVar, Activity activity) {
            this.f45409a = callbackHandler;
            this.f45410b = str;
            this.f45411c = jSONArray;
            this.f45412d = eVar;
            this.f45413e = activity;
        }

        @Override // d.a.m0.a.n1.q.b.a
        public void a() {
            List<d.a.m0.a.e2.c.f> w;
            Map<String, d.a.m0.a.e2.c.f> g2 = d.a.m0.a.n1.q.c.a.g(true);
            d.a.m0.a.e2.c.f y = h.this.y(g2, this.f45409a, this.f45410b);
            if (y == null || (w = h.this.w(g2, this.f45411c, this.f45409a, this.f45410b)) == null) {
                return;
            }
            y.g(w);
            if (this.f45412d.j().e(this.f45413e)) {
                h.this.z(new C0675b(y, w));
            } else {
                d.a.m0.a.c1.a.T().a(this.f45413e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.e2.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f45426c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f45427d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45428e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f45429f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.a.m0.a.a2.e eVar, Activity activity, List list) {
            this.f45424a = callbackHandler;
            this.f45425b = str;
            this.f45426c = z;
            this.f45427d = eVar;
            this.f45428e = activity;
            this.f45429f = list;
        }

        @Override // d.a.m0.a.e2.c.a
        public void onResult(boolean z) {
            d.a.m0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.a.m0.a.e2.c.d.n(10003, this.f45424a, this.f45425b);
                return;
            }
            boolean z2 = this.f45426c;
            if (this.f45427d.j().e(this.f45428e)) {
                h.this.H(this.f45429f, this.f45428e, this.f45424a, this.f45425b);
            } else if (z2) {
                h.this.K(this.f45429f, this.f45428e, this.f45424a, this.f45425b);
            } else {
                h.this.G(this.f45429f, this.f45428e, this.f45424a, this.f45425b, this.f45427d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f45431a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f45432b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45433c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45434d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45431a = list;
            this.f45432b = activity;
            this.f45433c = callbackHandler;
            this.f45434d = str;
        }

        @Override // d.a.m0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            d.a.m0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
            if (z) {
                h.this.H(this.f45431a, this.f45432b, this.f45433c, this.f45434d);
            } else {
                d.a.m0.a.e2.c.d.n(10004, this.f45433c, this.f45434d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.m0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f45437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45439h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45436e = list;
            this.f45437f = activity;
            this.f45438g = callbackHandler;
            this.f45439h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f45436e, this.f45437f, this.f45438g, this.f45439h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f45442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45443g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45444h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f45441e = activity;
            this.f45442f = list;
            this.f45443g = callbackHandler;
            this.f45444h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f45441e, this.f45442f, this.f45443g, this.f45444h);
            } else {
                d.a.m0.a.e2.c.d.n(10003, this.f45443g, this.f45444h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.m0.a.v2.e1.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45446e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f45447f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45448g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45449h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45446e = list;
            this.f45447f = activity;
            this.f45448g = callbackHandler;
            this.f45449h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f45446e, this.f45447f, this.f45448g, this.f45449h);
            } else {
                d.a.m0.a.e2.c.d.n(10003, this.f45448g, this.f45449h);
            }
        }
    }

    /* renamed from: d.a.m0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0676h implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45452f;

        public C0676h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f45451e = callbackHandler;
            this.f45452f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (iVar == null) {
                d.a.m0.a.e2.c.d.n(10001, this.f45451e, this.f45452f);
                k.p(10001, null);
                return;
            }
            int b2 = iVar.b();
            d.a.m0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f45520a);
            if (b2 != 0) {
                d.a.m0.a.e2.c.d.n(b2, this.f45451e, this.f45452f);
            } else {
                this.f45451e.handleSchemeDispatchCallback(this.f45452f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f45453e;

        public i(h hVar, j jVar) {
            this.f45453e = jVar;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                this.f45453e.a(false, i2);
            } else {
                this.f45453e.a(true, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    public h(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
    }

    public final boolean A(List<d.a.m0.a.e2.c.f> list) {
        if (list != null && list.size() > 0) {
            for (d.a.m0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(d.a.m0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f45479b, "mapp_location") || TextUtils.equals(fVar.f45479b, "mapp_images") || TextUtils.equals(fVar.f45479b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f45479b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f45479b, "ppcert") || TextUtils.equals(fVar.f45479b, "mapp_i_face_verify") || TextUtils.equals(fVar.f45479b, "snsapi_userinfo") || TextUtils.equals(fVar.f45479b, "mapp_choose_address") || TextUtils.equals(fVar.f45479b, "mobile") || TextUtils.equals(fVar.f45479b, "mapp_choose_invoice");
    }

    public final boolean C(d.a.m0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f45479b, "ppcert") || TextUtils.equals(fVar.f45479b, "mapp_i_face_verify");
    }

    public final boolean D(List<d.a.m0.a.e2.c.f> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (d.a.m0.a.e2.c.f fVar : list) {
            if (fVar != null && !E(fVar)) {
                z = false;
            }
        }
        return z;
    }

    public final boolean E(d.a.m0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f45479b, "mapp_location") || TextUtils.equals(fVar.f45479b, "mapp_images") || TextUtils.equals(fVar.f45479b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f45479b, PermissionProxy.SCOPE_ID_CAMERA);
    }

    public final boolean F(List<d.a.m0.a.e2.c.f> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (d.a.m0.a.e2.c.f fVar : list) {
            if (fVar != null && C(fVar)) {
                return false;
            }
        }
        return true;
    }

    public final void G(List<d.a.m0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.m0.a.a2.e eVar) {
        if (D(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            L(eVar, activity, new d(list, activity, callbackHandler, str));
        }
    }

    public final void H(List<d.a.m0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (F(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            z(new e(list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<d.a.m0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (z) {
            d.a.m0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
            J(activity, list, callbackHandler, str);
            return;
        }
        d.a.m0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
        M(new f(activity, list, callbackHandler, str));
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.m0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).f45479b;
        }
        d.a.m0.a.e2.c.j.b d2 = d.a.m0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
        d2.p(new C0676h(this, callbackHandler, str));
        d2.a();
    }

    public final void K(List<d.a.m0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.m0.a.c1.a.T().d(new g(list, activity, callbackHandler, str));
    }

    public final void L(@NonNull d.a.m0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        v(eVar, activity, jVar);
    }

    public final void M(d.a.m0.a.v2.e1.b<String> bVar) {
        d.a.m0.a.c1.a.T().b(false, bVar);
    }

    public final void N(@NonNull Activity activity, d.a.m0.a.e2.c.f fVar, String str) {
        String O = d.a.m0.a.a2.d.g().r().O();
        boolean equals = TextUtils.equals(str, "1");
        if (!A(fVar.s)) {
            fVar.r = activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_end);
        } else if (equals) {
            fVar.r = activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_end);
        } else {
            fVar.r = activity.getString(d.a.m0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_end);
        }
    }

    public final void O(@NonNull Activity activity, d.a.m0.a.e2.c.f fVar, Boolean bool) {
        String O = d.a.m0.a.a2.d.g().r().O();
        boolean D = D(fVar.s);
        boolean A = A(fVar.s);
        if (!bool.booleanValue() && !D) {
            fVar.r = activity.getString(d.a.m0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_end);
        } else if (A) {
            fVar.r = activity.getString(d.a.m0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_end);
        } else {
            fVar.r = activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.m0.a.h.swanapp_multi_auth_default_name_end);
        }
    }

    public final void P(d.a.m0.a.e2.c.f fVar, List<d.a.m0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull d.a.m0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.m0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(callbackHandler, str, z, eVar, activity, list));
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar != null && (context instanceof Activity)) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.has("scopes")) {
                JSONArray optJSONArray = a2.optJSONArray("scopes");
                if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                    eVar.T().g(context, "scope_multi_authorize", new a(callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    return true;
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "scopes count error"));
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(100203, "illegal parameter"));
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(401, "runtime parameter error");
        return false;
    }

    public final void v(@NonNull d.a.m0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        eVar.j().f(activity, null, new i(this, jVar));
    }

    public final List<d.a.m0.a.e2.c.f> w(Map<String, d.a.m0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.m0.a.e2.c.f fVar;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                if (!B(fVar)) {
                    d.a.m0.a.e2.c.d.n(10005, callbackHandler, str);
                    k.p(10005, fVar);
                    return null;
                } else if (fVar.f45481d) {
                    d.a.m0.a.e2.c.d.n(10005, callbackHandler, str);
                    k.p(10005, fVar);
                    return null;
                } else {
                    if (!arrayList.contains(fVar) && !fVar.a()) {
                        arrayList.add(fVar);
                    }
                    if (!fVar.a()) {
                        z = false;
                    }
                }
            }
        }
        if (z) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            return null;
        }
        d.a.m0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.m0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        d.a.m0.a.n1.q.a.g().z(new b(callbackHandler, str, jSONArray, eVar, activity));
    }

    public final d.a.m0.a.e2.c.f y(Map<String, d.a.m0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.m0.a.e2.c.f fVar = map.get("scope_multi_authorize");
        if (fVar == null) {
            d.a.m0.a.e2.c.d.n(10001, callbackHandler, str);
            k.p(10001, null);
            return null;
        } else if (fVar.f45481d) {
            d.a.m0.a.e2.c.d.n(10005, callbackHandler, str);
            k.p(10005, fVar);
            return null;
        } else {
            return fVar;
        }
    }

    public final void z(d.a.m0.a.v2.e1.b<String> bVar) {
        d.a.m0.a.c1.a.T().c(d.a.m0.a.c1.a.b(), bVar);
    }
}
