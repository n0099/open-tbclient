package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hjo = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hjp;

    public c(Texture2dProgram texture2dProgram) {
        this.hjp = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hjp != null) {
            if (z) {
                this.hjp.release();
            }
            this.hjp = null;
        }
    }

    public int createTextureObject() {
        return this.hjp.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hjp != null) {
            this.hjp.draw(d.IDENTITY_MATRIX, this.hjo.getVertexArray(), 0, this.hjo.getVertexCount(), this.hjo.getCoordsPerVertex(), this.hjo.getVertexStride(), fArr, this.hjo.getTexCoordArray(), i, this.hjo.getTexCoordStride());
        }
    }
}
