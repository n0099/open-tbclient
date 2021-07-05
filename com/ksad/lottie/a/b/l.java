package com.ksad.lottie.a.b;

import android.graphics.Path;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class l extends a<com.ksad.lottie.model.content.h, Path> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.content.h f33693c;

    /* renamed from: d  reason: collision with root package name */
    public final Path f33694d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.h>> list) {
        super(list);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33693c = new com.ksad.lottie.model.content.h();
        this.f33694d = new Path();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Path a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.h> aVar, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, f2)) == null) {
            this.f33693c.a(aVar.f33774a, aVar.f33775b, f2);
            com.ksad.lottie.d.e.a(this.f33693c, this.f33694d);
            return this.f33694d;
        }
        return (Path) invokeLF.objValue;
    }
}
