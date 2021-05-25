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
        public final /* synthetic */ CallbackHandler f41620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41621f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f41622g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41623h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONArray f41624i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.a.l0.a.a2.e eVar, JSONArray jSONArray) {
            this.f41620e = callbackHandler;
            this.f41621f = str;
            this.f41622g = context;
            this.f41623h = eVar;
            this.f41624i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                h.this.x((Activity) this.f41622g, this.f41623h, this.f41620e, this.f41624i, this.f41621f);
            } else {
                d.a.l0.a.e2.c.d.p(iVar, this.f41620e, this.f41621f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.n1.q.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41625a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41626b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f41627c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41628d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41629e;

        /* loaded from: classes3.dex */
        public class a implements d.a.l0.a.v2.e1.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.e2.c.f f41631e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f41632f;

            /* renamed from: d.a.l0.a.e2.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0615a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f41634e;

                public RunnableC0615a(Boolean bool) {
                    this.f41634e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.a.l0.a.e2.c.f fVar = aVar.f41631e;
                    List list = aVar.f41632f;
                    boolean booleanValue = this.f41634e.booleanValue();
                    b bVar = b.this;
                    hVar.P(fVar, list, booleanValue, bVar.f41629e, bVar.f41628d, bVar.f41625a, bVar.f41626b);
                }
            }

            public a(d.a.l0.a.e2.c.f fVar, List list) {
                this.f41631e = fVar;
                this.f41632f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f41629e, this.f41631e, bool);
                q0.X(new RunnableC0615a(bool));
            }
        }

        /* renamed from: d.a.l0.a.e2.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0616b implements d.a.l0.a.v2.e1.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.e2.c.f f41636e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f41637f;

            /* renamed from: d.a.l0.a.e2.b.h$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0616b c0616b = C0616b.this;
                    b bVar = b.this;
                    h.this.P(c0616b.f41636e, c0616b.f41637f, false, bVar.f41629e, bVar.f41628d, bVar.f41625a, bVar.f41626b);
                }
            }

            public C0616b(d.a.l0.a.e2.c.f fVar, List list) {
                this.f41636e = fVar;
                this.f41637f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f41629e, this.f41636e, str);
                q0.X(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.a.l0.a.a2.e eVar, Activity activity) {
            this.f41625a = callbackHandler;
            this.f41626b = str;
            this.f41627c = jSONArray;
            this.f41628d = eVar;
            this.f41629e = activity;
        }

        @Override // d.a.l0.a.n1.q.b.a
        public void a() {
            List<d.a.l0.a.e2.c.f> w;
            Map<String, d.a.l0.a.e2.c.f> g2 = d.a.l0.a.n1.q.c.a.g(true);
            d.a.l0.a.e2.c.f y = h.this.y(g2, this.f41625a, this.f41626b);
            if (y == null || (w = h.this.w(g2, this.f41627c, this.f41625a, this.f41626b)) == null) {
                return;
            }
            y.g(w);
            if (this.f41628d.j().e(this.f41629e)) {
                h.this.z(new C0616b(y, w));
            } else {
                d.a.l0.a.c1.a.T().a(this.f41629e, new a(y, w));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.e2.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f41641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f41642c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f41643d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f41645f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.a.l0.a.a2.e eVar, Activity activity, List list) {
            this.f41640a = callbackHandler;
            this.f41641b = str;
            this.f41642c = z;
            this.f41643d = eVar;
            this.f41644e = activity;
            this.f41645f = list;
        }

        @Override // d.a.l0.a.e2.c.a
        public void onResult(boolean z) {
            d.a.l0.a.e0.d.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.a.l0.a.e2.c.d.n(10003, this.f41640a, this.f41641b);
                return;
            }
            boolean z2 = this.f41642c;
            if (this.f41643d.j().e(this.f41644e)) {
                h.this.H(this.f41645f, this.f41644e, this.f41640a, this.f41641b);
            } else if (z2) {
                h.this.K(this.f41645f, this.f41644e, this.f41640a, this.f41641b);
            } else {
                h.this.G(this.f41645f, this.f41644e, this.f41640a, this.f41641b, this.f41643d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f41647a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f41648b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41649c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41650d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f41647a = list;
            this.f41648b = activity;
            this.f41649c = callbackHandler;
            this.f41650d = str;
        }

        @Override // d.a.l0.a.e2.b.h.j
        public void a(boolean z, int i2) {
            d.a.l0.a.e0.d.g("MultiAuthorize", "login result:" + i2);
            if (z) {
                h.this.H(this.f41647a, this.f41648b, this.f41649c, this.f41650d);
            } else {
                d.a.l0.a.e2.c.d.n(10004, this.f41649c, this.f41650d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f41652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f41653f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41654g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41655h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f41652e = list;
            this.f41653f = activity;
            this.f41654g = callbackHandler;
            this.f41655h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f41652e, this.f41653f, this.f41654g, this.f41655h);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.a.v2.e1.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f41657e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f41658f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41659g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41660h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f41657e = activity;
            this.f41658f = list;
            this.f41659g = callbackHandler;
            this.f41660h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f41657e, this.f41658f, this.f41659g, this.f41660h);
            } else {
                d.a.l0.a.e2.c.d.n(10003, this.f41659g, this.f41660h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.l0.a.v2.e1.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f41662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f41663f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41664g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41665h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f41662e = list;
            this.f41663f = activity;
            this.f41664g = callbackHandler;
            this.f41665h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f41662e, this.f41663f, this.f41664g, this.f41665h);
            } else {
                d.a.l0.a.e2.c.d.n(10003, this.f41664g, this.f41665h);
            }
        }
    }

    /* renamed from: d.a.l0.a.e2.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0617h implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41667e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f41668f;

        public C0617h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f41667e = callbackHandler;
            this.f41668f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            if (iVar == null) {
                d.a.l0.a.e2.c.d.n(10001, this.f41667e, this.f41668f);
                k.p(10001, null);
                return;
            }
            int b2 = iVar.b();
            d.a.l0.a.e0.d.l("MultiAuthorize", "requestAuthorize " + iVar.a() + ",  code=" + b2 + ", data=" + iVar.f41736a);
            if (b2 != 0) {
                d.a.l0.a.e2.c.d.n(b2, this.f41667e, this.f41668f);
            } else {
                this.f41667e.handleSchemeDispatchCallback(this.f41668f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f41669e;

        public i(h hVar, j jVar) {
            this.f41669e = jVar;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 != 0) {
                this.f41669e.a(false, i2);
            } else {
                this.f41669e.a(true, i2);
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
        return TextUtils.equals(fVar.f41695b, "mapp_location") || TextUtils.equals(fVar.f41695b, "mapp_images") || TextUtils.equals(fVar.f41695b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f41695b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(fVar.f41695b, "ppcert") || TextUtils.equals(fVar.f41695b, "mapp_i_face_verify") || TextUtils.equals(fVar.f41695b, "snsapi_userinfo") || TextUtils.equals(fVar.f41695b, "mapp_choose_address") || TextUtils.equals(fVar.f41695b, "mobile") || TextUtils.equals(fVar.f41695b, "mapp_choose_invoice");
    }

    public final boolean C(d.a.l0.a.e2.c.f fVar) {
        return TextUtils.equals(fVar.f41695b, "ppcert") || TextUtils.equals(fVar.f41695b, "mapp_i_face_verify");
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
        return TextUtils.equals(fVar.f41695b, "mapp_location") || TextUtils.equals(fVar.f41695b, "mapp_images") || TextUtils.equals(fVar.f41695b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(fVar.f41695b, PermissionProxy.SCOPE_ID_CAMERA);
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
            strArr[i2] = list.get(i2).f41695b;
        }
        d.a.l0.a.e2.c.j.b d2 = d.a.l0.a.a2.d.g().y().a().b().d(activity, false, true, strArr, null, true);
        d2.p(new C0617h(this, callbackHandler, str));
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
                } else if (fVar.f41697d) {
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
        } else if (fVar.f41697d) {
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
