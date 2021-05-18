package d.a.t.d;

import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d.a.t.e.b f64655a = d.a.t.e.b.a();

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.t.a.c f64656b = new d.a.t.a.c(BdAsyncTaskParallelType.SERIAL, f64655a);

    /* renamed from: d.a.t.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1806a<T> extends BdAsyncTask<String, Object, T> {
        public b<T> m;
        public c<T> n;

        public C1806a(b<T> bVar, c<T> cVar) {
            this.m = null;
            this.n = null;
            this.m = bVar;
            this.n = cVar;
        }

        @Override // com.baidu.live.asynctask.BdAsyncTask
        public void q(T t) {
            c<T> cVar = this.n;
            if (cVar != null) {
                cVar.onReturnDataInUI(t);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.asynctask.BdAsyncTask
        /* renamed from: z */
        public T f(String... strArr) {
            try {
                if (this.m != null) {
                    return this.m.a();
                }
                return null;
            } catch (Throwable th) {
                d.a.t.e.a.c(th);
                return null;
            }
        }
    }

    public static <T> BdAsyncTask a(b<T> bVar, c<T> cVar) {
        return b(bVar, cVar, 2);
    }

    public static <T> BdAsyncTask b(b<T> bVar, c<T> cVar, int i2) {
        if (bVar != null) {
            C1806a c1806a = new C1806a(bVar, cVar);
            c1806a.v(f64656b);
            c1806a.x(f64655a);
            c1806a.w(i2);
            c1806a.g(new String[0]);
            return c1806a;
        }
        return null;
    }
}
