package org.webrtc;

import android.opengl.GLES20;
import com.baidu.wallet.core.StatusCode;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes8.dex */
public class GlShader {
    public static final String TAG = "GlShader";
    public int program;

    public GlShader(String str, String str2) {
        int compileShader = compileShader(35633, str);
        int compileShader2 = compileShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        this.program = glCreateProgram;
        if (glCreateProgram == 0) {
            throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(glCreateProgram, compileShader);
        GLES20.glAttachShader(this.program, compileShader2);
        GLES20.glLinkProgram(this.program);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
        if (iArr[0] == 1) {
            GLES20.glDeleteShader(compileShader);
            GLES20.glDeleteShader(compileShader2);
            GlUtil.checkNoGLES2Error("Creating GlShader");
            return;
        }
        Logging.e(TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
        throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
    }

    public static int compileShader(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            GlUtil.checkNoGLES2Error("compileShader");
            return glCreateShader;
        }
        Logging.e(TAG, "Compile error " + GLES20.glGetShaderInfoLog(glCreateShader) + " in shader:\n" + str);
        throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
    }

    public int getAttribLocation(String str) {
        int i2 = this.program;
        if (i2 != -1) {
            int glGetAttribLocation = GLES20.glGetAttribLocation(i2, str);
            if (glGetAttribLocation >= 0) {
                return glGetAttribLocation;
            }
            throw new RuntimeException("Could not locate '" + str + "' in program");
        }
        throw new RuntimeException("The program has been released");
    }

    public int getUniformLocation(String str) {
        int i2 = this.program;
        if (i2 != -1) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(i2, str);
            if (glGetUniformLocation >= 0) {
                return glGetUniformLocation;
            }
            throw new RuntimeException("Could not locate uniform '" + str + "' in program");
        }
        throw new RuntimeException("The program has been released");
    }

    public void release() {
        Logging.d(TAG, "Deleting shader.");
        int i2 = this.program;
        if (i2 != -1) {
            GLES20.glDeleteProgram(i2);
            this.program = -1;
        }
    }

    public void setVertexAttribArray(String str, int i2, int i3, FloatBuffer floatBuffer) {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        int attribLocation = getAttribLocation(str);
        GLES20.glEnableVertexAttribArray(attribLocation);
        GLES20.glVertexAttribPointer(attribLocation, i2, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, i3, (Buffer) floatBuffer);
        GlUtil.checkNoGLES2Error("setVertexAttribArray");
    }

    public void setVertexAttribArray(String str, int i2, FloatBuffer floatBuffer) {
        setVertexAttribArray(str, i2, 0, floatBuffer);
    }

    public void useProgram() {
        int i2 = this.program;
        if (i2 == -1) {
            throw new RuntimeException("The program has been released");
        }
        GLES20.glUseProgram(i2);
        GlUtil.checkNoGLES2Error("glUseProgram");
    }
}
