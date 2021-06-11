package d.a.l0.a.e2.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.StringHelper;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.j2.c;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45360a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, C0675d> f45361b = new HashMap();

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45362e;

        public a(String str) {
            this.f45362e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context e2 = d.e();
            Toast.makeText(e2, "aiapps-oauth :: " + this.f45362e, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45363e;

        public b(f fVar) {
            this.f45363e = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                d.j("onNegBtn", Boolean.FALSE);
                d.a.l0.a.j2.k.o(PrefetchEvent.STATE_CLICK, this.f45363e.f45371b, false);
                d.d(this.f45363e.f45371b, false);
            } else if (i2 == -1) {
                d.j("onPosBtn", Boolean.FALSE);
                d.a.l0.a.j2.k.o(PrefetchEvent.STATE_CLICK, this.f45363e.f45371b, true);
                d.d(this.f45363e.f45371b, true);
            }
            d.a.l0.a.c1.b.n().a("na_authorize_end");
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45364e;

        public c(f fVar) {
            this.f45364e = fVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            d.j("onCancel", Boolean.FALSE);
            d.a.l0.a.j2.k.o(PrefetchEvent.STATE_CLICK, this.f45364e.f45371b, false);
            d.d(this.f45364e.f45371b, false);
        }
    }

    /* renamed from: d.a.l0.a.e2.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0675d {

        /* renamed from: a  reason: collision with root package name */
        public final Set<d.a.l0.a.e2.c.a> f45365a = new HashSet();

        public C0675d(String str) {
        }
    }

    public static RequestBody b(Map<String, String> map) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (TextUtils.isEmpty(key)) {
                key = "";
            }
            if (TextUtils.isEmpty(value)) {
                value = "";
            }
            if (f45360a) {
                j("query :: " + key + " = " + value, Boolean.FALSE);
            }
            builder.add(key, value);
        }
        return builder.build();
    }

    public static JSONObject c(JSONObject jSONObject) {
        String A = d.a.l0.a.c1.a.n().A();
        return (jSONObject == null || TextUtils.isEmpty(A)) ? jSONObject : jSONObject.optJSONObject(A);
    }

    public static void d(String str, boolean z) {
        C0675d remove;
        synchronized (f45361b) {
            remove = f45361b.remove(str);
        }
        if (remove == null || remove.f45365a.isEmpty()) {
            return;
        }
        for (d.a.l0.a.e2.c.a aVar : remove.f45365a) {
            if (aVar != null) {
                aVar.onResult(z);
            }
        }
    }

    public static Context e() {
        return AppRuntime.getAppContext();
    }

    public static String f(int i2) {
        String str;
        switch (i2) {
            case 10001:
                str = "internal error";
                break;
            case 10002:
                str = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
                break;
            case 10003:
                str = "user deny";
                break;
            case 10004:
                str = "user not logged in";
                break;
            case 10005:
                str = "system deny";
                break;
            case 10006:
                str = "no data";
                break;
            default:
                str = "Permission denied";
                break;
        }
        if (f45360a) {
            Log.w("OAuthUtils", i2 + " " + str);
        }
        return str;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String g() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = e().getPackageManager().getPackageInfo(e().getPackageName(), 64);
            return (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? "" : d.a.l0.t.f.d(signatureArr[0].toByteArray(), false);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean h(i<b.e> iVar) {
        return iVar != null && iVar.c() && iVar.f45412a.f45427b;
    }

    public static boolean i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
    }

    public static void j(String str, Boolean bool) {
        d.a.l0.a.e0.d.h("aiapps-oauth", str);
        if (f45360a && bool.booleanValue()) {
            q0.X(new a(str));
        }
    }

    @Deprecated
    public static void k(Runnable runnable) {
        q0.X(runnable);
    }

    public static synchronized void l(@NonNull JSONObject jSONObject) {
        synchronized (d.class) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && optJSONObject.has("code")) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("code", 1);
                    jSONObject.put("data", jSONObject2);
                } catch (JSONException e2) {
                    if (f45360a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void m(d.a.l0.a.e2.d.a aVar, CallbackHandler callbackHandler, String str) {
        d.a.l0.a.q2.a aVar2;
        if (aVar == null || (aVar2 = aVar.j) == null) {
            return;
        }
        int i2 = -1;
        try {
            i2 = (int) aVar2.a();
        } catch (ClassCastException e2) {
            if (f45360a) {
                Log.e("OAuthUtils", e2.toString());
            }
        }
        if (i2 < 0) {
            return;
        }
        n(i2, callbackHandler, str);
    }

    public static void n(int i2, CallbackHandler callbackHandler, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String f2 = f(i2);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, f2).toString());
        d.a.l0.a.e0.d.l("OAuthUtils", "authorize failed : " + f2);
    }

    public static void o(i<b.e> iVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        if (iVar != null && iVar.a() != null) {
            int b2 = iVar.b();
            String f2 = f(b2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f2));
            d.a.l0.a.e0.d.l("OAuthUtils", "authorize failed : " + f2);
            return;
        }
        d.a.l0.a.e0.d.b("OAuthUtils", "authorize failed : result is invalid");
    }

    public static void p(i<b.e> iVar, CallbackHandler callbackHandler, String str) {
        if (iVar != null && iVar.a() != null) {
            n(iVar.b(), callbackHandler, str);
        } else {
            d.a.l0.a.e0.d.b("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void q() {
        f45361b.clear();
    }

    public static void r(int i2, @NonNull String str, @NonNull String str2) {
        String str3;
        try {
            String V = d.a.l0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                V = "NotSwanAppProcess";
            }
            String str4 = str + "===";
            if (str2.length() > 1024) {
                str3 = (str4 + str2.substring(0, 1024)) + StringHelper.STRING_MORE;
            } else {
                str3 = str4 + str2;
            }
            c.b bVar = new c.b(i2);
            bVar.h(V);
            bVar.i(str3);
            bVar.m();
            d.a.l0.a.e0.d.h("OAuthUtils", "error reported: " + i2 + " ,content: " + str3);
        } catch (Exception e2) {
            if (f45360a) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void s(@NonNull String str, @NonNull String str2) {
        synchronized (d.class) {
            r(10004, str, str2);
        }
    }

    public static void t(Context context, d.a.l0.a.a2.e eVar, f fVar, JSONObject jSONObject, d.a.l0.a.e2.c.a aVar) {
        if (fVar != null && !TextUtils.isEmpty(fVar.f45371b)) {
            synchronized (f45361b) {
                C0675d c0675d = f45361b.get(fVar.f45371b);
                if (c0675d != null) {
                    c0675d.f45365a.add(aVar);
                    return;
                }
                C0675d c0675d2 = new C0675d(fVar.f45371b);
                c0675d2.f45365a.add(aVar);
                f45361b.put(fVar.f45371b, c0675d2);
                b bVar = new b(fVar);
                c cVar = new c(fVar);
                d.a.l0.a.j2.k.o("show", fVar.f45371b, false);
                d.a.l0.a.c1.b.n().a("na_authorize_start");
                u(context, eVar, fVar, jSONObject, bVar, cVar);
                return;
            }
        }
        aVar.onResult(false);
    }

    public static void u(Context context, d.a.l0.a.a2.e eVar, f fVar, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        h.a a2 = d.a.l0.a.c1.a.b0().a(context, eVar, fVar, jSONObject, onClickListener);
        if (a2 == null) {
            if (f45360a) {
                throw new RuntimeException("auth dialog builder is null");
            }
            return;
        }
        d.a.l0.a.z1.b.b.h c2 = a2.c();
        c2.a(false);
        c2.setOnCancelListener(onCancelListener);
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setWindowAnimations(d.a.l0.a.i.action_sheet_animation);
        }
        SwanAppActivity x = eVar == null ? null : eVar.x();
        if (x == null || x.isFinishing()) {
            return;
        }
        c2.show();
    }
}
