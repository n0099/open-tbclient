package d.a.v.d;

import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d.a.v.e.b f68426a = d.a.v.e.b.a();

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.v.a.c f68427b = new d.a.v.a.c(BdAsyncTaskParallelType.SERIAL, f68426a);

    /* renamed from: d.a.v.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1871a<T> extends BdAsyncTask<String, Object, T> {
        public b<T> m;
        public c<T> n;

        public C1871a(b<T> bVar, c<T> cVar) {
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
            C1871a c1871a = new C1871a(bVar, cVar);
            c1871a.v(f68427b);
            c1871a.x(f68426a);
            c1871a.w(i2);
            c1871a.g(new String[0]);
            return c1871a;
        }
        return null;
    }
}
