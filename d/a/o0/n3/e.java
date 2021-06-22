package d.a.o0.n3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import d.a.c.e.p.f;
import d.a.n0.s.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f61555a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f61556b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f61557c;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.a.o0.u1.d.a(d.a.o0.u1.c.f65154b);
            d.a.o0.u1.d.a(d.a.o0.u1.c.f65155c);
            d.a.o0.u1.d.a(d.a.o0.u1.c.f65156d);
            d.a.o0.u1.d.a(d.a.o0.u1.c.f65158f);
            d.a.o0.u1.d.a(d.a.o0.u1.c.f65159g);
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
            List j = e.j(d.a.o0.u1.c.f65157e);
            if (j == null) {
                return null;
            }
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                e.this.n((d.a.o0.n3.d) j.get(i2));
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
    public class d extends BdAsyncTask<d.a.o0.n3.d, Void, Void> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.o0.n3.d... dVarArr) {
            if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                e.this.g(dVarArr[0]);
            }
            return null;
        }
    }

    /* renamed from: d.a.o0.n3.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1507e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f61561a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e h() {
        return C1507e.f61561a;
    }

    public static List<d.a.o0.n3.d> j(String str) {
        File[] listFiles;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(new d.a.o0.n3.d(m(d.a.o0.u1.d.e(listFiles[i2])), listFiles[i2].getAbsolutePath()));
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
        for (int i2 = 0; i2 < length; i2++) {
            if (!StringUtils.isNull(split[i2])) {
                arrayList.add(split[i2]);
            }
        }
        return arrayList;
    }

    public final void e() {
        new a(this).execute(new Void[0]);
    }

    public final synchronized boolean f(String str, String str2) {
        if (this.f61557c.contains(str)) {
            return false;
        }
        File file = new File(str);
        return d.a.o0.u1.d.f(file, str2 + "\n");
    }

    public final synchronized void g(d.a.o0.n3.d dVar) {
        try {
            byte[] a2 = d.a.o0.n3.c.a(dVar.f61553a);
            if (d.a.o0.n3.c.c(a2, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.f61554b)) {
                FileHelper.deleteFile(new File(dVar.f61554b));
                this.f61557c.add(dVar.f61554b);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String i() {
        if (StringUtils.isNull(this.f61555a)) {
            if (!f.c()) {
                return null;
            }
            this.f61555a = String.valueOf(System.currentTimeMillis());
        }
        return d.a.o0.u1.c.f65157e + this.f61555a;
    }

    public synchronized void k(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        this.f61556b.add(jSONObject.toString());
        String i2 = i();
        if (f.c()) {
            l(jSONObject, i2);
        }
        if (this.f61556b.size() >= g.a() || z) {
            n(new d.a.o0.n3.d(this.f61556b, i2));
            this.f61556b.clear();
            this.f61555a = null;
        }
    }

    public final void l(JSONObject jSONObject, String str) {
        if (StringUtils.isNull(str) || !f.c()) {
            return;
        }
        new c().execute(str, jSONObject.toString());
    }

    public final void n(d.a.o0.n3.d dVar) {
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
        this.f61556b = new ArrayList();
        this.f61557c = new ArrayList();
        if (f.c()) {
            e();
        }
    }
}
