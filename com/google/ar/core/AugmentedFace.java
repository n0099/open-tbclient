package com.google.ar.core;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes5.dex */
public class AugmentedFace extends TrackableBase {
    private FloatBuffer nie;
    private FloatBuffer nif;
    private FloatBuffer nig;
    private CharBuffer nih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AugmentedFace(long j, Session session) {
        super(j, session);
        dKL();
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

    void dKL() {
        this.nie = Session.q(nativeGetMeshVerticesByteBuffer(this.nib.nic, this.nic)).asFloatBuffer().asReadOnlyBuffer();
        this.nif = Session.q(nativeGetMeshNormalsByteBuffer(this.nib.nic, this.nic)).asFloatBuffer().asReadOnlyBuffer();
        this.nig = Session.q(nativeGetMeshTextureCoordinatesByteBuffer(this.nib.nic, this.nic)).asFloatBuffer().asReadOnlyBuffer();
        this.nih = Session.q(nativeGetMeshTriangleIndicesByteBuffer(this.nib.nic, this.nic)).asCharBuffer().asReadOnlyBuffer();
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
