package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d ijK = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram ijL;

    public c(Texture2dProgram texture2dProgram) {
        this.ijL = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.ijL != null) {
            if (z) {
                this.ijL.release();
            }
            this.ijL = null;
        }
    }

    public int createTextureObject() {
        return this.ijL.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.ijL != null) {
            this.ijL.draw(d.IDENTITY_MATRIX, this.ijK.getVertexArray(), 0, this.ijK.getVertexCount(), this.ijK.getCoordsPerVertex(), this.ijK.getVertexStride(), fArr, this.ijK.getTexCoordArray(), i, this.ijK.getTexCoordStride());
        }
    }
}
