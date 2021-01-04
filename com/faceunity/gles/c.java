package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes8.dex */
public class c {
    private final Drawable2d pHb = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pHc;

    public c(Texture2dProgram texture2dProgram) {
        this.pHc = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pHc != null) {
            if (z) {
                this.pHc.release();
            }
            this.pHc = null;
        }
    }

    public int createTextureObject() {
        return this.pHc.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pHc != null) {
            this.pHc.draw(d.IDENTITY_MATRIX, this.pHb.getVertexArray(), 0, this.pHb.getVertexCount(), this.pHb.getCoordsPerVertex(), this.pHb.getVertexStride(), fArr, this.pHb.getTexCoordArray(), i, this.pHb.getTexCoordStride());
        }
    }
}
