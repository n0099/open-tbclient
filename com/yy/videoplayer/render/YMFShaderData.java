package com.yy.videoplayer.render;

import android.opengl.Matrix;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.gles_decoder.GlUtil;
import com.yy.videoplayer.utils.GLUtil;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class YMFShaderData {
    public static final int COORD_SIZE = 2;
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "YMFShaderData";
    private boolean bFlipHorizontal;
    private boolean bFlipVertial;
    private static final float[] VERTEX_COORDINATE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] TEXTURE_COORDINATE_UP_DOWN = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] TEXTURE_COORDINATE = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private float[] mIdentityMatrixVertex = new float[16];
    private float[] mIdentityMatrixTexture = new float[16];
    private int mTexCoordStride = 8;
    private int mVertexCoordStride = 8;
    private int mVertexCount = VERTEX_COORDINATE.length / 2;
    private FloatBuffer mVertexCoordArray = GLUtil.createFloatBuffer(VERTEX_COORDINATE);
    private FloatBuffer mTextureCoordArray = GLUtil.createFloatBuffer(TEXTURE_COORDINATE);
    private FloatBuffer mTextureCoordUpDownArray = GLUtil.createFloatBuffer(TEXTURE_COORDINATE_UP_DOWN);
    private FloatBuffer mWaterCoordArray = GLUtil.createFloatBuffer(TEXTURE_COORDINATE_UP_DOWN);

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

    public void clip(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode) {
        float[] fArr = new float[8];
        float f = i / i2;
        float f2 = i3 / i4;
        System.arraycopy(VERTEX_COORDINATE, 0, fArr, 0, VERTEX_COORDINATE.length);
        if (scaleMode == VideoConstant.ScaleMode.ClipToBounds) {
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
        } else if (scaleMode == VideoConstant.ScaleMode.AspectFit) {
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
        } else if (scaleMode == VideoConstant.ScaleMode.Original) {
            if (i < i3 && i2 < i4) {
                float f7 = i / i3;
                float f8 = i2 / i4;
                fArr[0] = fArr[0] * f7;
                fArr[2] = fArr[2] * f7;
                fArr[4] = fArr[4] * f7;
                fArr[6] = f7 * fArr[6];
                fArr[1] = fArr[1] * f8;
                fArr[3] = fArr[3] * f8;
                fArr[5] = fArr[5] * f8;
                fArr[7] = f8 * fArr[7];
            } else if (f < f2) {
                float f9 = f / f2;
                fArr[0] = fArr[0] * f9;
                fArr[2] = fArr[2] * f9;
                fArr[4] = fArr[4] * f9;
                fArr[6] = f9 * fArr[6];
            } else {
                float f10 = f2 / f;
                fArr[1] = fArr[1] * f10;
                fArr[3] = fArr[3] * f10;
                fArr[5] = fArr[5] * f10;
                fArr[7] = f10 * fArr[7];
            }
        }
        this.mVertexCoordArray = GlUtil.createFloatBuffer(fArr);
    }

    public void clip(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mTextureCoordArray = GLUtil.createFloatBuffer(TEXTURE_COORDINATE);
        if (this.bFlipVertial) {
            flipVertical(false);
        }
        if (this.bFlipHorizontal) {
            flipHorizontal(false);
        }
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(r0);
        float[] fArr = {i3 / i, i5 / i2, i4 / i, i5 / i2, i3 / i, i6 / i2, i4 / i, i6 / i2};
        this.mTextureCoordArray = GLUtil.createFloatBuffer(fArr);
    }

    public void clip(int i, int i2, int i3, int i4, int i5) {
        this.mTextureCoordArray = GLUtil.createFloatBuffer(TEXTURE_COORDINATE);
        if (this.bFlipVertial) {
            flipVertical(false);
        }
        if (this.bFlipHorizontal) {
            flipHorizontal(false);
        }
        int abs = Math.abs(i - i3);
        int abs2 = Math.abs(i2 - i4);
        float[] fArr = new float[8];
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(fArr);
        if (abs > 0) {
            float f = abs / i;
            switch (i5 & 3) {
                case 1:
                    fArr[0] = fArr[0] + f;
                    fArr[4] = f + fArr[4];
                    break;
                case 2:
                    fArr[2] = fArr[2] - f;
                    fArr[6] = fArr[6] - f;
                    break;
                case 3:
                    fArr[0] = fArr[0] + (f / 2.0f);
                    fArr[4] = fArr[4] + (f / 2.0f);
                    fArr[2] = fArr[2] - (f / 2.0f);
                    fArr[6] = fArr[6] - (f / 2.0f);
                    break;
            }
        }
        if (abs2 > 0) {
            float f2 = abs2 / i2;
            switch (i5 & 12) {
                case 4:
                    fArr[1] = fArr[1] - f2;
                    fArr[3] = fArr[3] - f2;
                    break;
                case 8:
                    fArr[5] = fArr[5] + f2;
                    fArr[7] = f2 + fArr[7];
                    break;
                case 12:
                    fArr[1] = fArr[1] - (f2 / 2.0f);
                    fArr[3] = fArr[3] - (f2 / 2.0f);
                    fArr[5] = fArr[5] + (f2 / 2.0f);
                    fArr[7] = (f2 / 2.0f) + fArr[7];
                    break;
            }
        }
        this.mTextureCoordArray = GLUtil.createFloatBuffer(fArr);
    }

    public void flipVertical(boolean z) {
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(r1);
        float[] fArr = {0.0f, 1.0f - fArr[1], 0.0f, 1.0f - fArr[3], 0.0f, 1.0f - fArr[5], 0.0f, 1.0f - fArr[7]};
        this.mTextureCoordArray = GLUtil.createFloatBuffer(fArr);
        if (z) {
            this.bFlipVertial = this.bFlipVertial ? false : true;
        }
        YMFLog.info(this, "[Util    ]", hashCode() + " flipVertical:" + this.bFlipVertial);
    }

    public void flipHorizontal(boolean z) {
        this.mTextureCoordArray.rewind();
        this.mTextureCoordArray.get(r1);
        float[] fArr = {1.0f - fArr[0], 0.0f, 1.0f - fArr[2], 0.0f, 1.0f - fArr[4], 0.0f, 1.0f - fArr[6]};
        this.mTextureCoordArray = GLUtil.createFloatBuffer(fArr);
        if (z) {
            this.bFlipHorizontal = this.bFlipHorizontal ? false : true;
        }
        YMFLog.info(this, "[Util    ]", hashCode() + " flipHorizontal:" + this.bFlipHorizontal);
    }

    public boolean checkUpdateMirrorMode(boolean z) {
        return this.bFlipHorizontal != z;
    }

    public void setRotation(float f) {
        Matrix.rotateM(this.mIdentityMatrixVertex, 0, f, 0.0f, 0.0f, 1.0f);
    }
}
