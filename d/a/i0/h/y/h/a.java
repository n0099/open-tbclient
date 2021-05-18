package d.a.i0.h.y.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.c f47586a;

    /* renamed from: b  reason: collision with root package name */
    public b f47587b;

    public a(d.a.i0.a.l0.c cVar) {
        this.f47586a = cVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f47586a);
        cVar.D(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f47587b == null) {
            this.f47587b = new b();
        }
        return this.f47587b;
    }
}
