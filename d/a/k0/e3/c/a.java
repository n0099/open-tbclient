package d.a.k0.e3.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.e3.b.a f54695a;

    /* renamed from: b  reason: collision with root package name */
    public c f54696b;

    /* renamed from: c  reason: collision with root package name */
    public c f54697c = new C1319a();

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.j.d.a> f54698d = new b();

    /* renamed from: d.a.k0.e3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1319a implements c {
        public C1319a() {
        }

        @Override // d.a.k0.e3.c.a.c
        public void a() {
            a.this.f54695a = null;
            if (a.this.f54696b != null) {
                a.this.f54696b.a();
            }
        }

        @Override // d.a.k0.e3.c.a.c
        public void b(d.a.k0.e3.b.a aVar) {
            a.this.f54695a = aVar;
            if (a.this.f54696b != null) {
                a.this.f54696b.b(aVar);
            }
        }

        @Override // d.a.k0.e3.c.a.c
        public void c(Object obj) {
            if (a.this.f54696b != null) {
                a.this.f54696b.c(obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public b() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.f54696b != null) {
                a.this.f54696b.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar == null || aVar.p() == null) {
                if (a.this.f54696b != null) {
                    a.this.f54696b.a();
                }
            } else if (a.this.f54696b != null) {
                a.this.f54696b.c(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b(d.a.k0.e3.b.a aVar);

        void c(Object obj);
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<String, Void, Object> {

        /* renamed from: a  reason: collision with root package name */
        public c f54701a;

        public d(a aVar, c cVar) {
            this.f54701a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Object doInBackground(String... strArr) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/splashSchedule");
            String postNetData = netWork.postNetData();
            if (!netWork.getNetContext().getResponse().isRequestSuccess() || c(postNetData)) {
                return null;
            }
            d.a.k0.e3.b.a aVar = new d.a.k0.e3.b.a();
            aVar.b(postNetData);
            return aVar;
        }

        public final boolean c(String str) {
            if (str != null) {
                try {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(str);
                    return errorData.error_code != 0;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return true;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            c cVar = this.f54701a;
            if (cVar != null) {
                if (obj instanceof d.a.k0.e3.b.a) {
                    cVar.b((d.a.k0.e3.b.a) obj);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public d.a.k0.e3.b.b c() {
        d.a.k0.e3.b.a aVar = this.f54695a;
        if (aVar != null && !ListUtils.isEmpty(aVar.f54687a)) {
            for (d.a.k0.e3.b.b bVar : this.f54695a.f54687a) {
                if (bVar != null && bVar.b() && bVar.f54690b == 3) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void d() {
        d dVar = new d(this, this.f54697c);
        dVar.setSelfExecute(true);
        dVar.execute(new String[0]);
    }

    public void e() {
        d.a.k0.e3.b.b c2 = c();
        if (c2 != null && !TextUtils.isEmpty(c2.f54693e)) {
            f(c2.f54692d, c2.f54693e, true);
            return;
        }
        c cVar = this.f54696b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f(int i2, String str, boolean z) {
        if (i2 == 1 || i2 == 2) {
            if (z) {
                d.a.c.e.l.d.h().m(str, 10, this.f54698d, null);
            } else {
                d.a.c.e.l.d.h().m(str, 10, null, null);
            }
        }
    }

    public void g() {
        d.a.k0.e3.b.a aVar = this.f54695a;
        if (aVar == null || ListUtils.isEmpty(aVar.f54687a)) {
            return;
        }
        d.a.k0.e3.b.b c2 = c();
        for (d.a.k0.e3.b.b bVar : this.f54695a.f54687a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f54690b != 4) {
                f(bVar.f54692d, bVar.f54693e, false);
            }
        }
    }

    public void h(c cVar) {
        this.f54696b = cVar;
    }
}
