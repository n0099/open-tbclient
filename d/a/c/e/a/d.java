package d.a.c.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static BdUniqueId f38425d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f38426e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public static d f38427f = null;

    /* renamed from: a  reason: collision with root package name */
    public b f38428a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallel f38429b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTaskParallel f38430c;

    public d() {
        this.f38428a = null;
        this.f38429b = null;
        this.f38430c = null;
        this.f38429b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f38430c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f38428a = new b();
    }

    public static d g() {
        if (f38427f == null) {
            synchronized (d.class) {
                if (f38427f == null) {
                    f38427f = new d();
                }
            }
        }
        return f38427f;
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return f(diskFileOperate, f38425d, this.f38429b, 10);
        }
        return f(diskFileOperate, f38426e, this.f38430c, 5);
    }

    public final boolean b(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.f38428a, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(c(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }

    public final String c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return null;
        }
        if (diskFileOperate.getPath() == null) {
            return diskFileOperate.getName() + FieldBuilder.SE + diskFileOperate.hashCode();
        }
        return diskFileOperate.getPath() + "/" + diskFileOperate.getName() + FieldBuilder.SE + diskFileOperate.hashCode();
    }

    public boolean d(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean b2 = new e(this.f38428a, diskFileOperate).b();
        diskFileOperate.callback(b2);
        return b2;
    }

    public void e(DiskFileOperate diskFileOperate) {
        String c2 = c(diskFileOperate);
        if (c2 != null) {
            BdAsyncTask.removeAllTask(f38425d, c2);
            BdAsyncTask.removeAllTask(f38426e, c2);
        }
    }

    public final boolean f(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i2) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.getOperateType() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < i2 + diskFileOperate.getTrySuccessWeight()) {
            return b(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void h(String str) {
        this.f38428a.e(str);
    }
}
