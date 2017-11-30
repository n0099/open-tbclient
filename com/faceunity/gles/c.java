package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d huA = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram huB;

    public c(Texture2dProgram texture2dProgram) {
        this.huB = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.huB != null) {
            if (z) {
                this.huB.release();
            }
            this.huB = null;
        }
    }

    public int createTextureObject() {
        return this.huB.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.huB != null) {
            this.huB.draw(d.IDENTITY_MATRIX, this.huA.getVertexArray(), 0, this.huA.getVertexCount(), this.huA.getCoordsPerVertex(), this.huA.getVertexStride(), fArr, this.huA.getTexCoordArray(), i, this.huA.getTexCoordStride());
        }
    }
}
