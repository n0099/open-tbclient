package com.yy.videoplayer.render;

import android.opengl.GLES20;
import com.yy.videoplayer.utils.YMFLog;
/* loaded from: classes6.dex */
public class YMFShader {
    private static final String TAG = "YMFShader";
    private int mFragmentHandle;
    private boolean mReady;
    private int mVertexHandle;

    public YMFShader(String str, String str2) {
        this.mVertexHandle = loadShader(35633, str);
        this.mFragmentHandle = loadShader(35632, str2);
        if (this.mVertexHandle > 0 && this.mFragmentHandle > 0) {
            this.mReady = true;
        }
    }

    public boolean ready() {
        return this.mReady;
    }

    public int getVertexHandle() {
        return this.mVertexHandle;
    }

    public int getFragmentHandle() {
        return this.mFragmentHandle;
    }

    public void release() {
        if (this.mVertexHandle != -1) {
            GLES20.glDeleteShader(this.mVertexHandle);
            this.mVertexHandle = -1;
        }
        if (this.mFragmentHandle != -1) {
            GLES20.glDeleteShader(this.mFragmentHandle);
            this.mFragmentHandle = -1;
        }
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
}
