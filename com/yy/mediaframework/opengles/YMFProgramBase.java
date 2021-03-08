package com.yy.mediaframework.opengles;

import android.opengl.GLES20;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class YMFProgramBase implements IProgram {
    private static final int INPUT_TYPE_ATTRIBUTE = 0;
    private static final int INPUT_TYPE_UNIFORM = 1;
    private static final String TAG = "YMFProgramBase";
    private int mProgram;
    private YMFShader mShader;
    private HashMap<String, Integer> mHandleMap = new HashMap<>();
    private YMFShaderData mShaderData = new YMFShaderData();

    protected abstract void onSetAttributeValue();

    protected abstract void onSetUniformValue();

    /* JADX INFO: Access modifiers changed from: protected */
    public YMFProgramBase(String str, String str2) {
        this.mShader = new YMFShader(str, str2);
        if (this.mShader.ready()) {
            initProgram(this.mShader);
        }
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void useProgram() {
        GLES20.glUseProgram(this.mProgram);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void flipReset() {
        this.mShaderData.flipReset();
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void flipVertical() {
        this.mShaderData.flipVertical(true);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void flipHorizontal() {
        this.mShaderData.flipHorizontal(true);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void flipResetWater() {
        this.mShaderData.flipResetWater();
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void flipHorizontalWater() {
        this.mShaderData.flipHorizontalWater(true);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void flipVerticalWater() {
        this.mShaderData.flipVerticalWater(true);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void rotation(int i) {
        this.mShaderData.setRotation(i);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void clip(int i, int i2, int i3, int i4) {
        this.mShaderData.clip(i, i2, i3, i4);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void prepareInputTextureTransformMatrix(float[] fArr) {
        this.mShaderData.setInputTextureTransformMatrix(fArr);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void drawFrame() {
        onSetAttributeValue();
        onSetUniformValue();
        GLES20.glDrawArrays(5, 0, this.mShaderData.getVertexCount());
    }

    @Override // com.yy.mediaframework.opengles.IProgram
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

    /* JADX INFO: Access modifiers changed from: protected */
    public FloatBuffer getWaterMarkCoordData() {
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
