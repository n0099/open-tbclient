package d.b.b.e.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes.dex */
public abstract class b<V> extends FutureTask<V> {

    /* renamed from: e  reason: collision with root package name */
    public BdAsyncTask<?, ?, ?> f41667e;

    public b(Callable<V> callable, BdAsyncTask<?, ?, ?> bdAsyncTask) {
        super(callable);
        this.f41667e = null;
        this.f41667e = bdAsyncTask;
    }

    public abstract void a();

    public BdAsyncTask<?, ?, ?> b() {
        return this.f41667e;
    }
}
