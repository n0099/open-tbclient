package com.repackage;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public class b26 implements z16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z16 a;
    public final Map<Integer, z16> b;

    public b26(z16 defaultRenderer, Pair<Integer, ? extends z16>... renderers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultRenderer, renderers};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultRenderer, "defaultRenderer");
        Intrinsics.checkNotNullParameter(renderers, "renderers");
        this.a = defaultRenderer;
        this.b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(renderers, renderers.length));
    }

    @Override // com.repackage.z16
    public l26 a(d06 item, d26 displayer, xz5 config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            z16 z16Var = this.b.get(Integer.valueOf(c(item)));
            if (z16Var == null) {
                z16Var = this.a;
            }
            return z16Var.a(item, displayer, config);
        }
        return (l26) invokeLLL.objValue;
    }

    @Override // com.repackage.z16
    public void b(d06 item, Canvas canvas, d26 displayer, xz5 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            z16 z16Var = this.b.get(Integer.valueOf(c(item)));
            if (z16Var == null) {
                z16Var = this.a;
            }
            z16Var.b(item, canvas, displayer, config);
        }
    }

    public int c(d06 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().g();
        }
        return invokeL.intValue;
    }
}
