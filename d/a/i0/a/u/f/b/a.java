package d.a.i0.a.u.f.b;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<BasePendingOperation> f45043a = new ArrayList();

    public void b(BasePendingOperation basePendingOperation) {
        this.f45043a.add(basePendingOperation);
    }

    public void c() {
        this.f45043a.clear();
    }
}
