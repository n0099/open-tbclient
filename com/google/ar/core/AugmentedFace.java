package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer pKc;
    private FloatBuffer pKd;
    private FloatBuffer pKe;
    private CharBuffer pKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        eBH();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes3.dex */
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

    void eBH() {
        this.pKc = Session.q(nativeGetMeshVerticesByteBuffer(this.pKa.pKb, this.pKb)).asFloatBuffer().asReadOnlyBuffer();
        this.pKd = Session.q(nativeGetMeshNormalsByteBuffer(this.pKa.pKb, this.pKb)).asFloatBuffer().asReadOnlyBuffer();
        this.pKe = Session.q(nativeGetMeshTextureCoordinatesByteBuffer(this.pKa.pKb, this.pKb)).asFloatBuffer().asReadOnlyBuffer();
        this.pKf = Session.q(nativeGetMeshTriangleIndicesByteBuffer(this.pKa.pKb, this.pKb)).asCharBuffer().asReadOnlyBuffer();
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
