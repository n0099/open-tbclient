package d.b.g0.g.u;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class b extends JSEvent {

    /* loaded from: classes3.dex */
    public static class a {
        @V8JavascriptField
        public long startupTime;
    }

    public b(long j) {
        super("appAttach");
        this.data = a(j);
    }

    public final Object a(long j) {
        a aVar = new a();
        aVar.startupTime = j;
        return aVar;
    }
}
