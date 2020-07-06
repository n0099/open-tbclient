package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d mYW = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram mYX;

    public c(Texture2dProgram texture2dProgram) {
        this.mYX = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mYX != null) {
            if (z) {
                this.mYX.release();
            }
            this.mYX = null;
        }
    }

    public int createTextureObject() {
        return this.mYX.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.mYX != null) {
            this.mYX.draw(d.IDENTITY_MATRIX, this.mYW.getVertexArray(), 0, this.mYW.getVertexCount(), this.mYW.getCoordsPerVertex(), this.mYW.getVertexStride(), fArr, this.mYW.getTexCoordArray(), i, this.mYW.getTexCoordStride());
        }
    }
}
