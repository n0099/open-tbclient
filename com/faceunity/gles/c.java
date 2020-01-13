package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes8.dex */
public class c {
    private final Drawable2d lXf = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lXg;

    public c(Texture2dProgram texture2dProgram) {
        this.lXg = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lXg != null) {
            if (z) {
                this.lXg.release();
            }
            this.lXg = null;
        }
    }

    public int createTextureObject() {
        return this.lXg.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lXg != null) {
            this.lXg.draw(d.IDENTITY_MATRIX, this.lXf.getVertexArray(), 0, this.lXf.getVertexCount(), this.lXf.getCoordsPerVertex(), this.lXf.getVertexStride(), fArr, this.lXf.getTexCoordArray(), i, this.lXf.getTexCoordStride());
        }
    }
}
