package d.a.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f42075a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f42076b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f42077c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f42075a = null;
        this.f42077c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f42075a = bVar;
            this.f42077c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f42076b = new e(this.f42075a, this.f42077c);
        this.f42076b.b();
        return this.f42077c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f42077c.callback(diskFileOperate.isSuccess());
        } else {
            this.f42077c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f42076b != null) {
            this.f42076b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f42077c.callback(false);
    }
}
