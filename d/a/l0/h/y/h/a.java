package d.a.l0.h.y.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.c f51436a;

    /* renamed from: b  reason: collision with root package name */
    public b f51437b;

    public a(d.a.l0.a.l0.c cVar) {
        this.f51436a = cVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f51436a);
        cVar.D(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f51437b == null) {
            this.f51437b = new b();
        }
        return this.f51437b;
    }
}
