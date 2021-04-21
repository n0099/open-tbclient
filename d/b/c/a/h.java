package d.b.c.a;

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
    public static h f42209d;

    /* renamed from: a  reason: collision with root package name */
    public Resources f42210a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f42211b = null;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f42212c = null;

    public static h a() {
        if (f42209d == null) {
            synchronized (h.class) {
                if (f42209d == null) {
                    f42209d = new h();
                }
            }
        }
        return f42209d;
    }

    public synchronized Resources b() {
        return this.f42210a;
    }

    public synchronized void c(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (!TextUtils.isEmpty(str2)) {
            if (this.f42210a != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (this.f42212c == null) {
                        this.f42212c = new HashSet<>();
                    }
                    if (this.f42212c.contains(str)) {
                        d.b.c.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                    }
                    this.f42212c.add(str);
                }
                if (this.f42211b == null) {
                    this.f42211b = new ArrayList<>();
                }
                if (this.f42211b.contains(str2)) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 20) {
                    d.b.c.h.k.d.a(this.f42210a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.f42211b.size() > 0) {
                        Iterator<String> it = this.f42211b.iterator();
                        while (it.hasNext()) {
                            d.b.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                        }
                    }
                    d.b.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                    d.b.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.f42210a = new Resources(assetManager, this.f42210a.getDisplayMetrics(), this.f42210a.getConfiguration());
                }
                this.f42211b.add(str2);
                return;
            }
            throw new RuntimeException("hostResources is null");
        }
        throw new IllegalArgumentException("param resPath is null");
    }

    public synchronized void d(Resources resources) {
        this.f42210a = resources;
    }
}
