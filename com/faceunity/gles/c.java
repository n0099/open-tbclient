package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes17.dex */
public class c {
    private final Drawable2d ngY = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram ngZ;

    public c(Texture2dProgram texture2dProgram) {
        this.ngZ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.ngZ != null) {
            if (z) {
                this.ngZ.release();
            }
            this.ngZ = null;
        }
    }

    public int createTextureObject() {
        return this.ngZ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.ngZ != null) {
            this.ngZ.draw(d.IDENTITY_MATRIX, this.ngY.getVertexArray(), 0, this.ngY.getVertexCount(), this.ngY.getCoordsPerVertex(), this.ngY.getVertexStride(), fArr, this.ngY.getTexCoordArray(), i, this.ngY.getTexCoordStride());
        }
    }
}
