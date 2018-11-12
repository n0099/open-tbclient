package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d ilu = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram ilv;

    public c(Texture2dProgram texture2dProgram) {
        this.ilv = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.ilv != null) {
            if (z) {
                this.ilv.release();
            }
            this.ilv = null;
        }
    }

    public int createTextureObject() {
        return this.ilv.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.ilv != null) {
            this.ilv.draw(d.IDENTITY_MATRIX, this.ilu.getVertexArray(), 0, this.ilu.getVertexCount(), this.ilu.getCoordsPerVertex(), this.ilu.getVertexStride(), fArr, this.ilu.getTexCoordArray(), i, this.ilu.getTexCoordStride());
        }
    }
}
