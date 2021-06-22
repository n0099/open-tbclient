package d.a.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f42178a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f42179b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f42180c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f42178a = null;
        this.f42180c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f42178a = bVar;
            this.f42180c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f42179b = new e(this.f42178a, this.f42180c);
        this.f42179b.b();
        return this.f42180c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f42180c.callback(diskFileOperate.isSuccess());
        } else {
            this.f42180c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f42179b != null) {
            this.f42179b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f42180c.callback(false);
    }
}
