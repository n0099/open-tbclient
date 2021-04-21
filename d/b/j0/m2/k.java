package d.b.j0.m2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f58819a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58820b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f58821c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58822d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.j0.l2.b> f58823e = new ArrayList();

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.j0.t1.d.a(d.b.j0.t1.f.f62987b);
            d.b.j0.t1.d.a(d.b.j0.t1.f.f62988c);
            d.b.j0.t1.d.a(d.b.j0.t1.f.f62989d);
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                File file = new File(d.b.j0.t1.f.f62990e + d.b.j0.t1.f.f62986a + lVar.f58825b + d.b.j0.t1.f.f62986a + "debug");
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f58824a.a().toString());
                sb.append("\n");
                d.b.j0.t1.d.g(file, sb.toString(), true);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
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
                d.b.j0.t1.d.g(new File(d.b.j0.t1.f.f62990e + d.b.j0.t1.f.f62986a + eVar.f58796d + d.b.j0.t1.f.f62986a + "kpi"), k.e(eVar.f58793a, eVar.f58794b, eVar.f58795c).toString(), false);
            }
            return null;
        }
    }

    static {
        if (d.b.c.e.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }

    public k(String str) {
        this.f58819a = str;
    }

    public static final JSONObject e(boolean z, int i, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("postSuccess", (z2 && z) ? 1 : 0);
            jSONObject.put("errorTimes", i);
            if (!z2) {
                i2 = 0;
            }
            jSONObject.put("posted", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(d.b.j0.l2.b bVar) {
        this.f58823e.add(bVar);
        c();
        m(bVar);
        l();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!ListUtils.isEmpty(this.f58823e)) {
                int size = this.f58823e.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.f58823e.get(i).a());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void c() {
        if (d.b.c.e.p.f.c()) {
            File file = new File(d.b.j0.t1.f.f62990e + d.b.j0.t1.f.f62986a + this.f58819a + d.b.j0.t1.f.f62986a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        return e(this.f58820b, this.f58821c, this.f58822d);
    }

    public void f() {
        this.f58821c++;
    }

    public boolean g() {
        return this.f58821c > 0;
    }

    public boolean h() {
        return this.f58822d;
    }

    public void i() {
        this.f58820b = false;
    }

    public void j() {
        this.f58820b = true;
    }

    public void k() {
        this.f58822d = true;
    }

    public final void l() {
        if (d.b.c.e.p.f.c()) {
            new c(this).execute(new e(this.f58820b, this.f58821c, this.f58822d, this.f58819a));
        }
    }

    public final void m(d.b.j0.l2.b bVar) {
        if (!d.b.c.e.p.f.c() || bVar == null) {
            return;
        }
        new b(this).execute(new l(bVar, this.f58819a));
    }
}
