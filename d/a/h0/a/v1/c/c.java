package d.a.h0.a.v1.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.i;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.v1.c.i.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44900a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, d> f44901b = new HashMap();

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44902e;

        public a(String str) {
            this.f44902e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context e2 = c.e();
            Toast.makeText(e2, "aiapps-oauth :: " + this.f44902e, 0).show();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f44903e;

        public b(e eVar) {
            this.f44903e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                c.j("onNegBtn", Boolean.FALSE);
                d.a.h0.a.z1.h.p(PrefetchEvent.STATE_CLICK, this.f44903e.f44911b, false);
                c.d(this.f44903e.f44911b, false);
            } else if (i2 == -1) {
                c.j("onPosBtn", Boolean.FALSE);
                d.a.h0.a.z1.h.p(PrefetchEvent.STATE_CLICK, this.f44903e.f44911b, true);
                c.d(this.f44903e.f44911b, true);
            }
            d.a.h0.g.c0.d.a("na_authorize_end");
        }
    }

    /* renamed from: d.a.h0.a.v1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnCancelListenerC0834c implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f44904e;

        public DialogInterface$OnCancelListenerC0834c(e eVar) {
            this.f44904e = eVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            c.j("onCancel", Boolean.FALSE);
            d.a.h0.a.z1.h.p(PrefetchEvent.STATE_CLICK, this.f44904e.f44911b, false);
            c.d(this.f44904e.f44911b, false);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Set<d.a.h0.a.v1.c.a> f44905a = new HashSet();

        public d(String str) {
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
            if (f44900a) {
                j("query :: " + key + " = " + value, Boolean.FALSE);
            }
            builder.add(key, value);
        }
        return builder.build();
    }

    public static JSONObject c(JSONObject jSONObject) {
        String F = d.a.h0.a.w0.a.l().F();
        return (jSONObject == null || TextUtils.isEmpty(F)) ? jSONObject : jSONObject.optJSONObject(F);
    }

    public static void d(String str, boolean z) {
        d remove;
        synchronized (f44901b) {
            remove = f44901b.remove(str);
        }
        if (remove == null || remove.f44905a.isEmpty()) {
            return;
        }
        for (d.a.h0.a.v1.c.a aVar : remove.f44905a) {
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
        if (f44900a) {
            Log.w("OAuthUtils", i2 + " " + str);
        }
        return str;
    }

    public static String g() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = e().getPackageManager().getPackageInfo(e().getPackageName(), 64);
            return (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) ? "" : d.a.h0.p.e.d(signatureArr[0].toByteArray(), false);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean h(h<b.e> hVar) {
        return hVar != null && hVar.c() && hVar.f44952a.f44967b;
    }

    public static boolean i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
    }

    public static void j(String str, Boolean bool) {
        d.a.h0.a.c0.c.h("aiapps-oauth", str);
        if (f44900a && bool.booleanValue()) {
            new Handler(Looper.getMainLooper()).post(new a(str));
        }
    }

    @Deprecated
    public static void k(Runnable runnable) {
        k0.T(runnable);
    }

    public static void l(d.a.h0.a.v1.d.a aVar, CallbackHandler callbackHandler, String str) {
        d.a.h0.a.f2.a aVar2;
        if (aVar == null || (aVar2 = aVar.j) == null) {
            return;
        }
        int i2 = -1;
        try {
            i2 = (int) aVar2.a();
        } catch (ClassCastException e2) {
            if (f44900a) {
                Log.e("OAuthUtils", e2.toString());
            }
        }
        if (i2 < 0) {
            return;
        }
        m(i2, callbackHandler, str);
    }

    public static void m(int i2, CallbackHandler callbackHandler, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String f2 = f(i2);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i2, f2).toString());
        d.a.h0.a.c0.c.l("OAuthUtils", "authorize failed : " + f2);
    }

    public static void n(h<b.e> hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        if (hVar != null && hVar.a() != null) {
            int b2 = hVar.b();
            String f2 = f(b2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f2));
            d.a.h0.a.c0.c.l("OAuthUtils", "authorize failed : " + f2);
            return;
        }
        d.a.h0.a.c0.c.b("OAuthUtils", "authorize failed : result is invalid");
    }

    public static void o(h<b.e> hVar, CallbackHandler callbackHandler, String str) {
        if (hVar != null && hVar.a() != null) {
            m(hVar.b(), callbackHandler, str);
        } else {
            d.a.h0.a.c0.c.b("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void p() {
        f44901b.clear();
    }

    public static void q(Context context, d.a.h0.a.r1.e eVar, e eVar2, JSONObject jSONObject, d.a.h0.a.v1.c.a aVar) {
        if (eVar2 != null && !TextUtils.isEmpty(eVar2.f44911b)) {
            synchronized (f44901b) {
                d dVar = f44901b.get(eVar2.f44911b);
                if (dVar != null) {
                    dVar.f44905a.add(aVar);
                    return;
                }
                d dVar2 = new d(eVar2.f44911b);
                dVar2.f44905a.add(aVar);
                f44901b.put(eVar2.f44911b, dVar2);
                b bVar = new b(eVar2);
                DialogInterface$OnCancelListenerC0834c dialogInterface$OnCancelListenerC0834c = new DialogInterface$OnCancelListenerC0834c(eVar2);
                d.a.h0.a.z1.h.p("show", eVar2.f44911b, false);
                d.a.h0.g.c0.d.a("na_authorize_start");
                r(context, eVar, eVar2, jSONObject, bVar, dialogInterface$OnCancelListenerC0834c);
                return;
            }
        }
        aVar.onResult(false);
    }

    public static void r(Context context, d.a.h0.a.r1.e eVar, e eVar2, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        g.a a2 = d.a.h0.a.w0.a.P().a(context, eVar, eVar2, jSONObject, onClickListener);
        if (a2 == null) {
            if (f44900a) {
                throw new RuntimeException("auth dialog builder is null");
            }
            return;
        }
        d.a.h0.a.q1.b.b.g c2 = a2.c();
        c2.a(false);
        c2.setOnCancelListener(onCancelListener);
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(h0.r(context), -2);
            window.setWindowAnimations(i.action_sheet_animation);
        }
        SwanAppActivity v = eVar == null ? null : eVar.v();
        if (v == null || v.isFinishing()) {
            return;
        }
        c2.show();
    }
}
