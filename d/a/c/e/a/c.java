package d.a.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f38422a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f38423b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f38424c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f38422a = null;
        this.f38424c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f38422a = bVar;
            this.f38424c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f38423b = new e(this.f38422a, this.f38424c);
        this.f38423b.b();
        return this.f38424c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f38424c.callback(diskFileOperate.isSuccess());
        } else {
            this.f38424c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f38423b != null) {
            this.f38423b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f38424c.callback(false);
    }
}
