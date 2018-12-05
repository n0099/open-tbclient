package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d isG = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram isH;

    public c(Texture2dProgram texture2dProgram) {
        this.isH = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.isH != null) {
            if (z) {
                this.isH.release();
            }
            this.isH = null;
        }
    }

    public int createTextureObject() {
        return this.isH.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.isH != null) {
            this.isH.draw(d.IDENTITY_MATRIX, this.isG.getVertexArray(), 0, this.isG.getVertexCount(), this.isG.getCoordsPerVertex(), this.isG.getVertexStride(), fArr, this.isG.getTexCoordArray(), i, this.isG.getTexCoordStride());
        }
    }
}
