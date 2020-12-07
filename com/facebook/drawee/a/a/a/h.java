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
    private String pdJ;
    @Nullable
    private Object pdL;
    @Nullable
    private ImageRequest pdM;
    @Nullable
    private com.facebook.imagepipeline.f.f pdN;
    private boolean pdW;
    private long pdO = -1;
    private long pdP = -1;
    private long pdQ = -1;
    private long pdR = -1;
    private long pdS = -1;
    private long pdT = -1;
    private long pdU = -1;
    private int pdV = -1;
    private int pdX = -1;
    private int pdY = -1;
    private int peh = -1;

    public void reset() {
        this.mRequestId = null;
        this.pdM = null;
        this.pdL = null;
        this.pdN = null;
        this.pdO = -1L;
        this.pdQ = -1L;
        this.pdR = -1L;
        this.pdS = -1L;
        this.pdT = -1L;
        this.pdU = -1L;
        this.pdV = -1;
        this.mIsCanceled = false;
        this.VG = false;
        this.pdW = false;
        this.pdX = -1;
        this.pdY = -1;
        this.peh = -1;
    }

    public void PX(int i) {
        this.peh = i;
    }

    public int eqX() {
        return this.peh;
    }

    public void Zm(@Nullable String str) {
        this.pdJ = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pdM = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pdL = obj;
    }

    public void im(long j) {
        this.pdO = j;
    }

    public void in(long j) {
        this.pdP = j;
    }

    public void io(long j) {
        this.pdQ = j;
    }

    public void ip(long j) {
        this.pdR = j;
    }

    public void iq(long j) {
        this.pdS = j;
    }

    public void ir(long j) {
        this.pdT = j;
    }

    public void is(long j) {
        this.pdU = j;
    }

    public void PY(int i) {
        this.pdV = i;
    }

    public void AK(boolean z) {
        this.mIsCanceled = z;
    }

    public void AL(boolean z) {
        this.VG = z;
    }

    public void AM(boolean z) {
        this.pdW = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pdN = fVar;
    }

    public void PZ(int i) {
        this.pdX = i;
    }

    public void Qa(int i) {
        this.pdY = i;
    }

    public e eqY() {
        return new e(this.pdJ, this.mRequestId, this.pdM, this.pdL, this.pdN, this.pdO, this.pdP, this.pdQ, this.pdR, this.pdS, this.pdT, this.pdU, this.pdV, this.mIsCanceled, this.VG, this.pdW, this.pdX, this.pdY);
    }
}
