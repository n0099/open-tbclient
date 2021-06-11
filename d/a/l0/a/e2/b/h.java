package d.a.l0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.j2.k;
import d.a.l0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45298g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45299h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45300i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.a.l0.a.a2.e eVar, JSONArray jSONArray) {
            this.f45296e = callbackHandler;
            this.f45297f = str;
            this.f45298g = context;
            this.f45299h = eVar;
            this.f45300i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                h.this.x((Activity) this.f45298g, this.f45299h, this.f45296e, this.f45300i, this.f45297f);
            } else {
                d.a.l0.a.e2.c.d.p(iVar, this.f45296e, this.f45297f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45301a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45302b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f45303c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45304d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45305e;

        /* loaded from: classes3.dex */
        public class a implements d.a.l0.a.v2.e1.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.e2.c.f f45307e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f45308f;

            /* renamed from: d.a.l0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0671a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f45310e;

                public RunnableC0671a(Boolean bool) {
                    this.f45310e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.a.l0.a.e2.c.f fVar = aVar.f45307e;
                    List list = aVar.f45308f;
                    boolean booleanValue = this.f45310e.booleanValue();
                    b bVar = b.this;
                    hVar.P(fVar, list, booleanValue, bVar.f45305e, bVar.f45304d, bVar.f45301a, bVar.f45302b);
                }
            }

            public a(d.a.l0.a.e2.c.f fVar, List list) {
                this.f45307e = fVar;
                this.f45308f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f45305e, this.f45307e, bool);
                q0.X(new RunnableC0671a(bool));
            }
        }

        /* renamed from: d.a.l0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0672b implements d.a.l0.a.v2.e1.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.e2.c.f f45312e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f45313f;

            /* renamed from: d.a.l0.a.e2.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0672b c0672b = C0672b.this;
                    b bVar = b.this;
                    h.this.P(c0672b.f45312e, c0672b.f45313f, false, bVar.f45305e, bVar.f45304d, bVar.f45301a, bVar.f45302b);
                }
            }

            public C0672b(d.a.l0.a.e2.c.f fVar, List list) {
                this.f45312e = fVar;
                this.f45313f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f45305e, this.f45312e, str);
                q0.X(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.l0.a.a2.e eVar, Activity activity) {
            this.f45301a = callbackHandler;
            this.f45302b = str;
            this.f45303c = jSONArray;
            this.f45304d = eVar;
            this.f45305e = activity;
        }

        @Override // d.a.l0.a.n1.q.b.a
        public void a() {
            List<d.a.l0.a.e2.c.f> w;
            Map<String, d.a.l0.a.e2.c.f> g2 = d.a.l0.a.n1.q.c.a.g(true);
            d.a.l0.a.e2.c.f y = h.this.y(g2, this.f45301a, this.f45302b);
            if (y == null || (w = h.this.w(g2, this.f45303c, this.f45301a, this.f45302b)) == null) {
                return;
            }
            y.g(w);
            if (this.f45304d.j().e(this.f45305e)) {
                h.this.z(new C0672b(y, w));
            } else {
                d.a.l0.a.c1.a.T().a(this.f45305e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.e2.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45316a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45317b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f45318c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45319d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f45321f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.a.l0.a.a2.e eVar, Activity activity, List list) {
            this.f45316a = callbackHandler;
            this.f45317b = str;
            this.f45318c = z;
            this.f45319d = eVar;
            this.f45320e = activity;
            this.f45321f = list;
        }

        @Override // d.a.l0.a.e2.c.a
        public void onResult(boolean z) {
            d.a.l0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.a.l0.a.e2.c.d.n(10003, this.f45316a, this.f45317b);
                return;
            }
            boolean z2 = this.f45318c;
            if (this.f45319d.j().e(this.f45320e)) {
                h.this.H(this.f45321f, this.f45320e, this.f45316a, this.f45317b);
            } else if (z2) {
                h.this.K(this.f45321f, this.f45320e, this.f45316a, this.f45317b);
            } else {
                h.this.G(this.f45321f, this.f45320e, this.f45316a, this.f45317b, this.f45319d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f45323a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f45324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45325c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45326d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45323a = list;
            this.f45324b = activity;
            this.f45325c = callbackHandler;
            this.f45326d = str;
        }

        @Override // d.a.l0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            d.a.l0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
            if (z) {
                h.this.H(this.f45323a, this.f45324b, this.f45325c, this.f45326d);
            } else {
                d.a.l0.a.e2.c.d.n(10004, this.f45325c, this.f45326d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f45329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45331h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45328e = list;
            this.f45329f = activity;
            this.f45330g = callbackHandler;
            this.f45331h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f45328e, this.f45329f, this.f45330g, this.f45331h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f45333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f45334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45335g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45336h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f45333e = activity;
            this.f45334f = list;
            this.f45335g = callbackHandler;
            this.f45336h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f45333e, this.f45334f, this.f45335g, this.f45336h);
            } else {
                d.a.l0.a.e2.c.d.n(10003, this.f45335g, this.f45336h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.a.v2.e1.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45338e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f45339f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45340g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45341h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f45338e = list;
            this.f45339f = activity;
            this.f45340g = callbackHandler;
            this.f45341h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f45338e, this.f45339f, this.f45340g, this.f45341h);
            } else {
                d.a.l0.a.e2.c.d.n(10003, this.f45340g, this.f45341h);
            }
        }
    }

    /* renamed from: d.a.l0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0673h implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45344f;

        public C0673h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f45343e = callbackHandler;
            this.f45344f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (iVar == null) {
                d.a.l0.a.e2.c.d.n(10001, this.f45343e, this.f45344f);
                k.p(10001, null);
                return;
            }
            int b2 = iVar.b();
            d.a.l0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f45412a);
            if (b2 != 0) {
                d.a.l0.a.e2.c.d.n(b2, this.f45343e, this.f45344f);
            } else {
                this.f45343e.handleSchemeDispatchCallback(this.f45344f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f45345e;

        public i(h hVar, j jVar) {
            this.f45345e = jVar;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                this.f45345e.a(false, i2);
            } else {
                this.f45345e.a(true, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    public h(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
    }

    public final boolean A(List<d.a.l0.a.e2.c.f> list) {
        if (list != null && list.size() > 0) {
            for (d.a.l0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(d.a.l0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f45371b, "mapp_location") || TextUtils.equals(fVar.f45371b, "mapp_images") || TextUtils.equals(fVar.f45371b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f45371b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f45371b, "ppcert") || TextUtils.equals(fVar.f45371b, "mapp_i_face_verify") || TextUtils.equals(fVar.f45371b, "snsapi_userinfo") || TextUtils.equals(fVar.f45371b, "mapp_choose_address") || TextUtils.equals(fVar.f45371b, "mobile") || TextUtils.equals(fVar.f45371b, "mapp_choose_invoice");
    }

    public final boolean C(d.a.l0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f45371b, "ppcert") || TextUtils.equals(fVar.f45371b, "mapp_i_face_verify");
    }

    public final boolean D(List<d.a.l0.a.e2.c.f> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (d.a.l0.a.e2.c.f fVar : list) {
            if (fVar != null && !E(fVar)) {
                z = false;
            }
        }
        return z;
    }

    public final boolean E(d.a.l0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f45371b, "mapp_location") || TextUtils.equals(fVar.f45371b, "mapp_images") || TextUtils.equals(fVar.f45371b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f45371b, PermissionProxy.SCOPE_ID_CAMERA);
    }

    public final boolean F(List<d.a.l0.a.e2.c.f> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (d.a.l0.a.e2.c.f fVar : list) {
            if (fVar != null && C(fVar)) {
                return false;
            }
        }
        return true;
    }

    public final void G(List<d.a.l0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.l0.a.a2.e eVar) {
        if (D(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            L(eVar, activity, new d(list, activity, callbackHandler, str));
        }
    }

    public final void H(List<d.a.l0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (F(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            z(new e(list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<d.a.l0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (z) {
            d.a.l0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
            J(activity, list, callbackHandler, str);
            return;
        }
        d.a.l0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
        M(new f(activity, list, callbackHandler, str));
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.l0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).f45371b;
        }
        d.a.l0.a.e2.c.j.b d2 = d.a.l0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
        d2.p(new C0673h(this, callbackHandler, str));
        d2.a();
    }

    public final void K(List<d.a.l0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.l0.a.c1.a.T().d(new g(list, activity, callbackHandler, str));
    }

    public final void L(@NonNull d.a.l0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        v(eVar, activity, jVar);
    }

    public final void M(d.a.l0.a.v2.e1.b<String> bVar) {
        d.a.l0.a.c1.a.T().b(false, bVar);
    }

    public final void N(@NonNull Activity activity, d.a.l0.a.e2.c.f fVar, String str) {
        String O = d.a.l0.a.a2.d.g().r().O();
        boolean equals = TextUtils.equals(str, "1");
        if (!A(fVar.s)) {
            fVar.r = activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_end);
        } else if (equals) {
            fVar.r = activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_end);
        } else {
            fVar.r = activity.getString(d.a.l0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_end);
        }
    }

    public final void O(@NonNull Activity activity, d.a.l0.a.e2.c.f fVar, Boolean bool) {
        String O = d.a.l0.a.a2.d.g().r().O();
        boolean D = D(fVar.s);
        boolean A = A(fVar.s);
        if (!bool.booleanValue() && !D) {
            fVar.r = activity.getString(d.a.l0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_end);
        } else if (A) {
            fVar.r = activity.getString(d.a.l0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_end);
        } else {
            fVar.r = activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.l0.a.h.swanapp_multi_auth_default_name_end);
        }
    }

    public final void P(d.a.l0.a.e2.c.f fVar, List<d.a.l0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull d.a.l0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.l0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(callbackHandler, str, z, eVar, activity, list));
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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

    public final void v(@NonNull d.a.l0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        eVar.j().f(activity, null, new i(this, jVar));
    }

    public final List<d.a.l0.a.e2.c.f> w(Map<String, d.a.l0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.l0.a.e2.c.f fVar;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                if (!B(fVar)) {
                    d.a.l0.a.e2.c.d.n(10005, callbackHandler, str);
                    k.p(10005, fVar);
                    return null;
                } else if (fVar.f45373d) {
                    d.a.l0.a.e2.c.d.n(10005, callbackHandler, str);
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
        d.a.l0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.l0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        d.a.l0.a.n1.q.a.g().z(new b(callbackHandler, str, jSONArray, eVar, activity));
    }

    public final d.a.l0.a.e2.c.f y(Map<String, d.a.l0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.l0.a.e2.c.f fVar = map.get("scope_multi_authorize");
        if (fVar == null) {
            d.a.l0.a.e2.c.d.n(10001, callbackHandler, str);
            k.p(10001, null);
            return null;
        } else if (fVar.f45373d) {
            d.a.l0.a.e2.c.d.n(10005, callbackHandler, str);
            k.p(10005, fVar);
            return null;
        } else {
            return fVar;
        }
    }

    public final void z(d.a.l0.a.v2.e1.b<String> bVar) {
        d.a.l0.a.c1.a.T().c(d.a.l0.a.c1.a.b(), bVar);
    }
}
