package d.a.j0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.j;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f53366a;

    /* renamed from: d.a.j0.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1212b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f53367d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f53368a;

        /* renamed from: b  reason: collision with root package name */
        public String f53369b;

        /* renamed from: c  reason: collision with root package name */
        public long f53370c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f53368a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.a.j0.e0.i.d.m().n(this.f53369b, (int) this.f53370c, false);
        }

        public C1212b(String str) {
            this.f53368a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f53367d));
            this.f53369b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f53369b);
                    this.f53368a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f53370c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f53368a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f53368a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f53368a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f53368a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f53368a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.a.j0.e0.i.d.m().n(this.f53369b, (int) this.f53370c, booleanValue);
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f53369b);
            statsItem.c("speed", Integer.valueOf((int) this.f53370c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f53366a == null) {
            synchronized (b.class) {
                if (f53366a == null) {
                    f53366a = new b();
                }
            }
        }
        return f53366a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1212b(str).execute(new String[0]);
        }
    }
}
