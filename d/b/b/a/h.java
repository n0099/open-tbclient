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
    public static h f41471d;

    /* renamed from: a  reason: collision with root package name */
    public Resources f41472a = null;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f41473b = null;

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f41474c = null;

    public static h a() {
        if (f41471d == null) {
            synchronized (h.class) {
                if (f41471d == null) {
                    f41471d = new h();
                }
            }
        }
        return f41471d;
    }

    public synchronized Resources b() {
        return this.f41472a;
    }

    public synchronized void c(String str, String str2) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if (!TextUtils.isEmpty(str2)) {
            if (this.f41472a != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (this.f41474c == null) {
                        this.f41474c = new HashSet<>();
                    }
                    if (this.f41474c.contains(str)) {
                        d.b.b.h.h.a.b().o("plugin_load", "repeat_inject_res", str, str2);
                    }
                    this.f41474c.add(str);
                }
                if (this.f41473b == null) {
                    this.f41473b = new ArrayList<>();
                }
                if (this.f41473b.contains(str2)) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 20) {
                    d.b.b.h.k.d.a(this.f41472a.getAssets(), V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                } else {
                    AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                    if (this.f41473b.size() > 0) {
                        Iterator<String> it = this.f41473b.iterator();
                        while (it.hasNext()) {
                            d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{it.next()});
                        }
                    }
                    d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{str2});
                    d.b.b.h.k.d.a(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Object[]{BdBaseApplication.getInst().getApp().getPackageCodePath()});
                    this.f41472a = new Resources(assetManager, this.f41472a.getDisplayMetrics(), this.f41472a.getConfiguration());
                }
                this.f41473b.add(str2);
                return;
            }
            throw new RuntimeException("hostResources is null");
        }
        throw new IllegalArgumentException("param resPath is null");
    }

    public synchronized void d(Resources resources) {
        this.f41472a = resources;
    }
}
