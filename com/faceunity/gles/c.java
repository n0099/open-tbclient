package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d gYk = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram gYl;

    public c(Texture2dProgram texture2dProgram) {
        this.gYl = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.gYl != null) {
            if (z) {
                this.gYl.release();
            }
            this.gYl = null;
        }
    }

    public int createTextureObject() {
        return this.gYl.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.gYl != null) {
            this.gYl.draw(d.IDENTITY_MATRIX, this.gYk.getVertexArray(), 0, this.gYk.getVertexCount(), this.gYk.getCoordsPerVertex(), this.gYk.getVertexStride(), fArr, this.gYk.getTexCoordArray(), i, this.gYk.getTexCoordStride());
        }
    }
}
