package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class h {
    @Nullable
    private Object lJB;
    @Nullable
    private ImageRequest lJC;
    @Nullable
    private com.facebook.imagepipeline.g.f lJD;
    private boolean lJM;
    @Nullable
    private String lJz;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean zi;
    private long lJE = -1;
    private long lJF = -1;
    private long lJG = -1;
    private long lJH = -1;
    private long lJI = -1;
    private long lJJ = -1;
    private long lJK = -1;
    private int lJL = -1;
    private int lJN = -1;
    private int lJO = -1;
    private int lJX = -1;

    public void reset() {
        this.mRequestId = null;
        this.lJC = null;
        this.lJB = null;
        this.lJD = null;
        this.lJE = -1L;
        this.lJG = -1L;
        this.lJH = -1L;
        this.lJI = -1L;
        this.lJJ = -1L;
        this.lJK = -1L;
        this.lJL = -1;
        this.mIsCanceled = false;
        this.zi = false;
        this.lJM = false;
        this.lJN = -1;
        this.lJO = -1;
        this.lJX = -1;
    }

    public void Ht(int i) {
        this.lJX = i;
    }

    public int dkB() {
        return this.lJX;
    }

    public void OK(@Nullable String str) {
        this.lJz = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lJC = imageRequest;
    }

    public void bb(@Nullable Object obj) {
        this.lJB = obj;
    }

    public void fa(long j) {
        this.lJE = j;
    }

    public void fb(long j) {
        this.lJF = j;
    }

    public void fc(long j) {
        this.lJG = j;
    }

    public void fd(long j) {
        this.lJH = j;
    }

    public void fe(long j) {
        this.lJI = j;
    }

    public void ff(long j) {
        this.lJJ = j;
    }

    public void fg(long j) {
        this.lJK = j;
    }

    public void Hu(int i) {
        this.lJL = i;
    }

    public void uX(boolean z) {
        this.mIsCanceled = z;
    }

    public void uY(boolean z) {
        this.zi = z;
    }

    public void uZ(boolean z) {
        this.lJM = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lJD = fVar;
    }

    public void Hv(int i) {
        this.lJN = i;
    }

    public void Hw(int i) {
        this.lJO = i;
    }

    public e dkC() {
        return new e(this.lJz, this.mRequestId, this.lJC, this.lJB, this.lJD, this.lJE, this.lJF, this.lJG, this.lJH, this.lJI, this.lJJ, this.lJK, this.lJL, this.mIsCanceled, this.zi, this.lJM, this.lJN, this.lJO);
    }
}
