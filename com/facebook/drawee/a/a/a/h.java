package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class h {
    private boolean Tx;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String mSJ;
    @Nullable
    private Object mSL;
    @Nullable
    private ImageRequest mSM;
    @Nullable
    private com.facebook.imagepipeline.g.f mSN;
    private boolean mSX;
    private long mSO = -1;
    private long mSQ = -1;
    private long mSR = -1;
    private long mSS = -1;
    private long mST = -1;
    private long mSU = -1;
    private long mSV = -1;
    private int mSW = -1;
    private int mSY = -1;
    private int mSZ = -1;
    private int mTi = -1;

    public void reset() {
        this.mRequestId = null;
        this.mSM = null;
        this.mSL = null;
        this.mSN = null;
        this.mSO = -1L;
        this.mSR = -1L;
        this.mSS = -1L;
        this.mST = -1L;
        this.mSU = -1L;
        this.mSV = -1L;
        this.mSW = -1;
        this.mIsCanceled = false;
        this.Tx = false;
        this.mSX = false;
        this.mSY = -1;
        this.mSZ = -1;
        this.mTi = -1;
    }

    public void Iv(int i) {
        this.mTi = i;
    }

    public int dDF() {
        return this.mTi;
    }

    public void Rv(@Nullable String str) {
        this.mSJ = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.mSM = imageRequest;
    }

    public void aZ(@Nullable Object obj) {
        this.mSL = obj;
    }

    public void fX(long j) {
        this.mSO = j;
    }

    public void fY(long j) {
        this.mSQ = j;
    }

    public void fZ(long j) {
        this.mSR = j;
    }

    public void ga(long j) {
        this.mSS = j;
    }

    public void gb(long j) {
        this.mST = j;
    }

    public void gc(long j) {
        this.mSU = j;
    }

    public void gd(long j) {
        this.mSV = j;
    }

    public void Iw(int i) {
        this.mSW = i;
    }

    public void wX(boolean z) {
        this.mIsCanceled = z;
    }

    public void wY(boolean z) {
        this.Tx = z;
    }

    public void wZ(boolean z) {
        this.mSX = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.mSN = fVar;
    }

    public void Ix(int i) {
        this.mSY = i;
    }

    public void Iy(int i) {
        this.mSZ = i;
    }

    public e dDG() {
        return new e(this.mSJ, this.mRequestId, this.mSM, this.mSL, this.mSN, this.mSO, this.mSQ, this.mSR, this.mSS, this.mST, this.mSU, this.mSV, this.mSW, this.mIsCanceled, this.Tx, this.mSX, this.mSY, this.mSZ);
    }
}
