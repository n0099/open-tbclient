package d.b.g0.a.t1.k.j0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.f.d;
import d.b.g0.a.t.c.f.h;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46819e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46820f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46821g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46822h;
        public final /* synthetic */ int i;
        public final /* synthetic */ boolean j;

        public a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, boolean z) {
            this.f46819e = context;
            this.f46820f = callbackHandler;
            this.f46821g = unitedSchemeEntity;
            this.f46822h = str;
            this.i = i;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.r(this.f46819e, this.f46820f, this.f46821g, this.f46822h, this.i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46823e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46824f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46825g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46826h;
        public final /* synthetic */ int i;
        public final /* synthetic */ Drawable j;
        public final /* synthetic */ boolean k;

        public b(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, Drawable drawable, boolean z) {
            this.f46823e = context;
            this.f46824f = callbackHandler;
            this.f46825g = unitedSchemeEntity;
            this.f46826h = str;
            this.i = i;
            this.j = drawable;
            this.k = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(this.f46823e, this.f46824f, this.f46825g, this.f46826h, this.i, this.j, this.k);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46827e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46828f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46829g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46830h;
        public final /* synthetic */ int i;
        public final /* synthetic */ boolean j;

        public c(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, boolean z) {
            this.f46827e = context;
            this.f46828f = callbackHandler;
            this.f46829g = unitedSchemeEntity;
            this.f46830h = str;
            this.i = i;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.q(this.f46827e, this.f46828f, this.f46829g, this.f46830h, this.i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46833g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46834h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public d(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, String str2, String str3) {
            this.f46831e = context;
            this.f46832f = callbackHandler;
            this.f46833g = unitedSchemeEntity;
            this.f46834h = str;
            this.i = i;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o(this.f46831e, this.f46832f, this.f46833g, this.f46834h, this.i, this.j, this.k);
        }
    }

    /* renamed from: d.b.g0.a.t1.k.j0.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0852e implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46836b;

        public C0852e(e eVar, String str, CallbackHandler callbackHandler) {
            this.f46835a = str;
            this.f46836b = callbackHandler;
        }

        @Override // d.b.g0.a.q1.b.f.d.a
        public void a() {
            if (TextUtils.isEmpty(this.f46835a)) {
                return;
            }
            this.f46836b.handleSchemeDispatchCallback(this.f46835a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/showToast");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        char c2;
        if (eVar != null && eVar.Z()) {
            if (a0.f46680b) {
                Log.d("ShowToastAction", "ShowToastAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0) {
            String str = params.get("params");
            if (TextUtils.isEmpty(str)) {
                d.b.g0.a.c0.c.b("ShowToastAction", "the key params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("type", "1");
                int y = h.y(jSONObject);
                String optString2 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    d.b.g0.a.c0.c.b("ShowToastAction", "message is null");
                    return false;
                }
                boolean optBoolean = jSONObject.optBoolean("mask");
                String optString3 = jSONObject.optString("image", "-1");
                Drawable E = h.E(context, optString3, eVar);
                if (a0.f46680b) {
                    Log.e("ShowToastAction", "imagepath = " + optString3);
                }
                if (!TextUtils.equals(optString3, "-1") && E == null && TextUtils.equals(optString, "2")) {
                    optString = "1";
                }
                String optString4 = jSONObject.optString("cb");
                String optString5 = jSONObject.optString("buttonText");
                switch (optString.hashCode()) {
                    case 49:
                        if (optString.equals("1")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 50:
                        if (optString.equals("2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51:
                        if (optString.equals("3")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 52:
                        if (optString.equals("4")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                try {
                    if (c2 == 0) {
                        k0.X(new a(context, callbackHandler, unitedSchemeEntity, optString2, y, optBoolean));
                    } else if (c2 == 1) {
                        k0.X(new b(context, callbackHandler, unitedSchemeEntity, optString2, y, E, optBoolean));
                    } else if (c2 == 2) {
                        k0.X(new c(context, callbackHandler, unitedSchemeEntity, optString2, y, optBoolean));
                    } else if (c2 != 3) {
                        n(unitedSchemeEntity);
                        return false;
                    } else {
                        k0.X(new d(context, callbackHandler, unitedSchemeEntity, optString2, y, optString5, optString4));
                    }
                    return true;
                } catch (JSONException e2) {
                    e = e2;
                    if (a0.f46680b) {
                        e.printStackTrace();
                    }
                    d.b.g0.a.c0.c.b("ShowToastAction", "json exception");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            d.b.g0.a.c0.c.b("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity) {
        if (a0.f46680b) {
            Log.w("ShowToastAction", "the toast type is unknown");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, @NonNull String str2, String str3) {
        d.b.g0.a.q1.b.f.d d2 = d.b.g0.a.q1.b.f.d.d(context);
        d2.p(str);
        d2.j(str2);
        d2.k(i);
        d2.s(new C0852e(this, str3, callbackHandler));
        d2.t();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void p(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, Drawable drawable, boolean z) {
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(context, h.A(str, 14));
        f2.m(drawable);
        f2.k(i);
        f2.q(z);
        f2.x();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void q(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(context, h.A(str, 14));
        f2.k(i);
        f2.q(z);
        f2.v();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void r(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        d.b.g0.a.q1.b.f.d f2 = d.b.g0.a.q1.b.f.d.f(context, str);
        f2.k(i);
        f2.q(z);
        f2.o(2);
        f2.C();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
