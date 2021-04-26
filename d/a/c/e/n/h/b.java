package d.a.c.e.n.h;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public static void a(ArrayList<String> arrayList, boolean z) {
        d.a.c.e.a.f.e eVar = new d.a.c.e.a.f.e(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
        eVar.setSdCard(z);
        eVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.c.e.a.d.g().a(eVar);
    }

    public static File[] b(boolean z, boolean z2) {
        File[] listFiles;
        DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), null, DiskFileOperate.Action.INFO);
        diskFileOperate.setSdCard(z);
        diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.c.e.a.d.g().d(diskFileOperate);
        File[] listFiles2 = (diskFileOperate.getFileInfo() == null || diskFileOperate.getFileInfo().listFiles() == null) ? null : diskFileOperate.getFileInfo().listFiles();
        if (z2) {
            DiskFileOperate diskFileOperate2 = new DiskFileOperate(BdStatisticsManager.getInstance().getNotUploadWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate2.setSdCard(z);
            diskFileOperate2.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.c.e.a.d.g().d(diskFileOperate2);
            if (diskFileOperate2.getFileInfo() != null && (listFiles = diskFileOperate2.getFileInfo().listFiles()) != null && listFiles.length != 0) {
                if (listFiles2 == null || listFiles2.length == 0) {
                    return listFiles;
                }
                File[] fileArr = new File[listFiles.length + listFiles2.length];
                System.arraycopy(listFiles2, 0, fileArr, 0, listFiles2.length);
                System.arraycopy(listFiles, 0, fileArr, listFiles2.length, listFiles.length);
                return fileArr;
            }
        }
        return listFiles2;
    }

    public static ArrayList<d> c(boolean z) {
        ArrayList<d> arrayList = new ArrayList<>();
        File[] b2 = b(z, true);
        if (b2 != null) {
            for (File file : b2) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name)) {
                        arrayList.add(new d(name, file.length(), file.lastModified()));
                    }
                }
            }
        }
        return arrayList;
    }
}
