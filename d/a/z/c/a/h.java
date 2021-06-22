package d.a.z.c.a;

import android.util.Log;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f68735b = new h();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.f0.a.b.c<IWebViewDataDirectoryManager> f68736a;

    public h() {
        b();
    }

    public static h a() {
        return f68735b;
    }

    public void b() {
        d.a.f0.a.b.a b2 = d.a.f0.a.b.a.b();
        this.f68736a = b2;
        b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
    }

    public void c() {
        if (d.a.z.i.b.a()) {
            Log.i("NPS-WebViewDataDirec", "webViewDataDirectoryManagerHolder class=" + this.f68736a.getClass());
        }
        this.f68736a.get().setDataDirectorySuffix();
    }
}
