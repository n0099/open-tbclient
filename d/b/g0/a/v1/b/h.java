package d.b.g0.a.v1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.i.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46698e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46699f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46700g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46701h;
        public final /* synthetic */ JSONArray i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.b.g0.a.r1.e eVar, JSONArray jSONArray) {
            this.f46698e = callbackHandler;
            this.f46699f = str;
            this.f46700g = context;
            this.f46701h = eVar;
            this.i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                h.this.x((Activity) this.f46700g, this.f46701h, this.f46698e, this.i, this.f46699f);
            } else {
                d.b.g0.a.v1.c.c.o(hVar, this.f46698e, this.f46699f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46702a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46703b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46704c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46705d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46706e;

        /* loaded from: classes3.dex */
        public class a implements d.b.g0.a.i2.u0.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.v1.c.e f46708e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f46709f;

            /* renamed from: d.b.g0.a.v1.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0858a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f46711e;

                public RunnableC0858a(Boolean bool) {
                    this.f46711e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.b.g0.a.v1.c.e eVar = aVar.f46708e;
                    List list = aVar.f46709f;
                    boolean booleanValue = this.f46711e.booleanValue();
                    b bVar = b.this;
                    hVar.P(eVar, list, booleanValue, bVar.f46706e, bVar.f46705d, bVar.f46702a, bVar.f46703b);
                }
            }

            public a(d.b.g0.a.v1.c.e eVar, List list) {
                this.f46708e = eVar;
                this.f46709f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f46706e, this.f46708e, bool);
                k0.T(new RunnableC0858a(bool));
            }
        }

        /* renamed from: d.b.g0.a.v1.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0859b implements d.b.g0.a.i2.u0.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.v1.c.e f46713e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f46714f;

            /* renamed from: d.b.g0.a.v1.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0859b c0859b = C0859b.this;
                    b bVar = b.this;
                    h.this.P(c0859b.f46713e, c0859b.f46714f, false, bVar.f46706e, bVar.f46705d, bVar.f46702a, bVar.f46703b);
                }
            }

            public C0859b(d.b.g0.a.v1.c.e eVar, List list) {
                this.f46713e = eVar;
                this.f46714f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f46706e, this.f46713e, str);
                k0.T(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.b.g0.a.r1.e eVar, Activity activity) {
            this.f46702a = callbackHandler;
            this.f46703b = str;
            this.f46704c = jSONArray;
            this.f46705d = eVar;
            this.f46706e = activity;
        }

        @Override // d.b.g0.a.g1.o.b.a
        public void a() {
            List<d.b.g0.a.v1.c.e> w;
            Map<String, d.b.g0.a.v1.c.e> g2 = d.b.g0.a.g1.o.c.a.g(true);
            d.b.g0.a.v1.c.e y = h.this.y(g2, this.f46702a, this.f46703b);
            if (y == null || (w = h.this.w(g2, this.f46704c, this.f46702a, this.f46703b)) == null) {
                return;
            }
            y.g(w);
            if (this.f46705d.z().e(this.f46706e)) {
                h.this.z(new C0859b(y, w));
            } else {
                d.b.g0.a.w0.a.I().a(this.f46706e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.v1.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46717a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46718b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f46719c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46720d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46721e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f46722f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.b.g0.a.r1.e eVar, Activity activity, List list) {
            this.f46717a = callbackHandler;
            this.f46718b = str;
            this.f46719c = z;
            this.f46720d = eVar;
            this.f46721e = activity;
            this.f46722f = list;
        }

        @Override // d.b.g0.a.v1.c.a
        public void onResult(boolean z) {
            d.b.g0.a.c0.c.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.b.g0.a.v1.c.c.m(10003, this.f46717a, this.f46718b);
                return;
            }
            boolean z2 = this.f46719c;
            if (this.f46720d.z().e(this.f46721e)) {
                h.this.H(this.f46722f, this.f46721e, this.f46717a, this.f46718b);
            } else if (z2) {
                h.this.K(this.f46722f, this.f46721e, this.f46717a, this.f46718b);
            } else {
                h.this.G(this.f46722f, this.f46721e, this.f46717a, this.f46718b, this.f46720d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f46724a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f46725b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46726c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46727d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f46724a = list;
            this.f46725b = activity;
            this.f46726c = callbackHandler;
            this.f46727d = str;
        }

        @Override // d.b.g0.a.v1.b.h.j
        public void a(boolean z, int i) {
            d.b.g0.a.c0.c.g("MultiAuthorize", "login result:" + i);
            if (z) {
                h.this.H(this.f46724a, this.f46725b, this.f46726c, this.f46727d);
            } else {
                d.b.g0.a.v1.c.c.m(10004, this.f46726c, this.f46727d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f46730f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46731g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46732h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f46729e = list;
            this.f46730f = activity;
            this.f46731g = callbackHandler;
            this.f46732h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f46729e, this.f46730f, this.f46731g, this.f46732h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46733e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f46734f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46735g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46736h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f46733e = activity;
            this.f46734f = list;
            this.f46735g = callbackHandler;
            this.f46736h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f46733e, this.f46734f, this.f46735g, this.f46736h);
            } else {
                d.b.g0.a.v1.c.c.m(10003, this.f46735g, this.f46736h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.b.g0.a.i2.u0.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f46738f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46739g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46740h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f46737e = list;
            this.f46738f = activity;
            this.f46739g = callbackHandler;
            this.f46740h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f46737e, this.f46738f, this.f46739g, this.f46740h);
            } else {
                d.b.g0.a.v1.c.c.m(10003, this.f46739g, this.f46740h);
            }
        }
    }

    /* renamed from: d.b.g0.a.v1.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0860h implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46742f;

        public C0860h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f46741e = callbackHandler;
            this.f46742f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (hVar == null) {
                d.b.g0.a.v1.c.c.m(10001, this.f46741e, this.f46742f);
                d.b.g0.a.z1.h.q(10001, null);
                return;
            }
            int b2 = hVar.b();
            d.b.g0.a.c0.c.l("MultiAuthorize", "requestAuthorize " + hVar.a() + ",  code=" + b2 + ", data=" + hVar.f46807a);
            if (b2 != 0) {
                d.b.g0.a.v1.c.c.m(b2, this.f46741e, this.f46742f);
            } else {
                this.f46741e.handleSchemeDispatchCallback(this.f46742f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f46743e;

        public i(h hVar, j jVar) {
            this.f46743e = jVar;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                this.f46743e.a(false, i);
            } else {
                this.f46743e.a(true, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i);
    }

    public h(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/multiAuthorize");
    }

    public final boolean A(List<d.b.g0.a.v1.c.e> list) {
        if (list != null && list.size() > 0) {
            for (d.b.g0.a.v1.c.e eVar : list) {
                if (eVar != null && C(eVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(d.b.g0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f46768b, "mapp_location") || TextUtils.equals(eVar.f46768b, "mapp_images") || TextUtils.equals(eVar.f46768b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f46768b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(eVar.f46768b, "ppcert") || TextUtils.equals(eVar.f46768b, "mapp_i_face_verify") || TextUtils.equals(eVar.f46768b, "snsapi_userinfo") || TextUtils.equals(eVar.f46768b, "mapp_choose_address") || TextUtils.equals(eVar.f46768b, "mobile") || TextUtils.equals(eVar.f46768b, "mapp_choose_invoice");
    }

    public final boolean C(d.b.g0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f46768b, "ppcert") || TextUtils.equals(eVar.f46768b, "mapp_i_face_verify");
    }

    public final boolean D(List<d.b.g0.a.v1.c.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (d.b.g0.a.v1.c.e eVar : list) {
            if (eVar != null && !E(eVar)) {
                z = false;
            }
        }
        return z;
    }

    public final boolean E(d.b.g0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f46768b, "mapp_location") || TextUtils.equals(eVar.f46768b, "mapp_images") || TextUtils.equals(eVar.f46768b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f46768b, PermissionProxy.SCOPE_ID_CAMERA);
    }

    public final boolean F(List<d.b.g0.a.v1.c.e> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (d.b.g0.a.v1.c.e eVar : list) {
            if (eVar != null && C(eVar)) {
                return false;
            }
        }
        return true;
    }

    public final void G(List<d.b.g0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.b.g0.a.r1.e eVar) {
        if (D(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            L(eVar, activity, new d(list, activity, callbackHandler, str));
        }
    }

    public final void H(List<d.b.g0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (F(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            z(new e(list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<d.b.g0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (z) {
            d.b.g0.a.c0.c.g("MultiAuthorize", "onCallback: real name success");
            J(activity, list, callbackHandler, str);
            return;
        }
        d.b.g0.a.c0.c.g("MultiAuthorize", "onCallback: real name fail");
        M(new f(activity, list, callbackHandler, str));
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.b.g0.a.v1.c.e> list, @NonNull CallbackHandler callbackHandler, String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).f46768b;
        }
        d.b.g0.a.v1.c.i.b e2 = d.b.g0.a.r1.d.e().o().a().a().e(activity, false, true, strArr, null, true);
        e2.p(new C0860h(this, callbackHandler, str));
        e2.a();
    }

    public final void K(List<d.b.g0.a.v1.c.e> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.g0.a.w0.a.I().d(new g(list, activity, callbackHandler, str));
    }

    public final void L(@NonNull d.b.g0.a.r1.e eVar, @NonNull Activity activity, j jVar) {
        v(eVar, activity, jVar);
    }

    public final void M(d.b.g0.a.i2.u0.b<String> bVar) {
        d.b.g0.a.w0.a.I().b(false, bVar);
    }

    public final void N(@NonNull Activity activity, d.b.g0.a.v1.c.e eVar, String str) {
        String M = d.b.g0.a.r1.d.e().s().M();
        boolean equals = TextUtils.equals(str, "1");
        if (!A(eVar.s)) {
            eVar.r = activity.getString(d.b.g0.a.h.swanapp_multi_auth_realname_name_head) + M + activity.getString(d.b.g0.a.h.swanapp_multi_auth_realname_name_end);
        } else if (equals) {
            eVar.r = activity.getString(d.b.g0.a.h.swanapp_multi_auth_realname_name_head) + M + activity.getString(d.b.g0.a.h.swanapp_multi_auth_realname_name_end);
        } else {
            eVar.r = activity.getString(d.b.g0.a.h.swanapp_multi_auth_un_realname_name_head) + M + activity.getString(d.b.g0.a.h.swanapp_multi_auth_un_realname_name_end);
        }
    }

    public final void O(@NonNull Activity activity, d.b.g0.a.v1.c.e eVar, Boolean bool) {
        String M = d.b.g0.a.r1.d.e().s().M();
        boolean D = D(eVar.s);
        boolean A = A(eVar.s);
        if (!bool.booleanValue() && !D) {
            eVar.r = activity.getString(d.b.g0.a.h.swanapp_multi_auth_guest_login_name_head) + M + activity.getString(d.b.g0.a.h.swanapp_multi_auth_guest_login_name_end);
        } else if (A) {
            eVar.r = activity.getString(d.b.g0.a.h.swanapp_multi_auth_un_realname_name_head) + M + activity.getString(d.b.g0.a.h.swanapp_multi_auth_not_login_name_end);
        } else {
            eVar.r = activity.getString(d.b.g0.a.h.swanapp_multi_auth_not_login_name_head) + M + activity.getString(d.b.g0.a.h.swanapp_multi_auth_not_login_name_end);
        }
    }

    public final void P(d.b.g0.a.v1.c.e eVar, List<d.b.g0.a.v1.c.e> list, boolean z, @NonNull Activity activity, @NonNull d.b.g0.a.r1.e eVar2, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.g0.a.v1.c.c.q(activity, eVar2, eVar, new JSONObject(), new c(callbackHandler, str, z, eVar2, activity, list));
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
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

    public final void v(@NonNull d.b.g0.a.r1.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        eVar.z().f(activity, null, new i(this, jVar));
    }

    public final List<d.b.g0.a.v1.c.e> w(Map<String, d.b.g0.a.v1.c.e> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.g0.a.v1.c.e eVar;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (eVar = map.get(optString)) != null) {
                if (!B(eVar)) {
                    d.b.g0.a.v1.c.c.m(10005, callbackHandler, str);
                    d.b.g0.a.z1.h.q(10005, eVar);
                    return null;
                } else if (eVar.f46770d) {
                    d.b.g0.a.v1.c.c.m(10005, callbackHandler, str);
                    d.b.g0.a.z1.h.q(10005, eVar);
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
        d.b.g0.a.c0.c.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.b.g0.a.r1.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        d.b.g0.a.g1.o.a.h().z(new b(callbackHandler, str, jSONArray, eVar, activity));
    }

    public final d.b.g0.a.v1.c.e y(Map<String, d.b.g0.a.v1.c.e> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.b.g0.a.v1.c.e eVar = map.get("scope_multi_authorize");
        if (eVar == null) {
            d.b.g0.a.v1.c.c.m(10001, callbackHandler, str);
            d.b.g0.a.z1.h.q(10001, null);
            return null;
        } else if (eVar.f46770d) {
            d.b.g0.a.v1.c.c.m(10005, callbackHandler, str);
            d.b.g0.a.z1.h.q(10005, eVar);
            return null;
        } else {
            return eVar;
        }
    }

    public final void z(d.b.g0.a.i2.u0.b<String> bVar) {
        d.b.g0.a.w0.a.I().c(d.b.g0.a.w0.a.c(), bVar);
    }
}
