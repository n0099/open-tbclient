package com.yy.mediaframework.gpuimage.util;

import android.content.Context;
import android.opengl.GLES20;
import com.yy.mediaframework.utils.YMFLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class GLShaderProgram {
    static final String Tag = "GLShaderProgram";
    private String fragmentSource;
    private String vertexSource;
    private int mProgram = -1;
    private int mShaderVertex = -1;
    private int mShaderFragment = -1;
    private final HashMap<String, Integer> mShaderHandleMap = new HashMap<>();

    public void setProgram(int i, int i2, Context context) {
        this.vertexSource = loadRawString(i, context);
        this.fragmentSource = loadRawString(i2, context);
        setProgram(this.vertexSource, this.fragmentSource);
    }

    public void setProgram(String str, String str2) {
        this.mShaderVertex = loadShader(35633, str);
        this.mShaderFragment = loadShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, this.mShaderVertex);
            GLES20.glAttachShader(glCreateProgram, this.mShaderFragment);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                destory();
                YMFLog.error(this, "[Util    ]", "Link shader error:" + glGetProgramInfoLog);
                return;
            }
        }
        this.mProgram = glCreateProgram;
        this.mShaderHandleMap.clear();
    }

    public void useProgram() {
        GLES20.glUseProgram(this.mProgram);
    }

    public void destory() {
        if (this.mProgram != -1) {
            GLES20.glDeleteShader(this.mShaderVertex);
            GLES20.glDeleteShader(this.mShaderFragment);
            GLES20.glDeleteProgram(this.mProgram);
            this.mShaderFragment = -1;
            this.mShaderVertex = -1;
            this.mProgram = -1;
        }
    }

    public int programHandle() {
        return this.mProgram;
    }

    public int getHandle(String str) {
        if (this.mShaderHandleMap.containsKey(str)) {
            return this.mShaderHandleMap.get(str).intValue();
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, str);
        if (glGetAttribLocation == -1) {
            glGetAttribLocation = GLES20.glGetUniformLocation(this.mProgram, str);
        }
        if (glGetAttribLocation == -1) {
            YMFLog.error(this, "[Util    ]", "GLSL shader, Could not get attrib location for " + str);
            return glGetAttribLocation;
        }
        this.mShaderHandleMap.put(str, Integer.valueOf(glGetAttribLocation));
        return glGetAttribLocation;
    }

    public int[] getHandles(String... strArr) {
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = getHandle(strArr[i]);
        }
        return iArr;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                YMFLog.error(this, "[Util    ]", "Compile shader error:" + glGetShaderInfoLog);
                return -1;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    private String loadRawString(int i, Context context) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = openRawResource.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            YMFLog.info(this, "[Util    ]", "loadRawString exception:" + e.getMessage());
        }
        return byteArrayOutputStream.toString();
    }

    public void setUniform1i(String str, int i) {
        GLES20.glUniform1i(getHandle(str), i);
    }

    public void setUniform2i(String str, int i, int i2) {
        GLES20.glUniform2i(getHandle(str), i, i2);
    }

    public void setUniform1f(String str, float f) {
        GLES20.glUniform1f(getHandle(str), f);
    }

    public void setUniform2f(String str, float f, float f2) {
        GLES20.glUniform2f(getHandle(str), f, f2);
    }

    public void setUniformMatrix4fv(String str, int i, boolean z, float[] fArr, int i2) {
        GLES20.glUniformMatrix4fv(getHandle(str), i, z, fArr, i2);
    }

    public void setVertexAttribPointer(String str, int i, int i2, boolean z, int i3, Buffer buffer) {
        int handle = getHandle(str);
        GLES20.glEnableVertexAttribArray(handle);
        GLES20.glVertexAttribPointer(handle, i, i2, z, i3, buffer);
    }

    public void disableVertexAttribPointer(String str) {
        GLES20.glDisableVertexAttribArray(getHandle(str));
    }

    public void setUniformTexture(String str, int i, int i2, int i3) {
        GLES20.glUniform1i(getHandle(str), i);
        GLES20.glActiveTexture(33984 + i);
        GLES20.glBindTexture(i3, i2);
    }
}
