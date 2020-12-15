package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes23.dex */
public class c {
    private final Drawable2d prD = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram prE;

    public c(Texture2dProgram texture2dProgram) {
        this.prE = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.prE != null) {
            if (z) {
                this.prE.release();
            }
            this.prE = null;
        }
    }

    public int createTextureObject() {
        return this.prE.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.prE != null) {
            this.prE.draw(d.IDENTITY_MATRIX, this.prD.getVertexArray(), 0, this.prD.getVertexCount(), this.prD.getCoordsPerVertex(), this.prD.getVertexStride(), fArr, this.prD.getTexCoordArray(), i, this.prD.getTexCoordStride());
        }
    }
}
