package d.a.v.a;

import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import java.security.InvalidParameterException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.v.e.b f64705a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f64706b;

    /* renamed from: c  reason: collision with root package name */
    public int f64707c = 1;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, d.a.v.e.b bVar) {
        this.f64705a = null;
        this.f64706b = BdAsyncTaskParallelType.MAX_PARALLEL;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f64706b = bdAsyncTaskParallelType;
            this.f64705a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        return this.f64707c;
    }

    public int b() {
        d.a.v.e.b bVar = this.f64705a;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    public BdAsyncTaskParallelType c() {
        return this.f64706b;
    }
}
