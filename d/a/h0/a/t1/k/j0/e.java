package d.a.h0.a.t1.k.j0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.f.d;
import d.a.h0.a.t.c.f.h;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44544e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44545f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44546g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44547h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44548i;
        public final /* synthetic */ boolean j;

        public a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, boolean z) {
            this.f44544e = context;
            this.f44545f = callbackHandler;
            this.f44546g = unitedSchemeEntity;
            this.f44547h = str;
            this.f44548i = i2;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.r(this.f44544e, this.f44545f, this.f44546g, this.f44547h, this.f44548i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44549e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44550f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44551g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44552h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44553i;
        public final /* synthetic */ Drawable j;
        public final /* synthetic */ boolean k;

        public b(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, Drawable drawable, boolean z) {
            this.f44549e = context;
            this.f44550f = callbackHandler;
            this.f44551g = unitedSchemeEntity;
            this.f44552h = str;
            this.f44553i = i2;
            this.j = drawable;
            this.k = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(this.f44549e, this.f44550f, this.f44551g, this.f44552h, this.f44553i, this.j, this.k);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44555f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44556g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44557h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44558i;
        public final /* synthetic */ boolean j;

        public c(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, boolean z) {
            this.f44554e = context;
            this.f44555f = callbackHandler;
            this.f44556g = unitedSchemeEntity;
            this.f44557h = str;
            this.f44558i = i2;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.q(this.f44554e, this.f44555f, this.f44556g, this.f44557h, this.f44558i, this.j);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f44559e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44560f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44561g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44562h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f44563i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public d(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, int i2, String str2, String str3) {
            this.f44559e = context;
            this.f44560f = callbackHandler;
            this.f44561g = unitedSchemeEntity;
            this.f44562h = str;
            this.f44563i = i2;
            this.j = str2;
            this.k = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.o(this.f44559e, this.f44560f, this.f44561g, this.f44562h, this.f44563i, this.j, this.k);
        }
    }

    /* renamed from: d.a.h0.a.t1.k.j0.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0811e implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44564a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44565b;

        public C0811e(e eVar, String str, CallbackHandler callbackHandler) {
            this.f44564a = str;
            this.f44565b = callbackHandler;
        }

        @Override // d.a.h0.a.q1.b.f.d.a
        public void a() {
            if (TextUtils.isEmpty(this.f44564a)) {
                return;
            }
            this.f44565b.handleSchemeDispatchCallback(this.f44564a, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/showToast");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        char c2;
        if (eVar != null && eVar.Z()) {
            if (a0.f44398b) {
                Log.d("ShowToastAction", "ShowToastAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && params.size() != 0) {
            String str = params.get("params");
            if (TextUtils.isEmpty(str)) {
                d.a.h0.a.c0.c.b("ShowToastAction", "the key params is null");
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
                    d.a.h0.a.c0.c.b("ShowToastAction", "message is null");
                    return false;
                }
                boolean optBoolean = jSONObject.optBoolean("mask");
                String optString3 = jSONObject.optString("image", "-1");
                Drawable E = h.E(context, optString3, eVar);
                if (a0.f44398b) {
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
                    if (a0.f44398b) {
                        e.printStackTrace();
                    }
                    d.a.h0.a.c0.c.b("ShowToastAction", "json exception");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            d.a.h0.a.c0.c.b("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity) {
        if (a0.f44398b) {
            Log.w("ShowToastAction", "the toast type is unknown");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }

    public final void o(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, @NonNull String str2, String str3) {
        d.a.h0.a.q1.b.f.d d2 = d.a.h0.a.q1.b.f.d.d(context);
        d2.p(str);
        d2.j(str2);
        d2.k(i2);
        d2.s(new C0811e(this, str3, callbackHandler));
        d2.t();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void p(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, Drawable drawable, boolean z) {
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(context, h.A(str, 14));
        f2.m(drawable);
        f2.k(i2);
        f2.q(z);
        f2.x();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void q(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(context, h.A(str, 14));
        f2.k(i2);
        f2.q(z);
        f2.v();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void r(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i2, boolean z) {
        d.a.h0.a.q1.b.f.d f2 = d.a.h0.a.q1.b.f.d.f(context, str);
        f2.k(i2);
        f2.q(z);
        f2.o(2);
        f2.C();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
