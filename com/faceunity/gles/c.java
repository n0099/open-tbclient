package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes7.dex */
public class c {
    private final Drawable2d pQT = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pQU;

    public c(Texture2dProgram texture2dProgram) {
        this.pQU = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pQU != null) {
            if (z) {
                this.pQU.release();
            }
            this.pQU = null;
        }
    }

    public int createTextureObject() {
        return this.pQU.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pQU != null) {
            this.pQU.draw(d.IDENTITY_MATRIX, this.pQT.getVertexArray(), 0, this.pQT.getVertexCount(), this.pQT.getCoordsPerVertex(), this.pQT.getVertexStride(), fArr, this.pQT.getTexCoordArray(), i, this.pQT.getTexCoordStride());
        }
    }
}
