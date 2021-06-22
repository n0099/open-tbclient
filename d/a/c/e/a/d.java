package d.a.c.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static BdUniqueId f42181d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f42182e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public static d f42183f = null;

    /* renamed from: a  reason: collision with root package name */
    public b f42184a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallel f42185b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTaskParallel f42186c;

    public d() {
        this.f42184a = null;
        this.f42185b = null;
        this.f42186c = null;
        this.f42185b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f42186c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f42184a = new b();
    }

    public static d g() {
        if (f42183f == null) {
            synchronized (d.class) {
                if (f42183f == null) {
                    f42183f = new d();
                }
            }
        }
        return f42183f;
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return f(diskFileOperate, f42181d, this.f42185b, 10);
        }
        return f(diskFileOperate, f42182e, this.f42186c, 5);
    }

    public final boolean b(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.f42184a, diskFileOperate);
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
            return diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
        }
        return diskFileOperate.getPath() + "/" + diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
    }

    public boolean d(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean b2 = new e(this.f42184a, diskFileOperate).b();
        diskFileOperate.callback(b2);
        return b2;
    }

    public void e(DiskFileOperate diskFileOperate) {
        String c2 = c(diskFileOperate);
        if (c2 != null) {
            BdAsyncTask.removeAllTask(f42181d, c2);
            BdAsyncTask.removeAllTask(f42182e, c2);
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
        this.f42184a.e(str);
    }
}
