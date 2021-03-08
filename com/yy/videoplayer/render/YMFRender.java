package com.yy.videoplayer.render;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class YMFRender implements IRender {
    private static final String TAG = "YMFRender";
    private YMFTexture mBackgroundTexture;
    private YMFFramebuffer mFrameBuffer;
    private YMFTexture mInput2dTexture;
    private YMFTexture[] mInputImageTextures;
    private IProgram mProgram;
    private YMFTexture mWaterMarkTexture;

    public YMFRender(int i) {
        this.mProgram = YMFProgramFactory.createProgram(i);
    }

    private void createProgram(YMFImageBuffer yMFImageBuffer) {
        switch (yMFImageBuffer.mFormat) {
            case 0:
                this.mProgram = YMFProgramFactory.createProgram(1);
                return;
            case 1:
                this.mProgram = YMFProgramFactory.createProgram(2);
                return;
            case 2:
                this.mProgram = YMFProgramFactory.createProgram(3);
                return;
            case 36:
                this.mProgram = YMFProgramFactory.createProgram(0);
                return;
            default:
                YMFLog.error(this, "[Render  ]", "createProgram unsupported image format. ");
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

    private YMFTexture createBitmapTexture(Bitmap bitmap, int i, int i2) {
        this.mInputImageTextures = new YMFTexture[1];
        this.mInputImageTextures[0] = new YMFTexture(bitmap, 3553, i, i2, 6408, 33989);
        return this.mInputImageTextures[0];
    }

    private YMFTexture createRGBATexture(int i, int i2) {
        this.mInputImageTextures = new YMFTexture[1];
        this.mInputImageTextures[0] = new YMFTexture(3553, i, i2, 6408, 33984);
        return this.mInputImageTextures[0];
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
        boolean z2;
        if (this.mProgram == null || this.mProgram.programType() != imageFormatToProgramType(yMFImageBuffer.mFormat)) {
            releaseProgram();
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (this.mInputImageTextures == null || this.mInputImageTextures[0].getWidth() != yMFImageBuffer.mWidth || this.mInputImageTextures[0].getHeight() != yMFImageBuffer.mHeight) {
            releaseInYuvTextures();
            z = true;
        }
        if (z2) {
            createProgram(yMFImageBuffer);
        }
        if (z) {
            createInputTexture(yMFImageBuffer);
        }
    }

    @Override // com.yy.videoplayer.render.IRender
    public boolean prepareInputImageData(YMFImageBuffer yMFImageBuffer) {
        if (yMFImageBuffer != null) {
            try {
                if (yMFImageBuffer.mData != null) {
                    yMFImageBuffer.tryLockData();
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
                            break;
                        case 2:
                            this.mInputImageTextures[0].updateTextureData(byteBuffer.position(yoffset), i, i2);
                            this.mInputImageTextures[1].updateTextureData(byteBuffer.position(uoffset), i / 2, i2 / 2);
                            this.mInputImageTextures[2].updateTextureData(byteBuffer.position(voffset), i / 2, i2 / 2);
                            break;
                        case 36:
                            this.mInputImageTextures[0].updateTextureData(byteBuffer.position(0), i, i2);
                            break;
                    }
                    return true;
                }
            } catch (Exception e) {
                YMFLog.error(this, TAG, " data error:" + e.toString());
                return true;
            } finally {
                yMFImageBuffer.tryUnlockData();
            }
        }
        YMFLog.error(this, "[Render  ]", "invalid input YMFImageBuffer.");
        return false;
    }

    @Override // com.yy.videoplayer.render.IRender
    public int prepareInputBackgroundTexture(Bitmap bitmap, int i, int i2) {
        YMFTexture createBitmapTexture = createBitmapTexture(bitmap, i, i2);
        if (createBitmapTexture == null || !createBitmapTexture.validate()) {
            return -1;
        }
        if (this.mProgram == null || this.mProgram.programType() != 0) {
            releaseProgram();
            this.mProgram = YMFProgramFactory.createProgram(0);
        }
        this.mBackgroundTexture = createBitmapTexture;
        this.mBackgroundTexture.bindBackgroundTexture();
        return 0;
    }

    @Override // com.yy.videoplayer.render.IRender
    public boolean prepareInputTexture(YMFTexture yMFTexture) {
        if (yMFTexture == null || !yMFTexture.validate()) {
            return false;
        }
        if (this.mProgram == null || this.mProgram.programType() != 0) {
            releaseProgram();
            this.mProgram = YMFProgramFactory.createProgram(0);
        }
        this.mInput2dTexture = yMFTexture;
        this.mInput2dTexture.bind();
        return true;
    }

    @Override // com.yy.videoplayer.render.IRender
    public void prepareWaterTexture(YMFTexture yMFTexture) {
        if (yMFTexture != null && yMFTexture.validate()) {
            this.mProgram.enableWaterMarker(true);
            yMFTexture.bind();
            this.mWaterMarkTexture = yMFTexture;
            return;
        }
        this.mProgram.enableWaterMarker(false);
    }

    @Override // com.yy.videoplayer.render.IRender
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

    @Override // com.yy.videoplayer.render.IRender
    public void flipHorizontal() {
        if (this.mProgram != null) {
            this.mProgram.flipHorizontal();
        }
    }

    @Override // com.yy.videoplayer.render.IRender
    public void flipVertical() {
        if (this.mProgram != null) {
            this.mProgram.flipVertical();
        }
    }

    @Override // com.yy.videoplayer.render.IRender
    public boolean checkUpdateMirrorMode(boolean z) {
        if (this.mProgram != null) {
            return this.mProgram.checkUpdateMirrorMode(z);
        }
        return false;
    }

    @Override // com.yy.videoplayer.render.IRender
    public void rotate(int i) {
        if (this.mProgram != null) {
            this.mProgram.rotation(i);
        }
    }

    @Override // com.yy.videoplayer.render.IRender
    public void clip(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        if (this.mProgram != null) {
            this.mProgram.clip(i, i2, i3, i4, i5, i6, z);
        }
    }

    @Override // com.yy.videoplayer.render.IRender
    public void clip(int i, int i2, int i3, int i4, VideoConstant.ScaleMode scaleMode) {
        if (this.mProgram != null) {
            this.mProgram.clip(i, i2, i3, i4, scaleMode);
        }
    }

    @Override // com.yy.videoplayer.render.IRender
    public void render() {
        if (this.mProgram != null) {
            this.mProgram.useProgram();
            bindTexture();
            this.mProgram.drawFrame();
            reStoreGlContext();
        }
    }

    private void bindTexture() {
        if (this.mInput2dTexture != null) {
            this.mInput2dTexture.bind();
        }
        if (this.mBackgroundTexture != null) {
            this.mBackgroundTexture.bindBackgroundTexture();
        }
    }

    private void reStoreGlContext() {
        switch (this.mProgram.programType()) {
            case 0:
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
        if (this.mBackgroundTexture != null) {
            this.mBackgroundTexture.unBindBackgroundTexture();
        }
        GLES20.glUseProgram(0);
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

    @Override // com.yy.videoplayer.render.IRender
    public void release() {
        releaseInYuvTextures();
        releaseProgram();
        if (this.mFrameBuffer != null) {
            this.mFrameBuffer.release();
            this.mFrameBuffer = null;
        }
    }
}
