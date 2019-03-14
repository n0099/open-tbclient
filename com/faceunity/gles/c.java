package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d jMT = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram jMU;

    public c(Texture2dProgram texture2dProgram) {
        this.jMU = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.jMU != null) {
            if (z) {
                this.jMU.release();
            }
            this.jMU = null;
        }
    }

    public int createTextureObject() {
        return this.jMU.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.jMU != null) {
            this.jMU.draw(d.IDENTITY_MATRIX, this.jMT.getVertexArray(), 0, this.jMT.getVertexCount(), this.jMT.getCoordsPerVertex(), this.jMT.getVertexStride(), fArr, this.jMT.getTexCoordArray(), i, this.jMT.getTexCoordStride());
        }
    }
}
