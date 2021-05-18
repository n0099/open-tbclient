package d.a.i0.h.f0;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class c implements d.a.i0.a.p.b.a.h {
    @Override // d.a.i0.a.p.b.a.h
    public JSONObject a() {
        return b.c().d();
    }

    @Override // d.a.i0.a.p.b.a.h
    public void b(String str) {
        e.d(str);
    }

    @Override // d.a.i0.a.p.b.a.h
    public void c(CallbackHandler callbackHandler, String str) {
        e.e(callbackHandler, str);
    }

    @Override // d.a.i0.a.p.b.a.h
    public void d(CallbackHandler callbackHandler, String str) {
        e.a(callbackHandler, str);
    }

    @Override // d.a.i0.a.p.b.a.h
    public void e(String str) {
        e.f(str);
    }

    @Override // d.a.i0.a.p.b.a.h
    public void f(CallbackHandler callbackHandler, String str) {
        e.g(callbackHandler, str);
    }

    @Override // d.a.i0.a.p.b.a.h
    public void g(CallbackHandler callbackHandler, String str) {
        e.b(callbackHandler, str);
    }
}
