package com.kwad.sdk.glide.webp.decoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.glide.webp.WebpHeaderParser;
import com.kwad.sdk.glide.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38385a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38386b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38387c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f38388d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1391954835, "Lcom/kwad/sdk/glide/webp/decoder/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1391954835, "Lcom/kwad/sdk/glide/webp/decoder/a;");
                return;
            }
        }
        f38385a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.AnimatedWebpBitmapDecoder.DisableBitmap", Boolean.FALSE);
    }

    public a(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38386b = bVar;
        this.f38387c = eVar;
        this.f38388d = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            byte[] a2 = h.a(inputStream);
            if (a2 == null) {
                return null;
            }
            return a(ByteBuffer.wrap(a2), i2, i3, eVar);
        }
        return (s) invokeCommon.objValue;
    }

    public s<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr, 0, remaining);
            WebpImage create = WebpImage.create(bArr);
            i iVar = new i(this.f38388d, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i2, i3));
            try {
                iVar.b();
                return com.kwad.sdk.glide.load.resource.bitmap.d.a(iVar.h(), this.f38387c);
            } finally {
                iVar.i();
            }
        }
        return (s) invokeCommon.objValue;
    }

    public boolean a(InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, eVar)) == null) {
            if (((Boolean) eVar.a(f38385a)).booleanValue()) {
                return false;
            }
            return WebpHeaderParser.c(WebpHeaderParser.a(inputStream, this.f38386b));
        }
        return invokeLL.booleanValue;
    }

    public boolean a(ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, byteBuffer, eVar)) == null) {
            if (((Boolean) eVar.a(f38385a)).booleanValue()) {
                return false;
            }
            return WebpHeaderParser.c(WebpHeaderParser.a(byteBuffer));
        }
        return invokeLL.booleanValue;
    }
}
