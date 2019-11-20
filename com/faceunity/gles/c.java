package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d knh = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram kni;

    public c(Texture2dProgram texture2dProgram) {
        this.kni = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.kni != null) {
            if (z) {
                this.kni.release();
            }
            this.kni = null;
        }
    }

    public int createTextureObject() {
        return this.kni.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.kni != null) {
            this.kni.draw(d.IDENTITY_MATRIX, this.knh.getVertexArray(), 0, this.knh.getVertexCount(), this.knh.getCoordsPerVertex(), this.knh.getVertexStride(), fArr, this.knh.getTexCoordArray(), i, this.knh.getTexCoordStride());
        }
    }
}
