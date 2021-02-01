package com.yy.mediaframework.opengles;

import android.opengl.Matrix;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class YMFShaderData {
    public static final int COORD_SIZE = 2;
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "YMFShaderData";
    private boolean bFlipHorizontal;
    private boolean bFlipHorizontalWater;
    private boolean bFlipVertial;
    private boolean bFlipVertialWater;
    private static final float[] VERTEX_COORDINATE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] TEXTURE_COORDINATE = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private float[] mIdentityMatrixVertex = new float[16];
    private float[] mIdentityMatrixTexture = new float[16];
    private int mTexCoordStride = 8;
    private int mVertexCoordStride = 8;
    private int mVertexCount = VERTEX_COORDINATE.length / 2;
    private FloatBuffer mVertexCoordArray = GlUtil.createFloatBuffer(VERTEX_COORDINATE);
    private FloatBuffer mTextureCoordArray = GlUtil.createFloatBuffer(TEXTURE_COORDINATE);
    private FloatBuffer mWaterCoordArray = GlUtil.createFloatBuffer(TEXTURE_COORDINATE);

    public YMFShaderData() {
        Matrix.setIdentityM(this.mIdentityMatrixVertex, 0);
        Matrix.setIdentityM(this.mIdentityMatrixTexture, 0);
    }

    public FloatBuffer getVertexCoordData() {
        return this.mVertexCoordArray;
    }

    public int getVertexCoordStride() {
        return this.mVertexCoordStride;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public FloatBuffer getTextureCoordData() {
        return this.mTextureCoordArray;
    }

    public int getTextureCoordStride() {
        return this.mTexCoordStride;
    }

    public FloatBuffer getWaterMarkCoordData() {
        return this.mWaterCoordArray;
    }

    public float[] getVertexMatrix() {
        return this.mIdentityMatrixVertex;
    }

    public float[] getTextureMatrix() {
        return this.mIdentityMatrixTexture;
    }

    public void clip(int i, int i2, int i3, int i4) {
        this.mTextureCoordArray = GlUtil.createFloatBuffer(TEXTURE_COORDINATE);
        int abs = Math.abs(i - i3);
        int abs2 = Math.abs(i2 - i4);
        float[] fArr = new float[8];
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(fArr);
        if (abs > 0) {
            float f = abs / i;
            fArr[0] = fArr[0] + (f / 2.0f);
            fArr[4] = fArr[4] + (f / 2.0f);
            fArr[2] = fArr[2] - (f / 2.0f);
            fArr[6] = fArr[6] - (f / 2.0f);
            YMFLog.info(this, "[Util    ]", "clip left and right");
        }
        if (abs2 > 0) {
            float f2 = abs2 / i2;
            fArr[1] = fArr[1] + (f2 / 2.0f);
            fArr[3] = fArr[3] + (f2 / 2.0f);
            fArr[5] = fArr[5] - (f2 / 2.0f);
            fArr[7] = fArr[7] - (f2 / 2.0f);
            YMFLog.info(this, "[Util    ]", "clip top and bottom");
        }
        this.mTextureCoordArray = GlUtil.createFloatBuffer(fArr);
        if (this.bFlipVertial) {
            flipVertical(false);
        }
        if (this.bFlipHorizontal) {
            flipHorizontal(false);
        }
    }

    public void flipReset() {
        this.mTextureCoordArray = GlUtil.createFloatBuffer(TEXTURE_COORDINATE);
        this.bFlipVertial = false;
        this.bFlipHorizontal = false;
    }

    public void flipVertical(boolean z) {
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(r1);
        float[] fArr = {0.0f, 1.0f - fArr[1], 0.0f, 1.0f - fArr[3], 0.0f, 1.0f - fArr[5], 0.0f, 1.0f - fArr[7]};
        this.mTextureCoordArray = GlUtil.createFloatBuffer(fArr);
        if (z) {
            this.bFlipVertial = this.bFlipVertial ? false : true;
        }
    }

    public void flipHorizontal(boolean z) {
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(r1);
        float[] fArr = {1.0f - fArr[0], 0.0f, 1.0f - fArr[2], 0.0f, 1.0f - fArr[4], 0.0f, 1.0f - fArr[6]};
        this.mTextureCoordArray = GlUtil.createFloatBuffer(fArr);
        if (z) {
            this.bFlipHorizontal = this.bFlipHorizontal ? false : true;
        }
    }

    public void flipResetWater() {
        this.mWaterCoordArray = GlUtil.createFloatBuffer(TEXTURE_COORDINATE);
        this.bFlipVertialWater = false;
        this.bFlipHorizontalWater = false;
    }

    public void flipVerticalWater(boolean z) {
        this.mWaterCoordArray.rewind();
        this.mWaterCoordArray.get(r1);
        float[] fArr = {0.0f, 1.0f - fArr[1], 0.0f, 1.0f - fArr[3], 0.0f, 1.0f - fArr[5], 0.0f, 1.0f - fArr[7]};
        this.mWaterCoordArray = GlUtil.createFloatBuffer(fArr);
        if (z) {
            this.bFlipVertialWater = this.bFlipVertialWater ? false : true;
        }
    }

    public void flipHorizontalWater(boolean z) {
        this.mWaterCoordArray.rewind();
        this.mWaterCoordArray.get(r1);
        float[] fArr = {0.0f, 1.0f - fArr[1], 0.0f, 1.0f - fArr[3], 0.0f, 1.0f - fArr[5], 0.0f, 1.0f - fArr[7]};
        this.mWaterCoordArray = GlUtil.createFloatBuffer(fArr);
        if (z) {
            this.bFlipHorizontalWater = this.bFlipHorizontalWater ? false : true;
        }
    }

    public void setInputTextureTransformMatrix(float[] fArr) {
        for (int i = 0; i < this.mIdentityMatrixTexture.length; i++) {
            this.mIdentityMatrixTexture[i] = fArr[i];
        }
    }

    public void setRotation(float f) {
        Matrix.setIdentityM(this.mIdentityMatrixVertex, 0);
        Matrix.rotateM(this.mIdentityMatrixVertex, 0, f, 0.0f, 0.0f, 1.0f);
    }
}
