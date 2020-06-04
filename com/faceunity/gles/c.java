package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d mCN = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram mCO;

    public c(Texture2dProgram texture2dProgram) {
        this.mCO = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mCO != null) {
            if (z) {
                this.mCO.release();
            }
            this.mCO = null;
        }
    }

    public int createTextureObject() {
        return this.mCO.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.mCO != null) {
            this.mCO.draw(d.IDENTITY_MATRIX, this.mCN.getVertexArray(), 0, this.mCN.getVertexCount(), this.mCN.getCoordsPerVertex(), this.mCN.getVertexStride(), fArr, this.mCN.getTexCoordArray(), i, this.mCN.getTexCoordStride());
        }
    }
}
