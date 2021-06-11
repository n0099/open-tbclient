package com.kwai.player.vr;
/* loaded from: classes7.dex */
public class KwaiPlayerStereoMesh {
    public static final String TAG = "KwaiPlayerStereoMesh";
    public KwaiBaseMesh mKwaiBaseMesh;

    public KwaiPlayerStereoMesh(int i2) {
        genKwaiMesh(i2);
    }

    public void genKwaiMesh(int i2) {
        if (i2 == 1) {
            this.mKwaiBaseMesh = new KwaiSphereMesh();
        }
        KwaiBaseMesh kwaiBaseMesh = this.mKwaiBaseMesh;
        if (kwaiBaseMesh != null) {
            kwaiBaseMesh.genKwaiMesh();
        }
    }

    public KwaiMesh getKwaiMesh() {
        KwaiBaseMesh kwaiBaseMesh = this.mKwaiBaseMesh;
        if (kwaiBaseMesh != null) {
            return kwaiBaseMesh.getKwaiMesh();
        }
        return null;
    }
}
