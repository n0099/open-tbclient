package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d gYj = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram gYk;

    public c(Texture2dProgram texture2dProgram) {
        this.gYk = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.gYk != null) {
            if (z) {
                this.gYk.release();
            }
            this.gYk = null;
        }
    }

    public int createTextureObject() {
        return this.gYk.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.gYk != null) {
            this.gYk.draw(d.IDENTITY_MATRIX, this.gYj.getVertexArray(), 0, this.gYj.getVertexCount(), this.gYj.getCoordsPerVertex(), this.gYj.getVertexStride(), fArr, this.gYj.getTexCoordArray(), i, this.gYj.getTexCoordStride());
        }
    }
}
