package d.b.c.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static BdUniqueId f42083d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f42084e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public static d f42085f = null;

    /* renamed from: a  reason: collision with root package name */
    public b f42086a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallel f42087b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTaskParallel f42088c;

    public d() {
        this.f42086a = null;
        this.f42087b = null;
        this.f42088c = null;
        this.f42087b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f42088c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f42086a = new b();
    }

    public static d g() {
        if (f42085f == null) {
            synchronized (d.class) {
                if (f42085f == null) {
                    f42085f = new d();
                }
            }
        }
        return f42085f;
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return f(diskFileOperate, f42083d, this.f42087b, 10);
        }
        return f(diskFileOperate, f42084e, this.f42088c, 5);
    }

    public final boolean b(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.f42086a, diskFileOperate);
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
        boolean b2 = new e(this.f42086a, diskFileOperate).b();
        diskFileOperate.callback(b2);
        return b2;
    }

    public void e(DiskFileOperate diskFileOperate) {
        String c2 = c(diskFileOperate);
        if (c2 != null) {
            BdAsyncTask.removeAllTask(f42083d, c2);
            BdAsyncTask.removeAllTask(f42084e, c2);
        }
    }

    public final boolean f(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.getOperateType() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < i + diskFileOperate.getTrySuccessWeight()) {
            return b(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void h(String str) {
        this.f42086a.e(str);
    }
}
