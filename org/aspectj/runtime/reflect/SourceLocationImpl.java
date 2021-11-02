package org.aspectj.runtime.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.reflect.SourceLocation;
/* loaded from: classes3.dex */
public class SourceLocationImpl implements SourceLocation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String fileName;
    public int line;
    public Class withinType;

    public SourceLocationImpl(Class cls, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.withinType = cls;
        this.fileName = str;
        this.line = i2;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public int getColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public String getFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fileName : (String) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public int getLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.line : invokeV.intValue;
    }

    @Override // org.aspectj.lang.reflect.SourceLocation
    public Class getWithinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.withinType : (Class) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getFileName());
            stringBuffer.append(":");
            stringBuffer.append(getLine());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
