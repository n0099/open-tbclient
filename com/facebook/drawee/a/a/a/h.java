package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean TC;
    private boolean mIsCanceled;
    @Nullable
    private Object mKB;
    @Nullable
    private ImageRequest mKC;
    @Nullable
    private com.facebook.imagepipeline.g.f mKD;
    private boolean mKM;
    @Nullable
    private String mKz;
    @Nullable
    private String mRequestId;
    private long mKE = -1;
    private long mKF = -1;
    private long mKG = -1;
    private long mKH = -1;
    private long mKI = -1;
    private long mKJ = -1;
    private long mKK = -1;
    private int mKL = -1;
    private int mKN = -1;
    private int mKO = -1;
    private int mKX = -1;

    public void reset() {
        this.mRequestId = null;
        this.mKC = null;
        this.mKB = null;
        this.mKD = null;
        this.mKE = -1L;
        this.mKG = -1L;
        this.mKH = -1L;
        this.mKI = -1L;
        this.mKJ = -1L;
        this.mKK = -1L;
        this.mKL = -1;
        this.mIsCanceled = false;
        this.TC = false;
        this.mKM = false;
        this.mKN = -1;
        this.mKO = -1;
        this.mKX = -1;
    }

    public void Ia(int i) {
        this.mKX = i;
    }

    public int dAo() {
        return this.mKX;
    }

    public void QJ(@Nullable String str) {
        this.mKz = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.mKC = imageRequest;
    }

    public void aZ(@Nullable Object obj) {
        this.mKB = obj;
    }

    public void fK(long j) {
        this.mKE = j;
    }

    public void fL(long j) {
        this.mKF = j;
    }

    public void fM(long j) {
        this.mKG = j;
    }

    public void fN(long j) {
        this.mKH = j;
    }

    public void fO(long j) {
        this.mKI = j;
    }

    public void fP(long j) {
        this.mKJ = j;
    }

    public void fQ(long j) {
        this.mKK = j;
    }

    public void Ib(int i) {
        this.mKL = i;
    }

    public void ws(boolean z) {
        this.mIsCanceled = z;
    }

    public void wt(boolean z) {
        this.TC = z;
    }

    public void wu(boolean z) {
        this.mKM = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.mKD = fVar;
    }

    public void Ic(int i) {
        this.mKN = i;
    }

    public void Id(int i) {
        this.mKO = i;
    }

    public e dAp() {
        return new e(this.mKz, this.mRequestId, this.mKC, this.mKB, this.mKD, this.mKE, this.mKF, this.mKG, this.mKH, this.mKI, this.mKJ, this.mKK, this.mKL, this.mIsCanceled, this.TC, this.mKM, this.mKN, this.mKO);
    }
}
