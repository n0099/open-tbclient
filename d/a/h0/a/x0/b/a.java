package d.a.h0.a.x0.b;

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
    public d.a.h0.a.x0.a f45101a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.x0.a f45102b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppUtilsJavaScriptInterface f45103c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.t.a f45104d;

    public void a(Activity activity) {
        d.a.h0.a.x0.a aVar = this.f45101a;
        if (aVar != null) {
            aVar.setActivityRef(activity);
        }
        d.a.h0.a.x0.a aVar2 = this.f45102b;
        if (aVar2 != null) {
            aVar2.setActivityRef(activity);
        }
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.f45103c;
        if (swanAppUtilsJavaScriptInterface != null) {
            swanAppUtilsJavaScriptInterface.setActivity(activity);
        }
        d.a.h0.a.t.a aVar3 = this.f45104d;
        if (aVar3 != null) {
            aVar3.i(activity);
        }
    }

    public final void b(d.a.h0.a.e0.k.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull d.a.h0.a.t.a aVar2) {
        SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        this.f45101a = swanAppGlobalJsBridge;
        aVar.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler);
        this.f45102b = swanAppJsBridge;
        aVar.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
        aVar2.b(aVar);
    }

    public final void c(@NonNull d.a.h0.a.e0.k.a aVar, Context context, @NonNull d.a.h0.a.t.a aVar2) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.f45103c = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        aVar.addJavascriptInterface(this.f45103c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        aVar2.a(aVar);
    }

    public final void d(d.a.h0.a.e0.k.a aVar) {
        aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public void e(d.a.h0.a.e0.k.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        if (aVar == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        d.a.h0.a.t.a aVar2 = new d.a.h0.a.t.a(context, callbackHandler, aVar);
        this.f45104d = aVar2;
        b(aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2);
        if (aVar instanceof d.a.h0.g.i.b) {
            c(aVar, context, this.f45104d);
        } else {
            d(aVar);
        }
    }

    public void f(Context context, d.a.h0.a.e0.k.a aVar) {
        SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
        this.f45103c = swanAppUtilsJavaScriptInterface;
        swanAppUtilsJavaScriptInterface.setSource("swan_");
        aVar.addJavascriptInterface(this.f45103c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.f45103c.setForceShareLight(true);
    }
}
