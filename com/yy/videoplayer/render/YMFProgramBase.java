package com.yy.videoplayer.render;

import android.opengl.GLES20;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class YMFProgramBase implements IProgram {
    private static final int INPUT_TYPE_ATTRIBUTE = 0;
    private static final int INPUT_TYPE_UNIFORM = 1;
    private static final String TAG = "YMFProgramBase";
    protected int mProgram;
    private YMFShader mShader;
    private HashMap<String, Integer> mHandleMap = new HashMap<>();
    private YMFShaderData mShaderData = new YMFShaderData();

    protected abstract void onSetAttributeValue();

    protected abstract void onSetUniformValue();

    protected abstract void onUnSetAttributeValue();

    /* JADX INFO: Access modifiers changed from: protected */
    public YMFProgramBase(String str, String str2) {
        this.mShader = new YMFShader(str, str2);
        if (this.mShader.ready()) {
            initProgram(this.mShader);
        }
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void useProgram() {
        GLES20.glUseProgram(this.mProgram);
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void flipVertical() {
        this.mShaderData.flipVertical(true);
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void flipHorizontal() {
        this.mShaderData.flipHorizontal(true);
    }

    @Override // com.yy.videoplayer.render.IProgram
    public boolean checkUpdateMirrorMode(boolean z) {
        return this.mShaderData.checkUpdateMirrorMode(z);
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void rotation(int i) {
        this.mShaderData.setRotation(i);
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void clip(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7;
        int i8 = (i4 - i3) + 1;
        int i9 = (i5 - i6) + 1;
        int i10 = 0;
        if (i8 != i) {
            if (i3 != 0) {
                i10 = 1;
            }
            i10 |= 2;
        }
        if (i9 != i2) {
            if (i6 != 0) {
                i10 |= 8;
            }
            i7 = i10 | 4;
        } else {
            i7 = i10;
        }
        if (z) {
            this.mShaderData.clip(i, i2, i3, i4, i5, i6);
        } else {
            this.mShaderData.clip(i, i2, i8, i9, i7);
        }
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void clip(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode) {
        this.mShaderData.clip(i, i2, i3, i4, scaleMode);
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void drawFrame() {
        onSetUniformValue();
        onSetAttributeValue();
        GLES20.glDrawArrays(5, 0, this.mShaderData.getVertexCount());
        onUnSetAttributeValue();
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void release() {
        if (this.mShader != null) {
            this.mShader.release();
            this.mShader = null;
        }
        if (this.mProgram != -1) {
            GLES20.glDeleteProgram(this.mProgram);
            this.mProgram = -1;
        }
        this.mHandleMap.clear();
        this.mShaderData = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getVertexCoordStride() {
        return this.mShaderData.getVertexCoordStride();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FloatBuffer getVertexCoordData() {
        return this.mShaderData.getVertexCoordData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTextureCoordStride() {
        return this.mShaderData.getTextureCoordStride();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FloatBuffer getTextureCoordData() {
        return this.mShaderData.getTextureCoordData();
    }

    protected FloatBuffer getWaterMarkCoordData() {
        return this.mShaderData.getWaterMarkCoordData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] getVertexMatrix() {
        return this.mShaderData.getVertexMatrix();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] getTextureMatrix() {
        return this.mShaderData.getTextureMatrix();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUniform1i(String str, int i) {
        int handle = getHandle(str, 1);
        if (handle != -1) {
            GLES20.glUniform1i(handle, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUniformMatrix4fv(String str, int i, boolean z, float[] fArr, int i2) {
        int handle = getHandle(str, 1);
        if (handle != -1) {
            GLES20.glUniformMatrix4fv(handle, i, z, fArr, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVertexAttribPointer(String str, int i, int i2, boolean z, int i3, Buffer buffer) {
        int handle = getHandle(str, 0);
        if (handle != -1) {
            GLES20.glEnableVertexAttribArray(handle);
            GLES20.glVertexAttribPointer(handle, i, i2, z, i3, buffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void unSetVertexAttribPointer(String str) {
        int handle = getHandle(str, 0);
        if (handle != -1) {
            GLES20.glDisableVertexAttribArray(handle);
        }
    }

    private int getHandle(String str, int i) {
        int glGetUniformLocation;
        if (this.mHandleMap.containsKey(str)) {
            return this.mHandleMap.get(str).intValue();
        }
        if (i == 0) {
            glGetUniformLocation = GLES20.glGetAttribLocation(this.mProgram, str);
        } else {
            glGetUniformLocation = i == 1 ? GLES20.glGetUniformLocation(this.mProgram, str) : -1;
        }
        if (glGetUniformLocation != -1) {
            this.mHandleMap.put(str, Integer.valueOf(glGetUniformLocation));
            return glGetUniformLocation;
        }
        YMFLog.error(this, "[Util    ]", "Could not get location for " + str);
        return glGetUniformLocation;
    }

    private void initProgram(YMFShader yMFShader) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, yMFShader.getVertexHandle());
            GLES20.glAttachShader(glCreateProgram, yMFShader.getFragmentHandle());
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
                release();
                YMFLog.error(this, "[Util    ]", "Link shader error:" + glGetProgramInfoLog);
                return;
            }
        }
        this.mProgram = glCreateProgram;
    }
}
