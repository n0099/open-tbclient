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
    public String f61410a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61411b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f61412c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61413d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.n0.m2.b> f61414e = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.a.n0.u1.d.a(d.a.n0.u1.f.f65036b);
            d.a.n0.u1.d.a(d.a.n0.u1.f.f65037c);
            d.a.n0.u1.d.a(d.a.n0.u1.f.f65038d);
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
                File file = new File(d.a.n0.u1.f.f65039e + d.a.n0.u1.f.f65035a + lVar.f61416b + d.a.n0.u1.f.f65035a + "debug");
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f61415a.a().toString());
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
                d.a.n0.u1.d.g(new File(d.a.n0.u1.f.f65039e + d.a.n0.u1.f.f65035a + eVar.f61385d + d.a.n0.u1.f.f65035a + "kpi"), k.e(eVar.f61382a, eVar.f61383b, eVar.f61384c).toString(), false);
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
        this.f61410a = str;
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
        this.f61414e.add(bVar);
        c();
        m(bVar);
        l();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!ListUtils.isEmpty(this.f61414e)) {
                int size = this.f61414e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(this.f61414e.get(i2).a());
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
            File file = new File(d.a.n0.u1.f.f65039e + d.a.n0.u1.f.f65035a + this.f61410a + d.a.n0.u1.f.f65035a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        return e(this.f61411b, this.f61412c, this.f61413d);
    }

    public void f() {
        this.f61412c++;
    }

    public boolean g() {
        return this.f61412c > 0;
    }

    public boolean h() {
        return this.f61413d;
    }

    public void i() {
        this.f61411b = false;
    }

    public void j() {
        this.f61411b = true;
    }

    public void k() {
        this.f61413d = true;
    }

    public final void l() {
        if (d.a.c.e.p.f.c()) {
            new c(this).execute(new e(this.f61411b, this.f61412c, this.f61413d, this.f61410a));
        }
    }

    public final void m(d.a.n0.m2.b bVar) {
        if (!d.a.c.e.p.f.c() || bVar == null) {
            return;
        }
        new b(this).execute(new l(bVar, this.f61410a));
    }
}
