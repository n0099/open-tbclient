package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes23.dex */
public class c {
    private final Drawable2d pbi = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pbj;

    public c(Texture2dProgram texture2dProgram) {
        this.pbj = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pbj != null) {
            if (z) {
                this.pbj.release();
            }
            this.pbj = null;
        }
    }

    public int createTextureObject() {
        return this.pbj.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pbj != null) {
            this.pbj.draw(d.IDENTITY_MATRIX, this.pbi.getVertexArray(), 0, this.pbi.getVertexCount(), this.pbi.getCoordsPerVertex(), this.pbi.getVertexStride(), fArr, this.pbi.getTexCoordArray(), i, this.pbi.getTexCoordStride());
        }
    }
}
