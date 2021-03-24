package d.b.i0.l3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.b.e.p.f;
import d.b.h0.s.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f56788a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f56789b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f56790c;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a(e eVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            d.b.i0.s1.d.a(d.b.i0.s1.c.f60144b);
            d.b.i0.s1.d.a(d.b.i0.s1.c.f60145c);
            d.b.i0.s1.d.a(d.b.i0.s1.c.f60146d);
            d.b.i0.s1.d.a(d.b.i0.s1.c.f60148f);
            d.b.i0.s1.d.a(d.b.i0.s1.c.f60149g);
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
            List j = e.j(d.b.i0.s1.c.f60147e);
            if (j == null) {
                return null;
            }
            int size = j.size();
            for (int i = 0; i < size; i++) {
                e.this.n((d.b.i0.l3.d) j.get(i));
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
    public class d extends BdAsyncTask<d.b.i0.l3.d, Void, Void> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.b.i0.l3.d... dVarArr) {
            if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                e.this.g(dVarArr[0]);
            }
            return null;
        }
    }

    /* renamed from: d.b.i0.l3.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1338e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f56794a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e h() {
        return C1338e.f56794a;
    }

    public static List<d.b.i0.l3.d> j(String str) {
        File[] listFiles;
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new d.b.i0.l3.d(m(d.b.i0.s1.d.e(listFiles[i])), listFiles[i].getAbsolutePath()));
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
        if (this.f56790c.contains(str)) {
            return false;
        }
        File file = new File(str);
        return d.b.i0.s1.d.f(file, str2 + "\n");
    }

    public final synchronized void g(d.b.i0.l3.d dVar) {
        try {
            byte[] a2 = d.b.i0.l3.c.a(dVar.f56786a);
            if (d.b.i0.l3.c.c(a2, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.f56787b)) {
                FileHelper.deleteFile(new File(dVar.f56787b));
                this.f56790c.add(dVar.f56787b);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String i() {
        if (StringUtils.isNull(this.f56788a)) {
            if (!f.c()) {
                return null;
            }
            this.f56788a = String.valueOf(System.currentTimeMillis());
        }
        return d.b.i0.s1.c.f60147e + this.f56788a;
    }

    public synchronized void k(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        this.f56789b.add(jSONObject.toString());
        String i = i();
        if (f.c()) {
            l(jSONObject, i);
        }
        if (this.f56789b.size() >= g.a() || z) {
            n(new d.b.i0.l3.d(this.f56789b, i));
            this.f56789b.clear();
            this.f56788a = null;
        }
    }

    public final void l(JSONObject jSONObject, String str) {
        if (StringUtils.isNull(str) || !f.c()) {
            return;
        }
        new c().execute(str, jSONObject.toString());
    }

    public final void n(d.b.i0.l3.d dVar) {
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
        this.f56789b = new ArrayList();
        this.f56790c = new ArrayList();
        if (f.c()) {
            e();
        }
    }
}
