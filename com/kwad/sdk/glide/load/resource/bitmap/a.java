package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a<DataType> implements com.kwad.sdk.glide.load.f<DataType, BitmapDrawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<DataType, Bitmap> f38204a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f38205b;

    public a(@NonNull Resources resources, @NonNull com.kwad.sdk.glide.load.f<DataType, Bitmap> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38205b = (Resources) com.kwad.sdk.glide.g.j.a(resources);
        this.f38204a = (com.kwad.sdk.glide.load.f) com.kwad.sdk.glide.g.j.a(fVar);
    }

    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(@NonNull DataType datatype, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{datatype, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) ? q.a(this.f38205b, this.f38204a.a(datatype, i2, i3, eVar)) : (com.kwad.sdk.glide.load.engine.s) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull DataType datatype, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, datatype, eVar)) == null) ? this.f38204a.a(datatype, eVar) : invokeLL.booleanValue;
    }
}
