package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d lYd = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lYe;

    public c(Texture2dProgram texture2dProgram) {
        this.lYe = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lYe != null) {
            if (z) {
                this.lYe.release();
            }
            this.lYe = null;
        }
    }

    public int createTextureObject() {
        return this.lYe.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lYe != null) {
            this.lYe.draw(d.IDENTITY_MATRIX, this.lYd.getVertexArray(), 0, this.lYd.getVertexCount(), this.lYd.getCoordsPerVertex(), this.lYd.getVertexStride(), fArr, this.lYd.getTexCoordArray(), i, this.lYd.getTexCoordStride());
        }
    }
}
