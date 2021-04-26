package d.a.c.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static BdUniqueId f39516d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f39517e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public static d f39518f = null;

    /* renamed from: a  reason: collision with root package name */
    public b f39519a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallel f39520b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTaskParallel f39521c;

    public d() {
        this.f39519a = null;
        this.f39520b = null;
        this.f39521c = null;
        this.f39520b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f39521c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f39519a = new b();
    }

    public static d g() {
        if (f39518f == null) {
            synchronized (d.class) {
                if (f39518f == null) {
                    f39518f = new d();
                }
            }
        }
        return f39518f;
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return f(diskFileOperate, f39516d, this.f39520b, 10);
        }
        return f(diskFileOperate, f39517e, this.f39521c, 5);
    }

    public final boolean b(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.f39519a, diskFileOperate);
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
        boolean b2 = new e(this.f39519a, diskFileOperate).b();
        diskFileOperate.callback(b2);
        return b2;
    }

    public void e(DiskFileOperate diskFileOperate) {
        String c2 = c(diskFileOperate);
        if (c2 != null) {
            BdAsyncTask.removeAllTask(f39516d, c2);
            BdAsyncTask.removeAllTask(f39517e, c2);
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
        this.f39519a.e(str);
    }
}
