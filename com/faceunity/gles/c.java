package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes8.dex */
public class c {
    private final Drawable2d lXk = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lXl;

    public c(Texture2dProgram texture2dProgram) {
        this.lXl = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lXl != null) {
            if (z) {
                this.lXl.release();
            }
            this.lXl = null;
        }
    }

    public int createTextureObject() {
        return this.lXl.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lXl != null) {
            this.lXl.draw(d.IDENTITY_MATRIX, this.lXk.getVertexArray(), 0, this.lXk.getVertexCount(), this.lXk.getCoordsPerVertex(), this.lXk.getVertexStride(), fArr, this.lXk.getTexCoordArray(), i, this.lXk.getTexCoordStride());
        }
    }
}
