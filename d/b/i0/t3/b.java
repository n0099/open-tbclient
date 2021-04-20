package d.b.i0.t3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.c.e.j.a.e;
import d.b.c.e.p.k;
import d.b.c.e.p.q;
import java.io.File;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: d  reason: collision with root package name */
    public static final String f62611d = File.separator;

    /* renamed from: a  reason: collision with root package name */
    public String f62612a;

    /* renamed from: b  reason: collision with root package name */
    public String f62613b;

    /* renamed from: c  reason: collision with root package name */
    public a f62614c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.f62612a = str;
        this.f62613b = str2;
        this.f62614c = aVar;
    }

    public final void b(File file) {
        File[] listFiles;
        if (k.isEmpty(this.f62612a)) {
            return;
        }
        File file2 = new File(this.f62612a);
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
        if (!k.isEmpty(this.f62612a) && !k.isEmpty(this.f62613b)) {
            new File(this.f62612a).mkdirs();
            String str = this.f62612a + f62611d + "videosplash.temp";
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            e eVar = new e();
            eVar.b().s(this.f62613b);
            if (new d.b.c.e.j.a.c(eVar).c(str, null, 3, 3000, -1, -1, true, true)) {
                return d();
            }
        }
        return "";
    }

    public final String d() {
        File file = new File(this.f62612a + f62611d + "videosplash.temp");
        StringBuilder sb = new StringBuilder();
        sb.append(q.c(this.f62613b));
        sb.append(".mp4");
        String sb2 = sb.toString();
        File file2 = new File(this.f62612a + f62611d + sb2);
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
        if (this.f62614c == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f62614c.a(true, str, this.f62613b);
        } else {
            this.f62614c.a(false, null, null);
        }
    }
}
