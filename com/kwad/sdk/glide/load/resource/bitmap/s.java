package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.resource.bitmap.k;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class s implements com.kwad.sdk.glide.load.f<InputStream, Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final k f38243a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38244b;

    /* loaded from: classes7.dex */
    public static class a implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final RecyclableBufferedInputStream f38245a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.g.d f38246b;

        public a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.kwad.sdk.glide.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclableBufferedInputStream, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38245a = recyclableBufferedInputStream;
            this.f38246b = dVar;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38245a.a();
            }
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.k.a
        public void a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
            IOException a2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, bitmap) == null) || (a2 = this.f38246b.a()) == null) {
                return;
            }
            if (bitmap != null) {
                eVar.a(bitmap);
            }
            throw a2;
        }
    }

    public s(k kVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38243a = kVar;
        this.f38244b = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            if (inputStream instanceof RecyclableBufferedInputStream) {
                recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
                z = false;
            } else {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f38244b);
                z = true;
            }
            com.kwad.sdk.glide.g.d a2 = com.kwad.sdk.glide.g.d.a(recyclableBufferedInputStream);
            try {
                return this.f38243a.a(new com.kwad.sdk.glide.g.h(a2), i2, i3, eVar, new a(recyclableBufferedInputStream, a2));
            } finally {
                a2.b();
                if (z) {
                    recyclableBufferedInputStream.b();
                }
            }
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, eVar)) == null) ? this.f38243a.a(inputStream) : invokeLL.booleanValue;
    }
}
