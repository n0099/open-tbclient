package com.kwad.sdk.glide.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import androidx.core.internal.view.SupportMenu;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.webp.WebpSupportStatus;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public class WebpHeaderParser {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38362a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class WebpImageType {
        public static final /* synthetic */ WebpImageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final WebpImageType NONE_WEBP;
        public static final WebpImageType WEBP_EXTENDED;
        public static final WebpImageType WEBP_EXTENDED_ANIMATED;
        public static final WebpImageType WEBP_EXTENDED_WITH_ALPHA;
        public static final WebpImageType WEBP_LOSSLESS;
        public static final WebpImageType WEBP_LOSSLESS_WITH_ALPHA;
        public static final WebpImageType WEBP_SIMPLE;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean hasAlpha;
        public final boolean hasAnimation;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1387121808, "Lcom/kwad/sdk/glide/webp/WebpHeaderParser$WebpImageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1387121808, "Lcom/kwad/sdk/glide/webp/WebpHeaderParser$WebpImageType;");
                    return;
                }
            }
            WEBP_SIMPLE = new WebpImageType("WEBP_SIMPLE", 0, false, false);
            WEBP_LOSSLESS = new WebpImageType("WEBP_LOSSLESS", 1, false, false);
            WEBP_LOSSLESS_WITH_ALPHA = new WebpImageType("WEBP_LOSSLESS_WITH_ALPHA", 2, true, false);
            WEBP_EXTENDED = new WebpImageType("WEBP_EXTENDED", 3, false, false);
            WEBP_EXTENDED_WITH_ALPHA = new WebpImageType("WEBP_EXTENDED_WITH_ALPHA", 4, true, false);
            WEBP_EXTENDED_ANIMATED = new WebpImageType("WEBP_EXTENDED_ANIMATED", 5, false, true);
            WebpImageType webpImageType = new WebpImageType("NONE_WEBP", 6, false, false);
            NONE_WEBP = webpImageType;
            $VALUES = new WebpImageType[]{WEBP_SIMPLE, WEBP_LOSSLESS, WEBP_LOSSLESS_WITH_ALPHA, WEBP_EXTENDED, WEBP_EXTENDED_WITH_ALPHA, WEBP_EXTENDED_ANIMATED, webpImageType};
        }

        public WebpImageType(String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.hasAlpha = z;
            this.hasAnimation = z2;
        }

        public static WebpImageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (WebpImageType) Enum.valueOf(WebpImageType.class, str) : (WebpImageType) invokeL.objValue;
        }

        public static WebpImageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (WebpImageType[]) $VALUES.clone() : (WebpImageType[]) invokeV.objValue;
        }

        public boolean hasAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hasAlpha : invokeV.booleanValue;
        }

        public boolean hasAnimation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.hasAnimation : invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f38363a;

        /* renamed from: b  reason: collision with root package name */
        public final int f38364b;

        /* renamed from: c  reason: collision with root package name */
        public final int f38365c;

        /* renamed from: d  reason: collision with root package name */
        public int f38366d;

        public a(byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38363a = bArr;
            this.f38364b = i2;
            this.f38365c = i3;
            this.f38366d = i2;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((b() << 8) & 65280) | (b() & 255) : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                int min = (int) Math.min((this.f38364b + this.f38365c) - this.f38366d, j);
                this.f38366d += min;
                return min;
            }
            return invokeJ.longValue;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f38366d;
                if (i2 >= this.f38364b + this.f38365c) {
                    return -1;
                }
                byte[] bArr = this.f38363a;
                this.f38366d = i2 + 1;
                return bArr[i2];
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f38367a;

        public b(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38367a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((b() << 8) & 65280) | (b() & 255) : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                int min = (int) Math.min(this.f38367a.remaining(), j);
                ByteBuffer byteBuffer = this.f38367a;
                byteBuffer.position(byteBuffer.position() + min);
                return min;
            }
            return invokeJ.longValue;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f38367a.remaining() < 1) {
                    return -1;
                }
                return this.f38367a.get();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        int a();

        long a(long j);

        int b();
    }

    /* loaded from: classes7.dex */
    public static final class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f38368a;

        public d(InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38368a = inputStream;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((this.f38368a.read() << 8) & 65280) | (this.f38368a.read() & 255) : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (j < 0) {
                    return 0L;
                }
                long j2 = j;
                while (j2 > 0) {
                    long skip = this.f38368a.skip(j2);
                    if (skip <= 0) {
                        if (this.f38368a.read() == -1) {
                            break;
                        }
                        skip = 1;
                    }
                    j2 -= skip;
                }
                return j - j2;
            }
            return invokeJ.longValue;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38368a.read() : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2108946267, "Lcom/kwad/sdk/glide/webp/WebpHeaderParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2108946267, "Lcom/kwad/sdk/glide/webp/WebpHeaderParser;");
                return;
            }
        }
        f38362a = a();
    }

    public static WebpImageType a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cVar)) == null) {
            if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1380533830) {
                return WebpImageType.NONE_WEBP;
            }
            cVar.a(4L);
            if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1464156752) {
                return WebpImageType.NONE_WEBP;
            }
            int a2 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
            if (a2 == 1448097824) {
                return WebpImageType.WEBP_SIMPLE;
            }
            if (a2 == 1448097868) {
                cVar.a(4L);
                return (cVar.b() & 8) != 0 ? WebpImageType.WEBP_LOSSLESS_WITH_ALPHA : WebpImageType.WEBP_LOSSLESS;
            } else if (a2 == 1448097880) {
                cVar.a(4L);
                int b2 = cVar.b();
                return (b2 & 2) != 0 ? WebpImageType.WEBP_EXTENDED_ANIMATED : (b2 & 16) != 0 ? WebpImageType.WEBP_EXTENDED_WITH_ALPHA : WebpImageType.WEBP_EXTENDED;
            } else {
                return WebpImageType.NONE_WEBP;
            }
        }
        return (WebpImageType) invokeL.objValue;
    }

    public static WebpImageType a(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, bVar)) == null) {
            if (inputStream == null) {
                return WebpImageType.NONE_WEBP;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
            }
            inputStream.mark(21);
            try {
                return a(new d((InputStream) j.a(inputStream)));
            } finally {
                inputStream.reset();
            }
        }
        return (WebpImageType) invokeLL.objValue;
    }

    public static WebpImageType a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) ? byteBuffer == null ? WebpImageType.NONE_WEBP : a(new b((ByteBuffer) j.a(byteBuffer))) : (WebpImageType) invokeL.objValue;
    }

    public static WebpImageType a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65540, null, bArr, i2, i3)) == null) ? a(new a(bArr, i2, i3)) : (WebpImageType) invokeLII.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 17) {
                return false;
            }
            if (i2 == 17) {
                byte[] decode = Base64.decode(WebpSupportStatus.VP8X_WEBP_BASE64, 0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                if (options.outHeight != 1 || options.outWidth != 1) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean a(WebpImageType webpImageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, webpImageType)) == null) ? webpImageType == WebpImageType.WEBP_SIMPLE || webpImageType == WebpImageType.WEBP_LOSSLESS || webpImageType == WebpImageType.WEBP_LOSSLESS_WITH_ALPHA || webpImageType == WebpImageType.WEBP_EXTENDED || webpImageType == WebpImageType.WEBP_EXTENDED_WITH_ALPHA : invokeL.booleanValue;
    }

    public static boolean b(WebpImageType webpImageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, webpImageType)) == null) ? (webpImageType == WebpImageType.NONE_WEBP || webpImageType == WebpImageType.WEBP_SIMPLE) ? false : true : invokeL.booleanValue;
    }

    public static boolean c(WebpImageType webpImageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, webpImageType)) == null) ? webpImageType == WebpImageType.WEBP_EXTENDED_ANIMATED : invokeL.booleanValue;
    }
}
