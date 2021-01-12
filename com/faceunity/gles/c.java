package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes7.dex */
public class c {
    private final Drawable2d pEi = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pEj;

    public c(Texture2dProgram texture2dProgram) {
        this.pEj = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pEj != null) {
            if (z) {
                this.pEj.release();
            }
            this.pEj = null;
        }
    }

    public int createTextureObject() {
        return this.pEj.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pEj != null) {
            this.pEj.draw(d.IDENTITY_MATRIX, this.pEi.getVertexArray(), 0, this.pEi.getVertexCount(), this.pEi.getCoordsPerVertex(), this.pEi.getVertexStride(), fArr, this.pEi.getTexCoordArray(), i, this.pEi.getTexCoordStride());
        }
    }
}
