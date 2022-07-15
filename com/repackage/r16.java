package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class r16 extends z06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public r16(u06 context) {
        super(context, r3, null, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((u06) objArr2[0], (r0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        r0 b = r0.i(e16.class).b();
        Intrinsics.checkNotNullExpressionValue(b, "one(ActionComponent::class.java).get()");
    }

    @Override // com.repackage.z06
    public void l(o0 entity, float f) {
        e16 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            b16 b = z16.b(entity);
            p06 a2 = b == null ? null : b.a();
            if (a2 == null || (a = z16.a(entity)) == null) {
                return;
            }
            if (y16.b(this) >= a2.e().k()) {
                a.h(true);
                a.c(y16.b(this) - a2.e().k());
                return;
            }
            a.h(false);
        }
    }
}
