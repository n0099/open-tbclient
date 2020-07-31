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
    private String mSH;
    @Nullable
    private Object mSJ;
    @Nullable
    private ImageRequest mSK;
    @Nullable
    private com.facebook.imagepipeline.g.f mSL;
    private boolean mSV;
    private long mSM = -1;
    private long mSN = -1;
    private long mSO = -1;
    private long mSQ = -1;
    private long mSR = -1;
    private long mSS = -1;
    private long mST = -1;
    private int mSU = -1;
    private int mSW = -1;
    private int mSX = -1;
    private int mTg = -1;

    public void reset() {
        this.mRequestId = null;
        this.mSK = null;
        this.mSJ = null;
        this.mSL = null;
        this.mSM = -1L;
        this.mSO = -1L;
        this.mSQ = -1L;
        this.mSR = -1L;
        this.mSS = -1L;
        this.mST = -1L;
        this.mSU = -1;
        this.mIsCanceled = false;
        this.Tx = false;
        this.mSV = false;
        this.mSW = -1;
        this.mSX = -1;
        this.mTg = -1;
    }

    public void Iv(int i) {
        this.mTg = i;
    }

    public int dDE() {
        return this.mTg;
    }

    public void Rv(@Nullable String str) {
        this.mSH = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.mSK = imageRequest;
    }

    public void aZ(@Nullable Object obj) {
        this.mSJ = obj;
    }

    public void fX(long j) {
        this.mSM = j;
    }

    public void fY(long j) {
        this.mSN = j;
    }

    public void fZ(long j) {
        this.mSO = j;
    }

    public void ga(long j) {
        this.mSQ = j;
    }

    public void gb(long j) {
        this.mSR = j;
    }

    public void gc(long j) {
        this.mSS = j;
    }

    public void gd(long j) {
        this.mST = j;
    }

    public void Iw(int i) {
        this.mSU = i;
    }

    public void wX(boolean z) {
        this.mIsCanceled = z;
    }

    public void wY(boolean z) {
        this.Tx = z;
    }

    public void wZ(boolean z) {
        this.mSV = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.mSL = fVar;
    }

    public void Ix(int i) {
        this.mSW = i;
    }

    public void Iy(int i) {
        this.mSX = i;
    }

    public e dDF() {
        return new e(this.mSH, this.mRequestId, this.mSK, this.mSJ, this.mSL, this.mSM, this.mSN, this.mSO, this.mSQ, this.mSR, this.mSS, this.mST, this.mSU, this.mIsCanceled, this.Tx, this.mSV, this.mSW, this.mSX);
    }
}
