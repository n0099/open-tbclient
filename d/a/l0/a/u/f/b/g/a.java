package d.a.l0.a.u.f.b.g;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
/* loaded from: classes2.dex */
public class a extends BasePendingOperation {

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0927a f48898e;

    /* renamed from: d.a.l0.a.u.f.b.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0927a {
        void a();
    }

    public a(InterfaceC0927a interfaceC0927a) {
        this.f48898e = interfaceC0927a;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public boolean a() {
        return true;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public BasePendingOperation.OperationType d() {
        return BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC0927a interfaceC0927a = this.f48898e;
        if (interfaceC0927a != null) {
            interfaceC0927a.a();
        }
    }
}
