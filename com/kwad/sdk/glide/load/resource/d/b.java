package com.kwad.sdk.glide.load.resource.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.b.a;
/* loaded from: classes7.dex */
public final class b implements a.InterfaceC0454a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38269a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38270b;

    public b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38269a = eVar;
        this.f38270b = bVar;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0454a
    @NonNull
    public Bitmap a(int i2, int i3, @NonNull Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, config)) == null) ? this.f38269a.b(i2, i3, config) : (Bitmap) invokeIIL.objValue;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0454a
    public void a(@NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            this.f38269a.a(bitmap);
        }
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0454a
    public void a(@NonNull byte[] bArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) || (bVar = this.f38270b) == null) {
            return;
        }
        bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0454a
    public void a(@NonNull int[] iArr) {
        com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) || (bVar = this.f38270b) == null) {
            return;
        }
        bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) iArr);
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0454a
    @NonNull
    public byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f38270b;
            return bVar == null ? new byte[i2] : (byte[]) bVar.a(i2, byte[].class);
        }
        return (byte[]) invokeI.objValue;
    }

    @Override // com.kwad.sdk.glide.b.a.InterfaceC0454a
    @NonNull
    public int[] b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar = this.f38270b;
            return bVar == null ? new int[i2] : (int[]) bVar.a(i2, int[].class);
        }
        return (int[]) invokeI.objValue;
    }
}
