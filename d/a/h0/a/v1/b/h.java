package d.a.h0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44838f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f44839g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44840h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44841i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.a.h0.a.r1.e eVar, JSONArray jSONArray) {
            this.f44837e = callbackHandler;
            this.f44838f = str;
            this.f44839g = context;
            this.f44840h = eVar;
            this.f44841i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                h.this.x((Activity) this.f44839g, this.f44840h, this.f44837e, this.f44841i, this.f44838f);
            } else {
                d.a.h0.a.v1.c.c.o(hVar, this.f44837e, this.f44838f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44844c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44845d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44846e;

        /* loaded from: classes3.dex */
        public class a implements d.a.h0.a.i2.u0.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.v1.c.e f44848e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44849f;

            /* renamed from: d.a.h0.a.v1.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0830a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f44851e;

                public RunnableC0830a(Boolean bool) {
                    this.f44851e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.a.h0.a.v1.c.e eVar = aVar.f44848e;
                    List list = aVar.f44849f;
                    boolean booleanValue = this.f44851e.booleanValue();
                    b bVar = b.this;
                    hVar.P(eVar, list, booleanValue, bVar.f44846e, bVar.f44845d, bVar.f44842a, bVar.f44843b);
                }
            }

            public a(d.a.h0.a.v1.c.e eVar, List list) {
                this.f44848e = eVar;
                this.f44849f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f44846e, this.f44848e, bool);
                k0.T(new RunnableC0830a(bool));
            }
        }

        /* renamed from: d.a.h0.a.v1.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0831b implements d.a.h0.a.i2.u0.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.v1.c.e f44853e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44854f;

            /* renamed from: d.a.h0.a.v1.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0831b c0831b = C0831b.this;
                    b bVar = b.this;
                    h.this.P(c0831b.f44853e, c0831b.f44854f, false, bVar.f44846e, bVar.f44845d, bVar.f44842a, bVar.f44843b);
                }
            }

            public C0831b(d.a.h0.a.v1.c.e eVar, List list) {
                this.f44853e = eVar;
                this.f44854f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f44846e, this.f44853e, str);
                k0.T(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.h0.a.r1.e eVar, Activity activity) {
            this.f44842a = callbackHandler;
            this.f44843b = str;
            this.f44844c = jSONArray;
            this.f44845d = eVar;
            this.f44846e = activity;
        }

        @Override // d.a.h0.a.g1.o.b.a
        public void a() {
            List<d.a.h0.a.v1.c.e> w;
            Map<String, d.a.h0.a.v1.c.e> g2 = d.a.h0.a.g1.o.c.a.g(true);
            d.a.h0.a.v1.c.e y = h.this.y(g2, this.f44842a, this.f44843b);
            if (y == null || (w = h.this.w(g2, this.f44844c, this.f44842a, this.f44843b)) == null) {
                return;
            }
            y.g(w);
            if (this.f44845d.i().e(this.f44846e)) {
                h.this.z(new C0831b(y, w));
            } else {
                d.a.h0.a.w0.a.I().a(this.f44846e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.v1.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44857a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f44859c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f44860d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44861e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44862f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.a.h0.a.r1.e eVar, Activity activity, List list) {
            this.f44857a = callbackHandler;
            this.f44858b = str;
            this.f44859c = z;
            this.f44860d = eVar;
            this.f44861e = activity;
            this.f44862f = list;
        }

        @Override // d.a.h0.a.v1.c.a
        public void onResult(boolean z) {
            d.a.h0.a.c0.c.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.a.h0.a.v1.c.c.m(10003, this.f44857a, this.f44858b);
                return;
            }
            boolean z2 = this.f44859c;
            if (this.f44860d.i().e(this.f44861e)) {
                h.this.H(this.f44862f, this.f44861e, this.f44857a, this.f44858b);
            } else if (z2) {
                h.this.K(this.f44862f, this.f44861e, this.f44857a, this.f44858b);
            } else {
                h.this.G(this.f44862f, this.f44861e, this.f44857a, this.f44858b, this.f44860d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f44864a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f44865b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44866c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44867d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f44864a = list;
            this.f44865b = activity;
            this.f44866c = callbackHandler;
            this.f44867d = str;
        }

        @Override // d.a.h0.a.v1.b.h.j
        public void a(boolean z, int i2) {
            d.a.h0.a.c0.c.g("MultiAuthorize", "login result:" + i2);
            if (z) {
                h.this.H(this.f44864a, this.f44865b, this.f44866c, this.f44867d);
            } else {
                d.a.h0.a.v1.c.c.m(10004, this.f44866c, this.f44867d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44869e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44870f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44871g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44872h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f44869e = list;
            this.f44870f = activity;
            this.f44871g = callbackHandler;
            this.f44872h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f44869e, this.f44870f, this.f44871g, this.f44872h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f44874e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f44875f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44876g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44877h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f44874e = activity;
            this.f44875f = list;
            this.f44876g = callbackHandler;
            this.f44877h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f44874e, this.f44875f, this.f44876g, this.f44877h);
            } else {
                d.a.h0.a.v1.c.c.m(10003, this.f44876g, this.f44877h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.h0.a.i2.u0.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44879e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f44880f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44881g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44882h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f44879e = list;
            this.f44880f = activity;
            this.f44881g = callbackHandler;
            this.f44882h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f44879e, this.f44880f, this.f44881g, this.f44882h);
            } else {
                d.a.h0.a.v1.c.c.m(10003, this.f44881g, this.f44882h);
            }
        }
    }

    /* renamed from: d.a.h0.a.v1.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0832h implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44885f;

        public C0832h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f44884e = callbackHandler;
            this.f44885f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (hVar == null) {
                d.a.h0.a.v1.c.c.m(10001, this.f44884e, this.f44885f);
                d.a.h0.a.z1.h.q(10001, null);
                return;
            }
            int b2 = hVar.b();
            d.a.h0.a.c0.c.l("MultiAuthorize", "requestAuthorize " + hVar.a() + ",  code=" + b2 + ", data=" + hVar.f44952a);
            if (b2 != 0) {
                d.a.h0.a.v1.c.c.m(b2, this.f44884e, this.f44885f);
            } else {
                this.f44884e.handleSchemeDispatchCallback(this.f44885f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f44886e;

        public i(h hVar, j jVar) {
            this.f44886e = jVar;
        }

        @Override // d.a.h0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                this.f44886e.a(false, i2);
            } else {
                this.f44886e.a(true, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    public h(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/multiAuthorize");
    }

    public final boolean A(List<d.a.h0.a.v1.c.e> list) {
        if (list != null && list.size() > 0) {
            for (d.a.h0.a.v1.c.e eVar : list) {
                if (eVar != null && C(eVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(d.a.h0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f44911b, "mapp_location") || TextUtils.equals(eVar.f44911b, "mapp_images") || TextUtils.equals(eVar.f44911b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f44911b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(eVar.f44911b, "ppcert") || TextUtils.equals(eVar.f44911b, "mapp_i_face_verify") || TextUtils.equals(eVar.f44911b, "snsapi_userinfo") || TextUtils.equals(eVar.f44911b, "mapp_choose_address") || TextUtils.equals(eVar.f44911b, "mobile") || TextUtils.equals(eVar.f44911b, "mapp_choose_invoice");
    }

    public final boolean C(d.a.h0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f44911b, "ppcert") || TextUtils.equals(eVar.f44911b, "mapp_i_face_verify");
    }

    public final boolean D(List<d.a.h0.a.v1.c.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (d.a.h0.a.v1.c.e eVar : list) {
            if (eVar != null && !E(eVar)) {
                z = false;
            }
        }
        return z;
    }

    public final boolean E(d.a.h0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f44911b, "mapp_location") || TextUtils.equals(eVar.f44911b, "mapp_images") || TextUtils.equals(eVar.f44911b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f44911b, PermissionProxy.SCOPE_ID_CAMERA);
    }

    public final boolean F(List<d.a.h0.a.v1.c.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (d.a.h0.a.v1.c.e eVar : list) {
            if (eVar != null && C(eVar)) {
                return false;
            }
        }
        return true;
    }

    public final void G(List<d.a.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.h0.a.r1.e eVar) {
        if (D(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            L(eVar, activity, new d(list, activity, callbackHandler, str));
        }
    }

    public final void H(List<d.a.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (F(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            z(new e(list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<d.a.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (z) {
            d.a.h0.a.c0.c.g("MultiAuthorize", "onCallback: real name success");
            J(activity, list, callbackHandler, str);
            return;
        }
        d.a.h0.a.c0.c.g("MultiAuthorize", "onCallback: real name fail");
        M(new f(activity, list, callbackHandler, str));
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.h0.a.v1.c.e> list, @NonNull CallbackHandler callbackHandler, String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).f44911b;
        }
        d.a.h0.a.v1.c.i.b d2 = d.a.h0.a.r1.d.e().w().a().b().d(activity, false, true, strArr, null, true);
        d2.p(new C0832h(this, callbackHandler, str));
        d2.a();
    }

    public final void K(List<d.a.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.h0.a.w0.a.I().d(new g(list, activity, callbackHandler, str));
    }

    public final void L(@NonNull d.a.h0.a.r1.e eVar, @NonNull Activity activity, j jVar) {
        v(eVar, activity, jVar);
    }

    public final void M(d.a.h0.a.i2.u0.b<String> bVar) {
        d.a.h0.a.w0.a.I().b(false, bVar);
    }

    public final void N(@NonNull Activity activity, d.a.h0.a.v1.c.e eVar, String str) {
        String M = d.a.h0.a.r1.d.e().p().M();
        boolean equals = TextUtils.equals(str, "1");
        if (!A(eVar.s)) {
            eVar.r = activity.getString(d.a.h0.a.h.swanapp_multi_auth_realname_name_head) + M + activity.getString(d.a.h0.a.h.swanapp_multi_auth_realname_name_end);
        } else if (equals) {
            eVar.r = activity.getString(d.a.h0.a.h.swanapp_multi_auth_realname_name_head) + M + activity.getString(d.a.h0.a.h.swanapp_multi_auth_realname_name_end);
        } else {
            eVar.r = activity.getString(d.a.h0.a.h.swanapp_multi_auth_un_realname_name_head) + M + activity.getString(d.a.h0.a.h.swanapp_multi_auth_un_realname_name_end);
        }
    }

    public final void O(@NonNull Activity activity, d.a.h0.a.v1.c.e eVar, Boolean bool) {
        String M = d.a.h0.a.r1.d.e().p().M();
        boolean D = D(eVar.s);
        boolean A = A(eVar.s);
        if (!bool.booleanValue() && !D) {
            eVar.r = activity.getString(d.a.h0.a.h.swanapp_multi_auth_guest_login_name_head) + M + activity.getString(d.a.h0.a.h.swanapp_multi_auth_guest_login_name_end);
        } else if (A) {
            eVar.r = activity.getString(d.a.h0.a.h.swanapp_multi_auth_un_realname_name_head) + M + activity.getString(d.a.h0.a.h.swanapp_multi_auth_not_login_name_end);
        } else {
            eVar.r = activity.getString(d.a.h0.a.h.swanapp_multi_auth_not_login_name_head) + M + activity.getString(d.a.h0.a.h.swanapp_multi_auth_not_login_name_end);
        }
    }

    public final void P(d.a.h0.a.v1.c.e eVar, List<d.a.h0.a.v1.c.e> list, boolean z, @NonNull Activity activity, @NonNull d.a.h0.a.r1.e eVar2, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.h0.a.v1.c.c.q(activity, eVar2, eVar, new JSONObject(), new c(callbackHandler, str, z, eVar2, activity, list));
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar != null && (context instanceof Activity)) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.has("scopes")) {
                JSONArray optJSONArray = a2.optJSONArray("scopes");
                if (optJSONArray != null && optJSONArray.length() >= 2 && optJSONArray.length() <= 4) {
                    eVar.R().g(context, "scope_multi_authorize", new a(callbackHandler, a2.optString("cb"), context, eVar, optJSONArray));
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

    public final void v(@NonNull d.a.h0.a.r1.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        eVar.i().f(activity, null, new i(this, jVar));
    }

    public final List<d.a.h0.a.v1.c.e> w(Map<String, d.a.h0.a.v1.c.e> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.h0.a.v1.c.e eVar;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (eVar = map.get(optString)) != null) {
                if (!B(eVar)) {
                    d.a.h0.a.v1.c.c.m(10005, callbackHandler, str);
                    d.a.h0.a.z1.h.q(10005, eVar);
                    return null;
                } else if (eVar.f44913d) {
                    d.a.h0.a.v1.c.c.m(10005, callbackHandler, str);
                    d.a.h0.a.z1.h.q(10005, eVar);
                    return null;
                } else {
                    if (!arrayList.contains(eVar) && !eVar.a()) {
                        arrayList.add(eVar);
                    }
                    if (!eVar.a()) {
                        z = false;
                    }
                }
            }
        }
        if (z) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            return null;
        }
        d.a.h0.a.c0.c.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.h0.a.r1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        d.a.h0.a.g1.o.a.h().z(new b(callbackHandler, str, jSONArray, eVar, activity));
    }

    public final d.a.h0.a.v1.c.e y(Map<String, d.a.h0.a.v1.c.e> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.h0.a.v1.c.e eVar = map.get("scope_multi_authorize");
        if (eVar == null) {
            d.a.h0.a.v1.c.c.m(10001, callbackHandler, str);
            d.a.h0.a.z1.h.q(10001, null);
            return null;
        } else if (eVar.f44913d) {
            d.a.h0.a.v1.c.c.m(10005, callbackHandler, str);
            d.a.h0.a.z1.h.q(10005, eVar);
            return null;
        } else {
            return eVar;
        }
    }

    public final void z(d.a.h0.a.i2.u0.b<String> bVar) {
        d.a.h0.a.w0.a.I().c(d.a.h0.a.w0.a.c(), bVar);
    }
}
