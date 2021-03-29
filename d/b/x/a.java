package d.b.x;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import d.b.x.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements b.d {

    /* renamed from: a  reason: collision with root package name */
    public String f64828a;

    /* renamed from: b  reason: collision with root package name */
    public d f64829b;

    /* renamed from: c  reason: collision with root package name */
    public String f64830c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f64831d;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f64835h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64832e = true;

    /* renamed from: f  reason: collision with root package name */
    public int f64833f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64834g = false;
    public c i = null;
    public boolean j = false;
    public long k = 0;

    /* renamed from: d.b.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1777a implements Runnable {
        public RunnableC1777a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n(-1, "网络不可用");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n(-1, OneKeyLoginResult.m);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends BdAsyncTask<Object, String, String> {

        /* renamed from: a  reason: collision with root package name */
        public a f64838a;

        /* renamed from: b  reason: collision with root package name */
        public HttpNetContext f64839b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f64840c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64841d = false;

        /* renamed from: e  reason: collision with root package name */
        public long f64842e = 0;

        public c(a aVar) {
            this.f64838a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.f64842e = System.currentTimeMillis() - this.f64838a.k();
            this.f64838a.f64834g = true;
            this.f64840c = new NetWork(this.f64838a.h());
            HashMap<String, Object> j = this.f64838a.j();
            if (j != null && !j.isEmpty()) {
                for (Map.Entry<String, Object> entry : j.entrySet()) {
                    this.f64840c.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.f64838a.i() && j != null) {
                this.f64840c.addPostData("debugfile", (byte[]) j.get("debugfile"));
                postNetData = this.f64840c.postMultiNetData();
            } else {
                postNetData = this.f64840c.postNetData();
            }
            this.f64839b = this.f64840c.getNetContext();
            publishProgress(postNetData);
            return postNetData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onProgressUpdate(String... strArr) {
            super.onProgressUpdate(strArr);
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            this.f64838a.f64834g = false;
            if (this.f64838a.f64835h != null) {
                e.a().removeCallbacks(this.f64838a.f64835h);
            }
            HttpNetContext httpNetContext = this.f64839b;
            if (httpNetContext != null && httpNetContext.getResponse() != null && !this.f64841d && this.f64838a.f64829b != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("server", this.f64838a.h());
                hashMap.put(RetrieveTaskManager.KEY, this.f64838a.h());
                hashMap.put("state", this.f64839b.getStat().stat.f41785h);
                if (this.f64839b.getPerformance() != null && this.f64838a.k() > 0 && this.f64839b.getPerformance().containsKey("startTime")) {
                    long f2 = d.b.b.e.m.b.f(this.f64839b.getPerformance().get("startTime"), 0L) - this.f64838a.k();
                    if (f2 > 0) {
                        this.f64839b.getPerformance().put("taskWaitTime", String.valueOf(f2));
                    }
                    if (this.f64842e < 20000) {
                        this.f64839b.getPerformance().put("queneTime", String.valueOf(this.f64842e));
                    }
                }
                this.f64838a.f64829b.a(hashMap, this.f64839b.getPerformance(), this.f64839b.getResponse().mServerErrorCode, this.f64839b.getResponse().mErrorString, strArr[0], this.f64838a.f64828a);
            }
            this.f64838a.o();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.f64841d = true;
            super.cancel(true);
            NetWork netWork = this.f64840c;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            if (this.f64838a.f64829b != null) {
                this.f64838a.f64829b.a(null, null, -1, "cancle", "", this.f64838a.f64828a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.f64828a = str;
    }

    @Override // d.b.x.b.d
    public boolean a() {
        c cVar;
        if (this.f64834g && (cVar = this.i) != null) {
            cVar.cancel();
        }
        this.f64834g = false;
        return true;
    }

    public String h() {
        return this.f64830c;
    }

    public boolean i() {
        return this.j;
    }

    public HashMap<String, Object> j() {
        return this.f64831d;
    }

    public long k() {
        return this.k;
    }

    public Runnable l() {
        if (this.f64835h == null) {
            this.f64835h = new b();
        }
        return this.f64835h;
    }

    public boolean m() {
        if (this.f64829b == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.f64832e = l.C();
        if (this.f64833f >= 10) {
            e.a().postDelayed(l(), this.f64833f * 1000);
        }
        if (!this.f64832e) {
            e.a().post(new RunnableC1777a());
            return false;
        } else if (this.i == null) {
            c cVar = new c(this);
            this.i = cVar;
            cVar.execute(new Object[0]);
            return true;
        } else {
            return false;
        }
    }

    public final void n(int i, String str) {
        d dVar = this.f64829b;
        if (dVar != null) {
            dVar.a(null, null, i, str, null, this.f64828a);
        }
    }

    public final void o() {
        this.i = null;
    }

    public void p(d dVar) {
        this.f64829b = dVar;
    }

    public void q(String str) {
        this.f64830c = str;
    }

    public void r(boolean z) {
        this.j = z;
    }

    public void s(HashMap<String, Object> hashMap) {
        this.f64831d = hashMap;
    }

    public void t(long j) {
        this.k = j;
    }
}
