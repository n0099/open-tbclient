package com.kwad.sdk.glide.webp.a;

import android.content.Context;
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
import com.kwad.sdk.glide.f;
import com.kwad.sdk.glide.g;
import com.kwad.sdk.glide.load.d;
import com.kwad.sdk.glide.load.engine.h;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.request.e;
/* loaded from: classes7.dex */
public class b<TranscodeType> extends f<TranscodeType> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull com.kwad.sdk.glide.c cVar, @NonNull g gVar, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(cVar, gVar, cls, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, gVar, cls, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.kwad.sdk.glide.c) objArr2[0], (g) objArr2[1], (Class) objArr2[2], (Context) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: I */
    public b<TranscodeType> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (b) super.f() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: J */
    public b<TranscodeType> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (b) super.g() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: K */
    public b<TranscodeType> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (b) super.h() : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.f, com.kwad.sdk.glide.request.a
    @CheckResult
    /* renamed from: L */
    public b<TranscodeType> clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (b) super.clone() : (b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    public /* synthetic */ com.kwad.sdk.glide.request.a a(@NonNull d dVar, @NonNull Object obj) {
        return b((d<d>) dVar, (d) obj);
    }

    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    public /* synthetic */ com.kwad.sdk.glide.request.a a(@NonNull Class cls) {
        return b((Class<?>) cls);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f2)) == null) ? (b) super.a(f2) : (b) invokeF.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@NonNull Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, priority)) == null) ? (b) super.a(priority) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@NonNull com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, cVar)) == null) ? (b) super.a(cVar) : (b) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public <Y> b<TranscodeType> b(@NonNull d<Y> dVar, @NonNull Y y) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, dVar, y)) == null) ? (b) super.a((d<d<Y>>) dVar, (d<Y>) y) : (b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@NonNull h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, hVar)) == null) ? (b) super.a(hVar) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@NonNull DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, downsampleStrategy)) == null) ? (b) super.a(downsampleStrategy) : (b) invokeL.objValue;
    }

    @NonNull
    @CheckResult
    public b<TranscodeType> b(@NonNull Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, cls)) == null) ? (b) super.a(cls) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: b */
    public <Y> b<TranscodeType> a(@NonNull Class<Y> cls, @NonNull com.kwad.sdk.glide.load.h<Y> hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, cls, hVar)) == null) ? (b) super.a(cls, hVar) : (b) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.f
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, obj)) == null) ? (b) super.a(obj) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.f
    @NonNull
    @CheckResult
    /* renamed from: b */
    public b<TranscodeType> a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) ? (b) super.a(str) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public b<TranscodeType> b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048614, this, i2, i3)) == null) ? (b) super.b(i2, i3) : (b) invokeII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public b<TranscodeType> a(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, hVar)) == null) ? (b) super.a(hVar) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.f, com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public b<TranscodeType> b(@NonNull com.kwad.sdk.glide.request.a<?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, aVar)) == null) ? (b) super.a(aVar) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.f
    @NonNull
    @CheckResult
    /* renamed from: c */
    public b<TranscodeType> a(@Nullable e<TranscodeType> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, eVar)) == null) ? (b) super.a((e) eVar) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: c */
    public b<TranscodeType> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) ? (b) super.a(z) : (b) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: d */
    public b<TranscodeType> a(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, drawable)) == null) ? (b) super.a(drawable) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: d */
    public b<TranscodeType> b(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, hVar)) == null) ? (b) super.b(hVar) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.f
    @NonNull
    @CheckResult
    /* renamed from: d */
    public b<TranscodeType> b(@Nullable e<TranscodeType> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, eVar)) == null) ? (b) super.b((e) eVar) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: d */
    public b<TranscodeType> b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048623, this, z)) == null) ? (b) super.b(z) : (b) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: e */
    public b<TranscodeType> b(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, drawable)) == null) ? (b) super.b(drawable) : (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: f */
    public b<TranscodeType> c(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, drawable)) == null) ? (b) super.c(drawable) : (b) invokeL.objValue;
    }
}
