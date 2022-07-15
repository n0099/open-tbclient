package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.max.event.PanelEventTypeEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bm0 implements fh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PanelEventTypeEnum a;

    public bm0(PanelEventTypeEnum type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = type;
    }

    @Override // com.repackage.fh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String simpleName = bm0.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "PanelViewEvent::class.java.simpleName");
            return simpleName;
        }
        return (String) invokeV.objValue;
    }

    public final PanelEventTypeEnum getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (PanelEventTypeEnum) invokeV.objValue;
    }
}
