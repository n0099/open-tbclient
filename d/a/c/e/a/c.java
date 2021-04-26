package d.a.c.e.a;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class c extends BdAsyncTask<DiskFileOperate, Integer, DiskFileOperate> {

    /* renamed from: a  reason: collision with root package name */
    public b f39513a;

    /* renamed from: b  reason: collision with root package name */
    public volatile e f39514b = null;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f39515c;

    public c(b bVar, DiskFileOperate diskFileOperate) {
        this.f39513a = null;
        this.f39515c = null;
        if (bVar != null && diskFileOperate != null) {
            this.f39513a = bVar;
            this.f39515c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskFileTask parameter null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public DiskFileOperate doInBackground(DiskFileOperate... diskFileOperateArr) {
        this.f39514b = new e(this.f39513a, this.f39515c);
        this.f39514b.b();
        return this.f39515c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(DiskFileOperate diskFileOperate) {
        super.onPostExecute(diskFileOperate);
        if (diskFileOperate != null) {
            this.f39515c.callback(diskFileOperate.isSuccess());
        } else {
            this.f39515c.callback(false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.f39514b != null) {
            this.f39514b.c();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreCancel() {
        super.onPreCancel();
        this.f39515c.callback(false);
    }
}
