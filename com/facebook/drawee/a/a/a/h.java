package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class h {
    private boolean VG;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String pdL;
    @Nullable
    private Object pdN;
    @Nullable
    private ImageRequest pdO;
    @Nullable
    private com.facebook.imagepipeline.f.f pdP;
    private boolean pdY;
    private long pdQ = -1;
    private long pdR = -1;
    private long pdS = -1;
    private long pdT = -1;
    private long pdU = -1;
    private long pdV = -1;
    private long pdW = -1;
    private int pdX = -1;
    private int pdZ = -1;
    private int pea = -1;
    private int pej = -1;

    public void reset() {
        this.mRequestId = null;
        this.pdO = null;
        this.pdN = null;
        this.pdP = null;
        this.pdQ = -1L;
        this.pdS = -1L;
        this.pdT = -1L;
        this.pdU = -1L;
        this.pdV = -1L;
        this.pdW = -1L;
        this.pdX = -1;
        this.mIsCanceled = false;
        this.VG = false;
        this.pdY = false;
        this.pdZ = -1;
        this.pea = -1;
        this.pej = -1;
    }

    public void PX(int i) {
        this.pej = i;
    }

    public int eqY() {
        return this.pej;
    }

    public void Zm(@Nullable String str) {
        this.pdL = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pdO = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pdN = obj;
    }

    public void im(long j) {
        this.pdQ = j;
    }

    public void in(long j) {
        this.pdR = j;
    }

    public void io(long j) {
        this.pdS = j;
    }

    public void ip(long j) {
        this.pdT = j;
    }

    public void iq(long j) {
        this.pdU = j;
    }

    public void ir(long j) {
        this.pdV = j;
    }

    public void is(long j) {
        this.pdW = j;
    }

    public void PY(int i) {
        this.pdX = i;
    }

    public void AK(boolean z) {
        this.mIsCanceled = z;
    }

    public void AL(boolean z) {
        this.VG = z;
    }

    public void AM(boolean z) {
        this.pdY = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pdP = fVar;
    }

    public void PZ(int i) {
        this.pdZ = i;
    }

    public void Qa(int i) {
        this.pea = i;
    }

    public e eqZ() {
        return new e(this.pdL, this.mRequestId, this.pdO, this.pdN, this.pdP, this.pdQ, this.pdR, this.pdS, this.pdT, this.pdU, this.pdV, this.pdW, this.pdX, this.mIsCanceled, this.VG, this.pdY, this.pdZ, this.pea);
    }
}
