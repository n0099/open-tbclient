package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hEX = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hEY;

    public c(Texture2dProgram texture2dProgram) {
        this.hEY = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hEY != null) {
            if (z) {
                this.hEY.release();
            }
            this.hEY = null;
        }
    }

    public int createTextureObject() {
        return this.hEY.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hEY != null) {
            this.hEY.draw(d.IDENTITY_MATRIX, this.hEX.getVertexArray(), 0, this.hEX.getVertexCount(), this.hEX.getCoordsPerVertex(), this.hEX.getVertexStride(), fArr, this.hEX.getTexCoordArray(), i, this.hEX.getTexCoordStride());
        }
    }
}
