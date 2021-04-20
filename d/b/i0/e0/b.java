package d.b.i0.e0;

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
    public static b f55098a;

    /* renamed from: d.b.i0.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1250b extends BdAsyncTask<String, Void, Boolean> {

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f55099d = BdUniqueId.gen();

        /* renamed from: a  reason: collision with root package name */
        public Process f55100a;

        /* renamed from: b  reason: collision with root package name */
        public String f55101b;

        /* renamed from: c  reason: collision with root package name */
        public long f55102c;

        public final String b() {
            int I = j.I();
            return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            Process process = this.f55100a;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            d.b.i0.e0.i.d.m().n(this.f55101b, (int) this.f55102c, false);
        }

        public C1250b(String str) {
            this.f55100a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f55099d));
            this.f55101b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Process exec = runtime.exec(b() + this.f55101b);
                    this.f55100a = exec;
                    r1 = exec.waitFor() == 0;
                    this.f55102c = System.currentTimeMillis() - currentTimeMillis;
                } catch (Throwable th) {
                    this.f55100a.destroy();
                    throw th;
                }
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.c().a("test_speed", e2.getMessage());
                this.f55100a.destroy();
                return Boolean.valueOf(r1);
            } catch (InterruptedException e3) {
                BdLog.detailException(e3);
                d.c().a("test_speed", e3.getMessage());
                this.f55100a.destroy();
                return Boolean.valueOf(r1);
            } catch (Throwable th2) {
                BdLog.detailException(th2);
                d.c().a("test_speed", th2.getMessage());
                this.f55100a.destroy();
                return Boolean.valueOf(r1);
            }
            this.f55100a.destroy();
            return Boolean.valueOf(r1);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            d.b.i0.e0.i.d.m().n(this.f55101b, (int) this.f55102c, booleanValue);
            d.b.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_testspeed");
            statsItem.c("issuc", Boolean.valueOf(booleanValue));
            statsItem.b("ip", this.f55101b);
            statsItem.c("speed", Integer.valueOf((int) this.f55102c));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }

    public static final b a() {
        if (f55098a == null) {
            synchronized (b.class) {
                if (f55098a == null) {
                    f55098a = new b();
                }
            }
        }
        return f55098a;
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new C1250b(str).execute(new String[0]);
        }
    }
}
