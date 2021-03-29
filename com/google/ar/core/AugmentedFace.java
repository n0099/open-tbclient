package com.google.ar.core;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AugmentedFace extends TrackableBase {

    /* loaded from: classes6.dex */
    public enum RegionType {
        NOSE_TIP(0),
        FOREHEAD_LEFT(1),
        FOREHEAD_RIGHT(2);
        
        public final int nativeCode;

        RegionType(int i) {
            this.nativeCode = i;
        }
    }

    public AugmentedFace(long j, Session session) {
        super(j, session);
        a();
    }

    private native d.g.b.a.a nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native d.g.b.a.a nativeGetRegionPose(long j, long j2, int i);

    public void a() {
        Session.a(nativeGetMeshVerticesByteBuffer(this.f30898b.f30876a, this.f30897a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshNormalsByteBuffer(this.f30898b.f30876a, this.f30897a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshTextureCoordinatesByteBuffer(this.f30898b.f30876a, this.f30897a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshTriangleIndicesByteBuffer(this.f30898b.f30876a, this.f30897a)).asCharBuffer().asReadOnlyBuffer();
    }

    public AugmentedFace() {
        super(0L, null);
    }
}
