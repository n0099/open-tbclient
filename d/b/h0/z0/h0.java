package d.b.h0.z0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes3.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final BdUniqueId f52117a = BdUniqueId.gen();

    /* renamed from: b  reason: collision with root package name */
    public static final BdAsyncTaskParallel f52118b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f52117a);

    /* loaded from: classes3.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {

        /* renamed from: a  reason: collision with root package name */
        public f0<T> f52119a;

        /* renamed from: b  reason: collision with root package name */
        public n<T> f52120b;

        public a(f0<T> f0Var, n<T> nVar) {
            this.f52119a = null;
            this.f52120b = null;
            this.f52119a = f0Var;
            this.f52120b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public T doInBackground(String... strArr) {
            try {
                if (this.f52119a != null) {
                    return this.f52119a.doInBackground();
                }
                return null;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            n<T> nVar = this.f52120b;
            if (nVar != null) {
                nVar.onReturnDataInUI(t);
            }
        }
    }

    public static void a() {
        BdAsyncTask.removeAllTask(f52117a);
    }

    public static <T> void b(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(f52118b);
            aVar.setTag(f52117a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }

    public static <T> void c(f0<T> f0Var, n<T> nVar) {
        if (f0Var != null) {
            a aVar = new a(f0Var, nVar);
            aVar.setParallel(TiebaIMConfig.getParallel());
            aVar.setTag(f52117a);
            aVar.setPriority(4);
            aVar.execute(new String[0]);
        }
    }
}
