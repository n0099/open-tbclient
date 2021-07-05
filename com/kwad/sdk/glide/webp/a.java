package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Registry;
/* loaded from: classes7.dex */
public final class a extends com.kwad.sdk.glide.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f38369a;

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
                return;
            }
        }
        this.f38369a = new f();
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.kwad.sdk.glide.samples.webp.WebpModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.kwad.sdk.glide.framesequence.FsGlideLibraryModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.kwad.sdk.glide.webp.WebpGlideLibraryModule");
        }
    }

    @Override // com.kwad.sdk.glide.d.b
    public void a(@NonNull Context context, @NonNull com.kwad.sdk.glide.c cVar, @NonNull Registry registry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, registry) == null) {
            new com.kwad.sdk.glide.framesequence.f().a(context, cVar, registry);
            new d().a(context, cVar, registry);
            this.f38369a.a(context, cVar, registry);
        }
    }

    @Override // com.kwad.sdk.glide.d.a
    public void a(@NonNull Context context, @NonNull com.kwad.sdk.glide.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, dVar) == null) {
            this.f38369a.a(context, dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.a
    @NonNull
    /* renamed from: b */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b() : (b) invokeV.objValue;
    }
}
