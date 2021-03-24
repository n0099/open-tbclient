package d.b.b.e.n.h;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    public static void a(ArrayList<String> arrayList, boolean z) {
        d.b.b.e.a.f.e eVar = new d.b.b.e.a.f.e(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        eVar.setSdCard(z);
        eVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.b.b.e.a.d.g().a(eVar);
    }

    public static File[] b(boolean z) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.INFO);
        diskFileOperate.setSdCard(z);
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.b.b.e.a.d.g().d(diskFileOperate);
        if (diskFileOperate.getFileInfo() == null || diskFileOperate.getFileInfo().listFiles() == null) {
            return null;
        }
        return diskFileOperate.getFileInfo().listFiles();
    }
}
