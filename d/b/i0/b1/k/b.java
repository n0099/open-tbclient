package d.b.i0.b1.k;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.k;
import d.b.c.e.p.q;
import d.b.i0.r.y.r;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public String f50671a;

    /* renamed from: b  reason: collision with root package name */
    public String f50672b;

    /* renamed from: c  reason: collision with root package name */
    public NetWork f50673c;

    /* renamed from: d  reason: collision with root package name */
    public a f50674d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        this.f50671a = str;
        this.f50672b = str2;
        this.f50674d = aVar;
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
        if (k.isEmpty(this.f50671a) || k.isEmpty(this.f50672b) || !b(this.f50671a)) {
            return null;
        }
        String c2 = q.c(this.f50672b);
        String str = this.f50671a + c2 + "/";
        if (e(str)) {
            return c2;
        }
        NetWork netWork = new NetWork();
        this.f50673c = netWork;
        netWork.setUrl(this.f50672b);
        String str2 = this.f50671a + c2 + ".zip";
        if (this.f50673c.downloadFile(str2, null, 0, 3, 0, true) && f(str2, str)) {
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
        if (this.f50674d == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f50674d.a(true, str);
        } else {
            this.f50674d.a(false, null);
        }
    }
}
