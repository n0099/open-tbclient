package d.a.l0.a.u.f.b;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<BasePendingOperation> f48893a = new ArrayList();

    public void b(BasePendingOperation basePendingOperation) {
        this.f48893a.add(basePendingOperation);
    }

    public void c() {
        this.f48893a.clear();
    }
}
