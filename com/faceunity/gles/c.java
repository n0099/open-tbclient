package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes10.dex */
public class c {
    private final Drawable2d lXS = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram lXT;

    public c(Texture2dProgram texture2dProgram) {
        this.lXT = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.lXT != null) {
            if (z) {
                this.lXT.release();
            }
            this.lXT = null;
        }
    }

    public int createTextureObject() {
        return this.lXT.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.lXT != null) {
            this.lXT.draw(d.IDENTITY_MATRIX, this.lXS.getVertexArray(), 0, this.lXS.getVertexCount(), this.lXS.getCoordsPerVertex(), this.lXS.getVertexStride(), fArr, this.lXS.getTexCoordArray(), i, this.lXS.getTexCoordStride());
        }
    }
}
