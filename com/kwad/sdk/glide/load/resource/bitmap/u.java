package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.glide.load.f<Bitmap, Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.glide.load.engine.s<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f38252a;

        public a(@NonNull Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38252a = bitmap;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        @NonNull
        public Class<Bitmap> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Bitmap.class : (Class) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.s
        @NonNull
        /* renamed from: b */
        public Bitmap e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38252a : (Bitmap) invokeV.objValue;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.glide.g.k.a(this.f38252a) : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.load.engine.s
        public void d_() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    public u() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Bitmap bitmap, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? new a(bitmap) : (com.kwad.sdk.glide.load.engine.s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, eVar)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }
}
