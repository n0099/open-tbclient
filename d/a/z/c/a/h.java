package d.a.z.c.a;

import android.util.Log;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f64900b = new h();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.e0.a.b.c<IWebViewDataDirectoryManager> f64901a;

    public h() {
        b();
    }

    public static h a() {
        return f64900b;
    }

    public void b() {
        d.a.e0.a.b.a b2 = d.a.e0.a.b.a.b();
        this.f64901a = b2;
        b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
    }

    public void c() {
        if (d.a.z.i.b.a()) {
            Log.i("NPS-WebViewDataDirec", "webViewDataDirectoryManagerHolder class=" + this.f64901a.getClass());
        }
        this.f64901a.get().setDataDirectorySuffix();
    }
}
