package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hWp = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hWq;

    public c(Texture2dProgram texture2dProgram) {
        this.hWq = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hWq != null) {
            if (z) {
                this.hWq.release();
            }
            this.hWq = null;
        }
    }

    public int createTextureObject() {
        return this.hWq.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hWq != null) {
            this.hWq.draw(d.IDENTITY_MATRIX, this.hWp.getVertexArray(), 0, this.hWp.getVertexCount(), this.hWp.getCoordsPerVertex(), this.hWp.getVertexStride(), fArr, this.hWp.getTexCoordArray(), i, this.hWp.getTexCoordStride());
        }
    }
}
