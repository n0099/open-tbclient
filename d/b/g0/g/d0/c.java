package d.b.g0.g.d0;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import d.b.g0.g.d0.d.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f48087a;

    /* renamed from: b  reason: collision with root package name */
    public b f48088b = new b();

    public c(d.b.g0.g.i.b bVar) {
        this.f48087a = bVar;
    }

    @NonNull
    public d a() {
        this.f48088b.a();
        d.b.g0.a.f2.d.f44467h.b();
        return d.i(null);
    }

    @NonNull
    public d.b.g0.g.d0.d.c b() {
        String[] f2 = this.f48088b.f();
        d.b.g0.g.d0.d.c cVar = new d.b.g0.g.d0.d.c();
        cVar.keys = f2;
        cVar.currentSize = this.f48088b.e() / 1024;
        cVar.limitSize = this.f48088b.k() / 1024;
        cVar.errMsg = d.b.g0.g.d0.d.a.b("getStorageInfoSync");
        return cVar;
    }

    @NonNull
    public d c(String str) {
        if (str == null) {
            return d.b("parameter error: the key cannot be null.");
        }
        Object obj = null;
        String h2 = this.f48088b.h(str, null);
        if (h2 != null) {
            obj = this.f48087a.d0(Base64.decode(h2, 2), true);
        }
        if (obj == null) {
            obj = d.h();
        }
        return d.i(obj);
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public d e(String str) {
        if (str == null) {
            return d.b("parameter error: the key cannot be null.");
        }
        this.f48088b.m(str);
        d.b.g0.a.f2.d.f44467h.b();
        return d.i(null);
    }

    @NonNull
    public d f(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            d(jsSerializeValue);
            return d.b("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.i(null);
        } else {
            byte[] y = this.f48087a.y(jsSerializeValue, true);
            d(jsSerializeValue);
            if (y == null) {
                return d.b("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(y, 2);
            String h2 = this.f48088b.h(str, null);
            int length = str.getBytes().length;
            if (this.f48088b.k() - this.f48088b.e() < (encodeToString.length() + length) - (h2 == null ? 0 : h2.length() + length)) {
                return d.b("storage error: the storage space insufficient.");
            }
            boolean l = this.f48088b.l(str, encodeToString);
            d.b.g0.a.f2.d.f44467h.b();
            return l ? d.i(null) : d.b("storage error: the storage is invalid.");
        }
    }
}
