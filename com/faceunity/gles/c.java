package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d keZ = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram kfa;

    public c(Texture2dProgram texture2dProgram) {
        this.kfa = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.kfa != null) {
            if (z) {
                this.kfa.release();
            }
            this.kfa = null;
        }
    }

    public int createTextureObject() {
        return this.kfa.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.kfa != null) {
            this.kfa.draw(d.IDENTITY_MATRIX, this.keZ.getVertexArray(), 0, this.keZ.getVertexCount(), this.keZ.getCoordsPerVertex(), this.keZ.getVertexStride(), fArr, this.keZ.getTexCoordArray(), i, this.keZ.getTexCoordStride());
        }
    }
}
