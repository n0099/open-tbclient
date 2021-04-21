package d.b.h0.a.x0.b;

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
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.x0.a f47670a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.x0.a f47671b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppUtilsJavaScriptInterface f47672c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.t.a f47673d;

    public void a(Activity activity) {
        d.b.h0.a.x0.a aVar = this.f47670a;
        if (aVar != null) {
            aVar.setActivityRef(activity);
        }
        d.b.h0.a.x0.a aVar2 = this.f47671b;
        if (aVar2 != null) {
            aVar2.setActivityRef(activity);
        }
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.f47672c;
        if (swanAppUtilsJavaScriptInterface != null) {
            swanAppUtilsJavaScriptInterface.setActivity(activity);
        }
        d.b.h0.a.t.a aVar3 = this.f47673d;
        if (aVar3 != null) {
            aVar3.i(activity);
        }
    }

    public final void b(d.b.h0.a.e0.k.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull d.b.h0.a.t.a aVar2) {
        SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        this.f47670a = swanAppGlobalJsBridge;
        aVar.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        this.f47671b = swanAppJsBridge;
        aVar.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.b(aVar);
    }

    public final void c(@NonNull d.b.h0.a.e0.k.a aVar, Context context, @NonNull d.b.h0.a.t.a aVar2) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.f47672c = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        aVar.addJavascriptInterface(this.f47672c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    public final void d(d.b.h0.a.e0.k.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public void e(d.b.h0.a.e0.k.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        d.b.h0.a.t.a aVar2 = new d.b.h0.a.t.a(context, callbackHandler, aVar);
        this.f47673d = aVar2;
        b(aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2);
        if (aVar instanceof d.b.h0.g.i.b) {
            c(aVar, context, this.f47673d);
        } else {
            d(aVar);
        }
    }

    public void f(Context context, d.b.h0.a.e0.k.a aVar) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.f47672c = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        aVar.addJavascriptInterface(this.f47672c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.f47672c.setForceShareLight(true);
    }
}
