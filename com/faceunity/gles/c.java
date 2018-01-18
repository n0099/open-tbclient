package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hVV = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hVW;

    public c(Texture2dProgram texture2dProgram) {
        this.hVW = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hVW != null) {
            if (z) {
                this.hVW.release();
            }
            this.hVW = null;
        }
    }

    public int createTextureObject() {
        return this.hVW.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hVW != null) {
            this.hVW.draw(d.IDENTITY_MATRIX, this.hVV.getVertexArray(), 0, this.hVV.getVertexCount(), this.hVV.getCoordsPerVertex(), this.hVV.getVertexStride(), fArr, this.hVV.getTexCoordArray(), i, this.hVV.getTexCoordStride());
        }
    }
}
