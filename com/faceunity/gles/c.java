package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes8.dex */
public class c {
    private final Drawable2d pOO = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pOP;

    public c(Texture2dProgram texture2dProgram) {
        this.pOP = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pOP != null) {
            if (z) {
                this.pOP.release();
            }
            this.pOP = null;
        }
    }

    public int createTextureObject() {
        return this.pOP.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pOP != null) {
            this.pOP.draw(d.IDENTITY_MATRIX, this.pOO.getVertexArray(), 0, this.pOO.getVertexCount(), this.pOO.getCoordsPerVertex(), this.pOO.getVertexStride(), fArr, this.pOO.getTexCoordArray(), i, this.pOO.getTexCoordStride());
        }
    }
}
