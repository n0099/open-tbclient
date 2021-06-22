package d.a.m0.a.d1.b;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import d.a.m0.a.l0.c;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.d1.a f45095a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.d1.a f45096b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppUtilsJavaScriptInterface f45097c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.u.a f45098d;

    public void a(Activity activity) {
        d.a.m0.a.d1.a aVar = this.f45095a;
        if (aVar != null) {
            aVar.setActivityRef(activity);
        }
        d.a.m0.a.d1.a aVar2 = this.f45096b;
        if (aVar2 != null) {
            aVar2.setActivityRef(activity);
        }
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.f45097c;
        if (swanAppUtilsJavaScriptInterface != null) {
            swanAppUtilsJavaScriptInterface.setActivity(activity);
        }
        d.a.m0.a.u.a aVar3 = this.f45098d;
        if (aVar3 != null) {
            aVar3.i(activity);
        }
    }

    public final void b(d.a.m0.a.h0.f.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull d.a.m0.a.u.a aVar2) {
        SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
        this.f45095a = swanAppGlobalJsBridge;
        aVar.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
        this.f45096b = swanAppJsBridge;
        aVar.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.b(aVar);
    }

    public final void c(@NonNull d.a.m0.a.h0.f.a aVar, Context context, @NonNull d.a.m0.a.u.a aVar2) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.f45097c = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        aVar.addJavascriptInterface(this.f45097c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    public final void d(d.a.m0.a.h0.f.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public void e(d.a.m0.a.h0.f.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        d.a.m0.a.u.a aVar2 = new d.a.m0.a.u.a(context, callbackHandler, aVar);
        this.f45098d = aVar2;
        b(aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2);
        if (aVar instanceof c) {
            c(aVar, context, this.f45098d);
        } else {
            d(aVar);
        }
    }

    public void f(Context context, d.a.m0.a.h0.f.a aVar) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.f45097c = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        aVar.addJavascriptInterface(this.f45097c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.f45097c.setForceShareLight(true);
    }
}
