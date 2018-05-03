package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d huU = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram huV;

    public c(Texture2dProgram texture2dProgram) {
        this.huV = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.huV != null) {
            if (z) {
                this.huV.release();
            }
            this.huV = null;
        }
    }

    public int createTextureObject() {
        return this.huV.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.huV != null) {
            this.huV.draw(d.IDENTITY_MATRIX, this.huU.getVertexArray(), 0, this.huU.getVertexCount(), this.huU.getCoordsPerVertex(), this.huU.getVertexStride(), fArr, this.huU.getTexCoordArray(), i, this.huU.getTexCoordStride());
        }
    }
}
