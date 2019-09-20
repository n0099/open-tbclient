package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d kpM = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram kpN;

    public c(Texture2dProgram texture2dProgram) {
        this.kpN = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.kpN != null) {
            if (z) {
                this.kpN.release();
            }
            this.kpN = null;
        }
    }

    public int createTextureObject() {
        return this.kpN.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.kpN != null) {
            this.kpN.draw(d.IDENTITY_MATRIX, this.kpM.getVertexArray(), 0, this.kpM.getVertexCount(), this.kpM.getCoordsPerVertex(), this.kpM.getVertexStride(), fArr, this.kpM.getTexCoordArray(), i, this.kpM.getTexCoordStride());
        }
    }
}
