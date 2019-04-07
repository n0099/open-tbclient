package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d jMn = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram jMo;

    public c(Texture2dProgram texture2dProgram) {
        this.jMo = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.jMo != null) {
            if (z) {
                this.jMo.release();
            }
            this.jMo = null;
        }
    }

    public int createTextureObject() {
        return this.jMo.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.jMo != null) {
            this.jMo.draw(d.IDENTITY_MATRIX, this.jMn.getVertexArray(), 0, this.jMn.getVertexCount(), this.jMn.getCoordsPerVertex(), this.jMn.getVertexStride(), fArr, this.jMn.getTexCoordArray(), i, this.jMn.getTexCoordStride());
        }
    }
}
