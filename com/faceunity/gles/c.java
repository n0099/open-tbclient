package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hLY = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hLZ;

    public c(Texture2dProgram texture2dProgram) {
        this.hLZ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hLZ != null) {
            if (z) {
                this.hLZ.release();
            }
            this.hLZ = null;
        }
    }

    public int createTextureObject() {
        return this.hLZ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hLZ != null) {
            this.hLZ.draw(d.IDENTITY_MATRIX, this.hLY.getVertexArray(), 0, this.hLY.getVertexCount(), this.hLY.getCoordsPerVertex(), this.hLY.getVertexStride(), fArr, this.hLY.getTexCoordArray(), i, this.hLY.getTexCoordStride());
        }
    }
}
