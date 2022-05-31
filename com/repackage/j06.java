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
/* loaded from: classes6.dex */
public class j06 implements f06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f06 a;
    public final Map<Integer, f06> b;

    public j06(f06 defaultLayouter, Pair<Integer, ? extends f06>... layouter) {
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

    @Override // com.repackage.f06
    public void a(ry5 item, long j, r06 displayer, ly5 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            f(item).a(item, j, displayer, config);
        }
    }

    @Override // com.repackage.f06
    public void b(ry5 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            f(item).b(item);
        }
    }

    @Override // com.repackage.f06
    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            this.a.c(i, i2);
            for (f06 f06Var : this.b.values()) {
                f06Var.c(i, i2);
            }
        }
    }

    @Override // com.repackage.f06
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
            for (f06 f06Var : this.b.values()) {
                f06Var.clear();
            }
        }
    }

    @Override // com.repackage.f06
    public boolean d(ry5 item, long j, r06 displayer, ly5 config) {
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

    public int e(ry5 item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().j();
        }
        return invokeL.intValue;
    }

    public final f06 f(ry5 ry5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ry5Var)) == null) {
            f06 f06Var = this.b.get(Integer.valueOf(e(ry5Var)));
            return f06Var == null ? this.a : f06Var;
        }
        return (f06) invokeL.objValue;
    }
}
