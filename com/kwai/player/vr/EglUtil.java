package com.kwai.player.vr;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes7.dex */
public class EglUtil {
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final int NO_TEXTURE = -1;
    public static final String TAG = "EglUtil";

    public static int createBuffer(FloatBuffer floatBuffer) {
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        updateBufferData(iArr[0], floatBuffer);
        return iArr[0];
    }

    public static int createBuffer(float[] fArr) {
        return createBuffer(toFloatBuffer(fArr));
    }

    public static int createProgram(int i2, int i3) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i2);
            GLES20.glAttachShader(glCreateProgram, i3);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 1) {
                return glCreateProgram;
            }
            GLES20.glDeleteProgram(glCreateProgram);
            throw new RuntimeException("Could not link program");
        }
        throw new RuntimeException("Could not create program");
    }

    public static int loadShader(String str, int i2) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e(TAG, "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader) + "throw it.");
            return 0;
        }
        return glCreateShader;
    }

    public static int loadTexture(Bitmap bitmap, int i2, boolean z) {
        int[] iArr = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i2;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static String readTextFileFromRaw(Context context, int i2) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i2)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append('\n');
            } catch (IOException unused) {
                return null;
            }
        }
    }

    public static void setupSampler(int i2, int i3, int i4) {
        GLES20.glTexParameterf(i2, 10240, i3);
        GLES20.glTexParameterf(i2, 10241, i4);
        GLES20.glTexParameteri(i2, 10242, 33071);
        GLES20.glTexParameteri(i2, 10243, 33071);
    }

    public static FloatBuffer toFloatBuffer(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    public static void updateBufferData(int i2, FloatBuffer floatBuffer) {
        GLES20.glBindBuffer(34962, i2);
        GLES20.glBufferData(34962, floatBuffer.capacity() * 4, floatBuffer, 35044);
        GLES20.glBindBuffer(34962, 0);
    }
}
