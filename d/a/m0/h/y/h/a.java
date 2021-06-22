package d.a.m0.h.y.h;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.c f51544a;

    /* renamed from: b  reason: collision with root package name */
    public b f51545b;

    public a(d.a.m0.a.l0.c cVar) {
        this.f51544a = cVar;
    }

    public c a(JsObject jsObject) {
        c cVar = new c(b(), this.f51544a);
        cVar.D(jsObject);
        return cVar;
    }

    @NonNull
    public final b b() {
        if (this.f51545b == null) {
            this.f51545b = new b();
        }
        return this.f51545b;
    }
}
