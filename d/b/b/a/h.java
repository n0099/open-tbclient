package d.b.b.a;

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
    public static h f41472d;

    /* renamed from: a  reason: collision with root package name */
    public Resources f41473a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f41474b = null;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f41475c = null;

    public static h a() {
        if (f41472d == null) {
            synchronized (h.class) {
                if (f41472d == null) {
                    f41472d = new h();
                }
            }
        }
        return f41472d;
    }

    public synchronized Resources b() {
        return this.f41473a;
    }

    public synchronized void c(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (!TextUtils.isEmpty(str2)) {
            if (this.f41473a != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (this.f41475c == null) {
                        this.f41475c = new HashSet<>();
                    }
                    if (this.f41475c.contains(str)) {
                        d.b.b.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                    }
                    this.f41475c.add(str);
                }
                if (this.f41474b == null) {
                    this.f41474b = new ArrayList<>();
                }
                if (this.f41474b.contains(str2)) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 20) {
                    d.b.b.h.k.d.a(this.f41473a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.f41474b.size() > 0) {
                        Iterator<String> it = this.f41474b.iterator();
                        while (it.hasNext()) {
                            d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                        }
                    }
                    d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                    d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.f41473a = new Resources(assetManager, this.f41473a.getDisplayMetrics(), this.f41473a.getConfiguration());
                }
                this.f41474b.add(str2);
                return;
            }
            throw new RuntimeException("hostResources is null");
        }
        throw new IllegalArgumentException("param resPath is null");
    }

    public synchronized void d(Resources resources) {
        this.f41473a = resources;
    }
}
