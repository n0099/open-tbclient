package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d ijJ = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram ijK;

    public c(Texture2dProgram texture2dProgram) {
        this.ijK = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.ijK != null) {
            if (z) {
                this.ijK.release();
            }
            this.ijK = null;
        }
    }

    public int createTextureObject() {
        return this.ijK.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.ijK != null) {
            this.ijK.draw(d.IDENTITY_MATRIX, this.ijJ.getVertexArray(), 0, this.ijJ.getVertexCount(), this.ijJ.getCoordsPerVertex(), this.ijJ.getVertexStride(), fArr, this.ijJ.getTexCoordArray(), i, this.ijJ.getTexCoordStride());
        }
    }
}
