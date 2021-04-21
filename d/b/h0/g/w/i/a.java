package d.b.h0.g.w.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.b f49348a;

    /* renamed from: b  reason: collision with root package name */
    public b f49349b;

    public a(d.b.h0.g.i.b bVar) {
        this.f49348a = bVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f49348a);
        cVar.E(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f49349b == null) {
            this.f49349b = new b();
        }
        return this.f49349b;
    }
}
