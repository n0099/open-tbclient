package d.a.l0.h.k;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.l0.a {

    /* loaded from: classes3.dex */
    public class a implements V8Engine.WorkerFactory {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.WorkerFactory
        public V8Engine onCreateWorker() {
            c cVar = new c(b.this.getInitBasePath());
            cVar.H0();
            cVar.r(new d.a.l0.a.l0.k.b(cVar));
            cVar.G0(new d.a.l0.a.l0.k.c(cVar));
            return cVar.l0();
        }
    }

    public b(@NonNull String str, @NonNull d.a.l0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
        V8Engine v8Engine = this.f43293e;
        if (v8Engine == null) {
            return;
        }
        v8Engine.setWorkerFactoryDelegate(new a());
    }

    @Override // d.a.l0.a.l0.a
    public EventTarget D() {
        return new d.a.l0.h.d.d.a(this);
    }

    @Override // d.a.l0.a.l0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }

    @Override // d.a.l0.a.l0.a
    @NonNull
    public EventTarget w() {
        return new d.a.l0.h.d.b(this);
    }
}
