package d.b.b.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f41583a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f41584b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f41585c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f41583a = null;
        this.f41585c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f41583a = bVar;
            this.f41585c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f41584b = new e(this.f41583a, this.f41585c);
        this.f41584b.b();
        return this.f41585c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f41585c.callback(diskFileOperate.isSuccess());
        } else {
            this.f41585c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f41584b != null) {
            this.f41584b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f41585c.callback(false);
    }
}
