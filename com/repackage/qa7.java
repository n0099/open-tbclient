package com.repackage;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qa7 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<MetaData> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<MetaData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (ArrayList) invokeV.objValue;
    }

    public static void b(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, arrayList) == null) {
            a = arrayList;
        }
    }
}
