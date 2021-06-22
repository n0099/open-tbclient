package d.a.m0.a.u.f.b.g;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
/* loaded from: classes2.dex */
public class a extends BasePendingOperation {

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0930a f49006e;

    /* renamed from: d.a.m0.a.u.f.b.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0930a {
        void a();
    }

    public a(InterfaceC0930a interfaceC0930a) {
        this.f49006e = interfaceC0930a;
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
        InterfaceC0930a interfaceC0930a = this.f49006e;
        if (interfaceC0930a != null) {
            interfaceC0930a.a();
        }
    }
}
