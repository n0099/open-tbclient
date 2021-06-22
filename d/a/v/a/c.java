package d.a.v.a;

import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import java.security.InvalidParameterException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.v.e.b f68527a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f68528b;

    /* renamed from: c  reason: collision with root package name */
    public int f68529c = 1;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, d.a.v.e.b bVar) {
        this.f68527a = null;
        this.f68528b = BdAsyncTaskParallelType.MAX_PARALLEL;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f68528b = bdAsyncTaskParallelType;
            this.f68527a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        return this.f68529c;
    }

    public int b() {
        d.a.v.e.b bVar = this.f68527a;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    public BdAsyncTaskParallelType c() {
        return this.f68528b;
    }
}
