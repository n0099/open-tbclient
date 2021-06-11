package d.a.v.a;

import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import java.security.InvalidParameterException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.v.e.b f68423a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f68424b;

    /* renamed from: c  reason: collision with root package name */
    public int f68425c = 1;

    public c(BdAsyncTaskParallelType bdAsyncTaskParallelType, d.a.v.e.b bVar) {
        this.f68423a = null;
        this.f68424b = BdAsyncTaskParallelType.MAX_PARALLEL;
        if (bdAsyncTaskParallelType != null && bVar != null) {
            this.f68424b = bdAsyncTaskParallelType;
            this.f68423a = bVar;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        return this.f68425c;
    }

    public int b() {
        d.a.v.e.b bVar = this.f68423a;
        if (bVar == null) {
            return 0;
        }
        return bVar.b();
    }

    public BdAsyncTaskParallelType c() {
        return this.f68424b;
    }
}
