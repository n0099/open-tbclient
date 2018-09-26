package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hNr = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hNs;

    public c(Texture2dProgram texture2dProgram) {
        this.hNs = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hNs != null) {
            if (z) {
                this.hNs.release();
            }
            this.hNs = null;
        }
    }

    public int createTextureObject() {
        return this.hNs.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hNs != null) {
            this.hNs.draw(d.IDENTITY_MATRIX, this.hNr.getVertexArray(), 0, this.hNr.getVertexCount(), this.hNr.getCoordsPerVertex(), this.hNr.getVertexStride(), fArr, this.hNr.getTexCoordArray(), i, this.hNr.getTexCoordStride());
        }
    }
}
