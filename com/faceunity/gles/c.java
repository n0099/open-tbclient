package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hxt = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hxu;

    public c(Texture2dProgram texture2dProgram) {
        this.hxu = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hxu != null) {
            if (z) {
                this.hxu.release();
            }
            this.hxu = null;
        }
    }

    public int createTextureObject() {
        return this.hxu.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hxu != null) {
            this.hxu.draw(d.IDENTITY_MATRIX, this.hxt.getVertexArray(), 0, this.hxt.getVertexCount(), this.hxt.getCoordsPerVertex(), this.hxt.getVertexStride(), fArr, this.hxt.getTexCoordArray(), i, this.hxt.getTexCoordStride());
        }
    }
}
