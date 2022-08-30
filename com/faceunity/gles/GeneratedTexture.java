package com.faceunity.gles;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class GeneratedTexture {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLACK = 0;
    public static final int BLUE = 16711680;
    public static final int BYTES_PER_PIXEL = 4;
    public static final int CYAN = 16776960;
    public static final int FORMAT = 6408;
    public static final int GREEN = 65280;
    public static final int[] GRID;
    public static final int HALF = Integer.MIN_VALUE;
    public static final int LOW = 1073741824;
    public static final int MAGENTA = 16711935;
    public static final int OPAQUE = -16777216;
    public static final int RED = 255;
    public static final int TEX_SIZE = 64;
    public static final int TRANSP = 0;
    public static final int WHITE = 16777215;
    public static final int YELLOW = 65535;
    public static final ByteBuffer sCoarseImageData;
    public static final ByteBuffer sFineImageData;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.faceunity.gles.GeneratedTexture$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$faceunity$gles$GeneratedTexture$Image;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1285406455, "Lcom/faceunity/gles/GeneratedTexture$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1285406455, "Lcom/faceunity/gles/GeneratedTexture$1;");
                    return;
                }
            }
            int[] iArr = new int[Image.values().length];
            $SwitchMap$com$faceunity$gles$GeneratedTexture$Image = iArr;
            try {
                iArr[Image.COARSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$faceunity$gles$GeneratedTexture$Image[Image.FINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Image {
        public static final /* synthetic */ Image[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Image COARSE;
        public static final Image FINE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1695152301, "Lcom/faceunity/gles/GeneratedTexture$Image;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1695152301, "Lcom/faceunity/gles/GeneratedTexture$Image;");
                    return;
                }
            }
            COARSE = new Image("COARSE", 0);
            Image image = new Image("FINE", 1);
            FINE = image;
            $VALUES = new Image[]{COARSE, image};
        }

        public Image(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Image valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Image) Enum.valueOf(Image.class, str) : (Image) invokeL.objValue;
        }

        public static Image[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Image[]) $VALUES.clone() : (Image[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1717536804, "Lcom/faceunity/gles/GeneratedTexture;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1717536804, "Lcom/faceunity/gles/GeneratedTexture;");
                return;
            }
        }
        GRID = new int[]{-16776961, -16711681, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, -65281, -1, 1073742079, 1073807104, -16711681, -65281, 65280, -2147483393, -16777216, -256, -65281, -256, -65536};
        sCoarseImageData = generateCoarseData();
        sFineImageData = generateFineData();
    }

    public GeneratedTexture() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void checkerPattern(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            for (int i8 = i2; i8 < i4; i8++) {
                int i9 = i8 * 64 * 4;
                for (int i10 = i; i10 < i3; i10++) {
                    int i11 = (i10 * 4) + i9;
                    int i12 = ((i8 & i7) ^ (i10 & i7)) == 0 ? i5 : i6;
                    int i13 = i12 & 255;
                    int i14 = (i12 >> 24) & 255;
                    float f = i14 / 255.0f;
                    bArr[i11] = (byte) (i13 * f);
                    bArr[i11 + 1] = (byte) (((i12 >> 8) & 255) * f);
                    bArr[i11 + 2] = (byte) (((i12 >> 16) & 255) * f);
                    bArr[i11 + 3] = (byte) i14;
                }
            }
        }
    }

    public static int createTestTexture(Image image) {
        InterceptResult invokeL;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, image)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$faceunity$gles$GeneratedTexture$Image[image.ordinal()];
            if (i == 1) {
                byteBuffer = sCoarseImageData;
            } else if (i == 2) {
                byteBuffer = sFineImageData;
            } else {
                throw new RuntimeException("unknown image");
            }
            return GlUtil.createImageTexture(byteBuffer, 64, 64, FORMAT);
        }
        return invokeL.intValue;
    }

    public static ByteBuffer generateCoarseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            byte[] bArr = new byte[16384];
            for (int i = 0; i < 16384; i += 4) {
                int i2 = i / 4;
                int i3 = GRID[(((i2 / 64) / 16) * 4) + ((i2 % 64) / 16)];
                if (i == 0 || i == 16380) {
                    i3 = -1;
                }
                int i4 = i3 & 255;
                int i5 = (i3 >> 24) & 255;
                float f = i5 / 255.0f;
                bArr[i] = (byte) (i4 * f);
                bArr[i + 1] = (byte) (((i3 >> 8) & 255) * f);
                bArr[i + 2] = (byte) (((i3 >> 16) & 255) * f);
                bArr[i + 3] = (byte) i5;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
            allocateDirect.put(bArr);
            allocateDirect.position(0);
            return allocateDirect;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public static ByteBuffer generateFineData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            byte[] bArr = new byte[16384];
            checkerPattern(bArr, 0, 0, 32, 32, -16776961, -65536, 1);
            checkerPattern(bArr, 32, 32, 64, 64, -16776961, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, 2);
            checkerPattern(bArr, 0, 32, 32, 64, -65536, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, 4);
            checkerPattern(bArr, 32, 0, 64, 32, -1, -16777216, 8);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
            allocateDirect.put(bArr);
            allocateDirect.position(0);
            return allocateDirect;
        }
        return (ByteBuffer) invokeV.objValue;
    }
}
