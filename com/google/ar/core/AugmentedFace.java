package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer oSS;
    private FloatBuffer oST;
    private FloatBuffer oSU;
    private CharBuffer oSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        eoE();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes11.dex */
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

    void eoE() {
        this.oSS = Session.r(nativeGetMeshVerticesByteBuffer(this.oSQ.oSR, this.oSR)).asFloatBuffer().asReadOnlyBuffer();
        this.oST = Session.r(nativeGetMeshNormalsByteBuffer(this.oSQ.oSR, this.oSR)).asFloatBuffer().asReadOnlyBuffer();
        this.oSU = Session.r(nativeGetMeshTextureCoordinatesByteBuffer(this.oSQ.oSR, this.oSR)).asFloatBuffer().asReadOnlyBuffer();
        this.oSV = Session.r(nativeGetMeshTriangleIndicesByteBuffer(this.oSQ.oSR, this.oSR)).asCharBuffer().asReadOnlyBuffer();
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
