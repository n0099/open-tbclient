package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes7.dex */
public class c {
    private final Drawable2d lTo = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lTp;

    public c(Texture2dProgram texture2dProgram) {
        this.lTp = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lTp != null) {
            if (z) {
                this.lTp.release();
            }
            this.lTp = null;
        }
    }

    public int createTextureObject() {
        return this.lTp.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lTp != null) {
            this.lTp.draw(d.IDENTITY_MATRIX, this.lTo.getVertexArray(), 0, this.lTo.getVertexCount(), this.lTo.getCoordsPerVertex(), this.lTo.getVertexStride(), fArr, this.lTo.getTexCoordArray(), i, this.lTo.getTexCoordStride());
        }
    }
}
