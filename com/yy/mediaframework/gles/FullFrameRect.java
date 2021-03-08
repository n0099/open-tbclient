package com.yy.mediaframework.gles;

import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Log;
import com.yy.mediaframework.gles.Drawable2d;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class FullFrameRect {
    public static final int EXTRA_TEXTURE_SLAVE_PICTURE = 3;
    public static final int EXTRA_TEXTURE_STICKER = 2;
    public static final int EXTRA_TEXTURE_WATERMARK = 1;
    public static final int MAIN_TEXTURE = 0;
    private static final String TAG = "FullFrameRect";
    public final FloatBuffer DEFAULT_TEX_COORD_BUFFER;
    public final float[] IDENTITY_MATRIX;
    private FloatBuffer[] mCurTexCoordArray;
    private boolean[] mFlipX;
    private boolean[] mFlipY;
    private FloatBuffer mMainTextureCoord;
    private FloatBuffer[] mOrigTexCoordArray;
    private Texture2dProgram mProgram;
    private Drawable2d mRectDrawable;
    private FloatBuffer mSlaveTextureCoord;
    private FloatBuffer mWaterMarkTextureCoord;
    private boolean need2print;

    public FullFrameRect(Texture2dProgram texture2dProgram) {
        this(texture2dProgram, Drawable2d.Prefab.FULL_RECTANGLE);
    }

    public FullFrameRect(Texture2dProgram texture2dProgram, Drawable2d.Prefab prefab) {
        this.IDENTITY_MATRIX = new float[16];
        this.DEFAULT_TEX_COORD_BUFFER = Drawable2d.FULL_RECTANGLE_TEX_BUF;
        this.mCurTexCoordArray = new FloatBuffer[4];
        this.mOrigTexCoordArray = new FloatBuffer[4];
        this.mFlipX = new boolean[]{false, false, false, false};
        this.mFlipY = new boolean[]{false, false, false, false};
        this.need2print = true;
        this.mProgram = texture2dProgram;
        Matrix.setIdentityM(this.IDENTITY_MATRIX, 0);
        this.mRectDrawable = new Drawable2d(prefab);
        FloatBuffer[] floatBufferArr = this.mCurTexCoordArray;
        FloatBuffer[] floatBufferArr2 = this.mOrigTexCoordArray;
        FloatBuffer texCoordArray = this.mRectDrawable.getTexCoordArray();
        floatBufferArr2[0] = texCoordArray;
        floatBufferArr[0] = texCoordArray;
        this.mMainTextureCoord = texCoordArray;
        FloatBuffer[] floatBufferArr3 = this.mCurTexCoordArray;
        FloatBuffer[] floatBufferArr4 = this.mOrigTexCoordArray;
        FloatBuffer floatBuffer = this.DEFAULT_TEX_COORD_BUFFER;
        floatBufferArr4[1] = floatBuffer;
        floatBufferArr3[1] = floatBuffer;
        this.mWaterMarkTextureCoord = this.mCurTexCoordArray[1];
        FloatBuffer[] floatBufferArr5 = this.mCurTexCoordArray;
        FloatBuffer[] floatBufferArr6 = this.mOrigTexCoordArray;
        FloatBuffer floatBuffer2 = this.DEFAULT_TEX_COORD_BUFFER;
        floatBufferArr6[2] = floatBuffer2;
        floatBufferArr5[2] = floatBuffer2;
        FloatBuffer[] floatBufferArr7 = this.mCurTexCoordArray;
        FloatBuffer[] floatBufferArr8 = this.mOrigTexCoordArray;
        FloatBuffer floatBuffer3 = this.DEFAULT_TEX_COORD_BUFFER;
        floatBufferArr8[3] = floatBuffer3;
        floatBufferArr7[3] = floatBuffer3;
        this.mSlaveTextureCoord = floatBuffer3;
    }

    public FullFrameRect(Texture2dProgram texture2dProgram, Drawable2d.Prefab prefab, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        this.IDENTITY_MATRIX = new float[16];
        this.DEFAULT_TEX_COORD_BUFFER = Drawable2d.FULL_RECTANGLE_TEX_BUF;
        this.mCurTexCoordArray = new FloatBuffer[4];
        this.mOrigTexCoordArray = new FloatBuffer[4];
        this.mFlipX = new boolean[]{false, false, false, false};
        this.mFlipY = new boolean[]{false, false, false, false};
        this.need2print = true;
        this.mProgram = texture2dProgram;
        Matrix.setIdentityM(this.IDENTITY_MATRIX, 0);
        this.mRectDrawable = new Drawable2d(prefab);
        FloatBuffer[] floatBufferArr = this.mCurTexCoordArray;
        FloatBuffer[] floatBufferArr2 = this.mOrigTexCoordArray;
        FloatBuffer texCoordArray = this.mRectDrawable.getTexCoordArray();
        floatBufferArr2[0] = texCoordArray;
        floatBufferArr[0] = texCoordArray;
        this.mMainTextureCoord = texCoordArray;
        FloatBuffer[] floatBufferArr3 = this.mCurTexCoordArray;
        this.mOrigTexCoordArray[1] = floatBuffer;
        floatBufferArr3[1] = floatBuffer;
        this.mWaterMarkTextureCoord = this.mCurTexCoordArray[1];
        FloatBuffer[] floatBufferArr4 = this.mCurTexCoordArray;
        this.mOrigTexCoordArray[2] = floatBuffer2;
        floatBufferArr4[2] = floatBuffer2;
        FloatBuffer[] floatBufferArr5 = this.mCurTexCoordArray;
        FloatBuffer[] floatBufferArr6 = this.mOrigTexCoordArray;
        FloatBuffer floatBuffer3 = this.DEFAULT_TEX_COORD_BUFFER;
        floatBufferArr6[3] = floatBuffer3;
        floatBufferArr5[3] = floatBuffer3;
        this.mSlaveTextureCoord = floatBuffer3;
    }

    public void changeDrawable2d(Drawable2d.Prefab prefab) {
        this.mRectDrawable = new Drawable2d(prefab);
    }

    public void release(boolean z) {
        if (this.mProgram != null) {
            if (z) {
                this.mProgram.release();
            }
            this.mProgram = null;
        }
    }

    public void release() {
        release(true);
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

    public void scaleMVPMatrix(float f, float f2) {
        Matrix.setIdentityM(this.IDENTITY_MATRIX, 0);
        Matrix.scaleM(this.IDENTITY_MATRIX, 0, f, f2, 1.0f);
    }

    public void drawFrame(int i, float[] fArr, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = null;
        if (i4 >= 0) {
            floatBuffer2 = GlUtil.setFlipY(this.mSlaveTextureCoord);
        }
        drawFrame(i, this.mRectDrawable.getVertexArray(), this.mMainTextureCoord, fArr, i2, i3, i4, fArr2, floatBuffer, floatBuffer2, false);
    }

    public void drawFrame(int i, float[] fArr, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer, boolean z) {
        FloatBuffer floatBuffer2 = null;
        if (i4 >= 0) {
            floatBuffer2 = GlUtil.setFlipY(this.mSlaveTextureCoord);
        }
        drawFrame(i, this.mRectDrawable.getVertexArray(), this.mMainTextureCoord, fArr, i2, i3, i4, fArr2, floatBuffer, floatBuffer2, z);
    }

    public void drawFrame(int i, float[] fArr, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        drawFrame(i, this.mRectDrawable.getVertexArray(), this.mMainTextureCoord, fArr, i2, i3, i4, fArr2, floatBuffer, floatBuffer2 == null ? GlUtil.setFlipY(this.mSlaveTextureCoord) : GlUtil.setFlipY(floatBuffer2), false);
    }

    public void drawFrame(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, float[] fArr, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer3, FloatBuffer floatBuffer4, boolean z) {
        if (i4 >= 0) {
            this.mProgram.draw(this.IDENTITY_MATRIX, floatBuffer, 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, floatBuffer2, i, this.mRectDrawable.getTexCoordStride(), z ? this.mWaterMarkTextureCoord : this.mCurTexCoordArray[1], i2, this.mCurTexCoordArray[2], i3);
            this.mProgram.drawSlavePicture(i4, this.IDENTITY_MATRIX, fArr2, fArr, this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), this.mRectDrawable.getTexCoordStride(), 0, this.mRectDrawable.getVertexCount(), floatBuffer3, floatBuffer4);
            return;
        }
        this.mProgram.draw(this.IDENTITY_MATRIX, floatBuffer, 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, floatBuffer2, i, this.mRectDrawable.getTexCoordStride(), z ? this.mWaterMarkTextureCoord : this.mCurTexCoordArray[1], i2, this.mCurTexCoordArray[2], i3);
    }

    public void drawFrame(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, float[] fArr, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer3, FloatBuffer floatBuffer4) {
        if (i4 >= 0) {
            this.mProgram.draw(this.IDENTITY_MATRIX, floatBuffer, 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, floatBuffer2, i, this.mRectDrawable.getTexCoordStride(), this.mCurTexCoordArray[1], i2, this.mCurTexCoordArray[2], i3);
            this.mProgram.drawSlavePicture(i4, this.IDENTITY_MATRIX, fArr2, fArr, this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), this.mRectDrawable.getTexCoordStride(), 0, this.mRectDrawable.getVertexCount(), floatBuffer3, floatBuffer4);
            return;
        }
        this.mProgram.draw(this.IDENTITY_MATRIX, floatBuffer, 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), fArr, floatBuffer2, i, this.mRectDrawable.getTexCoordStride(), this.mCurTexCoordArray[1], i2, this.mCurTexCoordArray[2], i3);
    }

    private String convertFloatBuffer2String(FloatBuffer floatBuffer) {
        if (floatBuffer == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("Buffer::");
        for (int i = 0; i < floatBuffer.capacity(); i++) {
            sb.append(floatBuffer.get(i));
            sb.append("  ");
        }
        floatBuffer.rewind();
        return sb.toString();
    }

    public void adjustTexture(float f, float f2, float f3, float f4) {
        this.need2print = true;
        this.mCurTexCoordArray[0] = this.mOrigTexCoordArray[0];
        this.mCurTexCoordArray[1] = this.mOrigTexCoordArray[1];
        this.mCurTexCoordArray[2] = this.mOrigTexCoordArray[2];
        this.mCurTexCoordArray[3] = this.mOrigTexCoordArray[3];
        for (int i = 0; i < this.mCurTexCoordArray.length; i++) {
            if (this.mFlipX[i]) {
                this.mCurTexCoordArray[i] = GlUtil.setFlipX(this.mCurTexCoordArray[i]);
            }
            if (this.mFlipY[i]) {
                this.mCurTexCoordArray[i] = GlUtil.setFlipY(this.mCurTexCoordArray[i]);
            }
        }
        FloatBuffer[] floatBufferArr = this.mCurTexCoordArray;
        FloatBuffer adjustTexture = GlUtil.adjustTexture(this.mCurTexCoordArray[0], f, f2, f3, f4);
        floatBufferArr[0] = adjustTexture;
        this.mMainTextureCoord = adjustTexture;
    }

    public void adjustTextureArea(RectF rectF, int i, int i2, boolean z) {
        this.need2print = true;
        this.mCurTexCoordArray[0] = this.mOrigTexCoordArray[0];
        this.mCurTexCoordArray[1] = this.mOrigTexCoordArray[1];
        this.mCurTexCoordArray[2] = this.mOrigTexCoordArray[2];
        this.mCurTexCoordArray[3] = this.mOrigTexCoordArray[3];
        for (int i3 = 0; i3 < this.mCurTexCoordArray.length; i3++) {
            if (this.mFlipX[i3]) {
                this.mCurTexCoordArray[i3] = GlUtil.setFlipX(this.mCurTexCoordArray[i3]);
            }
            if (this.mFlipY[i3]) {
                this.mCurTexCoordArray[i3] = GlUtil.setFlipY(this.mCurTexCoordArray[i3]);
            }
        }
        FloatBuffer[] floatBufferArr = this.mCurTexCoordArray;
        FloatBuffer adjustTextureArea = GlUtil.adjustTextureArea(rectF, i, i2, z);
        floatBufferArr[0] = adjustTextureArea;
        this.mMainTextureCoord = adjustTextureArea;
    }

    public void adjustAllTexutre(float f, float f2, float f3, float f4) {
        FloatBuffer[] floatBufferArr = this.mCurTexCoordArray;
        FloatBuffer floatBuffer = this.mOrigTexCoordArray[0];
        floatBufferArr[0] = floatBuffer;
        this.mMainTextureCoord = floatBuffer;
        this.mCurTexCoordArray[1] = this.mOrigTexCoordArray[1];
        this.mCurTexCoordArray[2] = this.mOrigTexCoordArray[2];
        this.mCurTexCoordArray[3] = this.mOrigTexCoordArray[3];
        for (int i = 0; i < this.mCurTexCoordArray.length; i++) {
            if (this.mFlipX[i]) {
                this.mCurTexCoordArray[i] = GlUtil.setFlipX(this.mCurTexCoordArray[i]);
            }
            if (this.mFlipY[i]) {
                this.mCurTexCoordArray[i] = GlUtil.setFlipY(this.mCurTexCoordArray[i]);
            }
            this.mCurTexCoordArray[i] = GlUtil.adjustTexture(this.mCurTexCoordArray[i], f, f2, f3, f4);
        }
    }

    public void flipSlaveScreenX() {
        this.mSlaveTextureCoord = GlUtil.setFlipX(this.mCurTexCoordArray[3]);
    }

    public void resetFlip() {
        this.mMainTextureCoord = this.mCurTexCoordArray[0];
        this.mSlaveTextureCoord = this.mCurTexCoordArray[3];
    }

    public void flipYScreen() {
        this.mMainTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[0]);
        this.mSlaveTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[3]);
    }

    public void flipYScreen(boolean z) {
        this.mMainTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[0]);
        this.mSlaveTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[3]);
        if (z) {
            this.mWaterMarkTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[1]);
        }
    }

    public void flipYScreenXMaster() {
        this.mMainTextureCoord = GlUtil.setFlipX(GlUtil.setFlipY(this.mCurTexCoordArray[0]));
        this.mSlaveTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[3]);
    }

    public void flipYScreenXSlave() {
        this.mMainTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[0]);
        this.mSlaveTextureCoord = GlUtil.setFlipX(GlUtil.setFlipY(this.mCurTexCoordArray[3]));
    }

    public void flipXYScreen(boolean z) {
        this.mMainTextureCoord = GlUtil.setFlipX(GlUtil.setFlipY(this.mCurTexCoordArray[0]));
        this.mSlaveTextureCoord = GlUtil.setFlipX(GlUtil.setFlipY(this.mCurTexCoordArray[3]));
        if (z) {
            this.mWaterMarkTextureCoord = GlUtil.setFlipY(this.mCurTexCoordArray[1]);
        }
    }

    public void flipXYScreen() {
        this.mMainTextureCoord = GlUtil.setFlipX(GlUtil.setFlipY(this.mCurTexCoordArray[0]));
        this.mSlaveTextureCoord = GlUtil.setFlipX(GlUtil.setFlipY(this.mCurTexCoordArray[3]));
    }

    public void flipXMasterPicture() {
        this.mMainTextureCoord = GlUtil.setFlipX(this.mCurTexCoordArray[0]);
        this.mSlaveTextureCoord = this.mCurTexCoordArray[3];
    }

    public void flipXSlavePicture() {
        this.mMainTextureCoord = this.mCurTexCoordArray[0];
        this.mSlaveTextureCoord = GlUtil.setFlipX(this.mCurTexCoordArray[3]);
    }

    public void flipXScreen() {
        this.mMainTextureCoord = GlUtil.setFlipX(this.mCurTexCoordArray[0]);
        this.mSlaveTextureCoord = GlUtil.setFlipX(this.mCurTexCoordArray[3]);
    }

    public void setTextureFlipX(int i) {
        Log.e(TAG, "setTextureFlipX:" + i);
        this.need2print = true;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.mFlipX[i] = this.mFlipX[i] ? false : true;
                this.mCurTexCoordArray[i] = GlUtil.setFlipX(this.mOrigTexCoordArray[i]);
                return;
            default:
                YMFLog.info(this, "[Util    ]", "setTextureFlipX::no support type");
                return;
        }
    }

    public void setTextureFlipY(int i) {
        this.need2print = true;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.mFlipY[i] = this.mFlipY[i] ? false : true;
                this.mCurTexCoordArray[i] = GlUtil.setFlipY(this.mOrigTexCoordArray[i]);
                return;
            default:
                YMFLog.info(this, "[Util    ]", "setTextureFlipY::no support type");
                return;
        }
    }

    public void adjustVertex(int i, int i2, int i3, int i4, int i5) {
        if (this.mRectDrawable != null) {
            this.mRectDrawable.clipVertex(i, i2, i3, i4, i5);
        }
    }
}
