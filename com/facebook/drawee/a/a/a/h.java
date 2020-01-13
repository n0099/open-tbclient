package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class h {
    private boolean lJH;
    @Nullable
    private String lJu;
    @Nullable
    private Object lJw;
    @Nullable
    private ImageRequest lJx;
    @Nullable
    private com.facebook.imagepipeline.g.f lJy;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean zi;
    private long lJz = -1;
    private long lJA = -1;
    private long lJB = -1;
    private long lJC = -1;
    private long lJD = -1;
    private long lJE = -1;
    private long lJF = -1;
    private int lJG = -1;
    private int lJI = -1;
    private int lJJ = -1;
    private int lJS = -1;

    public void reset() {
        this.mRequestId = null;
        this.lJx = null;
        this.lJw = null;
        this.lJy = null;
        this.lJz = -1L;
        this.lJB = -1L;
        this.lJC = -1L;
        this.lJD = -1L;
        this.lJE = -1L;
        this.lJF = -1L;
        this.lJG = -1;
        this.mIsCanceled = false;
        this.zi = false;
        this.lJH = false;
        this.lJI = -1;
        this.lJJ = -1;
        this.lJS = -1;
    }

    public void Ht(int i) {
        this.lJS = i;
    }

    public int dkz() {
        return this.lJS;
    }

    public void OK(@Nullable String str) {
        this.lJu = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lJx = imageRequest;
    }

    public void bb(@Nullable Object obj) {
        this.lJw = obj;
    }

    public void fa(long j) {
        this.lJz = j;
    }

    public void fb(long j) {
        this.lJA = j;
    }

    public void fc(long j) {
        this.lJB = j;
    }

    public void fd(long j) {
        this.lJC = j;
    }

    public void fe(long j) {
        this.lJD = j;
    }

    public void ff(long j) {
        this.lJE = j;
    }

    public void fg(long j) {
        this.lJF = j;
    }

    public void Hu(int i) {
        this.lJG = i;
    }

    public void uX(boolean z) {
        this.mIsCanceled = z;
    }

    public void uY(boolean z) {
        this.zi = z;
    }

    public void uZ(boolean z) {
        this.lJH = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lJy = fVar;
    }

    public void Hv(int i) {
        this.lJI = i;
    }

    public void Hw(int i) {
        this.lJJ = i;
    }

    public e dkA() {
        return new e(this.lJu, this.mRequestId, this.lJx, this.lJw, this.lJy, this.lJz, this.lJA, this.lJB, this.lJC, this.lJD, this.lJE, this.lJF, this.lJG, this.mIsCanceled, this.zi, this.lJH, this.lJI, this.lJJ);
    }
}
