package d.a.k0.m3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoPlatformStatic;
import d.a.k0.t1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f57556a = new b();

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            List h2 = b.h();
            int size = h2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.k0.m3.a aVar = (d.a.k0.m3.a) h2.get(i2);
                b.this.j(aVar.f57554a, aVar.f57555b);
            }
            return null;
        }
    }

    /* renamed from: d.a.k0.m3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1428b extends BdAsyncTask<d.a.k0.m3.a, Void, Void> {
        public C1428b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.k0.m3.a... aVarArr) {
            if (aVarArr != null && aVarArr.length == 1 && aVarArr[0] != null) {
                b.this.c(aVarArr[0]);
            }
            return null;
        }
    }

    public static b d() {
        return f57556a;
    }

    public static JSONObject e(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", l(d.a.k0.t1.d.d(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static JSONObject f(String str) {
        JSONObject jSONObject;
        File file = new File(str);
        if (file.exists()) {
            try {
                jSONObject = new JSONObject(d.a.k0.t1.d.e(file));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (m(jSONObject)) {
                return jSONObject;
            }
            return null;
        }
        return null;
    }

    public static File[] g() {
        File file = new File(f.f61919e);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    public static List<d.a.k0.m3.a> h() {
        ArrayList arrayList = new ArrayList();
        File[] g2 = g();
        if (g2 == null) {
            return arrayList;
        }
        for (File file : g2) {
            String name = file.getName();
            JSONObject f2 = f(file.getAbsolutePath() + f.f61915a + "kpi");
            if (f2 == null) {
                d.a.k0.t1.d.b(name);
            } else {
                JSONObject e2 = e(file.getAbsolutePath() + f.f61915a + "debug");
                if (e2 == null) {
                    d.a.k0.t1.d.b(name);
                } else {
                    arrayList.add(new d.a.k0.m3.a(name, i(VideoPlatformStatic.c(), f2, e2)));
                }
            }
        }
        return arrayList;
    }

    public static JSONObject i(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("kpiInfo", jSONObject2);
            jSONObject4.put("baseInfo", jSONObject);
            jSONObject4.put("debugInfo", jSONObject3);
            return jSONObject4;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONArray l(JSONArray jSONArray) {
        int optInt;
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && ((optInt = optJSONObject.optInt("type")) == 501 || optInt == 503 || optInt == 502)) {
                z = true;
                break;
            }
        }
        if (!z) {
            jSONArray.put(new d.a.k0.l2.c(502, "unknown", -4399, "").a());
        }
        return jSONArray;
    }

    public static boolean m(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    public final void c(d.a.k0.m3.a aVar) {
        try {
            byte[] b2 = c.b(aVar.f57555b);
            c.c(b2, TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            d.a.k0.t1.d.b(aVar.f57554a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(String str, JSONObject jSONObject) {
        new C1428b().execute(new d.a.k0.m3.a(str, jSONObject));
    }

    public void k() {
        if (d.a.c.e.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }
}
