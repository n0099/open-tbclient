package d.a.l0.a.c2.f.j0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.u.e.g.h;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.f.e;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44775e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44776f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44777g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44778h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44779i;
        public final /* synthetic */ boolean j;

        public a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, boolean z) {
            this.f44775e = context;
            this.f44776f = callbackHandler;
            this.f44777g = unitedSchemeEntity;
            this.f44778h = str;
            this.f44779i = i2;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.r(this.f44775e, this.f44776f, this.f44777g, this.f44778h, this.f44779i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44781f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44782g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44783h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44784i;
        public final /* synthetic */ Drawable j;
        public final /* synthetic */ boolean k;

        public b(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, Drawable drawable, boolean z) {
            this.f44780e = context;
            this.f44781f = callbackHandler;
            this.f44782g = unitedSchemeEntity;
            this.f44783h = str;
            this.f44784i = i2;
            this.j = drawable;
            this.k = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(this.f44780e, this.f44781f, this.f44782g, this.f44783h, this.f44784i, this.j, this.k);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44786f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44787g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44788h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44789i;
        public final /* synthetic */ boolean j;

        public c(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, boolean z) {
            this.f44785e = context;
            this.f44786f = callbackHandler;
            this.f44787g = unitedSchemeEntity;
            this.f44788h = str;
            this.f44789i = i2;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.q(this.f44785e, this.f44786f, this.f44787g, this.f44788h, this.f44789i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44791f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44792g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44793h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44794i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public d(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, String str2, String str3) {
            this.f44790e = context;
            this.f44791f = callbackHandler;
            this.f44792g = unitedSchemeEntity;
            this.f44793h = str;
            this.f44794i = i2;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o(this.f44790e, this.f44791f, this.f44792g, this.f44793h, this.f44794i, this.j, this.k);
        }
    }

    /* renamed from: d.a.l0.a.c2.f.j0.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0641e implements e.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44795a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44796b;

        public C0641e(e eVar, String str, CallbackHandler callbackHandler) {
            this.f44795a = str;
            this.f44796b = callbackHandler;
        }

        @Override // d.a.l0.a.z1.b.f.e.c
        public void a() {
            if (TextUtils.isEmpty(this.f44795a)) {
                return;
            }
            this.f44796b.handleSchemeDispatchCallback(this.f44795a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/showToast");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        char c2;
        if (eVar != null && eVar.d0()) {
            if (a0.f44625b) {
                Log.d("ShowToastAction", "ShowToastAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0) {
            String str = params.get("params");
            if (TextUtils.isEmpty(str)) {
                d.a.l0.a.e0.d.b("ShowToastAction", "the key params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("type", "1");
                int z = h.z(jSONObject);
                String optString2 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    d.a.l0.a.e0.d.b("ShowToastAction", "message is null");
                    return false;
                }
                boolean optBoolean = jSONObject.optBoolean("mask");
                String optString3 = jSONObject.optString("image", "-1");
                if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(eVar).getPath())) {
                    optString3 = q0.w(eVar, optString3);
                }
                Drawable F = h.F(context, optString3, eVar);
                if (a0.f44625b) {
                    Log.e("ShowToastAction", "imagepath = " + optString3);
                }
                if (!TextUtils.equals(optString3, "-1") && F == null && TextUtils.equals(optString, "2")) {
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
                        q0.b0(new a(context, callbackHandler, unitedSchemeEntity, optString2, z, optBoolean));
                    } else if (c2 == 1) {
                        q0.b0(new b(context, callbackHandler, unitedSchemeEntity, optString2, z, F, optBoolean));
                    } else if (c2 == 2) {
                        q0.b0(new c(context, callbackHandler, unitedSchemeEntity, optString2, z, optBoolean));
                    } else if (c2 != 3) {
                        n(unitedSchemeEntity);
                        return false;
                    } else {
                        q0.b0(new d(context, callbackHandler, unitedSchemeEntity, optString2, z, optString5, optString4));
                    }
                    return true;
                } catch (JSONException e2) {
                    e = e2;
                    if (a0.f44625b) {
                        e.printStackTrace();
                    }
                    d.a.l0.a.e0.d.b("ShowToastAction", "json exception");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            d.a.l0.a.e0.d.b("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity) {
        if (a0.f44625b) {
            Log.w("ShowToastAction", "the toast type is unknown");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, @NonNull String str2, String str3) {
        d.a.l0.a.z1.b.f.e e2 = d.a.l0.a.z1.b.f.e.e(context);
        e2.q(str);
        e2.k(str2);
        e2.l(i2);
        e2.t(new C0641e(this, str3, callbackHandler));
        e2.v();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void p(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, Drawable drawable, boolean z) {
        d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(context, h.B(str, 14));
        g2.n(drawable);
        g2.l(i2);
        g2.r(z);
        g2.A();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void q(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(context, h.B(str, 14));
        g2.l(i2);
        g2.r(z);
        g2.y();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void r(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        d.a.l0.a.z1.b.f.e g2 = d.a.l0.a.z1.b.f.e.g(context, str);
        g2.l(i2);
        g2.r(z);
        g2.p(2);
        g2.F();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
