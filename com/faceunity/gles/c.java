package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d kfd = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram kfe;

    public c(Texture2dProgram texture2dProgram) {
        this.kfe = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.kfe != null) {
            if (z) {
                this.kfe.release();
            }
            this.kfe = null;
        }
    }

    public int createTextureObject() {
        return this.kfe.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.kfe != null) {
            this.kfe.draw(d.IDENTITY_MATRIX, this.kfd.getVertexArray(), 0, this.kfd.getVertexCount(), this.kfd.getCoordsPerVertex(), this.kfd.getVertexStride(), fArr, this.kfd.getTexCoordArray(), i, this.kfd.getTexCoordStride());
        }
    }
}
