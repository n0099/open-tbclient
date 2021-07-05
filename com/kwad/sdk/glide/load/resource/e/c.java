package com.kwad.sdk.glide.load.resource.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public final class c implements e<Drawable, byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38305a;

    /* renamed from: b  reason: collision with root package name */
    public final e<Bitmap, byte[]> f38306b;

    /* renamed from: c  reason: collision with root package name */
    public final e<com.kwad.sdk.glide.load.resource.d.c, byte[]> f38307c;

    public c(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<com.kwad.sdk.glide.load.resource.d.c, byte[]> eVar3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, eVar2, eVar3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38305a = eVar;
        this.f38306b = eVar2;
        this.f38307c = eVar3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.kwad.sdk.glide.load.engine.s<android.graphics.drawable.Drawable> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static s<com.kwad.sdk.glide.load.resource.d.c> a(@NonNull s<Drawable> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sVar)) == null) ? sVar : (s) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    @Nullable
    public s<byte[]> a(@NonNull s<Drawable> sVar, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sVar, eVar)) == null) {
            Drawable e2 = sVar.e();
            if (e2 instanceof BitmapDrawable) {
                return this.f38306b.a(com.kwad.sdk.glide.load.resource.bitmap.d.a(((BitmapDrawable) e2).getBitmap(), this.f38305a), eVar);
            }
            if (e2 instanceof com.kwad.sdk.glide.load.resource.d.c) {
                return this.f38307c.a(a(sVar), eVar);
            }
            return null;
        }
        return (s) invokeLL.objValue;
    }
}
