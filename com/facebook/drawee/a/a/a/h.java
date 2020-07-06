package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean TC;
    private boolean mIsCanceled;
    @Nullable
    private String mKC;
    @Nullable
    private Object mKE;
    @Nullable
    private ImageRequest mKF;
    @Nullable
    private com.facebook.imagepipeline.g.f mKG;
    private boolean mKP;
    @Nullable
    private String mRequestId;
    private long mKH = -1;
    private long mKI = -1;
    private long mKJ = -1;
    private long mKK = -1;
    private long mKL = -1;
    private long mKM = -1;
    private long mKN = -1;
    private int mKO = -1;
    private int mKQ = -1;
    private int mKR = -1;
    private int mLa = -1;

    public void reset() {
        this.mRequestId = null;
        this.mKF = null;
        this.mKE = null;
        this.mKG = null;
        this.mKH = -1L;
        this.mKJ = -1L;
        this.mKK = -1L;
        this.mKL = -1L;
        this.mKM = -1L;
        this.mKN = -1L;
        this.mKO = -1;
        this.mIsCanceled = false;
        this.TC = false;
        this.mKP = false;
        this.mKQ = -1;
        this.mKR = -1;
        this.mLa = -1;
    }

    public void Ia(int i) {
        this.mLa = i;
    }

    public int dAs() {
        return this.mLa;
    }

    public void QK(@Nullable String str) {
        this.mKC = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.mKF = imageRequest;
    }

    public void aZ(@Nullable Object obj) {
        this.mKE = obj;
    }

    public void fK(long j) {
        this.mKH = j;
    }

    public void fL(long j) {
        this.mKI = j;
    }

    public void fM(long j) {
        this.mKJ = j;
    }

    public void fN(long j) {
        this.mKK = j;
    }

    public void fO(long j) {
        this.mKL = j;
    }

    public void fP(long j) {
        this.mKM = j;
    }

    public void fQ(long j) {
        this.mKN = j;
    }

    public void Ib(int i) {
        this.mKO = i;
    }

    public void ws(boolean z) {
        this.mIsCanceled = z;
    }

    public void wt(boolean z) {
        this.TC = z;
    }

    public void wu(boolean z) {
        this.mKP = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.mKG = fVar;
    }

    public void Ic(int i) {
        this.mKQ = i;
    }

    public void Id(int i) {
        this.mKR = i;
    }

    public e dAt() {
        return new e(this.mKC, this.mRequestId, this.mKF, this.mKE, this.mKG, this.mKH, this.mKI, this.mKJ, this.mKK, this.mKL, this.mKM, this.mKN, this.mKO, this.mIsCanceled, this.TC, this.mKP, this.mKQ, this.mKR);
    }
}
