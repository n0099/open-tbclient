package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hxy = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hxz;

    public c(Texture2dProgram texture2dProgram) {
        this.hxz = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hxz != null) {
            if (z) {
                this.hxz.release();
            }
            this.hxz = null;
        }
    }

    public int createTextureObject() {
        return this.hxz.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hxz != null) {
            this.hxz.draw(d.IDENTITY_MATRIX, this.hxy.getVertexArray(), 0, this.hxy.getVertexCount(), this.hxy.getCoordsPerVertex(), this.hxy.getVertexStride(), fArr, this.hxy.getTexCoordArray(), i, this.hxy.getTexCoordStride());
        }
    }
}
