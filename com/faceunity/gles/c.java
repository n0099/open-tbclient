package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hHS = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hHT;

    public c(Texture2dProgram texture2dProgram) {
        this.hHT = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hHT != null) {
            if (z) {
                this.hHT.release();
            }
            this.hHT = null;
        }
    }

    public int createTextureObject() {
        return this.hHT.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hHT != null) {
            this.hHT.draw(d.IDENTITY_MATRIX, this.hHS.getVertexArray(), 0, this.hHS.getVertexCount(), this.hHS.getCoordsPerVertex(), this.hHS.getVertexStride(), fArr, this.hHS.getTexCoordArray(), i, this.hHS.getTexCoordStride());
        }
    }
}
