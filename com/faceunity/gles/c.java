package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes17.dex */
public class c {
    private final Drawable2d nBh = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram nBi;

    public c(Texture2dProgram texture2dProgram) {
        this.nBi = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.nBi != null) {
            if (z) {
                this.nBi.release();
            }
            this.nBi = null;
        }
    }

    public int createTextureObject() {
        return this.nBi.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.nBi != null) {
            this.nBi.draw(d.IDENTITY_MATRIX, this.nBh.getVertexArray(), 0, this.nBh.getVertexCount(), this.nBh.getCoordsPerVertex(), this.nBh.getVertexStride(), fArr, this.nBh.getTexCoordArray(), i, this.nBh.getTexCoordStride());
        }
    }
}
