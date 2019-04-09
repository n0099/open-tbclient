package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d jMo = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram jMp;

    public c(Texture2dProgram texture2dProgram) {
        this.jMp = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.jMp != null) {
            if (z) {
                this.jMp.release();
            }
            this.jMp = null;
        }
    }

    public int createTextureObject() {
        return this.jMp.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.jMp != null) {
            this.jMp.draw(d.IDENTITY_MATRIX, this.jMo.getVertexArray(), 0, this.jMo.getVertexCount(), this.jMo.getCoordsPerVertex(), this.jMo.getVertexStride(), fArr, this.jMo.getTexCoordArray(), i, this.jMo.getTexCoordStride());
        }
    }
}
