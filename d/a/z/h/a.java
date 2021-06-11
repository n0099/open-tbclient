package d.a.z.h;

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
import com.baidu.nps.utils.ContextHolder;
import d.a.z.c.a.d;
import d.a.z.c.a.h;
import d.a.z.h.c.b;
import d.a.z.i.c;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BundleInfo f68671a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.z.h.b.a f68672b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68673c = false;

    /* renamed from: d  reason: collision with root package name */
    public d.a.z.h.c.a f68674d = null;

    public a(BundleInfo bundleInfo) {
        if (a(bundleInfo)) {
            this.f68671a = bundleInfo;
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
        sb.append(".apk");
        return c.d(applicationContext, sb.toString()).exists();
    }

    public ClassLoader c() {
        return this.f68672b;
    }

    public synchronized Resources d(Resources resources) {
        Application applicationContext = ContextHolder.getApplicationContext();
        String absolutePath = c.d(applicationContext, this.f68671a.getPackageName() + ".apk").getAbsolutePath();
        AssetManager assets = resources.getAssets();
        if (ResourcesHookUtil.hookAssets(assets, absolutePath)) {
            if (this.f68674d == null || this.f68674d.getAssets().hashCode() != assets.hashCode()) {
                this.f68674d = new d.a.z.h.c.a(assets, resources.getDisplayMetrics(), resources.getConfiguration(), resources);
            }
        } else {
            throw new InitException(21, "resources hook error");
        }
        return this.f68674d;
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
        this.f68672b = new d.a.z.h.b.a(c.d(applicationContext, this.f68671a.getPackageName() + ".apk").getAbsolutePath(), c.f(applicationContext, this.f68671a.getPackageName()).getAbsolutePath(), c.e(applicationContext, this.f68671a.getPackageName()).getAbsolutePath(), applicationContext);
        return true;
    }

    public final synchronized boolean g() {
        try {
            Application applicationContext = ContextHolder.getApplicationContext();
            Resources a2 = d.c().a();
            Resources b2 = d.c().b();
            Resources[] d2 = d.c().d();
            if (!this.f68673c) {
                h(applicationContext);
                this.f68673c = true;
            }
            String absolutePath = c.d(applicationContext, this.f68671a.getPackageName() + ".apk").getAbsolutePath();
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
