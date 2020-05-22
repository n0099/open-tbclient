package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d mBC = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram mBD;

    public c(Texture2dProgram texture2dProgram) {
        this.mBD = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mBD != null) {
            if (z) {
                this.mBD.release();
            }
            this.mBD = null;
        }
    }

    public int createTextureObject() {
        return this.mBD.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.mBD != null) {
            this.mBD.draw(d.IDENTITY_MATRIX, this.mBC.getVertexArray(), 0, this.mBC.getVertexCount(), this.mBC.getCoordsPerVertex(), this.mBC.getVertexStride(), fArr, this.mBC.getTexCoordArray(), i, this.mBC.getTexCoordStride());
        }
    }
}
