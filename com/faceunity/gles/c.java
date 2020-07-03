package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d mYT = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram mYU;

    public c(Texture2dProgram texture2dProgram) {
        this.mYU = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mYU != null) {
            if (z) {
                this.mYU.release();
            }
            this.mYU = null;
        }
    }

    public int createTextureObject() {
        return this.mYU.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.mYU != null) {
            this.mYU.draw(d.IDENTITY_MATRIX, this.mYT.getVertexArray(), 0, this.mYT.getVertexCount(), this.mYT.getCoordsPerVertex(), this.mYT.getVertexStride(), fArr, this.mYT.getTexCoordArray(), i, this.mYT.getTexCoordStride());
        }
    }
}
