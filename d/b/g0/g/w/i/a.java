package d.b.g0.g.w.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.b f49019a;

    /* renamed from: b  reason: collision with root package name */
    public b f49020b;

    public a(d.b.g0.g.i.b bVar) {
        this.f49019a = bVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f49019a);
        cVar.E(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f49020b == null) {
            this.f49020b = new b();
        }
        return this.f49020b;
    }
}
