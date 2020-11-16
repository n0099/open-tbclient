package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes22.dex */
public class c {
    private final Drawable2d pcL = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram pcM;

    public c(Texture2dProgram texture2dProgram) {
        this.pcM = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.pcM != null) {
            if (z) {
                this.pcM.release();
            }
            this.pcM = null;
        }
    }

    public int createTextureObject() {
        return this.pcM.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.pcM != null) {
            this.pcM.draw(d.IDENTITY_MATRIX, this.pcL.getVertexArray(), 0, this.pcL.getVertexCount(), this.pcL.getCoordsPerVertex(), this.pcL.getVertexStride(), fArr, this.pcL.getTexCoordArray(), i, this.pcL.getTexCoordStride());
        }
    }
}
