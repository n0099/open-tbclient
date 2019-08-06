package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d knp = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram knq;

    public c(Texture2dProgram texture2dProgram) {
        this.knq = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.knq != null) {
            if (z) {
                this.knq.release();
            }
            this.knq = null;
        }
    }

    public int createTextureObject() {
        return this.knq.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.knq != null) {
            this.knq.draw(d.IDENTITY_MATRIX, this.knp.getVertexArray(), 0, this.knp.getVertexCount(), this.knp.getCoordsPerVertex(), this.knp.getVertexStride(), fArr, this.knp.getTexCoordArray(), i, this.knp.getTexCoordStride());
        }
    }
}
