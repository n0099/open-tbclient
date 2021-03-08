package com.yy.videoplayer.decoder.glesunder43;

import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.glesunder43.Drawable2d;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class FullFrameRect {
    private static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private Texture2dProgram mProgram;
    private final Drawable2d mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private float[] vertices = new float[8];
    private boolean mUseMultiVideoView = false;

    public void setUseMultiVideoview(boolean z) {
        this.mUseMultiVideoView = z;
    }

    public void upDateVertexCoord(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode) {
        float f = i / i2;
        float f2 = i3 / i4;
        System.arraycopy(FULL_RECTANGLE_COORDS, 0, this.vertices, 0, FULL_RECTANGLE_COORDS.length);
        if (scaleMode == VideoConstant.ScaleMode.ClipToBounds) {
            if (f < f2) {
                float f3 = f2 / f;
                float[] fArr = this.vertices;
                fArr[1] = fArr[1] * f3;
                float[] fArr2 = this.vertices;
                fArr2[3] = fArr2[3] * f3;
                float[] fArr3 = this.vertices;
                fArr3[5] = fArr3[5] * f3;
                float[] fArr4 = this.vertices;
                fArr4[7] = f3 * fArr4[7];
                return;
            }
            float f4 = f / f2;
            float[] fArr5 = this.vertices;
            fArr5[0] = fArr5[0] * f4;
            float[] fArr6 = this.vertices;
            fArr6[2] = fArr6[2] * f4;
            float[] fArr7 = this.vertices;
            fArr7[4] = fArr7[4] * f4;
            float[] fArr8 = this.vertices;
            fArr8[6] = f4 * fArr8[6];
        } else if (scaleMode == VideoConstant.ScaleMode.AspectFit) {
            if (f < f2) {
                float f5 = f / f2;
                float[] fArr9 = this.vertices;
                fArr9[0] = fArr9[0] * f5;
                float[] fArr10 = this.vertices;
                fArr10[2] = fArr10[2] * f5;
                float[] fArr11 = this.vertices;
                fArr11[4] = fArr11[4] * f5;
                float[] fArr12 = this.vertices;
                fArr12[6] = f5 * fArr12[6];
                return;
            }
            float f6 = f2 / f;
            float[] fArr13 = this.vertices;
            fArr13[1] = fArr13[1] * f6;
            float[] fArr14 = this.vertices;
            fArr14[3] = fArr14[3] * f6;
            float[] fArr15 = this.vertices;
            fArr15[5] = fArr15[5] * f6;
            float[] fArr16 = this.vertices;
            fArr16[7] = f6 * fArr16[7];
        }
    }

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        this.mProgram = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mProgram != null) {
            if (z) {
                this.mProgram.release();
            }
            this.mProgram = null;
        }
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public void changeProgram(Texture2dProgram texture2dProgram) {
        this.mProgram.release();
        this.mProgram = texture2dProgram;
    }

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr, int i2) {
        drawFrame(i, fArr, i2, -1, -1, -1);
    }

    public void drawFrame(int i, int i2, int i3, float[] fArr) {
        drawFrame(-1, fArr, -1, i, i2, i3);
    }

    public void drawFrame(int i, float[] fArr, int i2, int i3, int i4, int i5) {
        if (!this.mUseMultiVideoView) {
            this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride(), i2, i3, i4, i5);
            return;
        }
        FloatBuffer createFloatBuffer = GlUtil.createFloatBuffer(this.vertices);
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, createFloatBuffer, 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, this.mRectDrawable.getTexCoordArray(), i, this.mRectDrawable.getTexCoordStride(), i2, i3, i4, i5);
        createFloatBuffer.clear();
    }
}
