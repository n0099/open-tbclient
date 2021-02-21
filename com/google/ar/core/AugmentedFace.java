package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes15.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer pRP;
    private FloatBuffer pRQ;
    private FloatBuffer pRR;
    private CharBuffer pRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        eAT();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes15.dex */
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

    void eAT() {
        this.pRP = Session.q(nativeGetMeshVerticesByteBuffer(this.pRN.pRO, this.pRO)).asFloatBuffer().asReadOnlyBuffer();
        this.pRQ = Session.q(nativeGetMeshNormalsByteBuffer(this.pRN.pRO, this.pRO)).asFloatBuffer().asReadOnlyBuffer();
        this.pRR = Session.q(nativeGetMeshTextureCoordinatesByteBuffer(this.pRN.pRO, this.pRO)).asFloatBuffer().asReadOnlyBuffer();
        this.pRS = Session.q(nativeGetMeshTriangleIndicesByteBuffer(this.pRN.pRO, this.pRO)).asCharBuffer().asReadOnlyBuffer();
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
