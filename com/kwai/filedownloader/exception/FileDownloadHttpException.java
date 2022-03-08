package com.kwai.filedownloader.exception;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.e.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class FileDownloadHttpException extends IOException {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mCode;
    public final Map<String, List<String>> mRequestHeaderMap;
    public final Map<String, List<String>> mResponseHeaderMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDownloadHttpException(int i2, Map<String, List<String>> map, Map<String, List<String>> map2) {
        super(f.a("response requestHttpCode error: %d, \n request headers: %s \n response headers: %s", Integer.valueOf(i2), map, map2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), map, map2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCode = i2;
        this.mRequestHeaderMap = cloneSerializableMap(map);
        this.mResponseHeaderMap = cloneSerializableMap(map);
    }

    public static Map<String, List<String>> cloneSerializableMap(Map<String, List<String>> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCode : invokeV.intValue;
    }

    public Map<String, List<String>> getRequestHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRequestHeaderMap : (Map) invokeV.objValue;
    }

    public Map<String, List<String>> getResponseHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mResponseHeaderMap : (Map) invokeV.objValue;
    }
}
