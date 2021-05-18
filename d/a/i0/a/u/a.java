package d.a.i0.a.u;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import d.a.i0.a.k;
import d.a.i0.a.l0.c;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements d.a.i0.a.u.c.b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44626e = k.f43025a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f44627a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f44628b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f44629c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.h0.f.a f44630d;

    public a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull d.a.i0.a.h0.f.a aVar) {
        this.f44627a = context;
        this.f44628b = callbackHandler;
        this.f44630d = aVar;
    }

    public void a(@NonNull d.a.i0.a.h0.f.a aVar) {
        aVar.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
    }

    public final void b(@NonNull d.a.i0.a.h0.f.a aVar) {
        if (aVar instanceof c) {
            c((c) aVar);
        } else {
            d(aVar);
        }
    }

    public final void c(@NonNull c cVar) {
        e(cVar, SwanApi$$ModulesProvider.getV8ApiModules(this), d.a.i0.a.c1.a.s().a(this));
    }

    public final void d(@NonNull d.a.i0.a.h0.f.a aVar) {
        e(aVar, SwanApi$$ModulesProvider.getWebviewApiModules(this), d.a.i0.a.c1.a.s().c(this));
    }

    public final void e(@NonNull d.a.i0.a.h0.f.a aVar, Map<String, Object> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (map2 != null) {
            if (map == null) {
                map = map2;
            } else {
                try {
                    map.putAll(map2);
                } catch (Exception e2) {
                    if (f44626e) {
                        e2.printStackTrace();
                        throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                    }
                    return;
                }
            }
        }
        if (map == null) {
            if (f44626e) {
                throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
            }
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (TextUtils.isEmpty(key)) {
                if (f44626e) {
                    throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                }
            } else if (value == null) {
                if (f44626e) {
                    throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                }
            } else {
                aVar.addJavascriptInterface(value, key);
                if (f44626e) {
                    String str = aVar instanceof c ? "V8" : "Webview";
                    Log.d("Api-Binder", "doBindSwanApis(" + str + "): bound " + key);
                }
            }
        }
        if (f44626e) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 5) {
                Log.w("Api-Binder", "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms");
            }
        }
    }

    @NonNull
    public final Context f() {
        WeakReference<Activity> weakReference = this.f44629c;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity == null ? this.f44627a : activity;
    }

    @Override // d.a.i0.a.u.c.b
    @NonNull
    public d.a.i0.a.h0.f.a g() {
        return this.f44630d;
    }

    @Override // d.a.i0.a.u.c.b
    @NonNull
    public Context getContext() {
        return f();
    }

    @Override // d.a.i0.a.u.c.b
    @NonNull
    public CallbackHandler h() {
        return this.f44628b;
    }

    public void i(Activity activity) {
        if (activity != null) {
            this.f44629c = new WeakReference<>(activity);
        }
    }
}
