package d.a.o0.f0;

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
    public static b f58077a;

    /* renamed from: d.a.o0.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1362b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f58078d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f58079a;

        /* renamed from: b  reason: collision with root package name */
        public String f58080b;

        /* renamed from: c  reason: collision with root package name */
        public long f58081c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f58079a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.a.o0.f0.i.d.m().n(this.f58080b, (int) this.f58081c, false);
        }

        public C1362b(String str) {
            this.f58079a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f58078d));
            this.f58080b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f58080b);
                    this.f58079a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f58081c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f58079a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f58079a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f58079a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f58079a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f58079a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.a.o0.f0.i.d.m().n(this.f58080b, (int) this.f58081c, booleanValue);
            d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f58080b);
            statsItem.c("speed", Integer.valueOf((int) this.f58081c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f58077a == null) {
            synchronized (b.class) {
                if (f58077a == null) {
                    f58077a = new b();
                }
            }
        }
        return f58077a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1362b(str).execute(new String[0]);
        }
    }
}
