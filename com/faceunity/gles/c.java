package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes23.dex */
public class c {
    private final Drawable2d prB = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram prC;

    public c(Texture2dProgram texture2dProgram) {
        this.prC = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.prC != null) {
            if (z) {
                this.prC.release();
            }
            this.prC = null;
        }
    }

    public int createTextureObject() {
        return this.prC.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.prC != null) {
            this.prC.draw(d.IDENTITY_MATRIX, this.prB.getVertexArray(), 0, this.prB.getVertexCount(), this.prB.getCoordsPerVertex(), this.prB.getVertexStride(), fArr, this.prB.getTexCoordArray(), i, this.prB.getTexCoordStride());
        }
    }
}
