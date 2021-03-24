package d.b.g0.a.t;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.api.SwanApi$$ModulesProvider;
import com.baidu.swan.apps.api.module.network.SwanApiNetworkV8Module;
import d.b.g0.a.k;
import d.b.g0.a.t.b.b;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45918e = k.f45050a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f45919a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f45920b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f45921c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.e0.k.a f45922d;

    public a(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull d.b.g0.a.e0.k.a aVar) {
        this.f45919a = context;
        this.f45920b = callbackHandler;
        this.f45922d = aVar;
    }

    public void a(@NonNull d.b.g0.a.e0.k.a aVar) {
        aVar.addJavascriptInterface(new SwanApiNetworkV8Module(this), SwanApiNetworkV8Module.MODULE_NAME);
    }

    public final void b(@NonNull d.b.g0.a.e0.k.a aVar) {
        if (aVar instanceof d.b.g0.g.i.b) {
            c((d.b.g0.g.i.b) aVar);
        } else {
            d(aVar);
        }
    }

    public final void c(@NonNull d.b.g0.g.i.b bVar) {
        e(bVar, SwanApi$$ModulesProvider.getV8ApiModules(this), d.b.g0.a.w0.a.p().a(this));
    }

    public final void d(@NonNull d.b.g0.a.e0.k.a aVar) {
        e(aVar, SwanApi$$ModulesProvider.getWebviewApiModules(this), d.b.g0.a.w0.a.p().c(this));
    }

    public final void e(@NonNull d.b.g0.a.e0.k.a aVar, Map<String, Object> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (map2 != null) {
            if (map == null) {
                map = map2;
            } else {
                try {
                    map.putAll(map2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (f45918e) {
                        throw new RuntimeException("doBindSwanApis fail: " + e2.getMessage());
                    }
                    return;
                }
            }
        }
        if (map == null) {
            if (f45918e) {
                throw new RuntimeException("doBindSwanApis fail: api modules cannot be null");
            }
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (TextUtils.isEmpty(key)) {
                if (f45918e) {
                    throw new RuntimeException("doBindSwanApis fail: moduleName cannot be empty");
                }
            } else if (value == null) {
                if (f45918e) {
                    throw new RuntimeException("doBindSwanApis fail: module obj cannot be null");
                }
            } else {
                aVar.addJavascriptInterface(value, key);
                if (f45918e) {
                    String str = aVar instanceof d.b.g0.g.i.b ? "V8" : "Webview";
                    Log.d("Api-Binder", "doBindSwanApis(" + str + "): bound " + key);
                }
            }
        }
        if (f45918e) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 5) {
                Log.w("Api-Binder", "doBindSwanApis: 耗时 " + currentTimeMillis2 + "ms");
            }
        }
    }

    @NonNull
    public final Context f() {
        WeakReference<Activity> weakReference = this.f45921c;
        Activity activity = weakReference != null ? weakReference.get() : null;
        return activity == null ? this.f45919a : activity;
    }

    @Override // d.b.g0.a.t.b.b
    @NonNull
    public d.b.g0.a.e0.k.a g() {
        return this.f45922d;
    }

    @Override // d.b.g0.a.t.b.b
    @NonNull
    public Context getContext() {
        return f();
    }

    @Override // d.b.g0.a.t.b.b
    @NonNull
    public CallbackHandler h() {
        return this.f45920b;
    }

    public void i(Activity activity) {
        if (activity != null) {
            this.f45921c = new WeakReference<>(activity);
        }
    }
}
