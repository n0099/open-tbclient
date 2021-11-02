package com.faceunity.gles;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
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
    /* loaded from: classes11.dex */
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

        public Image(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        GRID = new int[]{BaseAnimatedElement.DEBUG_PAINT_COLOR, -16711681, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, -65281, -1, 1073742079, 1073807104, -16711681, -65281, 65280, -2147483393, -16777216, -256, -65281, -256, -65536};
        sCoarseImageData = generateCoarseData();
        sFineImageData = generateFineData();
    }

    public GeneratedTexture() {
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

    public static void checkerPattern(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
            for (int i9 = i3; i9 < i5; i9++) {
                int i10 = i9 * 64 * 4;
                for (int i11 = i2; i11 < i4; i11++) {
                    int i12 = (i11 * 4) + i10;
                    int i13 = ((i9 & i8) ^ (i11 & i8)) == 0 ? i6 : i7;
                    int i14 = i13 & 255;
                    int i15 = (i13 >> 24) & 255;
                    float f2 = i15 / 255.0f;
                    bArr[i12] = (byte) (i14 * f2);
                    bArr[i12 + 1] = (byte) (((i13 >> 8) & 255) * f2);
                    bArr[i12 + 2] = (byte) (((i13 >> 16) & 255) * f2);
                    bArr[i12 + 3] = (byte) i15;
                }
            }
        }
    }

    public static int createTestTexture(Image image) {
        InterceptResult invokeL;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, image)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$faceunity$gles$GeneratedTexture$Image[image.ordinal()];
            if (i2 == 1) {
                byteBuffer = sCoarseImageData;
            } else if (i2 == 2) {
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
            for (int i2 = 0; i2 < 16384; i2 += 4) {
                int i3 = i2 / 4;
                int i4 = GRID[(((i3 / 64) / 16) * 4) + ((i3 % 64) / 16)];
                if (i2 == 0 || i2 == 16380) {
                    i4 = -1;
                }
                int i5 = i4 & 255;
                int i6 = (i4 >> 24) & 255;
                float f2 = i6 / 255.0f;
                bArr[i2] = (byte) (i5 * f2);
                bArr[i2 + 1] = (byte) (((i4 >> 8) & 255) * f2);
                bArr[i2 + 2] = (byte) (((i4 >> 16) & 255) * f2);
                bArr[i2 + 3] = (byte) i6;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            byte[] bArr = new byte[16384];
            checkerPattern(bArr, 0, 0, 32, 32, BaseAnimatedElement.DEBUG_PAINT_COLOR, -65536, 1);
            checkerPattern(bArr, 32, 32, 64, 64, BaseAnimatedElement.DEBUG_PAINT_COLOR, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK, 2);
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
