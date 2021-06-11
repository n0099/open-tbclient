package d.a.m0.b1.k;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.k;
import d.a.c.e.p.q;
import d.a.m0.r.y.r;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public String f52762a;

    /* renamed from: b  reason: collision with root package name */
    public String f52763b;

    /* renamed from: c  reason: collision with root package name */
    public NetWork f52764c;

    /* renamed from: d  reason: collision with root package name */
    public a f52765d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        this.f52762a = str;
        this.f52763b = str2;
        this.f52765d = aVar;
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
        if (k.isEmpty(this.f52762a) || k.isEmpty(this.f52763b) || !b(this.f52762a)) {
            return null;
        }
        String c2 = q.c(this.f52763b);
        String str = this.f52762a + c2 + "/";
        if (e(str)) {
            return c2;
        }
        NetWork netWork = new NetWork();
        this.f52764c = netWork;
        netWork.setUrl(this.f52763b);
        String str2 = this.f52762a + c2 + ".zip";
        if (this.f52764c.downloadFile(str2, null, 0, 3, 0, true) && f(str2, str)) {
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
        if (this.f52765d == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f52765d.a(true, str);
        } else {
            this.f52765d.a(false, null);
        }
    }
}
