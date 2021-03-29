package d.b.i0.e0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.p.j;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f54215a;

    /* renamed from: d.b.i0.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1225b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f54216d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f54217a;

        /* renamed from: b  reason: collision with root package name */
        public String f54218b;

        /* renamed from: c  reason: collision with root package name */
        public long f54219c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f54217a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.b.i0.e0.i.d.m().n(this.f54218b, (int) this.f54219c, false);
        }

        public C1225b(String str) {
            this.f54217a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f54216d));
            this.f54218b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f54218b);
                    this.f54217a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f54219c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f54217a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f54217a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f54217a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f54217a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f54217a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.b.i0.e0.i.d.m().n(this.f54218b, (int) this.f54219c, booleanValue);
            d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f54218b);
            statsItem.c("speed", Integer.valueOf((int) this.f54219c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f54215a == null) {
            synchronized (b.class) {
                if (f54215a == null) {
                    f54215a = new b();
                }
            }
        }
        return f54215a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1225b(str).execute(new String[0]);
        }
    }
}
