package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes8.dex */
public class c {
    private final Drawable2d pIJ = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pIK;

    public c(Texture2dProgram texture2dProgram) {
        this.pIK = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pIK != null) {
            if (z) {
                this.pIK.release();
            }
            this.pIK = null;
        }
    }

    public int createTextureObject() {
        return this.pIK.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pIK != null) {
            this.pIK.draw(d.IDENTITY_MATRIX, this.pIJ.getVertexArray(), 0, this.pIJ.getVertexCount(), this.pIJ.getCoordsPerVertex(), this.pIJ.getVertexStride(), fArr, this.pIJ.getTexCoordArray(), i, this.pIJ.getTexCoordStride());
        }
    }
}
