package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d lZJ = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lZK;

    public c(Texture2dProgram texture2dProgram) {
        this.lZK = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lZK != null) {
            if (z) {
                this.lZK.release();
            }
            this.lZK = null;
        }
    }

    public int createTextureObject() {
        return this.lZK.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lZK != null) {
            this.lZK.draw(d.IDENTITY_MATRIX, this.lZJ.getVertexArray(), 0, this.lZJ.getVertexCount(), this.lZJ.getCoordsPerVertex(), this.lZJ.getVertexStride(), fArr, this.lZJ.getTexCoordArray(), i, this.lZJ.getTexCoordStride());
        }
    }
}
