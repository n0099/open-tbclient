package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes23.dex */
public class c {
    private final Drawable2d oRN = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram oRO;

    public c(Texture2dProgram texture2dProgram) {
        this.oRO = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.oRO != null) {
            if (z) {
                this.oRO.release();
            }
            this.oRO = null;
        }
    }

    public int createTextureObject() {
        return this.oRO.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.oRO != null) {
            this.oRO.draw(d.IDENTITY_MATRIX, this.oRN.getVertexArray(), 0, this.oRN.getVertexCount(), this.oRN.getCoordsPerVertex(), this.oRN.getVertexStride(), fArr, this.oRN.getTexCoordArray(), i, this.oRN.getTexCoordStride());
        }
    }
}
