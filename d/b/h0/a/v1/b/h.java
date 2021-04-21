package d.b.h0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import d.b.h0.a.i2.k0;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47420e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47421f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47422g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47423h;
        public final /* synthetic */ JSONArray i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.b.h0.a.r1.e eVar, JSONArray jSONArray) {
            this.f47420e = callbackHandler;
            this.f47421f = str;
            this.f47422g = context;
            this.f47423h = eVar;
            this.i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                h.this.x((Activity) this.f47422g, this.f47423h, this.f47420e, this.i, this.f47421f);
            } else {
                d.b.h0.a.v1.c.c.o(hVar, this.f47420e, this.f47421f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47424a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47425b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47426c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47427d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47428e;

        /* loaded from: classes3.dex */
        public class a implements d.b.h0.a.i2.u0.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.v1.c.e f47430e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f47431f;

            /* renamed from: d.b.h0.a.v1.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0891a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f47433e;

                public RunnableC0891a(Boolean bool) {
                    this.f47433e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.b.h0.a.v1.c.e eVar = aVar.f47430e;
                    List list = aVar.f47431f;
                    boolean booleanValue = this.f47433e.booleanValue();
                    b bVar = b.this;
                    hVar.P(eVar, list, booleanValue, bVar.f47428e, bVar.f47427d, bVar.f47424a, bVar.f47425b);
                }
            }

            public a(d.b.h0.a.v1.c.e eVar, List list) {
                this.f47430e = eVar;
                this.f47431f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f47428e, this.f47430e, bool);
                k0.T(new RunnableC0891a(bool));
            }
        }

        /* renamed from: d.b.h0.a.v1.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0892b implements d.b.h0.a.i2.u0.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.v1.c.e f47435e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f47436f;

            /* renamed from: d.b.h0.a.v1.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0892b c0892b = C0892b.this;
                    b bVar = b.this;
                    h.this.P(c0892b.f47435e, c0892b.f47436f, false, bVar.f47428e, bVar.f47427d, bVar.f47424a, bVar.f47425b);
                }
            }

            public C0892b(d.b.h0.a.v1.c.e eVar, List list) {
                this.f47435e = eVar;
                this.f47436f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f47428e, this.f47435e, str);
                k0.T(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.b.h0.a.r1.e eVar, Activity activity) {
            this.f47424a = callbackHandler;
            this.f47425b = str;
            this.f47426c = jSONArray;
            this.f47427d = eVar;
            this.f47428e = activity;
        }

        @Override // d.b.h0.a.g1.o.b.a
        public void a() {
            List<d.b.h0.a.v1.c.e> w;
            Map<String, d.b.h0.a.v1.c.e> g2 = d.b.h0.a.g1.o.c.a.g(true);
            d.b.h0.a.v1.c.e y = h.this.y(g2, this.f47424a, this.f47425b);
            if (y == null || (w = h.this.w(g2, this.f47426c, this.f47424a, this.f47425b)) == null) {
                return;
            }
            y.g(w);
            if (this.f47427d.z().e(this.f47428e)) {
                h.this.z(new C0892b(y, w));
            } else {
                d.b.h0.a.w0.a.I().a(this.f47428e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.h0.a.v1.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47439a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f47441c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47442d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47444f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.b.h0.a.r1.e eVar, Activity activity, List list) {
            this.f47439a = callbackHandler;
            this.f47440b = str;
            this.f47441c = z;
            this.f47442d = eVar;
            this.f47443e = activity;
            this.f47444f = list;
        }

        @Override // d.b.h0.a.v1.c.a
        public void onResult(boolean z) {
            d.b.h0.a.c0.c.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.b.h0.a.v1.c.c.m(10003, this.f47439a, this.f47440b);
                return;
            }
            boolean z2 = this.f47441c;
            if (this.f47442d.z().e(this.f47443e)) {
                h.this.H(this.f47444f, this.f47443e, this.f47439a, this.f47440b);
            } else if (z2) {
                h.this.K(this.f47444f, this.f47443e, this.f47439a, this.f47440b);
            } else {
                h.this.G(this.f47444f, this.f47443e, this.f47439a, this.f47440b, this.f47442d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f47446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f47447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47448c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47449d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f47446a = list;
            this.f47447b = activity;
            this.f47448c = callbackHandler;
            this.f47449d = str;
        }

        @Override // d.b.h0.a.v1.b.h.j
        public void a(boolean z, int i) {
            d.b.h0.a.c0.c.g("MultiAuthorize", "login result:" + i);
            if (z) {
                h.this.H(this.f47446a, this.f47447b, this.f47448c, this.f47449d);
            } else {
                d.b.h0.a.v1.c.c.m(10004, this.f47448c, this.f47449d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47452f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47453g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47454h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f47451e = list;
            this.f47452f = activity;
            this.f47453g = callbackHandler;
            this.f47454h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f47451e, this.f47452f, this.f47453g, this.f47454h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.h0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f47456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47457g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47458h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f47455e = activity;
            this.f47456f = list;
            this.f47457g = callbackHandler;
            this.f47458h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f47455e, this.f47456f, this.f47457g, this.f47458h);
            } else {
                d.b.h0.a.v1.c.c.m(10003, this.f47457g, this.f47458h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.h0.a.i2.u0.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47461g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47462h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f47459e = list;
            this.f47460f = activity;
            this.f47461g = callbackHandler;
            this.f47462h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f47459e, this.f47460f, this.f47461g, this.f47462h);
            } else {
                d.b.h0.a.v1.c.c.m(10003, this.f47461g, this.f47462h);
            }
        }
    }

    /* renamed from: d.b.h0.a.v1.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0893h implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47464f;

        public C0893h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f47463e = callbackHandler;
            this.f47464f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (hVar == null) {
                d.b.h0.a.v1.c.c.m(10001, this.f47463e, this.f47464f);
                d.b.h0.a.z1.h.q(10001, null);
                return;
            }
            int b2 = hVar.b();
            d.b.h0.a.c0.c.l("MultiAuthorize", "requestAuthorize " + hVar.a() + ",  code=" + b2 + ", data=" + hVar.f47529a);
            if (b2 != 0) {
                d.b.h0.a.v1.c.c.m(b2, this.f47463e, this.f47464f);
            } else {
                this.f47463e.handleSchemeDispatchCallback(this.f47464f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.b.h0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f47465e;

        public i(h hVar, j jVar) {
            this.f47465e = jVar;
        }

        @Override // d.b.h0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                this.f47465e.a(false, i);
            } else {
                this.f47465e.a(true, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i);
    }

    public h(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/multiAuthorize");
    }

    public final boolean A(List<d.b.h0.a.v1.c.e> list) {
        if (list != null && list.size() > 0) {
            for (d.b.h0.a.v1.c.e eVar : list) {
                if (eVar != null && C(eVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(d.b.h0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f47490b, "mapp_location") || TextUtils.equals(eVar.f47490b, "mapp_images") || TextUtils.equals(eVar.f47490b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f47490b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(eVar.f47490b, "ppcert") || TextUtils.equals(eVar.f47490b, "mapp_i_face_verify") || TextUtils.equals(eVar.f47490b, "snsapi_userinfo") || TextUtils.equals(eVar.f47490b, "mapp_choose_address") || TextUtils.equals(eVar.f47490b, "mobile") || TextUtils.equals(eVar.f47490b, "mapp_choose_invoice");
    }

    public final boolean C(d.b.h0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f47490b, "ppcert") || TextUtils.equals(eVar.f47490b, "mapp_i_face_verify");
    }

    public final boolean D(List<d.b.h0.a.v1.c.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (d.b.h0.a.v1.c.e eVar : list) {
            if (eVar != null && !E(eVar)) {
                z = false;
            }
        }
        return z;
    }

    public final boolean E(d.b.h0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f47490b, "mapp_location") || TextUtils.equals(eVar.f47490b, "mapp_images") || TextUtils.equals(eVar.f47490b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f47490b, PermissionProxy.SCOPE_ID_CAMERA);
    }

    public final boolean F(List<d.b.h0.a.v1.c.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (d.b.h0.a.v1.c.e eVar : list) {
            if (eVar != null && C(eVar)) {
                return false;
            }
        }
        return true;
    }

    public final void G(List<d.b.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.b.h0.a.r1.e eVar) {
        if (D(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            L(eVar, activity, new d(list, activity, callbackHandler, str));
        }
    }

    public final void H(List<d.b.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (F(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            z(new e(list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<d.b.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (z) {
            d.b.h0.a.c0.c.g("MultiAuthorize", "onCallback: real name success");
            J(activity, list, callbackHandler, str);
            return;
        }
        d.b.h0.a.c0.c.g("MultiAuthorize", "onCallback: real name fail");
        M(new f(activity, list, callbackHandler, str));
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.b.h0.a.v1.c.e> list, @NonNull CallbackHandler callbackHandler, String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).f47490b;
        }
        d.b.h0.a.v1.c.i.b e2 = d.b.h0.a.r1.d.e().o().a().a().e(activity, false, true, strArr, null, true);
        e2.p(new C0893h(this, callbackHandler, str));
        e2.a();
    }

    public final void K(List<d.b.h0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.h0.a.w0.a.I().d(new g(list, activity, callbackHandler, str));
    }

    public final void L(@NonNull d.b.h0.a.r1.e eVar, @NonNull Activity activity, j jVar) {
        v(eVar, activity, jVar);
    }

    public final void M(d.b.h0.a.i2.u0.b<String> bVar) {
        d.b.h0.a.w0.a.I().b(false, bVar);
    }

    public final void N(@NonNull Activity activity, d.b.h0.a.v1.c.e eVar, String str) {
        String M = d.b.h0.a.r1.d.e().s().M();
        boolean equals = TextUtils.equals(str, "1");
        if (!A(eVar.s)) {
            eVar.r = activity.getString(d.b.h0.a.h.swanapp_multi_auth_realname_name_head) + M + activity.getString(d.b.h0.a.h.swanapp_multi_auth_realname_name_end);
        } else if (equals) {
            eVar.r = activity.getString(d.b.h0.a.h.swanapp_multi_auth_realname_name_head) + M + activity.getString(d.b.h0.a.h.swanapp_multi_auth_realname_name_end);
        } else {
            eVar.r = activity.getString(d.b.h0.a.h.swanapp_multi_auth_un_realname_name_head) + M + activity.getString(d.b.h0.a.h.swanapp_multi_auth_un_realname_name_end);
        }
    }

    public final void O(@NonNull Activity activity, d.b.h0.a.v1.c.e eVar, Boolean bool) {
        String M = d.b.h0.a.r1.d.e().s().M();
        boolean D = D(eVar.s);
        boolean A = A(eVar.s);
        if (!bool.booleanValue() && !D) {
            eVar.r = activity.getString(d.b.h0.a.h.swanapp_multi_auth_guest_login_name_head) + M + activity.getString(d.b.h0.a.h.swanapp_multi_auth_guest_login_name_end);
        } else if (A) {
            eVar.r = activity.getString(d.b.h0.a.h.swanapp_multi_auth_un_realname_name_head) + M + activity.getString(d.b.h0.a.h.swanapp_multi_auth_not_login_name_end);
        } else {
            eVar.r = activity.getString(d.b.h0.a.h.swanapp_multi_auth_not_login_name_head) + M + activity.getString(d.b.h0.a.h.swanapp_multi_auth_not_login_name_end);
        }
    }

    public final void P(d.b.h0.a.v1.c.e eVar, List<d.b.h0.a.v1.c.e> list, boolean z, @NonNull Activity activity, @NonNull d.b.h0.a.r1.e eVar2, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.h0.a.v1.c.c.q(activity, eVar2, eVar, new JSONObject(), new c(callbackHandler, str, z, eVar2, activity, list));
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
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

    public final void v(@NonNull d.b.h0.a.r1.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        eVar.z().f(activity, null, new i(this, jVar));
    }

    public final List<d.b.h0.a.v1.c.e> w(Map<String, d.b.h0.a.v1.c.e> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.h0.a.v1.c.e eVar;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (eVar = map.get(optString)) != null) {
                if (!B(eVar)) {
                    d.b.h0.a.v1.c.c.m(10005, callbackHandler, str);
                    d.b.h0.a.z1.h.q(10005, eVar);
                    return null;
                } else if (eVar.f47492d) {
                    d.b.h0.a.v1.c.c.m(10005, callbackHandler, str);
                    d.b.h0.a.z1.h.q(10005, eVar);
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
        d.b.h0.a.c0.c.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.b.h0.a.r1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        d.b.h0.a.g1.o.a.h().z(new b(callbackHandler, str, jSONArray, eVar, activity));
    }

    public final d.b.h0.a.v1.c.e y(Map<String, d.b.h0.a.v1.c.e> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.h0.a.v1.c.e eVar = map.get("scope_multi_authorize");
        if (eVar == null) {
            d.b.h0.a.v1.c.c.m(10001, callbackHandler, str);
            d.b.h0.a.z1.h.q(10001, null);
            return null;
        } else if (eVar.f47492d) {
            d.b.h0.a.v1.c.c.m(10005, callbackHandler, str);
            d.b.h0.a.z1.h.q(10005, eVar);
            return null;
        } else {
            return eVar;
        }
    }

    public final void z(d.b.h0.a.i2.u0.b<String> bVar) {
        d.b.h0.a.w0.a.I().c(d.b.h0.a.w0.a.c(), bVar);
    }
}
