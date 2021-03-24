package d.b.i0.d3.c;

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
    public d.b.i0.d3.b.a f54170a;

    /* renamed from: b  reason: collision with root package name */
    public c f54171b;

    /* renamed from: c  reason: collision with root package name */
    public c f54172c = new C1221a();

    /* renamed from: d  reason: collision with root package name */
    public d.b.b.e.l.c<d.b.b.j.d.a> f54173d = new b();

    /* renamed from: d.b.i0.d3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1221a implements c {
        public C1221a() {
        }

        @Override // d.b.i0.d3.c.a.c
        public void a() {
            a.this.f54170a = null;
            if (a.this.f54171b != null) {
                a.this.f54171b.a();
            }
        }

        @Override // d.b.i0.d3.c.a.c
        public void b(Object obj) {
            if (a.this.f54171b != null) {
                a.this.f54171b.b(obj);
            }
        }

        @Override // d.b.i0.d3.c.a.c
        public void c(d.b.i0.d3.b.a aVar) {
            a.this.f54170a = aVar;
            if (a.this.f54171b != null) {
                a.this.f54171b.c(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public b() {
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (a.this.f54171b != null) {
                a.this.f54171b.a();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((b) aVar, str, i);
            if (aVar == null || aVar.p() == null) {
                if (a.this.f54171b != null) {
                    a.this.f54171b.a();
                }
            } else if (a.this.f54171b != null) {
                a.this.f54171b.b(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void b(Object obj);

        void c(d.b.i0.d3.b.a aVar);
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<String, Void, Object> {

        /* renamed from: a  reason: collision with root package name */
        public c f54176a;

        public d(a aVar, c cVar) {
            this.f54176a = cVar;
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
            d.b.i0.d3.b.a aVar = new d.b.i0.d3.b.a();
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
            c cVar = this.f54176a;
            if (cVar != null) {
                if (obj instanceof d.b.i0.d3.b.a) {
                    cVar.c((d.b.i0.d3.b.a) obj);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public d.b.i0.d3.b.b c() {
        d.b.i0.d3.b.a aVar = this.f54170a;
        if (aVar != null && !ListUtils.isEmpty(aVar.f54162a)) {
            for (d.b.i0.d3.b.b bVar : this.f54170a.f54162a) {
                if (bVar != null && bVar.b() && bVar.f54165b == 3) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void d() {
        d dVar = new d(this, this.f54172c);
        dVar.setSelfExecute(true);
        dVar.execute(new String[0]);
    }

    public void e() {
        d.b.i0.d3.b.b c2 = c();
        if (c2 != null && !TextUtils.isEmpty(c2.f54168e)) {
            f(c2.f54167d, c2.f54168e, true);
            return;
        }
        c cVar = this.f54171b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f(int i, String str, boolean z) {
        if (i == 1 || i == 2) {
            if (z) {
                d.b.b.e.l.d.h().m(str, 10, this.f54173d, null);
            } else {
                d.b.b.e.l.d.h().m(str, 10, null, null);
            }
        }
    }

    public void g() {
        d.b.i0.d3.b.a aVar = this.f54170a;
        if (aVar == null || ListUtils.isEmpty(aVar.f54162a)) {
            return;
        }
        d.b.i0.d3.b.b c2 = c();
        for (d.b.i0.d3.b.b bVar : this.f54170a.f54162a) {
            if (bVar != null && bVar != c2 && bVar.b() && bVar.f54165b != 4) {
                f(bVar.f54167d, bVar.f54168e, false);
            }
        }
    }

    public void h(c cVar) {
        this.f54171b = cVar;
    }
}
