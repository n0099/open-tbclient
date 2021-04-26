package d.a.h0.g.w.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.b f46844a;

    /* renamed from: b  reason: collision with root package name */
    public b f46845b;

    public a(d.a.h0.g.i.b bVar) {
        this.f46844a = bVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f46844a);
        cVar.E(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f46845b == null) {
            this.f46845b = new b();
        }
        return this.f46845b;
    }
}
