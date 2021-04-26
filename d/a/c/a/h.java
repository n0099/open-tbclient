package d.a.c.a;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.searchbox.v8engine.V8Engine;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {

    /* renamed from: d  reason: collision with root package name */
    public static h f39394d;

    /* renamed from: a  reason: collision with root package name */
    public Resources f39395a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f39396b = null;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f39397c = null;

    public static h a() {
        if (f39394d == null) {
            synchronized (h.class) {
                if (f39394d == null) {
                    f39394d = new h();
                }
            }
        }
        return f39394d;
    }

    public synchronized Resources b() {
        return this.f39395a;
    }

    public synchronized void c(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (!TextUtils.isEmpty(str2)) {
            if (this.f39395a != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (this.f39397c == null) {
                        this.f39397c = new HashSet<>();
                    }
                    if (this.f39397c.contains(str)) {
                        d.a.c.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                    }
                    this.f39397c.add(str);
                }
                if (this.f39396b == null) {
                    this.f39396b = new ArrayList<>();
                }
                if (this.f39396b.contains(str2)) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 20) {
                    d.a.c.h.k.d.a(this.f39395a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.f39396b.size() > 0) {
                        Iterator<String> it = this.f39396b.iterator();
                        while (it.hasNext()) {
                            d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                        }
                    }
                    d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                    d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.f39395a = new Resources(assetManager, this.f39395a.getDisplayMetrics(), this.f39395a.getConfiguration());
                }
                this.f39396b.add(str2);
                return;
            }
            throw new RuntimeException("hostResources is null");
        }
        throw new IllegalArgumentException("param resPath is null");
    }

    public synchronized void d(Resources resources) {
        this.f39395a = resources;
    }
}
