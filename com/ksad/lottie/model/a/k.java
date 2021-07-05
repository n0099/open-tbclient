package com.ksad.lottie.model.a;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final a f33848a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final a f33849b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final b f33850c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final b f33851d;

    public k(@Nullable a aVar, @Nullable a aVar2, @Nullable b bVar, @Nullable b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33848a = aVar;
        this.f33849b = aVar2;
        this.f33850c = bVar;
        this.f33851d = bVar2;
    }
}
