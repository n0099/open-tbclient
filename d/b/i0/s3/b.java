package d.b.i0.s3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import d.b.b.e.j.a.e;
import d.b.b.e.p.k;
import d.b.b.e.p.q;
import java.io.File;
/* loaded from: classes5.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: d  reason: collision with root package name */
    public static final String f60197d = File.separator;

    /* renamed from: a  reason: collision with root package name */
    public String f60198a;

    /* renamed from: b  reason: collision with root package name */
    public String f60199b;

    /* renamed from: c  reason: collision with root package name */
    public a f60200c;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, String str, String str2);
    }

    public b(String str, String str2, a aVar) {
        this.f60198a = str;
        this.f60199b = str2;
        this.f60200c = aVar;
    }

    public final void b(File file) {
        File[] listFiles;
        if (k.isEmpty(this.f60198a)) {
            return;
        }
        File file2 = new File(this.f60198a);
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
        if (!k.isEmpty(this.f60198a) && !k.isEmpty(this.f60199b)) {
            new File(this.f60198a).mkdirs();
            String str = this.f60198a + f60197d + "videosplash.temp";
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            e eVar = new e();
            eVar.b().s(this.f60199b);
            if (new d.b.b.e.j.a.c(eVar).c(str, null, 3, 3000, -1, -1, true, true)) {
                return d();
            }
        }
        return "";
    }

    public final String d() {
        File file = new File(this.f60198a + f60197d + "videosplash.temp");
        StringBuilder sb = new StringBuilder();
        sb.append(q.c(this.f60199b));
        sb.append(".mp4");
        String sb2 = sb.toString();
        File file2 = new File(this.f60198a + f60197d + sb2);
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
        if (this.f60200c == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f60200c.a(true, str, this.f60199b);
        } else {
            this.f60200c.a(false, null, null);
        }
    }
}
