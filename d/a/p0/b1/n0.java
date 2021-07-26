package d.a.p0.b1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.NewGodInfo;
/* loaded from: classes7.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            return d(i2 == 2);
        }
        return (String) invokeI.objValue;
    }

    public static String b(NewGodData newGodData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newGodData)) == null) {
            return d(newGodData != null && newGodData.getType() == 2);
        }
        return (String) invokeL.objValue;
    }

    public static String c(NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, newGodInfo)) == null) {
            return d(newGodInfo != null && newGodInfo.type.intValue() == 2);
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            if (z) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
        }
        return (String) invokeZ.objValue;
    }
}
