package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d mhG = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram mhH;

    public c(Texture2dProgram texture2dProgram) {
        this.mhH = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.mhH != null) {
            if (z) {
                this.mhH.release();
            }
            this.mhH = null;
        }
    }

    public int createTextureObject() {
        return this.mhH.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.mhH != null) {
            this.mhH.draw(d.IDENTITY_MATRIX, this.mhG.getVertexArray(), 0, this.mhG.getVertexCount(), this.mhG.getCoordsPerVertex(), this.mhG.getVertexStride(), fArr, this.mhG.getTexCoordArray(), i, this.mhG.getTexCoordStride());
        }
    }
}
