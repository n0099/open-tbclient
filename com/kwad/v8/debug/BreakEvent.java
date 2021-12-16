package com.kwad.v8.debug;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Object;
/* loaded from: classes3.dex */
public class BreakEvent extends EventData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SOURCE_COLUMN = "sourceColumn";
    public static final String SOURCE_LINE = "sourceLine";
    public static final String SOURCE_LINE_TEXT = "sourceLineText";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreakEvent(V8Object v8Object) {
        super(v8Object);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((V8Object) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getSourceColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.v8Object.executeIntegerFunction(SOURCE_COLUMN, null) : invokeV.intValue;
    }

    public int getSourceLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.v8Object.executeIntegerFunction(SOURCE_LINE, null) : invokeV.intValue;
    }

    public String getSourceLineText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v8Object.executeStringFunction(SOURCE_LINE_TEXT, null) : (String) invokeV.objValue;
    }
}
