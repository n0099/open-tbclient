package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hie = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hif;

    public c(Texture2dProgram texture2dProgram) {
        this.hif = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hif != null) {
            if (z) {
                this.hif.release();
            }
            this.hif = null;
        }
    }

    public int createTextureObject() {
        return this.hif.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hif != null) {
            this.hif.draw(d.IDENTITY_MATRIX, this.hie.getVertexArray(), 0, this.hie.getVertexCount(), this.hie.getCoordsPerVertex(), this.hie.getVertexStride(), fArr, this.hie.getTexCoordArray(), i, this.hie.getTexCoordStride());
        }
    }
}
