package d.b.h0.g.u;

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

    public e(d.b.h0.a.y0.e.b bVar) {
        super("appshow");
        this.data = a(bVar);
    }

    public final Object a(d.b.h0.a.y0.e.b bVar) {
        a aVar = new a();
        aVar.scene = bVar.S();
        aVar.devhook = bVar.i0();
        return aVar;
    }
}
