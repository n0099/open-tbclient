package d.a.h0.g.d0;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import d.a.h0.g.d0.d.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.b f46278a;

    /* renamed from: b  reason: collision with root package name */
    public b f46279b = new b();

    public c(d.a.h0.g.i.b bVar) {
        this.f46278a = bVar;
    }

    @NonNull
    public d a() {
        this.f46279b.a();
        d.a.h0.a.f2.d.f42499h.b();
        return d.i(null);
    }

    @NonNull
    public d.a.h0.g.d0.d.c b() {
        String[] f2 = this.f46279b.f();
        d.a.h0.g.d0.d.c cVar = new d.a.h0.g.d0.d.c();
        cVar.keys = f2;
        cVar.currentSize = this.f46279b.e() / 1024;
        cVar.limitSize = this.f46279b.k() / 1024;
        cVar.errMsg = d.a.h0.g.d0.d.a.b("getStorageInfoSync");
        return cVar;
    }

    @NonNull
    public d c(String str) {
        if (str == null) {
            return d.b("parameter error: the key cannot be null.");
        }
        Object obj = null;
        String h2 = this.f46279b.h(str, null);
        if (h2 != null) {
            obj = this.f46278a.B(Base64.decode(h2, 2), true);
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
        this.f46279b.m(str);
        d.a.h0.a.f2.d.f42499h.b();
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
            byte[] L = this.f46278a.L(jsSerializeValue, true);
            d(jsSerializeValue);
            if (L == null) {
                return d.b("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(L, 2);
            String h2 = this.f46279b.h(str, null);
            int length = str.getBytes().length;
            if (this.f46279b.k() - this.f46279b.e() < (encodeToString.length() + length) - (h2 == null ? 0 : h2.length() + length)) {
                return d.b("storage error: the storage space insufficient.");
            }
            boolean l = this.f46279b.l(str, encodeToString);
            d.a.h0.a.f2.d.f42499h.b();
            return l ? d.i(null) : d.b("storage error: the storage is invalid.");
        }
    }
}
