package d.a.j0.m2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public String f56834a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56835b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f56836c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56837d = false;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.j0.l2.b> f56838e = new ArrayList();

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.a.j0.t1.d.a(d.a.j0.t1.f.f61192b);
            d.a.j0.t1.d.a(d.a.j0.t1.f.f61193c);
            d.a.j0.t1.d.a(d.a.j0.t1.f.f61194d);
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                File file = new File(d.a.j0.t1.f.f61195e + d.a.j0.t1.f.f61191a + lVar.f56840b + d.a.j0.t1.f.f61191a + "debug");
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f56839a.a().toString());
                sb.append("\n");
                d.a.j0.t1.d.g(file, sb.toString(), true);
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
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
                d.a.j0.t1.d.g(new File(d.a.j0.t1.f.f61195e + d.a.j0.t1.f.f61191a + eVar.f56809d + d.a.j0.t1.f.f61191a + "kpi"), k.e(eVar.f56806a, eVar.f56807b, eVar.f56808c).toString(), false);
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
        this.f56834a = str;
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

    public void a(d.a.j0.l2.b bVar) {
        this.f56838e.add(bVar);
        c();
        m(bVar);
        l();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!ListUtils.isEmpty(this.f56838e)) {
                int size = this.f56838e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(this.f56838e.get(i2).a());
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
            File file = new File(d.a.j0.t1.f.f61195e + d.a.j0.t1.f.f61191a + this.f56834a + d.a.j0.t1.f.f61191a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        return e(this.f56835b, this.f56836c, this.f56837d);
    }

    public void f() {
        this.f56836c++;
    }

    public boolean g() {
        return this.f56836c > 0;
    }

    public boolean h() {
        return this.f56837d;
    }

    public void i() {
        this.f56835b = false;
    }

    public void j() {
        this.f56835b = true;
    }

    public void k() {
        this.f56837d = true;
    }

    public final void l() {
        if (d.a.c.e.p.f.c()) {
            new c(this).execute(new e(this.f56835b, this.f56836c, this.f56837d, this.f56834a));
        }
    }

    public final void m(d.a.j0.l2.b bVar) {
        if (!d.a.c.e.p.f.c() || bVar == null) {
            return;
        }
        new b(this).execute(new l(bVar, this.f56834a));
    }
}
