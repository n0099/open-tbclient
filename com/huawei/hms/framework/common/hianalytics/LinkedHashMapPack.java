package com.huawei.hms.framework.common.hianalytics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
/* loaded from: classes8.dex */
public class LinkedHashMapPack {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedHashMap<String, String> map;

    public LinkedHashMapPack() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.map = new LinkedHashMap<>();
    }

    public LinkedHashMap<String, String> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.map;
        }
        return (LinkedHashMap) invokeV.objValue;
    }

    public LinkedHashMapPack put(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            if (str != null) {
                LinkedHashMap<String, String> linkedHashMap = this.map;
                linkedHashMap.put(str, "" + j);
            }
            return this;
        }
        return (LinkedHashMapPack) invokeLJ.objValue;
    }

    public LinkedHashMapPack put(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                this.map.put(str, str2);
            }
            return this;
        }
        return (LinkedHashMapPack) invokeLL.objValue;
    }

    public LinkedHashMapPack put(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (str != null) {
                if (z) {
                    this.map.put(str, "1");
                } else {
                    this.map.put(str, "0");
                }
            }
            return this;
        }
        return (LinkedHashMapPack) invokeLZ.objValue;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j == j2) {
                return this;
            }
            return put(str, j);
        }
        return (LinkedHashMapPack) invokeCommon.objValue;
    }
}
