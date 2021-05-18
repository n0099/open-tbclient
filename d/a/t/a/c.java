package d.a.t.a;

import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import java.security.InvalidParameterException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.t.e.b f64652a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f64653b;

    /* renamed from: c  reason: collision with root package name */
    public int f64654c = 1;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, d.a.t.e.b bVar) {
        this.f64652a = null;
        this.f64653b = BdAsyncTaskParallelType.MAX_PARALLEL;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f64653b = bdAsyncTaskParallelType;
            this.f64652a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        return this.f64654c;
    }

    public int b() {
        d.a.t.e.b bVar = this.f64652a;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    public BdAsyncTaskParallelType c() {
        return this.f64653b;
    }
}
