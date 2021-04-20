package d.b.w.c.a;

import android.util.Log;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager;
import com.baidu.nps.interfa.IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    public static h f65542b = new h();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<IWebViewDataDirectoryManager> f65543a;

    public h() {
        b();
    }

    public static h a() {
        return f65542b;
    }

    public void b() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65543a = b2;
        b2.a(new IWebViewDataDirectoryManager_WebViewDataDirectoryManager_Provider());
    }

    public void c() {
        if (d.b.w.h.b.a()) {
            Log.i("NPS-WebViewDataDirec", "webViewDataDirectoryManagerHolder class=" + this.f65543a.getClass());
        }
        this.f65543a.get().setDataDirectorySuffix();
    }
}
