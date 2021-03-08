package com.yy.mediaframework.gles;

import android.annotation.TargetApi;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX = new float[16];
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "GlUtil";

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
    }

    private GlUtil() {
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int i = 0;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 != 0 && (loadShader = loadShader(35632, str2)) != 0) {
            int glCreateProgram = GLES20.glCreateProgram();
            checkGlError("glCreateProgram");
            if (glCreateProgram == 0) {
                YMFLog.error((Object) null, "[Util    ]", "Could not create program");
            }
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                YMFLog.error((Object) null, "[Util    ]", "Could not link program:" + GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
            } else {
                i = glCreateProgram;
            }
            GLES20.glDeleteShader(loadShader2);
            GLES20.glDeleteShader(loadShader);
        }
        return i;
    }

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlError("glCreateShader type:" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            YMFLog.error((Object) null, "[Util    ]", "Could not compile shader " + i + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            YMFLog.error((Object) null, "[Util    ]", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    public static void checkLocation(int i, String str) {
        if (i < 0) {
            throw new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public static int createImageTexture(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        checkGlError("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        checkGlError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        checkGlError("loadImageTexture");
        return i4;
    }

    public static int createOESTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static int createTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        return iArr[0];
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    @TargetApi(18)
    public static void logVersionInfo() {
        YMFLog.info(null, "[Util    ]", "vendor  :" + GLES20.glGetString(7936));
        YMFLog.info(null, "[Util    ]", "renderer:" + GLES20.glGetString(7937));
        YMFLog.info(null, "[Util    ]", "version :" + GLES20.glGetString(7938));
    }

    public String getGPUInfo() {
        String glGetString = GLES20.glGetString(7938);
        String glGetString2 = GLES20.glGetString(7936);
        String glGetString3 = GLES20.glGetString(7937);
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGetIntegerv(34930, allocate);
        int i = allocate.get(0);
        GLES20.glGetIntegerv(3379, allocate);
        String str = glGetString + ": " + glGetString2 + ": " + glGetString3 + ": " + i + ": " + allocate.get(0);
        YMFLog.info(null, "[Util    ]", str);
        return str;
    }

    public static String getGpuVendor() {
        return GLES20.glGetString(7937);
    }

    public static FloatBuffer setFlipX(FloatBuffer floatBuffer) {
        return createFloatBuffer(new float[]{floatBuffer.get(2), floatBuffer.get(3), floatBuffer.get(0), floatBuffer.get(1), floatBuffer.get(6), floatBuffer.get(7), floatBuffer.get(4), floatBuffer.get(5)});
    }

    public static FloatBuffer setFlipY(FloatBuffer floatBuffer) {
        return createFloatBuffer(new float[]{floatBuffer.get(4), floatBuffer.get(5), floatBuffer.get(6), floatBuffer.get(7), floatBuffer.get(0), floatBuffer.get(1), floatBuffer.get(2), floatBuffer.get(3)});
    }

    public static FloatBuffer adjustTexture(FloatBuffer floatBuffer, float f, float f2, float f3, float f4) {
        float max = Math.max(f3 / f, f4 / f2);
        float round = (1.0f - (1.0f / (Math.round(f * max) / f3))) / 2.0f;
        float round2 = (1.0f - (1.0f / (Math.round(max * f2) / f4))) / 2.0f;
        float[] fArr = {addDistance(floatBuffer.get(0), round), addDistance(floatBuffer.get(1), round2), addDistance(floatBuffer.get(2), round), addDistance(floatBuffer.get(3), round2), addDistance(floatBuffer.get(4), round), addDistance(floatBuffer.get(5), round2), addDistance(floatBuffer.get(6), round), addDistance(floatBuffer.get(7), round2)};
        YMFLog.info(null, "[Util    ]", "adjustTexture, textureCords:" + Arrays.toString(fArr));
        return createFloatBuffer(fArr);
    }

    public static FloatBuffer adjustTextureArea(RectF rectF, int i, int i2, boolean z) {
        float f = rectF.top / i2;
        float f2 = rectF.bottom / i2;
        float f3 = rectF.left / i;
        float f4 = rectF.right / i;
        YMFLog.info(null, "[Util    ]", "screenWidth:" + i + ", screenHeight:" + i2);
        float[] fArr = z ? new float[]{f3, f, f4, f, f3, f2, f4, f2} : new float[]{f3, f2, f4, f2, f3, f, f4, f};
        YMFLog.info(null, "[Util    ]", "adjustTextureArea textureCords:" + Arrays.toString(fArr));
        return createFloatBuffer(fArr);
    }

    private static float addDistance(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    public static FloatBuffer clip(FloatBuffer floatBuffer, int i, int i2, int i3, int i4, int i5) {
        if (floatBuffer == null) {
            YMFLog.error(TAG, "[Render  ]", "vertexSrcCoordinate null");
            return null;
        }
        float[] fArr = new float[8];
        float f = i / i2;
        float f2 = i3 / i4;
        floatBuffer.get(fArr, 0, 8);
        if (i5 == 1) {
            if (f < f2) {
                float f3 = f2 / f;
                fArr[1] = fArr[1] * f3;
                fArr[3] = fArr[3] * f3;
                fArr[5] = fArr[5] * f3;
                fArr[7] = f3 * fArr[7];
            } else {
                float f4 = f / f2;
                fArr[0] = fArr[0] * f4;
                fArr[2] = fArr[2] * f4;
                fArr[4] = fArr[4] * f4;
                fArr[6] = f4 * fArr[6];
            }
        } else if (i5 == 0) {
            if (f < f2) {
                float f5 = f / f2;
                fArr[0] = fArr[0] * f5;
                fArr[2] = fArr[2] * f5;
                fArr[4] = fArr[4] * f5;
                fArr[6] = f5 * fArr[6];
            } else {
                float f6 = f2 / f;
                fArr[1] = fArr[1] * f6;
                fArr[3] = fArr[3] * f6;
                fArr[5] = fArr[5] * f6;
                fArr[7] = f6 * fArr[7];
            }
        }
        return createFloatBuffer(fArr);
    }

    public static FloatBuffer adjustSlaveTexture(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        if (i3 == 0 || i4 == 0 || i == 0 || i2 == 0) {
            YMFLog.warn(null, "[Util    ]", "invalid size, return default texture coordinations");
            return null;
        }
        float f3 = (i3 * 1.0f) / i4;
        float f4 = (i * 1.0f) / i2;
        if (i3 == 720 && i4 == 1280) {
            if (f3 < f4) {
                f = (1.0f - (f3 / f4)) * 0.5f;
                f2 = 0.0f;
            }
            f = 0.0f;
            f2 = 0.0f;
        } else if (i3 == 1280 && i4 == 720) {
            if (f3 > f4) {
                f2 = 0.5f * (1.0f - (f4 / f3));
                f = 0.0f;
            }
            f = 0.0f;
            f2 = 0.0f;
        } else if (i3 == 480 && i4 == 640) {
            if (f3 > f4) {
                f2 = 0.5f * (1.0f - f3);
                f = 0.0f;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
        } else {
            if (i3 == 640 && i4 == 480) {
                if (f3 < f4) {
                    f = (1.0f - (1.0f / f3)) * 0.5f;
                    f2 = 0.0f;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
            }
            f = 0.0f;
            f2 = 0.0f;
        }
        float f5 = 1.0f - f2;
        float f6 = 1.0f - f;
        return createFloatBuffer(new float[]{f2, f, f5, f, f2, f6, f5, f6});
    }

    public static FloatBuffer adjustDualCameraSlaveTexture(YYMediaSample yYMediaSample, int i, int i2) {
        int i3;
        int i4;
        if (i < i2) {
            i3 = 16;
            i4 = 9;
        } else if (i > i2) {
            i3 = 9;
            i4 = 16;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (i * i3 == i2 * i4) {
            return null;
        }
        FloatBuffer adjustSlaveTexture = adjustSlaveTexture(i4, i3, i, i2);
        if (yYMediaSample.mOrientation == 1 && yYMediaSample.mOrginalCameraFacing != yYMediaSample.mCameraFacing) {
            return setFlipY(adjustSlaveTexture);
        }
        return adjustSlaveTexture;
    }
}
