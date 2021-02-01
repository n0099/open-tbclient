package com.kwai.player.vr;
/* loaded from: classes3.dex */
public class KwaiPlayerStereoMesh {
    private static final String TAG = "KwaiPlayerStereoMesh";
    private KwaiBaseMesh mKwaiBaseMesh;

    public KwaiPlayerStereoMesh(int i) {
        genKwaiMesh(i);
    }

    public void genKwaiMesh(int i) {
        switch (i) {
            case 1:
                this.mKwaiBaseMesh = new KwaiSphereMesh();
                break;
        }
        if (this.mKwaiBaseMesh != null) {
            this.mKwaiBaseMesh.genKwaiMesh();
        }
    }

    public KwaiMesh getKwaiMesh() {
        if (this.mKwaiBaseMesh != null) {
            return this.mKwaiBaseMesh.getKwaiMesh();
        }
        return null;
    }
}
