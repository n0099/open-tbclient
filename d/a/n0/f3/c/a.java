package d.a.n0.f3.c;

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
    public d.a.n0.f3.b.a f54885a;

    /* renamed from: b  reason: collision with root package name */
    public c f54886b;

    /* renamed from: c  reason: collision with root package name */
    public c f54887c = new C1337a();

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.l.c<d.a.c.j.d.a> f54888d = new b();

    /* renamed from: d.a.n0.f3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1337a implements c {
        public C1337a() {
        }

        @Override // d.a.n0.f3.c.a.c
        public void a() {
            a.this.f54885a = null;
            if (a.this.f54886b != null) {
                a.this.f54886b.a();
            }
        }

        @Override // d.a.n0.f3.c.a.c
        public void b(d.a.n0.f3.b.a aVar) {
            a.this.f54885a = aVar;
            if (a.this.f54886b != null) {
                a.this.f54886b.b(aVar);
            }
        }

        @Override // d.a.n0.f3.c.a.c
        public void c(Object obj) {
            if (a.this.f54886b != null) {
                a.this.f54886b.c(obj);
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
            if (a.this.f54886b != null) {
                a.this.f54886b.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((b) aVar, str, i2);
            if (aVar == null || aVar.p() == null) {
                if (a.this.f54886b != null) {
                    a.this.f54886b.a();
                }
            } else if (a.this.f54886b != null) {
                a.this.f54886b.c(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b(d.a.n0.f3.b.a aVar);

        void c(Object obj);
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<String, Void, Object> {

        /* renamed from: a  reason: collision with root package name */
        public c f54891a;

        public d(a aVar, c cVar) {
            this.f54891a = cVar;
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
            d.a.n0.f3.b.a aVar = new d.a.n0.f3.b.a();
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
            c cVar = this.f54891a;
            if (cVar != null) {
                if (obj instanceof d.a.n0.f3.b.a) {
                    cVar.b((d.a.n0.f3.b.a) obj);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public d.a.n0.f3.b.b c() {
        d.a.n0.f3.b.a aVar = this.f54885a;
        if (aVar != null && !ListUtils.isEmpty(aVar.f54877a)) {
            for (d.a.n0.f3.b.b bVar : this.f54885a.f54877a) {
                if (bVar != null && bVar.b() && bVar.f54880b == 3) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void d() {
        d dVar = new d(this, this.f54887c);
        dVar.setSelfExecute(true);
        dVar.execute(new String[0]);
    }

    public void e() {
        d.a.n0.f3.b.b c2 = c();
        if (c2 != null && !TextUtils.isEmpty(c2.f54883e)) {
            f(c2.f54882d, c2.f54883e, true);
            return;
        }
        c cVar = this.f54886b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f(int i2, String str, boolean z) {
        if (i2 == 1 || i2 == 2) {
            if (z) {
                d.a.c.e.l.d.h().m(str, 10, this.f54888d, null);
            } else {
                d.a.c.e.l.d.h().m(str, 10, null, null);
            }
        }
    }

    public void g() {
        d.a.n0.f3.b.a aVar = this.f54885a;
        if (aVar == null || ListUtils.isEmpty(aVar.f54877a)) {
            return;
        }
        d.a.n0.f3.b.b c2 = c();
        for (d.a.n0.f3.b.b bVar : this.f54885a.f54877a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f54880b != 4) {
                f(bVar.f54882d, bVar.f54883e, false);
            }
        }
    }

    public void h(c cVar) {
        this.f54886b = cVar;
    }
}
