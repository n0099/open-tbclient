package com.kwad.sdk.glide.webp.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.glide.load.f<ByteBuffer, k> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38391a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f38392b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38393c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f38394d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1391954928, "Lcom/kwad/sdk/glide/webp/decoder/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1391954928, "Lcom/kwad/sdk/glide/webp/decoder/d;");
                return;
            }
        }
        f38391a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", Boolean.FALSE);
    }

    public d(Context context, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38392b = context.getApplicationContext();
        this.f38393c = eVar;
        this.f38394d = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<k> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr, 0, remaining);
            WebpImage create = WebpImage.create(bArr);
            i iVar = new i(this.f38394d, create, byteBuffer, h.a(create.getWidth(), create.getHeight(), i2, i3), (WebpFrameCacheStrategy) eVar.a(o.f38430a));
            iVar.b();
            Bitmap h2 = iVar.h();
            if (h2 == null) {
                return null;
            }
            return new m(new k(this.f38392b, iVar, this.f38393c, com.kwad.sdk.glide.load.resource.b.a(), i2, i3, h2));
        }
        return (s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, byteBuffer, eVar)) == null) {
            if (((Boolean) eVar.a(f38391a)).booleanValue()) {
                return false;
            }
            return WebpHeaderParser.c(WebpHeaderParser.a(byteBuffer));
        }
        return invokeLL.booleanValue;
    }
}
