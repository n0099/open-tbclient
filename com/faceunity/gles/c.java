package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d ivQ = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram ivR;

    public c(Texture2dProgram texture2dProgram) {
        this.ivR = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.ivR != null) {
            if (z) {
                this.ivR.release();
            }
            this.ivR = null;
        }
    }

    public int createTextureObject() {
        return this.ivR.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.ivR != null) {
            this.ivR.draw(d.IDENTITY_MATRIX, this.ivQ.getVertexArray(), 0, this.ivQ.getVertexCount(), this.ivQ.getCoordsPerVertex(), this.ivQ.getVertexStride(), fArr, this.ivQ.getTexCoordArray(), i, this.ivQ.getTexCoordStride());
        }
    }
}
