package d.a.j0.e3.c;

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
    public d.a.j0.e3.b.a f53988a;

    /* renamed from: b  reason: collision with root package name */
    public c f53989b;

    /* renamed from: c  reason: collision with root package name */
    public c f53990c = new C1247a();

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.j.d.a> f53991d = new b();

    /* renamed from: d.a.j0.e3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1247a implements c {
        public C1247a() {
        }

        @Override // d.a.j0.e3.c.a.c
        public void a() {
            a.this.f53988a = null;
            if (a.this.f53989b != null) {
                a.this.f53989b.a();
            }
        }

        @Override // d.a.j0.e3.c.a.c
        public void b(d.a.j0.e3.b.a aVar) {
            a.this.f53988a = aVar;
            if (a.this.f53989b != null) {
                a.this.f53989b.b(aVar);
            }
        }

        @Override // d.a.j0.e3.c.a.c
        public void c(Object obj) {
            if (a.this.f53989b != null) {
                a.this.f53989b.c(obj);
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
            if (a.this.f53989b != null) {
                a.this.f53989b.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar == null || aVar.p() == null) {
                if (a.this.f53989b != null) {
                    a.this.f53989b.a();
                }
            } else if (a.this.f53989b != null) {
                a.this.f53989b.c(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b(d.a.j0.e3.b.a aVar);

        void c(Object obj);
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<String, Void, Object> {

        /* renamed from: a  reason: collision with root package name */
        public c f53994a;

        public d(a aVar, c cVar) {
            this.f53994a = cVar;
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
            d.a.j0.e3.b.a aVar = new d.a.j0.e3.b.a();
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
            c cVar = this.f53994a;
            if (cVar != null) {
                if (obj instanceof d.a.j0.e3.b.a) {
                    cVar.b((d.a.j0.e3.b.a) obj);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public d.a.j0.e3.b.b c() {
        d.a.j0.e3.b.a aVar = this.f53988a;
        if (aVar != null && !ListUtils.isEmpty(aVar.f53980a)) {
            for (d.a.j0.e3.b.b bVar : this.f53988a.f53980a) {
                if (bVar != null && bVar.b() && bVar.f53983b == 3) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void d() {
        d dVar = new d(this, this.f53990c);
        dVar.setSelfExecute(true);
        dVar.execute(new String[0]);
    }

    public void e() {
        d.a.j0.e3.b.b c2 = c();
        if (c2 != null && !TextUtils.isEmpty(c2.f53986e)) {
            f(c2.f53985d, c2.f53986e, true);
            return;
        }
        c cVar = this.f53989b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f(int i2, String str, boolean z) {
        if (i2 == 1 || i2 == 2) {
            if (z) {
                d.a.c.e.l.d.h().m(str, 10, this.f53991d, null);
            } else {
                d.a.c.e.l.d.h().m(str, 10, null, null);
            }
        }
    }

    public void g() {
        d.a.j0.e3.b.a aVar = this.f53988a;
        if (aVar == null || ListUtils.isEmpty(aVar.f53980a)) {
            return;
        }
        d.a.j0.e3.b.b c2 = c();
        for (d.a.j0.e3.b.b bVar : this.f53988a.f53980a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f53983b != 4) {
                f(bVar.f53985d, bVar.f53986e, false);
            }
        }
    }

    public void h(c cVar) {
        this.f53989b = cVar;
    }
}
