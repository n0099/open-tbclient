package com.kwad.sdk.glide.webp.decoder;

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
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.glide.load.f<InputStream, k> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38398a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<ByteBuffer, k> f38399b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f38400c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1391955021, "Lcom/kwad/sdk/glide/webp/decoder/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1391955021, "Lcom/kwad/sdk/glide/webp/decoder/g;");
                return;
            }
        }
        f38398a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.webp.decoder.StreamWebpDecoder.DisableAnimation", Boolean.FALSE);
    }

    public g(com.kwad.sdk.glide.load.f<ByteBuffer, k> fVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38399b = fVar;
        this.f38400c = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<k> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            byte[] a2 = h.a(inputStream);
            if (a2 == null) {
                return null;
            }
            return this.f38399b.a(ByteBuffer.wrap(a2), i2, i3, eVar);
        }
        return (s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, eVar)) == null) {
            if (((Boolean) eVar.a(f38398a)).booleanValue()) {
                return false;
            }
            return WebpHeaderParser.c(WebpHeaderParser.a(inputStream, this.f38400c));
        }
        return invokeLL.booleanValue;
    }
}
