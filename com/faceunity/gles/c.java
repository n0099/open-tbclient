package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d iwY = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram iwZ;

    public c(Texture2dProgram texture2dProgram) {
        this.iwZ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.iwZ != null) {
            if (z) {
                this.iwZ.release();
            }
            this.iwZ = null;
        }
    }

    public int createTextureObject() {
        return this.iwZ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.iwZ != null) {
            this.iwZ.draw(d.IDENTITY_MATRIX, this.iwY.getVertexArray(), 0, this.iwY.getVertexCount(), this.iwY.getCoordsPerVertex(), this.iwY.getVertexStride(), fArr, this.iwY.getTexCoordArray(), i, this.iwY.getTexCoordStride());
        }
    }
}
