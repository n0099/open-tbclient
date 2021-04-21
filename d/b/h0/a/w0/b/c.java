package d.b.h0.a.w0.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.cookie.CookieManager;
import d.b.h0.a.k;
@Singleton
@Service
/* loaded from: classes2.dex */
public class c implements d.b.h0.c.a {
    @Override // d.b.h0.c.a
    public CookieManager a() {
        return d.b.h0.a.w0.a.m().a();
    }

    @Override // d.b.h0.c.a
    public boolean isDebug() {
        return k.f45772a;
    }
}
