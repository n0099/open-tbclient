package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes17.dex */
public class c {
    private final Drawable2d nAP = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram nAQ;

    public c(Texture2dProgram texture2dProgram) {
        this.nAQ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.nAQ != null) {
            if (z) {
                this.nAQ.release();
            }
            this.nAQ = null;
        }
    }

    public int createTextureObject() {
        return this.nAQ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.nAQ != null) {
            this.nAQ.draw(d.IDENTITY_MATRIX, this.nAP.getVertexArray(), 0, this.nAP.getVertexCount(), this.nAP.getCoordsPerVertex(), this.nAP.getVertexStride(), fArr, this.nAP.getTexCoordArray(), i, this.nAP.getTexCoordStride());
        }
    }
}
