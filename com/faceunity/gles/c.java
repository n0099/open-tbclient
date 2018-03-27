package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hXY = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hXZ;

    public c(Texture2dProgram texture2dProgram) {
        this.hXZ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hXZ != null) {
            if (z) {
                this.hXZ.release();
            }
            this.hXZ = null;
        }
    }

    public int createTextureObject() {
        return this.hXZ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hXZ != null) {
            this.hXZ.draw(d.IDENTITY_MATRIX, this.hXY.getVertexArray(), 0, this.hXY.getVertexCount(), this.hXY.getCoordsPerVertex(), this.hXY.getVertexStride(), fArr, this.hXY.getTexCoordArray(), i, this.hXY.getTexCoordStride());
        }
    }
}
