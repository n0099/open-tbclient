package d.a.n0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f54809a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f54810b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f54809a);

    /* loaded from: classes3.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f54811a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f54812b;

        public a(f0<T> f0Var, n<T> nVar) {
            this.f54811a = null;
            this.f54812b = null;
            this.f54811a = f0Var;
            this.f54812b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            try {
                if (this.f54811a != null) {
                    return this.f54811a.doInBackground();
                }
                return null;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            n<T> nVar = this.f54812b;
            if (nVar != null) {
                nVar.onReturnDataInUI(t);
            }
        }
    }

    public static void a() {
        BdAsyncTask.removeAllTask(f54809a);
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(f54810b);
            aVar.setTag(f54809a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void c(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(f54809a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }
}
