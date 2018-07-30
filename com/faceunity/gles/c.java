package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hEV = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hEW;

    public c(Texture2dProgram texture2dProgram) {
        this.hEW = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hEW != null) {
            if (z) {
                this.hEW.release();
            }
            this.hEW = null;
        }
    }

    public int createTextureObject() {
        return this.hEW.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hEW != null) {
            this.hEW.draw(d.IDENTITY_MATRIX, this.hEV.getVertexArray(), 0, this.hEV.getVertexCount(), this.hEV.getCoordsPerVertex(), this.hEV.getVertexStride(), fArr, this.hEV.getTexCoordArray(), i, this.hEV.getTexCoordStride());
        }
    }
}
