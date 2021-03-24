package d.b.b.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f41582a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f41583b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f41584c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f41582a = null;
        this.f41584c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f41582a = bVar;
            this.f41584c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f41583b = new e(this.f41582a, this.f41584c);
        this.f41583b.b();
        return this.f41584c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f41584c.callback(diskFileOperate.isSuccess());
        } else {
            this.f41584c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f41583b != null) {
            this.f41583b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f41584c.callback(false);
    }
}
