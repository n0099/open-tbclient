package com.kwad.sdk.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
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
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes7.dex */
public final class j implements ImageHeaderParser {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f38217a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f38218b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f38219a;

        public a(ByteBuffer byteBuffer) {
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
            this.f38219a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((c() << 8) & 65280) | (c() & 255) : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
                int min = Math.min(i2, this.f38219a.remaining());
                if (min == 0) {
                    return -1;
                }
                this.f38219a.get(bArr, 0, min);
                return min;
            }
            return invokeLI.intValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                int min = (int) Math.min(this.f38219a.remaining(), j);
                ByteBuffer byteBuffer = this.f38219a;
                byteBuffer.position(byteBuffer.position() + min);
                return min;
            }
            return invokeJ.longValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public short b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (short) (c() & 255) : invokeV.shortValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f38219a.remaining() < 1) {
                    return -1;
                }
                return this.f38219a.get();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f38220a;

        public b(byte[] bArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38220a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65537, this, i2, i3)) == null) ? this.f38220a.remaining() - i2 >= i3 : invokeII.booleanValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38220a.remaining() : invokeV.intValue;
        }

        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (a(i2, 4)) {
                    return this.f38220a.getInt(i2);
                }
                return -1;
            }
            return invokeI.intValue;
        }

        public void a(ByteOrder byteOrder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteOrder) == null) {
                this.f38220a.order(byteOrder);
            }
        }

        public short b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                if (a(i2, 2)) {
                    return this.f38220a.getShort(i2);
                }
                return (short) -1;
            }
            return invokeI.shortValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        int a();

        int a(byte[] bArr, int i2);

        long a(long j);

        short b();

        int c();
    }

    /* loaded from: classes7.dex */
    public static final class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f38221a;

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
            this.f38221a = inputStream;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((this.f38221a.read() << 8) & 65280) | (this.f38221a.read() & 255) : invokeV.intValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
                int i3 = i2;
                while (i3 > 0) {
                    int read = this.f38221a.read(bArr, i2 - i3, i3);
                    if (read == -1) {
                        break;
                    }
                    i3 -= read;
                }
                return i2 - i3;
            }
            return invokeLI.intValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                if (j < 0) {
                    return 0L;
                }
                long j2 = j;
                while (j2 > 0) {
                    long skip = this.f38221a.skip(j2);
                    if (skip <= 0) {
                        if (this.f38221a.read() == -1) {
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

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public short b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (short) (this.f38221a.read() & 255) : invokeV.shortValue;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38221a.read() : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32649324, "Lcom/kwad/sdk/glide/load/resource/bitmap/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32649324, "Lcom/kwad/sdk/glide/load/resource/bitmap/j;");
                return;
            }
        }
        f38217a = DefaultImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
        f38218b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? i2 + 2 + (i3 * 12) : invokeII.intValue;
    }

    public static int a(b bVar) {
        InterceptResult invokeL;
        ByteOrder byteOrder;
        StringBuilder sb;
        String str;
        String sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            short b2 = bVar.b(6);
            if (b2 != 18761) {
                if (b2 != 19789 && Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    Log.d(DefaultImageHeaderParser.TAG, "Unknown endianness = " + ((int) b2));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            bVar.a(byteOrder);
            int a2 = bVar.a(10) + 6;
            short b3 = bVar.b(a2);
            for (int i2 = 0; i2 < b3; i2++) {
                int a3 = a(a2, i2);
                short b4 = bVar.b(a3);
                if (b4 == 274) {
                    short b5 = bVar.b(a3 + 2);
                    if (b5 >= 1 && b5 <= 12) {
                        int a4 = bVar.a(a3 + 4);
                        if (a4 >= 0) {
                            if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                                Log.d(DefaultImageHeaderParser.TAG, "Got tagIndex=" + i2 + " tagType=" + ((int) b4) + " formatCode=" + ((int) b5) + " componentCount=" + a4);
                            }
                            int i3 = a4 + f38218b[b5];
                            if (i3 <= 4) {
                                int i4 = a3 + 8;
                                if (i4 < 0 || i4 > bVar.a()) {
                                    if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                                        sb2 = "Illegal tagValueOffset=" + i4 + " tagType=" + ((int) b4);
                                        Log.d(DefaultImageHeaderParser.TAG, sb2);
                                    }
                                } else if (i3 >= 0 && i3 + i4 <= bVar.a()) {
                                    return bVar.b(i4);
                                } else {
                                    if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                                        sb = new StringBuilder();
                                        sb.append("Illegal number of bytes for TI tag data tagType=");
                                        sb.append((int) b4);
                                    }
                                }
                            } else if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                                sb = new StringBuilder();
                                str = "Got byte count > 4, not orientation, continuing, formatCode=";
                                sb.append(str);
                                sb.append((int) b5);
                            }
                        } else if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                            sb2 = "Negative tiff component count";
                            Log.d(DefaultImageHeaderParser.TAG, sb2);
                        }
                    } else if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                        sb = new StringBuilder();
                        str = "Got invalid format code = ";
                        sb.append(str);
                        sb.append((int) b5);
                    }
                    sb2 = sb.toString();
                    Log.d(DefaultImageHeaderParser.TAG, sb2);
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    private int a(c cVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, cVar, bVar)) == null) {
            int a2 = cVar.a();
            if (!a(a2)) {
                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    Log.d(DefaultImageHeaderParser.TAG, "Parser doesn't handle magic number: " + a2);
                }
                return -1;
            }
            int b2 = b(cVar);
            if (b2 == -1) {
                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    Log.d(DefaultImageHeaderParser.TAG, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
            try {
                return a(cVar, bArr, b2);
            } finally {
                bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            }
        }
        return invokeLL.intValue;
    }

    private int a(c cVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, this, cVar, bArr, i2)) == null) {
            int a2 = cVar.a(bArr, i2);
            if (a2 == i2) {
                if (a(bArr, i2)) {
                    return a(new b(bArr, i2));
                }
                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    Log.d(DefaultImageHeaderParser.TAG, "Missing jpeg exif preamble");
                }
                return -1;
            }
            if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                Log.d(DefaultImageHeaderParser.TAG, "Unable to read exif segment data, length: " + i2 + ", actually read: " + a2);
            }
            return -1;
        }
        return invokeLLI.intValue;
    }

    @NonNull
    private ImageHeaderParser.ImageType a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, cVar)) == null) {
            int a2 = cVar.a();
            if (a2 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int a3 = ((a2 << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
            if (a3 == -1991225785) {
                cVar.a(21L);
                return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
            } else if ((a3 >> 8) == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            } else {
                if (a3 != 1380533830) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                cVar.a(4L);
                if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int a4 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
                if ((a4 & (-256)) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i2 = a4 & 255;
                if (i2 == 88) {
                    cVar.a(4L);
                    return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i2 == 76) {
                    cVar.a(4L);
                    return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else {
                    return ImageHeaderParser.ImageType.WEBP;
                }
            }
        }
        return (ImageHeaderParser.ImageType) invokeL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? (i2 & DefaultImageHeaderParser.EXIF_MAGIC_NUMBER) == 65496 || i2 == 19789 || i2 == 18761 : invokeI.booleanValue;
    }

    private boolean a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, bArr, i2)) == null) {
            boolean z = bArr != null && i2 > f38217a.length;
            if (z) {
                int i3 = 0;
                while (true) {
                    byte[] bArr2 = f38217a;
                    if (i3 >= bArr2.length) {
                        break;
                    } else if (bArr[i3] != bArr2[i3]) {
                        return false;
                    } else {
                        i3++;
                    }
                }
            }
            return z;
        }
        return invokeLI.booleanValue;
    }

    private int b(c cVar) {
        short b2;
        short b3;
        int a2;
        long j;
        long a3;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cVar)) == null) {
            do {
                if (cVar.b() != 255) {
                    if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                        Log.d(DefaultImageHeaderParser.TAG, "Unknown segmentId=" + ((int) b2));
                    }
                    return -1;
                }
                b3 = cVar.b();
                if (b3 == 218) {
                    return -1;
                }
                if (b3 == 217) {
                    if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                        Log.d(DefaultImageHeaderParser.TAG, "Found MARKER_EOI in exif segment");
                    }
                    return -1;
                }
                a2 = cVar.a() - 2;
                if (b3 == 225) {
                    return a2;
                }
                j = a2;
                a3 = cVar.a(j);
            } while (a3 == j);
            if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                Log.d(DefaultImageHeaderParser.TAG, "Unable to skip enough data, type: " + ((int) b3) + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, inputStream, bVar)) == null) ? a(new d((InputStream) com.kwad.sdk.glide.g.j.a(inputStream)), (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar)) : invokeLL.intValue;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) ? a(new d((InputStream) com.kwad.sdk.glide.g.j.a(inputStream))) : (ImageHeaderParser.ImageType) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) ? a(new a((ByteBuffer) com.kwad.sdk.glide.g.j.a(byteBuffer))) : (ImageHeaderParser.ImageType) invokeL.objValue;
    }
}
