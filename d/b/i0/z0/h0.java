package d.b.i0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f52453a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f52454b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f52453a);

    /* loaded from: classes3.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f52455a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f52456b;

        public a(f0<T> f0Var, n<T> nVar) {
            this.f52455a = null;
            this.f52456b = null;
            this.f52455a = f0Var;
            this.f52456b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            try {
                if (this.f52455a != null) {
                    return this.f52455a.doInBackground();
                }
                return null;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            n<T> nVar = this.f52456b;
            if (nVar != null) {
                nVar.onReturnDataInUI(t);
            }
        }
    }

    public static void a() {
        BdAsyncTask.removeAllTask(f52453a);
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(f52454b);
            aVar.setTag(f52453a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void c(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(f52453a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }
}
