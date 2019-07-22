package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d kmj = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram kmk;

    public c(Texture2dProgram texture2dProgram) {
        this.kmk = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.kmk != null) {
            if (z) {
                this.kmk.release();
            }
            this.kmk = null;
        }
    }

    public int createTextureObject() {
        return this.kmk.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.kmk != null) {
            this.kmk.draw(d.IDENTITY_MATRIX, this.kmj.getVertexArray(), 0, this.kmj.getVertexCount(), this.kmj.getCoordsPerVertex(), this.kmj.getVertexStride(), fArr, this.kmj.getTexCoordArray(), i, this.kmj.getTexCoordStride());
        }
    }
}
