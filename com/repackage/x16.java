package com.repackage;

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
/* loaded from: classes7.dex */
public class x16 implements t16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t16 a;
    public final Map<Integer, t16> b;

    public x16(t16 defaultLayouter, Pair<Integer, ? extends t16>... layouter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultLayouter, layouter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultLayouter, "defaultLayouter");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        this.a = defaultLayouter;
        this.b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(layouter, layouter.length));
    }

    @Override // com.repackage.t16
    public void a(f06 item, long j, f26 displayer, zz5 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            f(item).a(item, j, displayer, config);
        }
    }

    @Override // com.repackage.t16
    public void b(f06 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            f(item).b(item);
        }
    }

    @Override // com.repackage.t16
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c(i, i2);
            for (t16 t16Var : this.b.values()) {
                t16Var.c(i, i2);
            }
        }
    }

    @Override // com.repackage.t16
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
            for (t16 t16Var : this.b.values()) {
                t16Var.clear();
            }
        }
    }

    @Override // com.repackage.t16
    public boolean d(f06 item, long j, f26 displayer, zz5 config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{item, Long.valueOf(j), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            return f(item).d(item, j, displayer, config);
        }
        return invokeCommon.booleanValue;
    }

    public int e(f06 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().j();
        }
        return invokeL.intValue;
    }

    public final t16 f(f06 f06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f06Var)) == null) {
            t16 t16Var = this.b.get(Integer.valueOf(e(f06Var)));
            return t16Var == null ? this.a : t16Var;
        }
        return (t16) invokeL.objValue;
    }
}
