package d.b.g0.g.w.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f48627a;

    /* renamed from: b  reason: collision with root package name */
    public b f48628b;

    public a(d.b.g0.g.i.b bVar) {
        this.f48627a = bVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f48627a);
        cVar.E(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f48628b == null) {
            this.f48628b = new b();
        }
        return this.f48628b;
    }
}
