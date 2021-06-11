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
    public static h f41956d;

    /* renamed from: a  reason: collision with root package name */
    public Resources f41957a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f41958b = null;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f41959c = null;

    public static h a() {
        if (f41956d == null) {
            synchronized (h.class) {
                if (f41956d == null) {
                    f41956d = new h();
                }
            }
        }
        return f41956d;
    }

    public synchronized Resources b() {
        return this.f41957a;
    }

    public synchronized void c(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (!TextUtils.isEmpty(str2)) {
            if (this.f41957a != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (this.f41959c == null) {
                        this.f41959c = new HashSet<>();
                    }
                    if (this.f41959c.contains(str)) {
                        d.a.c.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                    }
                    this.f41959c.add(str);
                }
                if (this.f41958b == null) {
                    this.f41958b = new ArrayList<>();
                }
                if (this.f41958b.contains(str2)) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 20) {
                    d.a.c.h.k.d.a(this.f41957a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.f41958b.size() > 0) {
                        Iterator<String> it = this.f41958b.iterator();
                        while (it.hasNext()) {
                            d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                        }
                    }
                    d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                    d.a.c.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.f41957a = new Resources(assetManager, this.f41957a.getDisplayMetrics(), this.f41957a.getConfiguration());
                }
                this.f41958b.add(str2);
                return;
            }
            throw new RuntimeException("hostResources is null");
        }
        throw new IllegalArgumentException("param resPath is null");
    }

    public synchronized void d(Resources resources) {
        this.f41957a = resources;
    }
}
