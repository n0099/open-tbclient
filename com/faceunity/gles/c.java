package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d lXQ = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lXR;

    public c(Texture2dProgram texture2dProgram) {
        this.lXR = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lXR != null) {
            if (z) {
                this.lXR.release();
            }
            this.lXR = null;
        }
    }

    public int createTextureObject() {
        return this.lXR.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lXR != null) {
            this.lXR.draw(d.IDENTITY_MATRIX, this.lXQ.getVertexArray(), 0, this.lXQ.getVertexCount(), this.lXQ.getCoordsPerVertex(), this.lXQ.getVertexStride(), fArr, this.lXQ.getTexCoordArray(), i, this.lXQ.getTexCoordStride());
        }
    }
}
