package d.b.j0.m3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.c.e.p.f;
import d.b.i0.s.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f58839a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f58840b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f58841c;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.j0.t1.d.a(d.b.j0.t1.c.f62980b);
            d.b.j0.t1.d.a(d.b.j0.t1.c.f62981c);
            d.b.j0.t1.d.a(d.b.j0.t1.c.f62982d);
            d.b.j0.t1.d.a(d.b.j0.t1.c.f62984f);
            d.b.j0.t1.d.a(d.b.j0.t1.c.f62985g);
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            List j = e.j(d.b.j0.t1.c.f62983e);
            if (j == null) {
                return null;
            }
            int size = j.size();
            for (int i = 0; i < size; i++) {
                e.this.n((d.b.j0.m3.d) j.get(i));
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Void, Void> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                e.this.f(strArr[0], strArr[1]);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<d.b.j0.m3.d, Void, Void> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.b.j0.m3.d... dVarArr) {
            if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                e.this.g(dVarArr[0]);
            }
            return null;
        }
    }

    /* renamed from: d.b.j0.m3.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1418e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f58845a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e h() {
        return C1418e.f58845a;
    }

    public static List<d.b.j0.m3.d> j(String str) {
        File[] listFiles;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new d.b.j0.m3.d(m(d.b.j0.t1.d.e(listFiles[i])), listFiles[i].getAbsolutePath()));
            }
            return arrayList;
        }
        return null;
    }

    public static List<String> m(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String[] split = str.split("\n");
        int length = split.length;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            if (!StringUtils.isNull(split[i])) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public final void e() {
        new a(this).execute(new Void[0]);
    }

    public final synchronized boolean f(String str, String str2) {
        if (this.f58841c.contains(str)) {
            return false;
        }
        File file = new File(str);
        return d.b.j0.t1.d.f(file, str2 + "\n");
    }

    public final synchronized void g(d.b.j0.m3.d dVar) {
        try {
            byte[] a2 = d.b.j0.m3.c.a(dVar.f58837a);
            if (d.b.j0.m3.c.c(a2, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.f58838b)) {
                FileHelper.deleteFile(new File(dVar.f58838b));
                this.f58841c.add(dVar.f58838b);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String i() {
        if (StringUtils.isNull(this.f58839a)) {
            if (!f.c()) {
                return null;
            }
            this.f58839a = String.valueOf(System.currentTimeMillis());
        }
        return d.b.j0.t1.c.f62983e + this.f58839a;
    }

    public synchronized void k(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        this.f58840b.add(jSONObject.toString());
        String i = i();
        if (f.c()) {
            l(jSONObject, i);
        }
        if (this.f58840b.size() >= g.a() || z) {
            n(new d.b.j0.m3.d(this.f58840b, i));
            this.f58840b.clear();
            this.f58839a = null;
        }
    }

    public final void l(JSONObject jSONObject, String str) {
        if (StringUtils.isNull(str) || !f.c()) {
            return;
        }
        new c().execute(str, jSONObject.toString());
    }

    public final void n(d.b.j0.m3.d dVar) {
        if (dVar == null) {
            return;
        }
        new d().execute(dVar);
    }

    public void o() {
        if (f.c()) {
            new b().execute(new Void[0]);
        }
    }

    public e() {
        this.f58840b = new ArrayList();
        this.f58841c = new ArrayList();
        if (f.c()) {
            e();
        }
    }
}
