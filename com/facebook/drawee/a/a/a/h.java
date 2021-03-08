package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class h {
    private boolean WZ;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String pDl;
    @Nullable
    private Object pDn;
    @Nullable
    private ImageRequest pDo;
    @Nullable
    private com.facebook.imagepipeline.f.f pDp;
    private boolean pDy;
    private long pDq = -1;
    private long pDr = -1;
    private long pDs = -1;
    private long pDt = -1;
    private long pDu = -1;
    private long pDv = -1;
    private long pDw = -1;
    private int pDx = -1;
    private int pDz = -1;
    private int pDA = -1;
    private int pDJ = -1;

    public void reset() {
        this.mRequestId = null;
        this.pDo = null;
        this.pDn = null;
        this.pDp = null;
        this.pDq = -1L;
        this.pDs = -1L;
        this.pDt = -1L;
        this.pDu = -1L;
        this.pDv = -1L;
        this.pDw = -1L;
        this.pDx = -1;
        this.mIsCanceled = false;
        this.WZ = false;
        this.pDy = false;
        this.pDz = -1;
        this.pDA = -1;
        this.pDJ = -1;
    }

    public void Pe(int i) {
        this.pDJ = i;
    }

    public int etX() {
        return this.pDJ;
    }

    public void ZI(@Nullable String str) {
        this.pDl = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pDo = imageRequest;
    }

    public void bn(@Nullable Object obj) {
        this.pDn = obj;
    }

    public void iD(long j) {
        this.pDq = j;
    }

    public void iE(long j) {
        this.pDr = j;
    }

    public void iF(long j) {
        this.pDs = j;
    }

    public void iG(long j) {
        this.pDt = j;
    }

    public void iH(long j) {
        this.pDu = j;
    }

    public void iI(long j) {
        this.pDv = j;
    }

    public void iJ(long j) {
        this.pDw = j;
    }

    public void Pf(int i) {
        this.pDx = i;
    }

    public void Bf(boolean z) {
        this.mIsCanceled = z;
    }

    public void Bg(boolean z) {
        this.WZ = z;
    }

    public void Bh(boolean z) {
        this.pDy = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pDp = fVar;
    }

    public void Pg(int i) {
        this.pDz = i;
    }

    public void Ph(int i) {
        this.pDA = i;
    }

    public e etY() {
        return new e(this.pDl, this.mRequestId, this.pDo, this.pDn, this.pDp, this.pDq, this.pDr, this.pDs, this.pDt, this.pDu, this.pDv, this.pDw, this.pDx, this.mIsCanceled, this.WZ, this.pDy, this.pDz, this.pDA);
    }
}
