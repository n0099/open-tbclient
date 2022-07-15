package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class f16 extends l16<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function1<Long, Boolean> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f16(Function1<? super Long, Boolean> selfPredicate) {
        super(2048, false, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {selfPredicate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(selfPredicate, "selfPredicate");
        this.e = selfPredicate;
    }

    @Override // com.repackage.l16, com.repackage.g16
    public boolean b(p06 item, s26 timer, j06 config) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, timer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(timer, "timer");
            Intrinsics.checkNotNullParameter(config, "config");
            q06 e = item.e();
            if (!this.e.invoke(e.o()).booleanValue()) {
                Set<String> d = d();
                if (!(d instanceof Collection) || !d.isEmpty()) {
                    for (String str : d) {
                        if (StringsKt__StringsKt.contains$default((CharSequence) e.c(), (CharSequence) str, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l16
    /* renamed from: e */
    public String c(q06 data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.c();
        }
        return (String) invokeL.objValue;
    }
}
