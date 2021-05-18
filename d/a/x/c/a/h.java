package d.a.x.c.a;

import android.util.Log;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f64847b = new h();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<IWebViewDataDirectoryManager> f64848a;

    public h() {
        b();
    }

    public static h a() {
        return f64847b;
    }

    public void b() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64848a = b2;
        b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
    }

    public void c() {
        if (d.a.x.i.b.a()) {
            Log.i("NPS-WebViewDataDirec", "webViewDataDirectoryManagerHolder class=" + this.f64848a.getClass());
        }
        this.f64848a.get().setDataDirectorySuffix();
    }
}
