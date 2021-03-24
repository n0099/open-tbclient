package com.kwai.player.vr;
/* loaded from: classes6.dex */
public class KwaiPlayerStereoMesh {
    public static final String TAG = "KwaiPlayerStereoMesh";
    public KwaiBaseMesh mKwaiBaseMesh;

    public KwaiPlayerStereoMesh(int i) {
        genKwaiMesh(i);
    }

    public void genKwaiMesh(int i) {
        if (i == 1) {
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
