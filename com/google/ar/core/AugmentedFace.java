package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes24.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer nMj;
    private FloatBuffer nMk;
    private FloatBuffer nMl;
    private CharBuffer nMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        eaT();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes24.dex */
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

    void eaT() {
        this.nMj = Session.q(nativeGetMeshVerticesByteBuffer(this.nMh.nMi, this.nMi)).asFloatBuffer().asReadOnlyBuffer();
        this.nMk = Session.q(nativeGetMeshNormalsByteBuffer(this.nMh.nMi, this.nMi)).asFloatBuffer().asReadOnlyBuffer();
        this.nMl = Session.q(nativeGetMeshTextureCoordinatesByteBuffer(this.nMh.nMi, this.nMi)).asFloatBuffer().asReadOnlyBuffer();
        this.nMm = Session.q(nativeGetMeshTriangleIndicesByteBuffer(this.nMh.nMi, this.nMi)).asCharBuffer().asReadOnlyBuffer();
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
