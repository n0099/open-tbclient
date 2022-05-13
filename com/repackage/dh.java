package com.repackage;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class dh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ArrayList<String> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65536, null, arrayList, z) == null) {
            xb xbVar = new xb(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.DELETE_FILES, arrayList);
            xbVar.setSdCard(z);
            xbVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            rb.f().a(xbVar);
        }
    }

    public static File[] b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getTrackLogWriteDir(), null, DiskFileOperate.Action.INFO);
            diskFileOperate.setSdCard(z);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            rb.f().call(diskFileOperate);
            if (diskFileOperate.getFileInfo() == null || diskFileOperate.getFileInfo().listFiles() == null) {
                return null;
            }
            return diskFileOperate.getFileInfo().listFiles();
        }
        return (File[]) invokeZ.objValue;
    }
}
