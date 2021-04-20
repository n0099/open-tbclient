package d.b.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f42080a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f42081b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f42082c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f42080a = null;
        this.f42082c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f42080a = bVar;
            this.f42082c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f42081b = new e(this.f42080a, this.f42082c);
        this.f42081b.b();
        return this.f42082c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f42082c.callback(diskFileOperate.isSuccess());
        } else {
            this.f42082c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f42081b != null) {
            this.f42081b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f42082c.callback(false);
    }
}
