package d.a.n0.u3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import d.a.c.e.j.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.q;
import java.io.File;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: d  reason: collision with root package name */
    public static final String f61370d = File.separator;

    /* renamed from: a  reason: collision with root package name */
    public String f61371a;

    /* renamed from: b  reason: collision with root package name */
    public String f61372b;

    /* renamed from: c  reason: collision with root package name */
    public a f61373c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.f61371a = str;
        this.f61372b = str2;
        this.f61373c = aVar;
    }

    public final void b(File file) {
        File[] listFiles;
        if (k.isEmpty(this.f61371a)) {
            return;
        }
        File file2 = new File(this.f61371a);
        if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
            return;
        }
        for (File file3 : listFiles) {
            if (file3 != null && !file3.equals(file)) {
                FileHelper.deleteFileOrDir(file3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public String doInBackground(Void... voidArr) {
        if (!k.isEmpty(this.f61371a) && !k.isEmpty(this.f61372b)) {
            new File(this.f61371a).mkdirs();
            String str = this.f61371a + f61370d + "videosplash.temp";
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            e eVar = new e();
            eVar.b().s(this.f61372b);
            if (new d.a.c.e.j.a.c(eVar).c(str, null, 3, 3000, -1, -1, true, true)) {
                return d();
            }
        }
        return "";
    }

    public final String d() {
        File file = new File(this.f61371a + f61370d + "videosplash.temp");
        StringBuilder sb = new StringBuilder();
        sb.append(q.c(this.f61372b));
        sb.append(".mp4");
        String sb2 = sb.toString();
        File file2 = new File(this.f61371a + f61370d + sb2);
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            b(file2);
            return file2.getAbsolutePath();
        }
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.f61373c == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f61373c.a(true, str, this.f61372b);
        } else {
            this.f61373c.a(false, null, null);
        }
    }
}
