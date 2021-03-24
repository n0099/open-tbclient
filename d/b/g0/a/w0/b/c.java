package d.b.g0.a.w0.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.cookie.CookieManager;
import d.b.g0.a.k;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c implements d.b.g0.c.a {
    @Override // d.b.g0.c.a
    public CookieManager a() {
        return d.b.g0.a.w0.a.m().a();
    }

    @Override // d.b.g0.c.a
    public boolean isDebug() {
        return k.f45050a;
    }
}
