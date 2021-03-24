package d.b.h0.b1.k;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.b.e.p.k;
import d.b.b.e.p.q;
import d.b.h0.r.y.r;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<Void, Void, String> {

    /* renamed from: a  reason: collision with root package name */
    public String f49941a;

    /* renamed from: b  reason: collision with root package name */
    public String f49942b;

    /* renamed from: c  reason: collision with root package name */
    public NetWork f49943c;

    /* renamed from: d  reason: collision with root package name */
    public a f49944d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        this.f49941a = str;
        this.f49942b = str2;
        this.f49944d = aVar;
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
        if (k.isEmpty(this.f49941a) || k.isEmpty(this.f49942b) || !b(this.f49941a)) {
            return null;
        }
        String c2 = q.c(this.f49942b);
        String str = this.f49941a + c2 + "/";
        if (e(str)) {
            return c2;
        }
        NetWork netWork = new NetWork();
        this.f49943c = netWork;
        netWork.setUrl(this.f49942b);
        String str2 = this.f49941a + c2 + ".zip";
        if (this.f49943c.downloadFile(str2, null, 0, 3, 0, true) && f(str2, str)) {
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
        if (this.f49944d == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f49944d.a(true, str);
        } else {
            this.f49944d.a(false, null);
        }
    }
}
