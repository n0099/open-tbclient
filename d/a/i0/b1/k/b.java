package d.a.i0.b1.k;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.k;
import d.a.c.e.p.q;
import d.a.i0.r.y.r;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public String f48235a;

    /* renamed from: b  reason: collision with root package name */
    public String f48236b;

    /* renamed from: c  reason: collision with root package name */
    public NetWork f48237c;

    /* renamed from: d  reason: collision with root package name */
    public a f48238d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        this.f48235a = str;
        this.f48236b = str2;
        this.f48238d = aVar;
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e2) {
            TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public final void c(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String doInBackground(Void... voidArr) {
        if (k.isEmpty(this.f48235a) || k.isEmpty(this.f48236b) || !b(this.f48235a)) {
            return null;
        }
        String c2 = q.c(this.f48236b);
        String str = this.f48235a + c2 + "/";
        if (e(str)) {
            return c2;
        }
        NetWork netWork = new NetWork();
        this.f48237c = netWork;
        netWork.setUrl(this.f48236b);
        String str2 = this.f48235a + c2 + ".zip";
        if (this.f48237c.downloadFile(str2, null, 0, 3, 0, true) && f(str2, str)) {
            c(str2);
            return c2;
        }
        c(str2);
        return null;
    }

    public final boolean e(String str) {
        return !k.isEmpty(str) && new File(str).exists();
    }

    public final boolean f(String str, String str2) {
        if (k.isEmpty(str) || k.isEmpty(str2)) {
            return false;
        }
        return r.b(str, str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        if (this.f48238d == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f48238d.a(true, str);
        } else {
            this.f48238d.a(false, null);
        }
    }
}
