package d.b.i0.l2;

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
    public String f56768a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56769b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f56770c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56771d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.k2.b> f56772e = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.i0.s1.d.a(d.b.i0.s1.f.f60151b);
            d.b.i0.s1.d.a(d.b.i0.s1.f.f60152c);
            d.b.i0.s1.d.a(d.b.i0.s1.f.f60153d);
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
                File file = new File(d.b.i0.s1.f.f60154e + d.b.i0.s1.f.f60150a + lVar.f56774b + d.b.i0.s1.f.f60150a + "debug");
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f56773a.a().toString());
                sb.append("\n");
                d.b.i0.s1.d.g(file, sb.toString(), true);
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
                d.b.i0.s1.d.g(new File(d.b.i0.s1.f.f60154e + d.b.i0.s1.f.f60150a + eVar.f56745d + d.b.i0.s1.f.f60150a + "kpi"), k.e(eVar.f56742a, eVar.f56743b, eVar.f56744c).toString(), false);
            }
            return null;
        }
    }

    static {
        if (d.b.b.e.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }

    public k(String str) {
        this.f56768a = str;
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

    public void a(d.b.i0.k2.b bVar) {
        this.f56772e.add(bVar);
        c();
        m(bVar);
        l();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!ListUtils.isEmpty(this.f56772e)) {
                int size = this.f56772e.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.f56772e.get(i).a());
                }
            }
            jSONObject.put("running", jSONArray);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void c() {
        if (d.b.b.e.p.f.c()) {
            File file = new File(d.b.i0.s1.f.f60154e + d.b.i0.s1.f.f60150a + this.f56768a + d.b.i0.s1.f.f60150a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        return e(this.f56769b, this.f56770c, this.f56771d);
    }

    public void f() {
        this.f56770c++;
    }

    public boolean g() {
        return this.f56770c > 0;
    }

    public boolean h() {
        return this.f56771d;
    }

    public void i() {
        this.f56769b = false;
    }

    public void j() {
        this.f56769b = true;
    }

    public void k() {
        this.f56771d = true;
    }

    public final void l() {
        if (d.b.b.e.p.f.c()) {
            new c(this).execute(new e(this.f56769b, this.f56770c, this.f56771d, this.f56768a));
        }
    }

    public final void m(d.b.i0.k2.b bVar) {
        if (!d.b.b.e.p.f.c() || bVar == null) {
            return;
        }
        new b(this).execute(new l(bVar, this.f56768a));
    }
}
