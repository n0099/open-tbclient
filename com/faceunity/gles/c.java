package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hYc = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hYd;

    public c(Texture2dProgram texture2dProgram) {
        this.hYd = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hYd != null) {
            if (z) {
                this.hYd.release();
            }
            this.hYd = null;
        }
    }

    public int createTextureObject() {
        return this.hYd.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hYd != null) {
            this.hYd.draw(d.IDENTITY_MATRIX, this.hYc.getVertexArray(), 0, this.hYc.getVertexCount(), this.hYc.getCoordsPerVertex(), this.hYc.getVertexStride(), fArr, this.hYc.getTexCoordArray(), i, this.hYc.getTexCoordStride());
        }
    }
}
