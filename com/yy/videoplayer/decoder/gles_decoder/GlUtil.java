package com.yy.videoplayer.decoder.gles_decoder;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class GlUtil {
    public static final float[] IDENTITY_MATRIX = new float[16];
    private static final int SIZEOF_FLOAT = 4;
    public static final String TAG = "Grafika";

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
    }

    private GlUtil() {
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
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
            return 0;
        }
        return glCreateProgram;
    }

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlError("glCreateShader type:" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            YMFLog.error((Object) null, "[Util    ]", "Could not compile shader " + i + ":");
            YMFLog.error((Object) null, "[Util    ]", GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static void checkGlError(String str) {
        int glGetError;
        if (GLES20.glGetError() != 0) {
            String str2 = str + ": glError 0x" + Integer.toHexString(glGetError);
            YMFLog.error((Object) null, "[Util    ]", str2);
            throw new RuntimeException(str2);
        }
    }

    public static String getGpuVendor() {
        return GLES20.glGetString(7937);
    }

    public static int checkGlErrorNoException(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            YMFLog.error((Object) null, "[Util    ]", str + ": glError 0x" + Integer.toHexString(glGetError));
        }
        return glGetError;
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

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static void logVersionInfo() {
        YMFLog.info(null, "[Util    ]", "vendor  :" + GLES20.glGetString(7936));
        YMFLog.info(null, "[Util    ]", "renderer:" + GLES20.glGetString(7937));
        YMFLog.info(null, "[Util    ]", "version :" + GLES20.glGetString(7938));
    }
}
