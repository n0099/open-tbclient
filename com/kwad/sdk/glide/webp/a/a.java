package com.kwad.sdk.glide.webp.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.d;
import com.kwad.sdk.glide.load.h;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.request.f;
/* loaded from: classes7.dex */
public final class a extends f implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: I */
    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (a) super.g() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: J */
    public a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (a) super.h() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    /* renamed from: K */
    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (a) super.i() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    /* renamed from: L */
    public a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (a) super.j() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.glide.request.a' to match base method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    public /* synthetic */ f a(@NonNull d dVar, @NonNull Object obj) {
        return b((d<d>) dVar, (d) obj);
    }

    /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.glide.request.a' to match base method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    public /* synthetic */ f a(@NonNull h hVar) {
        return c((h<Bitmap>) hVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @CheckResult
    /* renamed from: a */
    public a clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? (a) super.clone() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: a */
    public a b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) ? (a) super.b(i2, i3) : (a) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: a */
    public a b(@NonNull com.kwad.sdk.glide.request.a<?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, aVar)) == null) ? (a) super.b(aVar) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (a) super.f() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public a a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f2)) == null) ? (a) super.a(f2) : (a) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public a a(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, priority)) == null) ? (a) super.a(priority) : (a) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <Y> a b(@NonNull d<Y> dVar, @NonNull Y y) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, dVar, y)) == null) ? (a) super.a((d<d<Y>>) dVar, (d<Y>) y) : (a) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public a a(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, downsampleStrategy)) == null) ? (a) super.a(downsampleStrategy) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public <Y> a a(@NonNull Class<Y> cls, @NonNull h<Y> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, cls, hVar)) == null) ? (a) super.a(cls, hVar) : (a) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public a a(@NonNull com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, cVar)) == null) ? (a) super.a(cVar) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public a a(@NonNull com.kwad.sdk.glide.load.engine.h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, hVar)) == null) ? (a) super.a(hVar) : (a) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public a c(@NonNull h<Bitmap> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, hVar)) == null) ? (a) super.a(hVar) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public a a(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, cls)) == null) ? (a) super.a(cls) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) ? (a) super.a(z) : (a) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: d */
    public a a(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, drawable)) == null) ? (a) super.a(drawable) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: d */
    public a b(@NonNull h<Bitmap> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, hVar)) == null) ? (a) super.b(hVar) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: d */
    public a b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) ? (a) super.b(z) : (a) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: e */
    public a b(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, drawable)) == null) ? (a) super.b(drawable) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: f */
    public a c(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, drawable)) == null) ? (a) super.c(drawable) : (a) invokeL.objValue;
    }
}
