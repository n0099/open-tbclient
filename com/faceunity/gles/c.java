package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d huX = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram huY;

    public c(Texture2dProgram texture2dProgram) {
        this.huY = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.huY != null) {
            if (z) {
                this.huY.release();
            }
            this.huY = null;
        }
    }

    public int createTextureObject() {
        return this.huY.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.huY != null) {
            this.huY.draw(d.IDENTITY_MATRIX, this.huX.getVertexArray(), 0, this.huX.getVertexCount(), this.huX.getCoordsPerVertex(), this.huX.getVertexStride(), fArr, this.huX.getTexCoordArray(), i, this.huX.getTexCoordStride());
        }
    }
}
