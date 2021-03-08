package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes14.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer pSE;
    private FloatBuffer pSF;
    private FloatBuffer pSG;
    private CharBuffer pSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        eAZ();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes14.dex */
    public enum RegionType {
        NOSE_TIP(0),
        FOREHEAD_LEFT(1),
        FOREHEAD_RIGHT(2);
        
        final int nativeCode;

        RegionType(int i) {
            this.nativeCode = i;
        }
    }

    protected AugmentedFace() {
        super(0L, null);
    }

    void eAZ() {
        this.pSE = Session.q(nativeGetMeshVerticesByteBuffer(this.pSC.pSD, this.pSD)).asFloatBuffer().asReadOnlyBuffer();
        this.pSF = Session.q(nativeGetMeshNormalsByteBuffer(this.pSC.pSD, this.pSD)).asFloatBuffer().asReadOnlyBuffer();
        this.pSG = Session.q(nativeGetMeshTextureCoordinatesByteBuffer(this.pSC.pSD, this.pSD)).asFloatBuffer().asReadOnlyBuffer();
        this.pSH = Session.q(nativeGetMeshTriangleIndicesByteBuffer(this.pSC.pSD, this.pSD)).asCharBuffer().asReadOnlyBuffer();
    }

    @Override // com.google.ar.core.TrackableBase
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.ar.core.TrackableBase
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }
}
