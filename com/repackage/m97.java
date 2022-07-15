package com.repackage;

import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, imMessageCenterShowItemData)) == null) {
            if (imMessageCenterShowItemData == null) {
                return false;
            }
            return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName()) || "".equals(imMessageCenterShowItemData.getOwnerName());
        }
        return invokeL.booleanValue;
    }

    public static boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imMessageCenterShowItemData)) == null) ? (imMessageCenterShowItemData == null || !String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName()) || "3222425470".equals(imMessageCenterShowItemData.getFriendId()) || "801001117".equals(imMessageCenterShowItemData.getFriendId()) || "5044059141".equals(imMessageCenterShowItemData.getFriendId())) ? false : true : invokeL.booleanValue;
    }
}
