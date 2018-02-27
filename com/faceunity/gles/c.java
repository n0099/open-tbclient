package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hXA = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hXB;

    public c(Texture2dProgram texture2dProgram) {
        this.hXB = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hXB != null) {
            if (z) {
                this.hXB.release();
            }
            this.hXB = null;
        }
    }

    public int createTextureObject() {
        return this.hXB.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hXB != null) {
            this.hXB.draw(d.IDENTITY_MATRIX, this.hXA.getVertexArray(), 0, this.hXA.getVertexCount(), this.hXA.getCoordsPerVertex(), this.hXA.getVertexStride(), fArr, this.hXA.getTexCoordArray(), i, this.hXA.getTexCoordStride());
        }
    }
}
