package d.a.i0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.j2.k;
import d.a.i0.a.v2.q0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41446e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41447f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f41448g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f41449h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f41450i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.a.i0.a.a2.e eVar, JSONArray jSONArray) {
            this.f41446e = callbackHandler;
            this.f41447f = str;
            this.f41448g = context;
            this.f41449h = eVar;
            this.f41450i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                h.this.x((Activity) this.f41448g, this.f41449h, this.f41446e, this.f41450i, this.f41447f);
            } else {
                d.a.i0.a.e2.c.d.p(iVar, this.f41446e, this.f41447f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f41453c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f41454d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41455e;

        /* loaded from: classes3.dex */
        public class a implements d.a.i0.a.v2.e1.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.e2.c.f f41457e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f41458f;

            /* renamed from: d.a.i0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0604a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f41460e;

                public RunnableC0604a(Boolean bool) {
                    this.f41460e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.a.i0.a.e2.c.f fVar = aVar.f41457e;
                    List list = aVar.f41458f;
                    boolean booleanValue = this.f41460e.booleanValue();
                    b bVar = b.this;
                    hVar.P(fVar, list, booleanValue, bVar.f41455e, bVar.f41454d, bVar.f41451a, bVar.f41452b);
                }
            }

            public a(d.a.i0.a.e2.c.f fVar, List list) {
                this.f41457e = fVar;
                this.f41458f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f41455e, this.f41457e, bool);
                q0.X(new RunnableC0604a(bool));
            }
        }

        /* renamed from: d.a.i0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0605b implements d.a.i0.a.v2.e1.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.e2.c.f f41462e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f41463f;

            /* renamed from: d.a.i0.a.e2.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0605b c0605b = C0605b.this;
                    b bVar = b.this;
                    h.this.P(c0605b.f41462e, c0605b.f41463f, false, bVar.f41455e, bVar.f41454d, bVar.f41451a, bVar.f41452b);
                }
            }

            public C0605b(d.a.i0.a.e2.c.f fVar, List list) {
                this.f41462e = fVar;
                this.f41463f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f41455e, this.f41462e, str);
                q0.X(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.i0.a.a2.e eVar, Activity activity) {
            this.f41451a = callbackHandler;
            this.f41452b = str;
            this.f41453c = jSONArray;
            this.f41454d = eVar;
            this.f41455e = activity;
        }

        @Override // d.a.i0.a.n1.q.b.a
        public void a() {
            List<d.a.i0.a.e2.c.f> w;
            Map<String, d.a.i0.a.e2.c.f> g2 = d.a.i0.a.n1.q.c.a.g(true);
            d.a.i0.a.e2.c.f y = h.this.y(g2, this.f41451a, this.f41452b);
            if (y == null || (w = h.this.w(g2, this.f41453c, this.f41451a, this.f41452b)) == null) {
                return;
            }
            y.g(w);
            if (this.f41454d.j().e(this.f41455e)) {
                h.this.z(new C0605b(y, w));
            } else {
                d.a.i0.a.c1.a.T().a(this.f41455e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.a.e2.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41466a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41467b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f41468c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f41469d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f41471f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.a.i0.a.a2.e eVar, Activity activity, List list) {
            this.f41466a = callbackHandler;
            this.f41467b = str;
            this.f41468c = z;
            this.f41469d = eVar;
            this.f41470e = activity;
            this.f41471f = list;
        }

        @Override // d.a.i0.a.e2.c.a
        public void onResult(boolean z) {
            d.a.i0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.a.i0.a.e2.c.d.n(10003, this.f41466a, this.f41467b);
                return;
            }
            boolean z2 = this.f41468c;
            if (this.f41469d.j().e(this.f41470e)) {
                h.this.H(this.f41471f, this.f41470e, this.f41466a, this.f41467b);
            } else if (z2) {
                h.this.K(this.f41471f, this.f41470e, this.f41466a, this.f41467b);
            } else {
                h.this.G(this.f41471f, this.f41470e, this.f41466a, this.f41467b, this.f41469d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f41473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f41474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41475c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41476d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f41473a = list;
            this.f41474b = activity;
            this.f41475c = callbackHandler;
            this.f41476d = str;
        }

        @Override // d.a.i0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            d.a.i0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
            if (z) {
                h.this.H(this.f41473a, this.f41474b, this.f41475c, this.f41476d);
            } else {
                d.a.i0.a.e2.c.d.n(10004, this.f41475c, this.f41476d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.i0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f41478e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f41479f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41480g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41481h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f41478e = list;
            this.f41479f = activity;
            this.f41480g = callbackHandler;
            this.f41481h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f41478e, this.f41479f, this.f41480g, this.f41481h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.i0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f41484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41486h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f41483e = activity;
            this.f41484f = list;
            this.f41485g = callbackHandler;
            this.f41486h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f41483e, this.f41484f, this.f41485g, this.f41486h);
            } else {
                d.a.i0.a.e2.c.d.n(10003, this.f41485g, this.f41486h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.i0.a.v2.e1.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f41488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f41489f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41490g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41491h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f41488e = list;
            this.f41489f = activity;
            this.f41490g = callbackHandler;
            this.f41491h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f41488e, this.f41489f, this.f41490g, this.f41491h);
            } else {
                d.a.i0.a.e2.c.d.n(10003, this.f41490g, this.f41491h);
            }
        }
    }

    /* renamed from: d.a.i0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0606h implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41493e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41494f;

        public C0606h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f41493e = callbackHandler;
            this.f41494f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (iVar == null) {
                d.a.i0.a.e2.c.d.n(10001, this.f41493e, this.f41494f);
                k.p(10001, null);
                return;
            }
            int b2 = iVar.b();
            d.a.i0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f41562a);
            if (b2 != 0) {
                d.a.i0.a.e2.c.d.n(b2, this.f41493e, this.f41494f);
            } else {
                this.f41493e.handleSchemeDispatchCallback(this.f41494f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f41495e;

        public i(h hVar, j jVar) {
            this.f41495e = jVar;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                this.f41495e.a(false, i2);
            } else {
                this.f41495e.a(true, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(boolean z, int i2);
    }

    public h(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/multiAuthorize");
    }

    public final boolean A(List<d.a.i0.a.e2.c.f> list) {
        if (list != null && list.size() > 0) {
            for (d.a.i0.a.e2.c.f fVar : list) {
                if (fVar != null && C(fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(d.a.i0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f41521b, "mapp_location") || TextUtils.equals(fVar.f41521b, "mapp_images") || TextUtils.equals(fVar.f41521b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f41521b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f41521b, "ppcert") || TextUtils.equals(fVar.f41521b, "mapp_i_face_verify") || TextUtils.equals(fVar.f41521b, "snsapi_userinfo") || TextUtils.equals(fVar.f41521b, "mapp_choose_address") || TextUtils.equals(fVar.f41521b, "mobile") || TextUtils.equals(fVar.f41521b, "mapp_choose_invoice");
    }

    public final boolean C(d.a.i0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f41521b, "ppcert") || TextUtils.equals(fVar.f41521b, "mapp_i_face_verify");
    }

    public final boolean D(List<d.a.i0.a.e2.c.f> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z = true;
        for (d.a.i0.a.e2.c.f fVar : list) {
            if (fVar != null && !E(fVar)) {
                z = false;
            }
        }
        return z;
    }

    public final boolean E(d.a.i0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f41521b, "mapp_location") || TextUtils.equals(fVar.f41521b, "mapp_images") || TextUtils.equals(fVar.f41521b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f41521b, PermissionProxy.SCOPE_ID_CAMERA);
    }

    public final boolean F(List<d.a.i0.a.e2.c.f> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (d.a.i0.a.e2.c.f fVar : list) {
            if (fVar != null && C(fVar)) {
                return false;
            }
        }
        return true;
    }

    public final void G(List<d.a.i0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull d.a.i0.a.a2.e eVar) {
        if (D(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            L(eVar, activity, new d(list, activity, callbackHandler, str));
        }
    }

    public final void H(List<d.a.i0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (F(list)) {
            J(activity, list, callbackHandler, str);
        } else {
            z(new e(list, activity, callbackHandler, str));
        }
    }

    public final void I(boolean z, List<d.a.i0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        if (z) {
            d.a.i0.a.e0.d.g("MultiAuthorize", "onCallback: real name success");
            J(activity, list, callbackHandler, str);
            return;
        }
        d.a.i0.a.e0.d.g("MultiAuthorize", "onCallback: real name fail");
        M(new f(activity, list, callbackHandler, str));
    }

    public final void J(@NonNull Activity activity, @NonNull List<d.a.i0.a.e2.c.f> list, @NonNull CallbackHandler callbackHandler, String str) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2).f41521b;
        }
        d.a.i0.a.e2.c.j.b d2 = d.a.i0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
        d2.p(new C0606h(this, callbackHandler, str));
        d2.a();
    }

    public final void K(List<d.a.i0.a.e2.c.f> list, @NonNull Activity activity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.i0.a.c1.a.T().d(new g(list, activity, callbackHandler, str));
    }

    public final void L(@NonNull d.a.i0.a.a2.e eVar, @NonNull Activity activity, j jVar) {
        v(eVar, activity, jVar);
    }

    public final void M(d.a.i0.a.v2.e1.b<String> bVar) {
        d.a.i0.a.c1.a.T().b(false, bVar);
    }

    public final void N(@NonNull Activity activity, d.a.i0.a.e2.c.f fVar, String str) {
        String O = d.a.i0.a.a2.d.g().r().O();
        boolean equals = TextUtils.equals(str, "1");
        if (!A(fVar.s)) {
            fVar.r = activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_end);
        } else if (equals) {
            fVar.r = activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_end);
        } else {
            fVar.r = activity.getString(d.a.i0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_end);
        }
    }

    public final void O(@NonNull Activity activity, d.a.i0.a.e2.c.f fVar, Boolean bool) {
        String O = d.a.i0.a.a2.d.g().r().O();
        boolean D = D(fVar.s);
        boolean A = A(fVar.s);
        if (!bool.booleanValue() && !D) {
            fVar.r = activity.getString(d.a.i0.a.h.swanapp_multi_auth_guest_login_name_head) + O + activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_end);
        } else if (A) {
            fVar.r = activity.getString(d.a.i0.a.h.swanapp_multi_auth_un_realname_name_head) + O + activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_end);
        } else {
            fVar.r = activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_head) + O + activity.getString(d.a.i0.a.h.swanapp_multi_auth_default_name_end);
        }
    }

    public final void P(d.a.i0.a.e2.c.f fVar, List<d.a.i0.a.e2.c.f> list, boolean z, @NonNull Activity activity, @NonNull d.a.i0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.i0.a.e2.c.d.t(activity, eVar, fVar, new JSONObject(), new c(callbackHandler, str, z, eVar, activity, list));
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
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

    public final void v(@NonNull d.a.i0.a.a2.e eVar, @NonNull Activity activity, @NonNull j jVar) {
        eVar.j().f(activity, null, new i(this, jVar));
    }

    public final List<d.a.i0.a.e2.c.f> w(Map<String, d.a.i0.a.e2.c.f> map, @NonNull JSONArray jSONArray, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.i0.a.e2.c.f fVar;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            String optString = jSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString) && map.containsKey(optString) && (fVar = map.get(optString)) != null) {
                if (!B(fVar)) {
                    d.a.i0.a.e2.c.d.n(10005, callbackHandler, str);
                    k.p(10005, fVar);
                    return null;
                } else if (fVar.f41523d) {
                    d.a.i0.a.e2.c.d.n(10005, callbackHandler, str);
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
        d.a.i0.a.e0.d.g("MultiAuthorize", "cb=" + str + ", gain=false , scopes=" + arrayList);
        if (arrayList.isEmpty()) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(202, "scopes invalid").toString());
            return null;
        }
        return arrayList;
    }

    @AnyThread
    public final void x(@NonNull Activity activity, @NonNull d.a.i0.a.a2.e eVar, @NonNull CallbackHandler callbackHandler, @NonNull JSONArray jSONArray, @NonNull String str) {
        d.a.i0.a.n1.q.a.g().z(new b(callbackHandler, str, jSONArray, eVar, activity));
    }

    public final d.a.i0.a.e2.c.f y(Map<String, d.a.i0.a.e2.c.f> map, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        d.a.i0.a.e2.c.f fVar = map.get("scope_multi_authorize");
        if (fVar == null) {
            d.a.i0.a.e2.c.d.n(10001, callbackHandler, str);
            k.p(10001, null);
            return null;
        } else if (fVar.f41523d) {
            d.a.i0.a.e2.c.d.n(10005, callbackHandler, str);
            k.p(10005, fVar);
            return null;
        } else {
            return fVar;
        }
    }

    public final void z(d.a.i0.a.v2.e1.b<String> bVar) {
        d.a.i0.a.c1.a.T().c(d.a.i0.a.c1.a.b(), bVar);
    }
}
