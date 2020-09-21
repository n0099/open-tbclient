package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes22.dex */
public class c {
    private final Drawable2d nLe = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram nLf;

    public c(Texture2dProgram texture2dProgram) {
        this.nLf = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.nLf != null) {
            if (z) {
                this.nLf.release();
            }
            this.nLf = null;
        }
    }

    public int createTextureObject() {
        return this.nLf.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.nLf != null) {
            this.nLf.draw(d.IDENTITY_MATRIX, this.nLe.getVertexArray(), 0, this.nLe.getVertexCount(), this.nLe.getCoordsPerVertex(), this.nLe.getVertexStride(), fArr, this.nLe.getTexCoordArray(), i, this.nLe.getTexCoordStride());
        }
    }
}
