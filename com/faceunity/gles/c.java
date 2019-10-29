package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d knY = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram knZ;

    public c(Texture2dProgram texture2dProgram) {
        this.knZ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.knZ != null) {
            if (z) {
                this.knZ.release();
            }
            this.knZ = null;
        }
    }

    public int createTextureObject() {
        return this.knZ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.knZ != null) {
            this.knZ.draw(d.IDENTITY_MATRIX, this.knY.getVertexArray(), 0, this.knY.getVertexCount(), this.knY.getCoordsPerVertex(), this.knY.getVertexStride(), fArr, this.knY.getTexCoordArray(), i, this.knY.getTexCoordStride());
        }
    }
}
