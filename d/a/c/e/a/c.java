package d.a.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f38758a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f38759b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f38760c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f38758a = null;
        this.f38760c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f38758a = bVar;
            this.f38760c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f38759b = new e(this.f38758a, this.f38760c);
        this.f38759b.b();
        return this.f38760c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f38760c.callback(diskFileOperate.isSuccess());
        } else {
            this.f38760c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f38759b != null) {
            this.f38759b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f38760c.callback(false);
    }
}
