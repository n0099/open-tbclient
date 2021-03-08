package com.yy.mediaframework.opengles;

import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class YMFRender implements IRender {
    private static final String TAG = "YMFRender";
    private YMFFramebuffer mFrameBuffer;
    private YMFTexture mInput2dTexture;
    private YMFTexture[] mInputImageTextures;
    private IProgram mProgram;
    private YMFTexture mWaterMarkTexture;

    public YMFRender(int i) {
        this.mProgram = YMFProgramFactory.craeteProgram(i);
    }

    private void createProgram(YMFImageBuffer yMFImageBuffer) {
        switch (yMFImageBuffer.mFormat) {
            case 0:
                this.mProgram = YMFProgramFactory.craeteProgram(1);
                return;
            case 1:
                this.mProgram = YMFProgramFactory.craeteProgram(2);
                return;
            case 2:
                this.mProgram = YMFProgramFactory.craeteProgram(3);
                return;
            case 36:
                this.mProgram = YMFProgramFactory.craeteProgram(0);
                return;
            default:
                YMFLog.error(this, "[Util    ]", "createProgram unsupported image format. ");
                return;
        }
    }

    private void createYuv420pTexture(int i, int i2) {
        this.mInputImageTextures = new YMFTexture[3];
        this.mInputImageTextures[0] = new YMFTexture(3553, i, i2, 6409, 33984);
        this.mInputImageTextures[1] = new YMFTexture(3553, i / 2, i2 / 2, 6409, 33985);
        this.mInputImageTextures[2] = new YMFTexture(3553, i / 2, i2 / 2, 6409, 33986);
    }

    private void createYuv420spTexture(int i, int i2) {
        this.mInputImageTextures = new YMFTexture[2];
        this.mInputImageTextures[0] = new YMFTexture(3553, i, i2, 6409, 33984);
        this.mInputImageTextures[1] = new YMFTexture(3553, i / 2, i2 / 2, 6410, 33985);
    }

    private void createRGBATexture(int i, int i2) {
        this.mInputImageTextures = new YMFTexture[1];
        this.mInputImageTextures[0] = new YMFTexture(3553, i, i2, 6408, 33984);
    }

    private void createInputTexture(YMFImageBuffer yMFImageBuffer) {
        switch (yMFImageBuffer.mFormat) {
            case 0:
                createYuv420spTexture(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight);
                return;
            case 1:
                createYuv420spTexture(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight);
                return;
            case 2:
                createYuv420pTexture(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight);
                return;
            case 36:
                createRGBATexture(yMFImageBuffer.mWidth, yMFImageBuffer.mHeight);
                return;
            default:
                return;
        }
    }

    public static int imageFormatToProgramType(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 36:
                return 0;
            default:
                return 4;
        }
    }

    private void checkUpdateProgram(YMFImageBuffer yMFImageBuffer) {
        boolean z;
        boolean z2 = false;
        if (this.mProgram == null || this.mProgram.programType() != imageFormatToProgramType(yMFImageBuffer.mFormat)) {
            releaseProgram();
            z = true;
        } else {
            z = false;
        }
        if (this.mInputImageTextures == null || this.mInputImageTextures[0].getWidth() != yMFImageBuffer.mWidth || this.mInputImageTextures[0].getHeight() != yMFImageBuffer.mHeight) {
            releaseInYuvTextures();
            z2 = true;
        }
        if (z) {
            createProgram(yMFImageBuffer);
        }
        if (z2) {
            createInputTexture(yMFImageBuffer);
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public boolean prepareInputImageData(YMFImageBuffer yMFImageBuffer) {
        if (yMFImageBuffer == null || yMFImageBuffer.mData == null) {
            YMFLog.error(this, "[Util    ]", "invalid input YMFImageBuffer.");
            return false;
        }
        int i = yMFImageBuffer.mWidth;
        int i2 = yMFImageBuffer.mHeight;
        int yoffset = yMFImageBuffer.getYoffset();
        int uoffset = yMFImageBuffer.getUoffset();
        int voffset = yMFImageBuffer.getVoffset();
        ByteBuffer byteBuffer = yMFImageBuffer.mData;
        checkUpdateProgram(yMFImageBuffer);
        byteBuffer.rewind();
        switch (yMFImageBuffer.mFormat) {
            case 0:
            case 1:
                this.mInputImageTextures[0].updateTextureData(byteBuffer.position(yoffset), i, i2);
                this.mInputImageTextures[1].updateTextureData(byteBuffer.position(uoffset), i / 2, i2 / 2);
                return true;
            case 2:
                this.mInputImageTextures[0].updateTextureData(byteBuffer.position(yoffset), i, i2);
                this.mInputImageTextures[1].updateTextureData(byteBuffer.position(uoffset), i / 2, i2 / 2);
                this.mInputImageTextures[2].updateTextureData(byteBuffer.position(voffset), i / 2, i2 / 2);
                return true;
            case 36:
                this.mInputImageTextures[0].updateTextureData(byteBuffer.position(0), i, i2);
                return true;
            default:
                return true;
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public boolean prepareInputTexture(YMFTexture yMFTexture) {
        if (yMFTexture == null || !yMFTexture.validate()) {
            return false;
        }
        boolean z = this.mProgram == null;
        if (this.mProgram != null && this.mProgram.programType() != 0 && this.mProgram.programType() != 4) {
            z = true;
        }
        if (z) {
            releaseProgram();
            if (yMFTexture.getFormat() == 69) {
                this.mProgram = YMFProgramFactory.craeteProgram(0);
            } else if (yMFTexture.getFormat() == 70) {
                this.mProgram = YMFProgramFactory.craeteProgram(4);
            }
        }
        this.mInput2dTexture = yMFTexture;
        this.mInput2dTexture.bind();
        return true;
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public boolean prepareInputTextureTransformMatrix(float[] fArr) {
        if (this.mProgram != null) {
            this.mProgram.prepareInputTextureTransformMatrix(fArr);
            return true;
        }
        return true;
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void prepareWaterTexture(YMFTexture yMFTexture) {
        if (yMFTexture != null && yMFTexture.validate()) {
            this.mProgram.enableWaterMarker(true);
            if (this.mProgram.programType() != 0 && this.mProgram.programType() != 4) {
                yMFTexture.setTextureUnit(33987);
            }
            yMFTexture.bind();
            this.mWaterMarkTexture = yMFTexture;
            return;
        }
        this.mProgram.enableWaterMarker(false);
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public boolean prepareOutputTexture(YMFTexture yMFTexture) {
        if (yMFTexture == null || !yMFTexture.validate()) {
            return false;
        }
        if (this.mFrameBuffer == null) {
            this.mFrameBuffer = new YMFFramebuffer();
        }
        this.mFrameBuffer.attachTexture(yMFTexture.getTextureId());
        return true;
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void flipReset() {
        if (this.mProgram != null) {
            this.mProgram.flipReset();
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void flipHorizontal() {
        if (this.mProgram != null) {
            this.mProgram.flipHorizontal();
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void flipVertical() {
        if (this.mProgram != null) {
            this.mProgram.flipVertical();
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void rotate(int i) {
        if (this.mProgram != null) {
            this.mProgram.rotation(i);
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void flipResetWater() {
        if (this.mProgram != null) {
            this.mProgram.flipResetWater();
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void flipHorizontalWater() {
        if (this.mProgram != null) {
            this.mProgram.flipHorizontalWater();
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void flipVerticalWater() {
        if (this.mProgram != null) {
            this.mProgram.flipVerticalWater();
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void clip(int i, int i2, int i3, int i4) {
        if (this.mProgram != null) {
            this.mProgram.clip(i, i2, i3, i4);
        }
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void render() {
        if (this.mProgram != null) {
            this.mProgram.useProgram();
            this.mProgram.drawFrame();
            reStoreGlContext();
        }
    }

    private void reStoreGlContext() {
        switch (this.mProgram.programType()) {
            case 0:
            case 4:
                if (this.mInput2dTexture != null) {
                    this.mInput2dTexture.unBind();
                    break;
                }
                break;
        }
        for (int i = 0; this.mInputImageTextures != null && i < this.mInputImageTextures.length; i++) {
            this.mInputImageTextures[i].unBind();
        }
        if (this.mFrameBuffer != null) {
            this.mFrameBuffer.unBind();
        }
        if (this.mWaterMarkTexture != null) {
            this.mWaterMarkTexture.unBind();
        }
    }

    private void releaseProgram() {
        if (this.mProgram != null) {
            this.mProgram.release();
            this.mProgram = null;
        }
    }

    private void releaseInYuvTextures() {
        for (int i = 0; this.mInputImageTextures != null && i < this.mInputImageTextures.length; i++) {
            this.mInputImageTextures[i].release();
        }
        this.mInputImageTextures = null;
    }

    @Override // com.yy.mediaframework.opengles.IRender
    public void release() {
        releaseInYuvTextures();
        releaseProgram();
        if (this.mFrameBuffer != null) {
            this.mFrameBuffer.release();
            this.mFrameBuffer = null;
        }
    }
}
