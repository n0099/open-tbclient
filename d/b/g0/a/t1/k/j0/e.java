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
        public final /* synthetic */ Context f46426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46427f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46428g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46429h;
        public final /* synthetic */ int i;
        public final /* synthetic */ boolean j;

        public a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, boolean z) {
            this.f46426e = context;
            this.f46427f = callbackHandler;
            this.f46428g = unitedSchemeEntity;
            this.f46429h = str;
            this.i = i;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.r(this.f46426e, this.f46427f, this.f46428g, this.f46429h, this.i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46431f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46432g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46433h;
        public final /* synthetic */ int i;
        public final /* synthetic */ Drawable j;
        public final /* synthetic */ boolean k;

        public b(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, Drawable drawable, boolean z) {
            this.f46430e = context;
            this.f46431f = callbackHandler;
            this.f46432g = unitedSchemeEntity;
            this.f46433h = str;
            this.i = i;
            this.j = drawable;
            this.k = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(this.f46430e, this.f46431f, this.f46432g, this.f46433h, this.i, this.j, this.k);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46434e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46435f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46436g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46437h;
        public final /* synthetic */ int i;
        public final /* synthetic */ boolean j;

        public c(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, boolean z) {
            this.f46434e = context;
            this.f46435f = callbackHandler;
            this.f46436g = unitedSchemeEntity;
            this.f46437h = str;
            this.i = i;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.q(this.f46434e, this.f46435f, this.f46436g, this.f46437h, this.i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f46438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46440g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46441h;
        public final /* synthetic */ int i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public d(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i, String str2, String str3) {
            this.f46438e = context;
            this.f46439f = callbackHandler;
            this.f46440g = unitedSchemeEntity;
            this.f46441h = str;
            this.i = i;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o(this.f46438e, this.f46439f, this.f46440g, this.f46441h, this.i, this.j, this.k);
        }
    }

    /* renamed from: d.b.g0.a.t1.k.j0.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0839e implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46442a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46443b;

        public C0839e(e eVar, String str, CallbackHandler callbackHandler) {
            this.f46442a = str;
            this.f46443b = callbackHandler;
        }

        @Override // d.b.g0.a.q1.b.f.d.a
        public void a() {
            if (TextUtils.isEmpty(this.f46442a)) {
                return;
            }
            this.f46443b.handleSchemeDispatchCallback(this.f46442a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/showToast");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        char c2;
        if (eVar != null && eVar.Z()) {
            if (a0.f46287b) {
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
                if (a0.f46287b) {
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
                    if (a0.f46287b) {
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
        if (a0.f46287b) {
            Log.w("ShowToastAction", "the toast type is unknown");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, @NonNull String str2, String str3) {
        d.b.g0.a.q1.b.f.d d2 = d.b.g0.a.q1.b.f.d.d(context);
        d2.p(str);
        d2.j(str2);
        d2.k(i);
        d2.s(new C0839e(this, str3, callbackHandler));
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
