package d.a.h0.g.i;

import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes3.dex */
public class e extends d.a.h0.g.i.a {

    /* loaded from: classes3.dex */
    public class a implements V8Engine.WorkerFactory {
        public a() {
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.WorkerFactory
        public V8Engine onCreateWorker() {
            f fVar = new f(e.this.getInitBasePath());
            fVar.C0();
            fVar.u(new d.a.h0.g.i.k.b(fVar));
            fVar.B0(new d.a.h0.g.i.k.c(fVar));
            return fVar.i0();
        }
    }

    public e(@NonNull String str, @NonNull d.a.h0.g.i.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
        V8Engine v8Engine = this.f46354e;
        if (v8Engine == null) {
            return;
        }
        v8Engine.setWorkerFactoryDelegate(new a());
    }

    @Override // d.a.h0.g.i.a
    @NonNull
    public EventTarget A() {
        return new d.a.h0.g.e.c(this);
    }

    @Override // d.a.h0.g.i.a
    public EventTarget C() {
        return new d.a.h0.g.e.e.a(this);
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }
}
