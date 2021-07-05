package com.kwad.sdk.glide.framesequence;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.engine.s;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.glide.load.f<ByteBuffer, FrameSequence> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f37717a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f37718b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final List<ImageHeaderParser> f37719c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(460487488, "Lcom/kwad/sdk/glide/framesequence/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(460487488, "Lcom/kwad/sdk/glide/framesequence/a;");
                return;
            }
        }
        f37717a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.ByteBufferFsDecoder.DisableAnimation", Boolean.FALSE);
        f37718b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.framesequence.ByteBufferFsDecoder.DisableWebp", Boolean.FALSE);
    }

    public a(List<ImageHeaderParser> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37719c = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<FrameSequence> a(ByteBuffer byteBuffer, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr, 0, remaining);
            FrameSequence decodeByteArray = FrameSequence.decodeByteArray(bArr);
            if (decodeByteArray == null) {
                return null;
            }
            return new b(decodeByteArray);
        }
        return (s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(ByteBuffer byteBuffer, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, byteBuffer, eVar)) == null) {
            if (((Boolean) eVar.a(f37717a)).booleanValue()) {
                return false;
            }
            byteBuffer.mark();
            ImageHeaderParser.ImageType a2 = com.kwad.sdk.glide.load.b.a(this.f37719c, byteBuffer);
            byteBuffer.reset();
            if (a2 == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
            if (((Boolean) eVar.a(f37718b)).booleanValue() || !(a2 == ImageHeaderParser.ImageType.WEBP || a2 == ImageHeaderParser.ImageType.WEBP_A)) {
                return false;
            }
            return WebpHeaderParser.a(WebpHeaderParser.a(byteBuffer));
        }
        return invokeLL.booleanValue;
    }
}
