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
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public class g implements com.kwad.sdk.glide.load.f<InputStream, FrameSequence> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f37728a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f37729b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final List<ImageHeaderParser> f37730c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37731d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(460487674, "Lcom/kwad/sdk/glide/framesequence/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(460487674, "Lcom/kwad/sdk/glide/framesequence/g;");
                return;
            }
        }
        f37728a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableAnimation", Boolean.FALSE);
        f37729b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.framesequence.StreamFsDecoder.DisableWebp", Boolean.FALSE);
    }

    public g(List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37730c = list;
        this.f37731d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<FrameSequence> a(InputStream inputStream, int i2, int i3, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            FrameSequence decodeStream = FrameSequence.decodeStream(inputStream);
            if (decodeStream == null) {
                return null;
            }
            return new b(decodeStream);
        }
        return (s) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(InputStream inputStream, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, eVar)) == null) {
            if (((Boolean) eVar.a(f37728a)).booleanValue()) {
                return false;
            }
            ImageHeaderParser.ImageType a2 = com.kwad.sdk.glide.load.b.a(this.f37730c, inputStream, this.f37731d);
            if (a2 == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
            if (((Boolean) eVar.a(f37729b)).booleanValue() || !(a2 == ImageHeaderParser.ImageType.WEBP || a2 == ImageHeaderParser.ImageType.WEBP_A)) {
                return false;
            }
            return WebpHeaderParser.a(WebpHeaderParser.a(inputStream, this.f37731d));
        }
        return invokeLL.booleanValue;
    }
}
