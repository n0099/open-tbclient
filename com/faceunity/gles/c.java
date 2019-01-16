package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes5.dex */
public class c {
    private final Drawable2d iwX = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram iwY;

    public c(Texture2dProgram texture2dProgram) {
        this.iwY = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.iwY != null) {
            if (z) {
                this.iwY.release();
            }
            this.iwY = null;
        }
    }

    public int createTextureObject() {
        return this.iwY.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.iwY != null) {
            this.iwY.draw(d.IDENTITY_MATRIX, this.iwX.getVertexArray(), 0, this.iwX.getVertexCount(), this.iwX.getCoordsPerVertex(), this.iwX.getVertexStride(), fArr, this.iwX.getTexCoordArray(), i, this.iwX.getTexCoordStride());
        }
    }
}
