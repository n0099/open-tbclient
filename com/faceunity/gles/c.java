package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes17.dex */
public class c {
    private final Drawable2d nha = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram nhb;

    public c(Texture2dProgram texture2dProgram) {
        this.nhb = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.nhb != null) {
            if (z) {
                this.nhb.release();
            }
            this.nhb = null;
        }
    }

    public int createTextureObject() {
        return this.nhb.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.nhb != null) {
            this.nhb.draw(d.IDENTITY_MATRIX, this.nha.getVertexArray(), 0, this.nha.getVertexCount(), this.nha.getCoordsPerVertex(), this.nha.getVertexStride(), fArr, this.nha.getTexCoordArray(), i, this.nha.getTexCoordStride());
        }
    }
}
