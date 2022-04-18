package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h16 extends p06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h16(k06 context) {
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
                super((k06) objArr2[0], (o0) objArr2[1], (Comparator) objArr2[2], ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        o0 b = o0.i(u06.class).b();
        Intrinsics.checkNotNullExpressionValue(b, "one(ActionComponent::class.java).get()");
    }

    @Override // com.repackage.p06
    public void l(l0 entity, float f) {
        u06 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, entity, f) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            r06 b = p16.b(entity);
            f06 a2 = b == null ? null : b.a();
            if (a2 == null || (a = p16.a(entity)) == null) {
                return;
            }
            if (o16.b(this) >= a2.e().k()) {
                a.h(true);
                a.c(o16.b(this) - a2.e().k());
                return;
            }
            a.h(false);
        }
    }
}
