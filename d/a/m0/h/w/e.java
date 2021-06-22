package d.a.m0.h.w;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class e extends JSEvent {

    /* loaded from: classes3.dex */
    public static class a {
        @V8JavascriptField
        public boolean devhook;
        @V8JavascriptField
        public String scene;
    }

    public e(d.a.m0.a.f1.e.b bVar) {
        super("appshow");
        this.data = a(bVar);
    }

    public final Object a(d.a.m0.a.f1.e.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.T();
        aVar.devhook = bVar.l0();
        return aVar;
    }
}
