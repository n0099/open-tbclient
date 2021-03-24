package d.b.z.c.a;

import android.util.Log;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f64876b = new h();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<IWebViewDataDirectoryManager> f64877a;

    public h() {
        b();
    }

    public static h a() {
        return f64876b;
    }

    public void b() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64877a = b2;
        b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
    }

    public void c() {
        if (d.b.z.h.b.a()) {
            Log.i("NPS-WebViewDataDirec", "webViewDataDirectoryManagerHolder class=" + this.f64877a.getClass());
        }
        this.f64877a.get().setDataDirectorySuffix();
    }
}
