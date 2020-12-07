package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes17.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer psY;
    private FloatBuffer psZ;
    private FloatBuffer pta;
    private CharBuffer ptb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        exV();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes17.dex */
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

    void exV() {
        this.psY = Session.r(nativeGetMeshVerticesByteBuffer(this.psW.psX, this.psX)).asFloatBuffer().asReadOnlyBuffer();
        this.psZ = Session.r(nativeGetMeshNormalsByteBuffer(this.psW.psX, this.psX)).asFloatBuffer().asReadOnlyBuffer();
        this.pta = Session.r(nativeGetMeshTextureCoordinatesByteBuffer(this.psW.psX, this.psX)).asFloatBuffer().asReadOnlyBuffer();
        this.ptb = Session.r(nativeGetMeshTriangleIndicesByteBuffer(this.psW.psX, this.psX)).asCharBuffer().asReadOnlyBuffer();
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
