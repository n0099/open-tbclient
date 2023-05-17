package com.google.ar.core;

import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class AugmentedFace extends TrackableBase {
    private native Pose nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native Pose nativeGetRegionPose(long j, long j2, int i);

    public AugmentedFace() {
        super(0L, null);
    }

    /* loaded from: classes9.dex */
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

    public void a() {
        Session.a(nativeGetMeshVerticesByteBuffer(this.b.a, this.a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshNormalsByteBuffer(this.b.a, this.a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshTextureCoordinatesByteBuffer(this.b.a, this.a)).asFloatBuffer().asReadOnlyBuffer();
        Session.a(nativeGetMeshTriangleIndicesByteBuffer(this.b.a, this.a)).asCharBuffer().asReadOnlyBuffer();
    }
}
