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
/* loaded from: classes2.dex */
public class h extends a0 {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46701g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46702h;
        public final /* synthetic */ JSONArray i;

        public a(CallbackHandler callbackHandler, String str, Context context, d.b.g0.a.r1.e eVar, JSONArray jSONArray) {
            this.f46699e = callbackHandler;
            this.f46700f = str;
            this.f46701g = context;
            this.f46702h = eVar;
            this.i = jSONArray;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                h.this.x((Activity) this.f46701g, this.f46702h, this.f46699e, this.i, this.f46700f);
            } else {
                d.b.g0.a.v1.c.c.o(hVar, this.f46699e, this.f46700f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.g1.o.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46703a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46704b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f46705c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46706d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46707e;

        /* loaded from: classes2.dex */
        public class a implements d.b.g0.a.i2.u0.b<Boolean> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.v1.c.e f46709e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f46710f;

            /* renamed from: d.b.g0.a.v1.b.h$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class RunnableC0859a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Boolean f46712e;

                public RunnableC0859a(Boolean bool) {
                    this.f46712e = bool;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    h hVar = h.this;
                    d.b.g0.a.v1.c.e eVar = aVar.f46709e;
                    List list = aVar.f46710f;
                    boolean booleanValue = this.f46712e.booleanValue();
                    b bVar = b.this;
                    hVar.P(eVar, list, booleanValue, bVar.f46707e, bVar.f46706d, bVar.f46703a, bVar.f46704b);
                }
            }

            public a(d.b.g0.a.v1.c.e eVar, List list) {
                this.f46709e = eVar;
                this.f46710f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(Boolean bool) {
                b bVar = b.this;
                h.this.O(bVar.f46707e, this.f46709e, bool);
                k0.T(new RunnableC0859a(bool));
            }
        }

        /* renamed from: d.b.g0.a.v1.b.h$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0860b implements d.b.g0.a.i2.u0.b<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.v1.c.e f46714e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f46715f;

            /* renamed from: d.b.g0.a.v1.b.h$b$b$a */
            /* loaded from: classes2.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C0860b c0860b = C0860b.this;
                    b bVar = b.this;
                    h.this.P(c0860b.f46714e, c0860b.f46715f, false, bVar.f46707e, bVar.f46706d, bVar.f46703a, bVar.f46704b);
                }
            }

            public C0860b(d.b.g0.a.v1.c.e eVar, List list) {
                this.f46714e = eVar;
                this.f46715f = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(String str) {
                b bVar = b.this;
                h.this.N(bVar.f46707e, this.f46714e, str);
                k0.T(new a());
            }
        }

        public b(CallbackHandler callbackHandler, String str, JSONArray jSONArray, d.b.g0.a.r1.e eVar, Activity activity) {
            this.f46703a = callbackHandler;
            this.f46704b = str;
            this.f46705c = jSONArray;
            this.f46706d = eVar;
            this.f46707e = activity;
        }

        @Override // d.b.g0.a.g1.o.b.a
        public void a() {
            List<d.b.g0.a.v1.c.e> w;
            Map<String, d.b.g0.a.v1.c.e> g2 = d.b.g0.a.g1.o.c.a.g(true);
            d.b.g0.a.v1.c.e y = h.this.y(g2, this.f46703a, this.f46704b);
            if (y == null || (w = h.this.w(g2, this.f46705c, this.f46703a, this.f46704b)) == null) {
                return;
            }
            y.g(w);
            if (this.f46706d.z().e(this.f46707e)) {
                h.this.z(new C0860b(y, w));
            } else {
                d.b.g0.a.w0.a.I().a(this.f46707e, new a(y, w));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.v1.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46718a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46719b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f46720c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46721d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46722e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f46723f;

        public c(CallbackHandler callbackHandler, String str, boolean z, d.b.g0.a.r1.e eVar, Activity activity, List list) {
            this.f46718a = callbackHandler;
            this.f46719b = str;
            this.f46720c = z;
            this.f46721d = eVar;
            this.f46722e = activity;
            this.f46723f = list;
        }

        @Override // d.b.g0.a.v1.c.a
        public void onResult(boolean z) {
            d.b.g0.a.c0.c.g("MultiAuthorize", "showAuthDialog " + z);
            if (!z) {
                d.b.g0.a.v1.c.c.m(10003, this.f46718a, this.f46719b);
                return;
            }
            boolean z2 = this.f46720c;
            if (this.f46721d.z().e(this.f46722e)) {
                h.this.H(this.f46723f, this.f46722e, this.f46718a, this.f46719b);
            } else if (z2) {
                h.this.K(this.f46723f, this.f46722e, this.f46718a, this.f46719b);
            } else {
                h.this.G(this.f46723f, this.f46722e, this.f46718a, this.f46719b, this.f46721d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f46725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f46726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46727c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46728d;

        public d(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f46725a = list;
            this.f46726b = activity;
            this.f46727c = callbackHandler;
            this.f46728d = str;
        }

        @Override // d.b.g0.a.v1.b.h.j
        public void a(boolean z, int i) {
            d.b.g0.a.c0.c.g("MultiAuthorize", "login result:" + i);
            if (z) {
                h.this.H(this.f46725a, this.f46726b, this.f46727c, this.f46728d);
            } else {
                d.b.g0.a.v1.c.c.m(10004, this.f46727c, this.f46728d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46730e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f46731f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46732g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46733h;

        public e(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f46730e = list;
            this.f46731f = activity;
            this.f46732g = callbackHandler;
            this.f46733h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            h.this.I(TextUtils.equals(str, "1"), this.f46730e, this.f46731f, this.f46732g, this.f46733h);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.g0.a.i2.u0.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46734e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f46735f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46736g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46737h;

        public f(Activity activity, List list, CallbackHandler callbackHandler, String str) {
            this.f46734e = activity;
            this.f46735f = list;
            this.f46736g = callbackHandler;
            this.f46737h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(String str) {
            if (!TextUtils.isEmpty(str)) {
                h.this.J(this.f46734e, this.f46735f, this.f46736g, this.f46737h);
            } else {
                d.b.g0.a.v1.c.c.m(10003, this.f46736g, this.f46737h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.b.g0.a.i2.u0.b<Integer> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f46739f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46740g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46741h;

        public g(List list, Activity activity, CallbackHandler callbackHandler, String str) {
            this.f46738e = list;
            this.f46739f = activity;
            this.f46740g = callbackHandler;
            this.f46741h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            if (num.intValue() == 0) {
                h.this.H(this.f46738e, this.f46739f, this.f46740g, this.f46741h);
            } else {
                d.b.g0.a.v1.c.c.m(10003, this.f46740g, this.f46741h);
            }
        }
    }

    /* renamed from: d.b.g0.a.v1.b.h$h  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0861h implements d.b.g0.a.i2.u0.b<d.b.g0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46743f;

        public C0861h(h hVar, CallbackHandler callbackHandler, String str) {
            this.f46742e = callbackHandler;
            this.f46743f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.v1.c.h<b.e> hVar) {
            if (hVar == null) {
                d.b.g0.a.v1.c.c.m(10001, this.f46742e, this.f46743f);
                d.b.g0.a.z1.h.q(10001, null);
                return;
            }
            int b2 = hVar.b();
            d.b.g0.a.c0.c.l("MultiAuthorize", "requestAuthorize " + hVar.a() + ",  code=" + b2 + ", data=" + hVar.f46808a);
            if (b2 != 0) {
                d.b.g0.a.v1.c.c.m(b2, this.f46742e, this.f46743f);
            } else {
                this.f46742e.handleSchemeDispatchCallback(this.f46743f, UnitedSchemeUtility.wrapCallbackParams(0, "success").toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.b.g0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f46744e;

        public i(h hVar, j jVar) {
            this.f46744e = jVar;
        }

        @Override // d.b.g0.a.m.a
        public void onResult(int i) {
            if (i != 0) {
                this.f46744e.a(false, i);
            } else {
                this.f46744e.a(true, i);
            }
        }
    }

    /* loaded from: classes2.dex */
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
        return TextUtils.equals(eVar.f46769b, "mapp_location") || TextUtils.equals(eVar.f46769b, "mapp_images") || TextUtils.equals(eVar.f46769b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f46769b, PermissionProxy.SCOPE_ID_CAMERA) || TextUtils.equals(eVar.f46769b, "ppcert") || TextUtils.equals(eVar.f46769b, "mapp_i_face_verify") || TextUtils.equals(eVar.f46769b, "snsapi_userinfo") || TextUtils.equals(eVar.f46769b, "mapp_choose_address") || TextUtils.equals(eVar.f46769b, "mobile") || TextUtils.equals(eVar.f46769b, "mapp_choose_invoice");
    }

    public final boolean C(d.b.g0.a.v1.c.e eVar) {
        return TextUtils.equals(eVar.f46769b, "ppcert") || TextUtils.equals(eVar.f46769b, "mapp_i_face_verify");
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
        return TextUtils.equals(eVar.f46769b, "mapp_location") || TextUtils.equals(eVar.f46769b, "mapp_images") || TextUtils.equals(eVar.f46769b, PermissionProxy.SCOPE_ID_RECORD) || TextUtils.equals(eVar.f46769b, PermissionProxy.SCOPE_ID_CAMERA);
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
            strArr[i2] = list.get(i2).f46769b;
        }
        d.b.g0.a.v1.c.i.b e2 = d.b.g0.a.r1.d.e().o().a().a().e(activity, false, true, strArr, null, true);
        e2.p(new C0861h(this, callbackHandler, str));
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
                } else if (eVar.f46771d) {
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
        } else if (eVar.f46771d) {
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
