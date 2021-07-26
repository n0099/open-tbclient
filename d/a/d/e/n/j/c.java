package d.a.d.e.n.j;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, arrayList, z) == null) {
            d.a.d.e.a.f.e eVar = new d.a.d.e.a.f.e(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
            eVar.setSdCard(z);
            eVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.d.e.a.d.g().a(eVar);
        }
    }

    public static File[] b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate.setSdCard(z);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.d.e.a.d.g().d(diskFileOperate);
            if (diskFileOperate.getFileInfo() == null || diskFileOperate.getFileInfo().listFiles() == null) {
                return null;
            }
            return diskFileOperate.getFileInfo().listFiles();
        }
        return (File[]) invokeZ.objValue;
    }
}
