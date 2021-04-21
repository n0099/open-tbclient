package d.b.j0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.p.j;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f55519a;

    /* renamed from: d.b.j0.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1273b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f55520d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f55521a;

        /* renamed from: b  reason: collision with root package name */
        public String f55522b;

        /* renamed from: c  reason: collision with root package name */
        public long f55523c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f55521a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.b.j0.e0.i.d.m().n(this.f55522b, (int) this.f55523c, false);
        }

        public C1273b(String str) {
            this.f55521a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f55520d));
            this.f55522b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f55522b);
                    this.f55521a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f55523c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f55521a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f55521a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f55521a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f55521a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f55521a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.b.j0.e0.i.d.m().n(this.f55522b, (int) this.f55523c, booleanValue);
            d.b.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f55522b);
            statsItem.c("speed", Integer.valueOf((int) this.f55523c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f55519a == null) {
            synchronized (b.class) {
                if (f55519a == null) {
                    f55519a = new b();
                }
            }
        }
        return f55519a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1273b(str).execute(new String[0]);
        }
    }
}
