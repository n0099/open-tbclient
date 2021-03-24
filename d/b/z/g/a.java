package d.b.z.g;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.runtime.InitException;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.nps.utils.Constant;
import com.baidu.nps.utils.ContextHolder;
import d.b.z.c.a.d;
import d.b.z.c.a.h;
import d.b.z.g.c.b;
import d.b.z.h.c;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BundleInfo f64915a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.z.g.b.a f64916b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64917c = false;

    /* renamed from: d  reason: collision with root package name */
    public d.b.z.g.c.a f64918d = null;

    public a(BundleInfo bundleInfo) {
        if (a(bundleInfo)) {
            this.f64915a = bundleInfo;
            return;
        }
        throw new InitException(22, "bad param bundleInfo:" + bundleInfo.toString());
    }

    public static a b(BundleInfo bundleInfo) {
        a aVar = new a(bundleInfo);
        aVar.e();
        return aVar;
    }

    public final boolean a(BundleInfo bundleInfo) {
        if (bundleInfo == null || TextUtils.isEmpty(bundleInfo.getPackageName())) {
            return false;
        }
        Application applicationContext = ContextHolder.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(bundleInfo.getPackageName());
        sb.append(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
        return c.d(applicationContext, sb.toString()).exists();
    }

    public ClassLoader c() {
        return this.f64916b;
    }

    public synchronized Resources d(Resources resources) {
        Application applicationContext = ContextHolder.getApplicationContext();
        String absolutePath = c.d(applicationContext, this.f64915a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
        AssetManager assets = resources.getAssets();
        if (ResourcesHookUtil.hookAssets(assets, absolutePath)) {
            if (this.f64918d == null || this.f64918d.getAssets().hashCode() != assets.hashCode()) {
                this.f64918d = new d.b.z.g.c.a(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
            }
        } else {
            throw new InitException(21, "resources hook error");
        }
        return this.f64918d;
    }

    public final void e() {
        if (f()) {
            if (!g()) {
                throw new InitException(20, "resources init error");
            }
            return;
        }
        throw new InitException(16, "class loader init error");
    }

    public final boolean f() {
        Application applicationContext = ContextHolder.getApplicationContext();
        this.f64916b = new d.b.z.g.b.a(c.d(applicationContext, this.f64915a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), c.f(applicationContext, this.f64915a.getPackageName()).getAbsolutePath(), c.e(applicationContext, this.f64915a.getPackageName()).getAbsolutePath(), applicationContext);
        return true;
    }

    public final synchronized boolean g() {
        try {
            Application applicationContext = ContextHolder.getApplicationContext();
            Resources a2 = d.c().a();
            Resources b2 = d.c().b();
            Resources[] d2 = d.c().d();
            if (!this.f64917c) {
                h(applicationContext);
                this.f64917c = true;
            }
            String absolutePath = c.d(applicationContext, this.f64915a.getPackageName() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath();
            ResourcesHookUtil.hookResources(a2, absolutePath);
            ResourcesHookUtil.hookResources(b2, absolutePath);
            if (d2 != null) {
                for (Resources resources : d2) {
                    ResourcesHookUtil.hookResources(resources, absolutePath);
                }
            }
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    public final void h(Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            h.a().c();
            try {
                new WebView(context);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new b(context, countDownLatch).sendMessage(Message.obtain());
        try {
            countDownLatch.await();
        } catch (Exception unused2) {
        }
    }

    public String toString() {
        return super.toString();
    }
}
