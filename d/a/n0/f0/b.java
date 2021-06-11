package d.a.n0.f0;

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
    public static b f57952a;

    /* renamed from: d.a.n0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1358b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f57953d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f57954a;

        /* renamed from: b  reason: collision with root package name */
        public String f57955b;

        /* renamed from: c  reason: collision with root package name */
        public long f57956c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f57954a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.a.n0.f0.i.d.m().n(this.f57955b, (int) this.f57956c, false);
        }

        public C1358b(String str) {
            this.f57954a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f57953d));
            this.f57955b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f57955b);
                    this.f57954a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f57956c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f57954a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f57954a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f57954a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f57954a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f57954a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.a.n0.f0.i.d.m().n(this.f57955b, (int) this.f57956c, booleanValue);
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f57955b);
            statsItem.c("speed", Integer.valueOf((int) this.f57956c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f57952a == null) {
            synchronized (b.class) {
                if (f57952a == null) {
                    f57952a = new b();
                }
            }
        }
        return f57952a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1358b(str).execute(new String[0]);
        }
    }
}
