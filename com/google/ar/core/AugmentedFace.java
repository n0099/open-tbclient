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

        RegionType(int i2) {
            this.nativeCode = i2;
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

    private native d.g.b.a.a nativeGetRegionPose(long j, long j2, int i2);

    public void a() {
        Session.a(nativeGetMeshVerticesByteBuffer(this.f30777b.f30753a, this.f30776a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshNormalsByteBuffer(this.f30777b.f30753a, this.f30776a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshTextureCoordinatesByteBuffer(this.f30777b.f30753a, this.f30776a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshTriangleIndicesByteBuffer(this.f30777b.f30753a, this.f30776a)).asCharBuffer().asReadOnlyBuffer();
    }

    public AugmentedFace() {
        super(0L, null);
    }
}
