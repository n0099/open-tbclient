package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes8.dex */
public class c {
    private final Drawable2d pOo = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pOp;

    public c(Texture2dProgram texture2dProgram) {
        this.pOp = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pOp != null) {
            if (z) {
                this.pOp.release();
            }
            this.pOp = null;
        }
    }

    public int createTextureObject() {
        return this.pOp.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pOp != null) {
            this.pOp.draw(d.IDENTITY_MATRIX, this.pOo.getVertexArray(), 0, this.pOo.getVertexCount(), this.pOo.getCoordsPerVertex(), this.pOo.getVertexStride(), fArr, this.pOo.getTexCoordArray(), i, this.pOo.getTexCoordStride());
        }
    }
}
