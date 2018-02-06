package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hXN = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hXO;

    public c(Texture2dProgram texture2dProgram) {
        this.hXO = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hXO != null) {
            if (z) {
                this.hXO.release();
            }
            this.hXO = null;
        }
    }

    public int createTextureObject() {
        return this.hXO.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hXO != null) {
            this.hXO.draw(d.IDENTITY_MATRIX, this.hXN.getVertexArray(), 0, this.hXN.getVertexCount(), this.hXN.getCoordsPerVertex(), this.hXN.getVertexStride(), fArr, this.hXN.getTexCoordArray(), i, this.hXN.getTexCoordStride());
        }
    }
}
