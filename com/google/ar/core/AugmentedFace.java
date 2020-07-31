package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes5.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer nib;
    private FloatBuffer nic;
    private FloatBuffer nie;
    private CharBuffer nif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        dKK();
    }

    private native h nativeGetCenterPose(long j, long j2);

    private native ByteBuffer nativeGetMeshNormalsByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTextureCoordinatesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshTriangleIndicesByteBuffer(long j, long j2);

    private native ByteBuffer nativeGetMeshVerticesByteBuffer(long j, long j2);

    private native h nativeGetRegionPose(long j, long j2, int i);

    /* loaded from: classes5.dex */
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

    void dKK() {
        this.nib = Session.q(nativeGetMeshVerticesByteBuffer(this.nhZ.nia, this.nia)).asFloatBuffer().asReadOnlyBuffer();
        this.nic = Session.q(nativeGetMeshNormalsByteBuffer(this.nhZ.nia, this.nia)).asFloatBuffer().asReadOnlyBuffer();
        this.nie = Session.q(nativeGetMeshTextureCoordinatesByteBuffer(this.nhZ.nia, this.nia)).asFloatBuffer().asReadOnlyBuffer();
        this.nif = Session.q(nativeGetMeshTriangleIndicesByteBuffer(this.nhZ.nia, this.nia)).asCharBuffer().asReadOnlyBuffer();
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
