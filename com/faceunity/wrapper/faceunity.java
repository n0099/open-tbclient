package com.faceunity.wrapper;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class faceunity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FU_ADM_FLAG_ENABLE_READBACK = 2;
    public static final int FU_ADM_FLAG_EXTERNAL_OES_TEXTURE = 1;
    public static final int FU_ADM_FLAG_FLIP_X = 32;
    public static final int FU_ADM_FLAG_FLIP_Y = 64;
    public static final int FU_ADM_FLAG_I420_BUFFER = 16;
    public static final int FU_ADM_FLAG_I420_TEXTURE = 8;
    public static final int FU_ADM_FLAG_NV21_TEXTURE = 4;
    public static final int FU_ADM_FLAG_RGBA_BUFFER = 128;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_OPPOSITE_X = 256;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_OPPOSITE_Y = 512;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_ROTATE_180 = 2048;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_ROTATE_270 = 4096;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_ROTATE_90 = 1024;
    public static final int FU_ADM_FLAG_TEXTURE_ROTATE_180 = 16384;
    public static final int FU_ADM_FLAG_TEXTURE_ROTATE_270 = 32768;
    public static final int FU_ADM_FLAG_TEXTURE_ROTATE_90 = 8192;
    public static final int FU_FORMAT_GL_CURRENT_FRAMEBUFFER = 3;
    public static final int FU_FORMAT_I420_BUFFER = 13;
    public static final int FU_FORMAT_NV12_BUFFER = 8;
    public static final int FU_FORMAT_NV21_BUFFER = 2;
    public static final int FU_FORMAT_RGBA_BUFFER = 4;
    public static final int FU_FORMAT_RGBA_TEXTURE = 1;
    public static final String TAG = "faceunity-wrapper";
    public static boolean isDebug;
    public static int[] ret_tex;
    public static int[] ret_wh;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class FUImage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public int f54100h;
        public byte[] nv21_data;
        public int tex;
        public int w;

        public FUImage() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-881944240, "Lcom/faceunity/wrapper/faceunity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-881944240, "Lcom/faceunity/wrapper/faceunity;");
                return;
            }
        }
        ret_wh = new int[2];
        ret_tex = new int[1];
        System.loadLibrary("nama");
    }

    public faceunity() {
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

    @Deprecated
    public static native int fuAvatarBindItems(int i2, int[] iArr, int[] iArr2);

    public static native int fuAvatarToImage(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i2, int i3, int i4, int i5, int[] iArr, int i6, int i7, int i8, byte[] bArr);

    public static native int fuAvatarToTexture(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i2, int i3, int i4, int i5, int[] iArr, int i6);

    public static native int fuAvatarToTextureWithTrans(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, int i2, int i3, int i4, int i5, int[] iArr, int i6);

    @Deprecated
    public static native int fuAvatarUnbindItems(int i2, int[] iArr);

    public static native int fuBeautifyImage(int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuBindItems(int i2, int[] iArr);

    public static native int fuCheckDebugItem(byte[] bArr);

    public static native int fuClearReadbackRelated();

    public static native void fuCreateEGLContext();

    public static native int fuCreateItemFromPackage(byte[] bArr);

    public static native int fuCreateTexForItem(int i2, String str, byte[] bArr, int i3, int i4);

    public static native int fuDeleteTexForItem(int i2, String str);

    public static native void fuDestroyAllItems();

    public static native void fuDestroyItem(int i2);

    public static native void fuDisableBoostWithEGLImage();

    public static native void fuDone();

    public static native int fuDualInputToTexture(long j2, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int[] iArr);

    public static native int fuDualInputToTexture(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, byte[] bArr2);

    public static native int fuDualInputToTextureMasked(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int[] iArr, int[] iArr2);

    public static native int fuGetFaceInfo(int i2, String str, float[] fArr);

    public static native int fuGetModuleCode(int i2);

    public static native int fuGetSystemError();

    public static native String fuGetSystemErrorString(int i2);

    public static native String fuGetVersion();

    public static native int fuHasFace();

    public static native int fuIsTracking();

    public static native double fuItemGetParam(int i2, String str);

    public static native String fuItemGetParamString(int i2, String str);

    public static native byte[] fuItemGetParamu8v(int i2, String str);

    public static native int fuItemSetParam(int i2, String str, double d2);

    public static native int fuItemSetParam(int i2, String str, String str2);

    public static native int fuItemSetParam(int i2, String str, double[] dArr);

    public static native int fuItemSetParamu8v(int i2, String str, byte[] bArr, int i3);

    public static native int fuLoadAnimModel(byte[] bArr);

    public static native int fuLoadExtendedARData(byte[] bArr);

    public static native int fuLoadTongueModel(byte[] bArr);

    public static native void fuOnCameraChange();

    public static native void fuOnDeviceLost();

    public static native void fuReleaseEGLContext();

    public static native int fuRenderI420ImageToTexture(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderNV21ImageToTexture(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToI420Image(long j2, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToI420Image(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToI420Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToI420Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr2);

    public static native int fuRenderToI420ImageMasked(byte[] bArr, int i2, int i3, int i4, int[] iArr, int[] iArr2);

    public static native int fuRenderToNV21Image(long j2, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToNV21Image(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToNV21Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToNV21Image(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr2);

    public static native int fuRenderToNV21ImageMasked(byte[] bArr, int i2, int i3, int i4, int[] iArr, int[] iArr2);

    public static native int fuRenderToRgbaImage(long j2, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i2, int i3, int i4, int[] iArr);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5);

    public static native int fuRenderToRgbaImage(byte[] bArr, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, byte[] bArr2);

    public static native int fuRenderToTexture(int i2, int i3, int i4, int i5, int[] iArr, int i6);

    public static native int fuRenderToTexture(int i2, int i3, int i4, int i5, int[] iArr, int i6, byte[] bArr, int i7, int i8);

    public static native int fuRenderToYUVImage(long j2, long j3, long j4, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr);

    public static native int fuRenderToYUVImage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr);

    public static native int fuRenderToYUVImage(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8);

    public static native int fuSetAsyncTrackFace(int i2);

    public static native int fuSetDefaultOrientation(int i2);

    public static native void fuSetDefaultRotationMode(int i2);

    public static native void fuSetExpressionCalibration(int i2);

    public static native void fuSetFocalLengthScale(float f2);

    public static native int fuSetMaxFaces(int i2);

    public static native void fuSetQualityTradeoff(float f2);

    public static native void fuSetStrictTracking(int i2);

    public static native int fuSetup(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native void fuTrackFace(byte[] bArr, int i2, int i3, int i4);

    public static native int fuUnBindItems(int i2, int[] iArr);

    public static native int fuUnbindAllItems(int i2);
}
