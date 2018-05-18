package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes2.dex */
public class c {
    private final Drawable2d hvY = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram hvZ;

    public c(Texture2dProgram texture2dProgram) {
        this.hvZ = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.hvZ != null) {
            if (z) {
                this.hvZ.release();
            }
            this.hvZ = null;
        }
    }

    public int createTextureObject() {
        return this.hvZ.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.hvZ != null) {
            this.hvZ.draw(d.IDENTITY_MATRIX, this.hvY.getVertexArray(), 0, this.hvY.getVertexCount(), this.hvY.getCoordsPerVertex(), this.hvY.getVertexStride(), fArr, this.hvY.getTexCoordArray(), i, this.hvY.getTexCoordStride());
        }
    }
}
