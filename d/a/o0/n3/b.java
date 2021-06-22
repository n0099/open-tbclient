package d.a.o0.n3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.VideoPlatformStatic;
import d.a.o0.u1.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f61550a = new b();

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
                d.a.o0.n3.a aVar = (d.a.o0.n3.a) h2.get(i2);
                b.this.j(aVar.f61548a, aVar.f61549b);
            }
            return null;
        }
    }

    /* renamed from: d.a.o0.n3.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1506b extends BdAsyncTask<d.a.o0.n3.a, Void, Void> {
        public C1506b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.o0.n3.a... aVarArr) {
            if (aVarArr != null && aVarArr.length == 1 && aVarArr[0] != null) {
                b.this.c(aVarArr[0]);
            }
            return null;
        }
    }

    public static b d() {
        return f61550a;
    }

    public static JSONObject e(String str) {
        if (!StringUtils.isNull(str) && new File(str).exists()) {
            try {
                return new JSONObject().put("running", l(d.a.o0.u1.d.d(str)));
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
                jSONObject = new JSONObject(d.a.o0.u1.d.e(file));
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
        File file = new File(f.f65164e);
        if (file.exists()) {
            return file.listFiles();
        }
        return null;
    }

    public static List<d.a.o0.n3.a> h() {
        ArrayList arrayList = new ArrayList();
        File[] g2 = g();
        if (g2 == null) {
            return arrayList;
        }
        for (File file : g2) {
            String name = file.getName();
            JSONObject f2 = f(file.getAbsolutePath() + f.f65160a + "kpi");
            if (f2 == null) {
                d.a.o0.u1.d.b(name);
            } else {
                JSONObject e2 = e(file.getAbsolutePath() + f.f65160a + "debug");
                if (e2 == null) {
                    d.a.o0.u1.d.b(name);
                } else {
                    arrayList.add(new d.a.o0.n3.a(name, i(VideoPlatformStatic.c(), f2, e2)));
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
            jSONArray.put(new d.a.o0.m2.c(502, "unknown", -4399, "").a());
        }
        return jSONArray;
    }

    public static boolean m(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errorTimes", -1);
        int optInt2 = jSONObject.optInt("postSuccess", -1);
        int optInt3 = jSONObject.optInt("posted", -1);
        return (optInt == -1 || optInt2 == -1 || optInt3 == -1 || (optInt3 != 1 && optInt <= 0)) ? false : true;
    }

    public final void c(d.a.o0.n3.a aVar) {
        try {
            byte[] b2 = c.b(aVar.f61549b);
            c.c(b2, TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
            d.a.o0.u1.d.b(aVar.f61548a);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(String str, JSONObject jSONObject) {
        new C1506b().execute(new d.a.o0.n3.a(str, jSONObject));
    }

    public void k() {
        if (d.a.c.e.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }
}
