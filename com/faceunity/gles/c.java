package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d mhK = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram mhL;

    public c(Texture2dProgram texture2dProgram) {
        this.mhL = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mhL != null) {
            if (z) {
                this.mhL.release();
            }
            this.mhL = null;
        }
    }

    public int createTextureObject() {
        return this.mhL.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.mhL != null) {
            this.mhL.draw(d.IDENTITY_MATRIX, this.mhK.getVertexArray(), 0, this.mhK.getVertexCount(), this.mhK.getCoordsPerVertex(), this.mhK.getVertexStride(), fArr, this.mhK.getTexCoordArray(), i, this.mhK.getTexCoordStride());
        }
    }
}
