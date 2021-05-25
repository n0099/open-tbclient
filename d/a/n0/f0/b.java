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
    public static b f54263a;

    /* renamed from: d.a.n0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1302b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f54264d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f54265a;

        /* renamed from: b  reason: collision with root package name */
        public String f54266b;

        /* renamed from: c  reason: collision with root package name */
        public long f54267c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f54265a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.a.n0.f0.i.d.m().n(this.f54266b, (int) this.f54267c, false);
        }

        public C1302b(String str) {
            this.f54265a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f54264d));
            this.f54266b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f54266b);
                    this.f54265a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f54267c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f54265a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f54265a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f54265a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f54265a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f54265a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.a.n0.f0.i.d.m().n(this.f54266b, (int) this.f54267c, booleanValue);
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f54266b);
            statsItem.c("speed", Integer.valueOf((int) this.f54267c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f54263a == null) {
            synchronized (b.class) {
                if (f54263a == null) {
                    f54263a = new b();
                }
            }
        }
        return f54263a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1302b(str).execute(new String[0]);
        }
    }
}
