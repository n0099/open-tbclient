package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.NewGodInfo;
/* loaded from: classes5.dex */
public class ce5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(NewGodData newGodData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newGodData)) == null) {
            return c(newGodData != null && newGodData.getType() == 2);
        }
        return (String) invokeL.objValue;
    }

    public static String b(NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newGodInfo)) == null) {
            return c(newGodInfo != null && newGodInfo.type.intValue() == 2);
        }
        return (String) invokeL.objValue;
    }

    public static String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0601);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0600);
        }
        return (String) invokeZ.objValue;
    }
}
