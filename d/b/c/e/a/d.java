package d.b.c.e.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static BdUniqueId f42323d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public static BdUniqueId f42324e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public static d f42325f = null;

    /* renamed from: a  reason: collision with root package name */
    public b f42326a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallel f42327b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTaskParallel f42328c;

    public d() {
        this.f42326a = null;
        this.f42327b = null;
        this.f42328c = null;
        this.f42327b = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f42328c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.f42326a = new b();
    }

    public static d g() {
        if (f42325f == null) {
            synchronized (d.class) {
                if (f42325f == null) {
                    f42325f = new d();
                }
            }
        }
        return f42325f;
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return f(diskFileOperate, f42323d, this.f42327b, 10);
        }
        return f(diskFileOperate, f42324e, this.f42328c, 5);
    }

    public final boolean b(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.f42326a, diskFileOperate);
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
        boolean b2 = new e(this.f42326a, diskFileOperate).b();
        diskFileOperate.callback(b2);
        return b2;
    }

    public void e(DiskFileOperate diskFileOperate) {
        String c2 = c(diskFileOperate);
        if (c2 != null) {
            BdAsyncTask.removeAllTask(f42323d, c2);
            BdAsyncTask.removeAllTask(f42324e, c2);
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
        this.f42326a.e(str);
    }
}
