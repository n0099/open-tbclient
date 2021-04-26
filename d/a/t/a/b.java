package d.a.t.a;

import com.baidu.live.asynctask.BdAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes2.dex */
public abstract class b<V> extends FutureTask<V> {

    /* renamed from: e  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f63964e;

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.f63964e = null;
        this.f63964e = bdAsyncTask;
    }

    public abstract void b();

    public BdAsyncTask<?, ?, ?> c() {
        return this.f63964e;
    }
}
