package d.a.c.e.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {

    /* renamed from: e  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f39599e;

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.f39599e = null;
        this.f39599e = bdAsyncTask;
    }

    public abstract void b();

    public BdAsyncTask<?, ?, ?> c() {
        return this.f39599e;
    }
}
