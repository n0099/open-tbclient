package d.a.v.d;

import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d.a.v.e.b f64708a = d.a.v.e.b.a();

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.v.a.c f64709b = new d.a.v.a.c(BdAsyncTaskParallelType.SERIAL, f64708a);

    /* renamed from: d.a.v.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1813a<T> extends BdAsyncTask<String, Object, T> {
        public b<T> m;
        public c<T> n;

        public C1813a(b<T> bVar, c<T> cVar) {
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
                d.a.v.e.a.c(th);
                return null;
            }
        }
    }

    public static <T> BdAsyncTask a(b<T> bVar, c<T> cVar) {
        return b(bVar, cVar, 2);
    }

    public static <T> BdAsyncTask b(b<T> bVar, c<T> cVar, int i2) {
        if (bVar != null) {
            C1813a c1813a = new C1813a(bVar, cVar);
            c1813a.v(f64709b);
            c1813a.x(f64708a);
            c1813a.w(i2);
            c1813a.g(new String[0]);
            return c1813a;
        }
        return null;
    }
}
