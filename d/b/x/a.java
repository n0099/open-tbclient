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
    public String f64827a;

    /* renamed from: b  reason: collision with root package name */
    public d f64828b;

    /* renamed from: c  reason: collision with root package name */
    public String f64829c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f64830d;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f64834h;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64831e = true;

    /* renamed from: f  reason: collision with root package name */
    public int f64832f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64833g = false;
    public c i = null;
    public boolean j = false;
    public long k = 0;

    /* renamed from: d.b.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1776a implements Runnable {
        public RunnableC1776a() {
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
        public a f64837a;

        /* renamed from: b  reason: collision with root package name */
        public HttpNetContext f64838b;

        /* renamed from: c  reason: collision with root package name */
        public NetWork f64839c = null;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64840d = false;

        /* renamed from: e  reason: collision with root package name */
        public long f64841e = 0;

        public c(a aVar) {
            this.f64837a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            String postNetData;
            this.f64841e = System.currentTimeMillis() - this.f64837a.k();
            this.f64837a.f64833g = true;
            this.f64839c = new NetWork(this.f64837a.h());
            HashMap<String, Object> j = this.f64837a.j();
            if (j != null && !j.isEmpty()) {
                for (Map.Entry<String, Object> entry : j.entrySet()) {
                    this.f64839c.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            if (this.f64837a.i() && j != null) {
                this.f64839c.addPostData("debugfile", (byte[]) j.get("debugfile"));
                postNetData = this.f64839c.postMultiNetData();
            } else {
                postNetData = this.f64839c.postNetData();
            }
            this.f64838b = this.f64839c.getNetContext();
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
            this.f64837a.f64833g = false;
            if (this.f64837a.f64834h != null) {
                e.a().removeCallbacks(this.f64837a.f64834h);
            }
            HttpNetContext httpNetContext = this.f64838b;
            if (httpNetContext != null && httpNetContext.getResponse() != null && !this.f64840d && this.f64837a.f64828b != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("server", this.f64837a.h());
                hashMap.put(RetrieveTaskManager.KEY, this.f64837a.h());
                hashMap.put("state", this.f64838b.getStat().stat.f41784h);
                if (this.f64838b.getPerformance() != null && this.f64837a.k() > 0 && this.f64838b.getPerformance().containsKey("startTime")) {
                    long f2 = d.b.b.e.m.b.f(this.f64838b.getPerformance().get("startTime"), 0L) - this.f64837a.k();
                    if (f2 > 0) {
                        this.f64838b.getPerformance().put("taskWaitTime", String.valueOf(f2));
                    }
                    if (this.f64841e < 20000) {
                        this.f64838b.getPerformance().put("queneTime", String.valueOf(this.f64841e));
                    }
                }
                this.f64837a.f64828b.a(hashMap, this.f64838b.getPerformance(), this.f64838b.getResponse().mServerErrorCode, this.f64838b.getResponse().mErrorString, strArr[0], this.f64837a.f64827a);
            }
            this.f64837a.o();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            this.f64840d = true;
            super.cancel(true);
            NetWork netWork = this.f64839c;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            if (this.f64837a.f64828b != null) {
                this.f64837a.f64828b.a(null, null, -1, "cancle", "", this.f64837a.f64827a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, int i, String str, Object obj, String str2);
    }

    public a(String str) {
        this.f64827a = str;
    }

    @Override // d.b.x.b.d
    public boolean a() {
        c cVar;
        if (this.f64833g && (cVar = this.i) != null) {
            cVar.cancel();
        }
        this.f64833g = false;
        return true;
    }

    public String h() {
        return this.f64829c;
    }

    public boolean i() {
        return this.j;
    }

    public HashMap<String, Object> j() {
        return this.f64830d;
    }

    public long k() {
        return this.k;
    }

    public Runnable l() {
        if (this.f64834h == null) {
            this.f64834h = new b();
        }
        return this.f64834h;
    }

    public boolean m() {
        if (this.f64828b == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.f64831e = l.C();
        if (this.f64832f >= 10) {
            e.a().postDelayed(l(), this.f64832f * 1000);
        }
        if (!this.f64831e) {
            e.a().post(new RunnableC1776a());
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
        d dVar = this.f64828b;
        if (dVar != null) {
            dVar.a(null, null, i, str, null, this.f64827a);
        }
    }

    public final void o() {
        this.i = null;
    }

    public void p(d dVar) {
        this.f64828b = dVar;
    }

    public void q(String str) {
        this.f64829c = str;
    }

    public void r(boolean z) {
        this.j = z;
    }

    public void s(HashMap<String, Object> hashMap) {
        this.f64830d = hashMap;
    }

    public void t(long j) {
        this.k = j;
    }
}
