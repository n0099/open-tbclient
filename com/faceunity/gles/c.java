package com.faceunity.gles;

import com.faceunity.gles.Drawable2d;
/* loaded from: classes23.dex */
public class c {
    private final Drawable2d oav = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    private Texture2dProgram oaw;

    public c(Texture2dProgram texture2dProgram) {
        this.oaw = texture2dProgram;
    }

    public void release(boolean z) {
        if (this.oaw != null) {
            if (z) {
                this.oaw.release();
            }
            this.oaw = null;
        }
    }

    public int createTextureObject() {
        return this.oaw.createTextureObject();
    }

    public void drawFrame(int i, float[] fArr) {
        if (this.oaw != null) {
            this.oaw.draw(d.IDENTITY_MATRIX, this.oav.getVertexArray(), 0, this.oav.getVertexCount(), this.oav.getCoordsPerVertex(), this.oav.getVertexStride(), fArr, this.oav.getTexCoordArray(), i, this.oav.getTexCoordStride());
        }
    }
}
