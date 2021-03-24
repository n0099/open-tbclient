package d.b.h0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f51692a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f51693b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f51692a);

    /* loaded from: classes3.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f51694a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f51695b;

        public a(f0<T> f0Var, n<T> nVar) {
            this.f51694a = null;
            this.f51695b = null;
            this.f51694a = f0Var;
            this.f51695b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            try {
                if (this.f51694a != null) {
                    return this.f51694a.doInBackground();
                }
                return null;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            n<T> nVar = this.f51695b;
            if (nVar != null) {
                nVar.onReturnDataInUI(t);
            }
        }
    }

    public static void a() {
        BdAsyncTask.removeAllTask(f51692a);
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(f51693b);
            aVar.setTag(f51692a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void c(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(f51692a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }
}
