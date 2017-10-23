package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d gXU = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram gXV;

    public c(Texture2dProgram texture2dProgram) {
        this.gXV = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.gXV != null) {
            if (z) {
                this.gXV.release();
            }
            this.gXV = null;
        }
    }

    public int createTextureObject() {
        return this.gXV.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.gXV != null) {
            this.gXV.draw(d.IDENTITY_MATRIX, this.gXU.getVertexArray(), 0, this.gXU.getVertexCount(), this.gXU.getCoordsPerVertex(), this.gXU.getVertexStride(), fArr, this.gXU.getTexCoordArray(), i, this.gXU.getTexCoordStride());
        }
    }
}
