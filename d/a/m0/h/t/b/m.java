package d.a.m0.h.t.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.HttpManager;
import okhttp3.Callback;
import okhttp3.Request;
@Singleton
@Service
/* loaded from: classes3.dex */
public class m implements d.a.m0.a.p.b.a.j {
    @Override // d.a.m0.a.p.b.a.j
    public void a(HttpManager httpManager, Request request, Callback callback) {
        if (httpManager == null || !(httpManager instanceof d.a.m0.h.y.b)) {
            return;
        }
        ((d.a.m0.h.y.b) httpManager).b(request, callback);
    }

    @Override // d.a.m0.a.p.b.a.j
    public HttpManager b() {
        return d.a.m0.h.y.b.d();
    }
}
