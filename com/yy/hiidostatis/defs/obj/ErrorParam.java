package com.yy.hiidostatis.defs.obj;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class ErrorParam extends ParamableElem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4313338615427788235L;
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public ErrorParam clearParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            super.clearParams();
            return this;
        }
        return (ErrorParam) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return String.format("ErrorParam: %s" + super.toString(), new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public ErrorParam addParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            super.addParam(str);
            return this;
        }
        return (ErrorParam) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public ErrorParam addParams(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            super.addParams(list);
            return this;
        }
        return (ErrorParam) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.defs.obj.ParamableElem
    public /* bridge */ /* synthetic */ ParamableElem addParams(List list) {
        return addParams((List<String>) list);
    }
}
