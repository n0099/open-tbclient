package d.a.t.a;

import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import java.security.InvalidParameterException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.t.e.b f63965a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f63966b;

    /* renamed from: c  reason: collision with root package name */
    public int f63967c = 1;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, d.a.t.e.b bVar) {
        this.f63965a = null;
        this.f63966b = BdAsyncTaskParallelType.MAX_PARALLEL;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f63966b = bdAsyncTaskParallelType;
            this.f63965a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        return this.f63967c;
    }

    public int b() {
        d.a.t.e.b bVar = this.f63965a;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    public BdAsyncTaskParallelType c() {
        return this.f63966b;
    }
}
