package d.a.i0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f50132a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f50133b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f50132a);

    /* loaded from: classes3.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f50134a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f50135b;

        public a(f0<T> f0Var, n<T> nVar) {
            this.f50134a = null;
            this.f50135b = null;
            this.f50134a = f0Var;
            this.f50135b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            try {
                if (this.f50134a != null) {
                    return this.f50134a.doInBackground();
                }
                return null;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            n<T> nVar = this.f50135b;
            if (nVar != null) {
                nVar.onReturnDataInUI(t);
            }
        }
    }

    public static void a() {
        BdAsyncTask.removeAllTask(f50132a);
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(f50133b);
            aVar.setTag(f50132a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void c(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(f50132a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }
}
