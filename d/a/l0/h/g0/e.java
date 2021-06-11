package d.a.l0.h.g0;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.c f51061a;

    /* renamed from: b  reason: collision with root package name */
    public c f51062b = new c();

    public e(d.a.l0.a.l0.c cVar) {
        this.f51061a = cVar;
    }

    @NonNull
    public d.a.l0.h.g0.f.d a() {
        this.f51062b.j();
        d.a.l0.a.q2.d.f47909h.b();
        return d.a.l0.h.g0.f.d.i(null);
    }

    @NonNull
    public d.a.l0.h.g0.f.c b() {
        String[] n = this.f51062b.n();
        d.a.l0.h.g0.f.c cVar = new d.a.l0.h.g0.f.c();
        cVar.keys = n;
        cVar.currentSize = this.f51062b.m() / 1024;
        cVar.limitSize = this.f51062b.s() / 1024;
        cVar.errMsg = d.a.l0.h.g0.f.a.b("getStorageInfoSync");
        return cVar;
    }

    @NonNull
    public d.a.l0.h.g0.f.d c(String str) {
        if (str == null) {
            return d.a.l0.h.g0.f.d.b("parameter error: the key cannot be null.");
        }
        Object obj = null;
        String p = this.f51062b.p(str, null);
        if (p != null) {
            obj = this.f51061a.C(Base64.decode(p, 2), true);
        }
        if (obj == null) {
            obj = d.a.l0.h.g0.f.d.h();
        }
        return d.a.l0.h.g0.f.d.i(obj);
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public d.a.l0.h.g0.f.d e(String str) {
        if (str == null) {
            return d.a.l0.h.g0.f.d.b("parameter error: the key cannot be null.");
        }
        this.f51062b.u(str);
        d.a.l0.a.q2.d.f47909h.b();
        return d.a.l0.h.g0.f.d.i(null);
    }

    @NonNull
    public d.a.l0.h.g0.f.d f(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            d(jsSerializeValue);
            return d.a.l0.h.g0.f.d.b("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.a.l0.h.g0.f.d.i(null);
        } else {
            byte[] N = this.f51061a.N(jsSerializeValue, true);
            d(jsSerializeValue);
            if (N == null) {
                return d.a.l0.h.g0.f.d.b("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(N, 2);
            String p = this.f51062b.p(str, null);
            int length = str.getBytes().length;
            if (this.f51062b.s() - this.f51062b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                return d.a.l0.h.g0.f.d.b("storage error: the storage space insufficient.");
            }
            boolean t = this.f51062b.t(str, encodeToString);
            d.a.l0.a.q2.d.f47909h.b();
            return t ? d.a.l0.h.g0.f.d.i(null) : d.a.l0.h.g0.f.d.b("storage error: the storage is invalid.");
        }
    }
}
