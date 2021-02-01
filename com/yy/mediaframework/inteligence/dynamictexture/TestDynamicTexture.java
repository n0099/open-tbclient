package com.yy.mediaframework.inteligence.dynamictexture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes4.dex */
public class TestDynamicTexture extends AbstractDynamicTexture {
    private static final int DEFAULT_TEXTURE_HEIGHT = 1280;
    private static final float DEFAULT_TEXTURE_RATIO = 0.4f;
    private static final int DEFAULT_TEXTURE_WIDTH = 720;
    private Bitmap bitmap;
    private int frameCount;
    private int[] textureIds = new int[15];
    private int textureIndex;

    public TestDynamicTexture(Context context, int i) {
        this.frameCount = 0;
        this.textureIndex = 0;
        for (int i2 = 0; i2 < this.textureIds.length; i2++) {
            this.textureIds[i2] = -1;
        }
        this.frameCount = 0;
        this.textureIndex = 0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), i, options);
    }

    @Override // com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture
    public void onDoFrame() {
        int i = this.frameCount;
        this.frameCount = i + 1;
        this.textureIndex = i % this.textureIds.length;
        if (this.textureIds[this.textureIndex] < 0) {
            this.textureIds[this.textureIndex] = createTexture(this.bitmap, 720, 1280, (1.0f * this.textureIndex) / this.textureIds.length, 0.4f);
        }
    }

    @Override // com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture
    public int getDynamicTextureId() {
        return this.textureIds[this.textureIndex];
    }

    @Override // com.yy.mediaframework.inteligence.dynamictexture.IDynamicTexture
    public void onRelease() {
        this.frameCount = 0;
        this.textureIndex = 0;
        for (int i = 0; i < this.textureIds.length; i++) {
            this.textureIds[i] = -1;
        }
    }
}
