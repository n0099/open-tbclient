package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes7.dex */
public class c {
    private final Drawable2d pEj = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pEk;

    public c(Texture2dProgram texture2dProgram) {
        this.pEk = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pEk != null) {
            if (z) {
                this.pEk.release();
            }
            this.pEk = null;
        }
    }

    public int createTextureObject() {
        return this.pEk.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pEk != null) {
            this.pEk.draw(d.IDENTITY_MATRIX, this.pEj.getVertexArray(), 0, this.pEj.getVertexCount(), this.pEj.getCoordsPerVertex(), this.pEj.getVertexStride(), fArr, this.pEj.getTexCoordArray(), i, this.pEj.getTexCoordStride());
        }
    }
}
