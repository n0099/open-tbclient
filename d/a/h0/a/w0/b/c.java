package d.a.h0.a.w0.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.cookie.CookieManager;
import d.a.h0.a.k;
@Singleton
@Service
/* loaded from: classes2.dex */
public class c implements d.a.h0.c.a {
    @Override // d.a.h0.c.a
    public CookieManager a() {
        return d.a.h0.a.w0.a.m().a();
    }

    @Override // d.a.h0.c.a
    public boolean isDebug() {
        return k.f43101a;
    }
}
