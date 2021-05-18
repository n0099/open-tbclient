package d.a.i0.h.g0;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.c f47211a;

    /* renamed from: b  reason: collision with root package name */
    public c f47212b = new c();

    public e(d.a.i0.a.l0.c cVar) {
        this.f47211a = cVar;
    }

    @NonNull
    public d.a.i0.h.g0.f.d a() {
        this.f47212b.j();
        d.a.i0.a.q2.d.f44059h.b();
        return d.a.i0.h.g0.f.d.i(null);
    }

    @NonNull
    public d.a.i0.h.g0.f.c b() {
        String[] n = this.f47212b.n();
        d.a.i0.h.g0.f.c cVar = new d.a.i0.h.g0.f.c();
        cVar.keys = n;
        cVar.currentSize = this.f47212b.m() / 1024;
        cVar.limitSize = this.f47212b.s() / 1024;
        cVar.errMsg = d.a.i0.h.g0.f.a.b("getStorageInfoSync");
        return cVar;
    }

    @NonNull
    public d.a.i0.h.g0.f.d c(String str) {
        if (str == null) {
            return d.a.i0.h.g0.f.d.b("parameter error: the key cannot be null.");
        }
        Object obj = null;
        String p = this.f47212b.p(str, null);
        if (p != null) {
            obj = this.f47211a.C(Base64.decode(p, 2), true);
        }
        if (obj == null) {
            obj = d.a.i0.h.g0.f.d.h();
        }
        return d.a.i0.h.g0.f.d.i(obj);
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public d.a.i0.h.g0.f.d e(String str) {
        if (str == null) {
            return d.a.i0.h.g0.f.d.b("parameter error: the key cannot be null.");
        }
        this.f47212b.u(str);
        d.a.i0.a.q2.d.f44059h.b();
        return d.a.i0.h.g0.f.d.i(null);
    }

    @NonNull
    public d.a.i0.h.g0.f.d f(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            d(jsSerializeValue);
            return d.a.i0.h.g0.f.d.b("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.a.i0.h.g0.f.d.i(null);
        } else {
            byte[] N = this.f47211a.N(jsSerializeValue, true);
            d(jsSerializeValue);
            if (N == null) {
                return d.a.i0.h.g0.f.d.b("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(N, 2);
            String p = this.f47212b.p(str, null);
            int length = str.getBytes().length;
            if (this.f47212b.s() - this.f47212b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                return d.a.i0.h.g0.f.d.b("storage error: the storage space insufficient.");
            }
            boolean t = this.f47212b.t(str, encodeToString);
            d.a.i0.a.q2.d.f44059h.b();
            return t ? d.a.i0.h.g0.f.d.i(null) : d.a.i0.h.g0.f.d.b("storage error: the storage is invalid.");
        }
    }
}
