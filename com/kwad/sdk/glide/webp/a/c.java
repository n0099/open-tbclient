package com.kwad.sdk.glide.webp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.c.h;
import com.kwad.sdk.glide.c.l;
import com.kwad.sdk.glide.g;
import com.kwad.sdk.glide.request.f;
/* loaded from: classes7.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
        super(cVar, hVar, lVar, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, hVar, lVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.kwad.sdk.glide.c) objArr2[0], (h) objArr2[1], (l) objArr2[2], (Context) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.glide.g
    public void a(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            if (!(fVar instanceof a)) {
                fVar = new a().b(fVar);
            }
            super.a(fVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<Drawable> a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? (b) super.a(str) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: c */
    public <ResourceType> b<ResourceType> a(@NonNull Class<ResourceType> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? new b<>(this.f37735a, this, cls, this.f37736b) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: j */
    public b<Bitmap> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (b) super.f() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g
    @NonNull
    @CheckResult
    /* renamed from: k */
    public b<Drawable> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (b) super.g() : (b) invokeV.objValue;
    }
}
