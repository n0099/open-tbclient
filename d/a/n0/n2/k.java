package d.a.n0.n2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f57721a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57722b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f57723c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57724d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.m2.b> f57725e = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.a.n0.u1.d.a(d.a.n0.u1.f.f61323b);
            d.a.n0.u1.d.a(d.a.n0.u1.f.f61324c);
            d.a.n0.u1.d.a(d.a.n0.u1.f.f61325d);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<l, Void, Void> {
        public b(k kVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(l... lVarArr) {
            if (lVarArr == null || lVarArr.length != 1 || lVarArr[0] == null) {
                return null;
            }
            l lVar = lVarArr[0];
            synchronized ("debug") {
                File file = new File(d.a.n0.u1.f.f61326e + d.a.n0.u1.f.f61322a + lVar.f57727b + d.a.n0.u1.f.f61322a + "debug");
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f57726a.a().toString());
                sb.append("\n");
                d.a.n0.u1.d.g(file, sb.toString(), true);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<e, Void, Void> {
        public c(k kVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(e... eVarArr) {
            if (eVarArr == null || eVarArr.length != 1 || eVarArr[0] == null) {
                return null;
            }
            e eVar = eVarArr[0];
            synchronized ("kpi") {
                d.a.n0.u1.d.g(new File(d.a.n0.u1.f.f61326e + d.a.n0.u1.f.f61322a + eVar.f57696d + d.a.n0.u1.f.f61322a + "kpi"), k.e(eVar.f57693a, eVar.f57694b, eVar.f57695c).toString(), false);
            }
            return null;
        }
    }

    static {
        if (d.a.c.e.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }

    public k(String str) {
        this.f57721a = str;
    }

    public static final JSONObject e(boolean z, int i2, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("postSuccess", (z2 && z) ? 1 : 0);
            jSONObject.put("errorTimes", i2);
            if (!z2) {
                i3 = 0;
            }
            jSONObject.put("posted", i3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(d.a.n0.m2.b bVar) {
        this.f57725e.add(bVar);
        c();
        m(bVar);
        l();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!ListUtils.isEmpty(this.f57725e)) {
                int size = this.f57725e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(this.f57725e.get(i2).a());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void c() {
        if (d.a.c.e.p.f.c()) {
            File file = new File(d.a.n0.u1.f.f61326e + d.a.n0.u1.f.f61322a + this.f57721a + d.a.n0.u1.f.f61322a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        return e(this.f57722b, this.f57723c, this.f57724d);
    }

    public void f() {
        this.f57723c++;
    }

    public boolean g() {
        return this.f57723c > 0;
    }

    public boolean h() {
        return this.f57724d;
    }

    public void i() {
        this.f57722b = false;
    }

    public void j() {
        this.f57722b = true;
    }

    public void k() {
        this.f57724d = true;
    }

    public final void l() {
        if (d.a.c.e.p.f.c()) {
            new c(this).execute(new e(this.f57722b, this.f57723c, this.f57724d, this.f57721a));
        }
    }

    public final void m(d.a.n0.m2.b bVar) {
        if (!d.a.c.e.p.f.c() || bVar == null) {
            return;
        }
        new b(this).execute(new l(bVar, this.f57721a));
    }
}
