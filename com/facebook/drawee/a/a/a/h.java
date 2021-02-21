package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class h {
    private boolean VE;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String pBg;
    @Nullable
    private Object pBi;
    @Nullable
    private ImageRequest pBj;
    @Nullable
    private com.facebook.imagepipeline.f.f pBk;
    private boolean pBt;
    private long pBl = -1;
    private long pBm = -1;
    private long pBn = -1;
    private long pBo = -1;
    private long pBp = -1;
    private long pBq = -1;
    private long pBr = -1;
    private int pBs = -1;
    private int pBu = -1;
    private int pBv = -1;
    private int pBE = -1;

    public void reset() {
        this.mRequestId = null;
        this.pBj = null;
        this.pBi = null;
        this.pBk = null;
        this.pBl = -1L;
        this.pBn = -1L;
        this.pBo = -1L;
        this.pBp = -1L;
        this.pBq = -1L;
        this.pBr = -1L;
        this.pBs = -1;
        this.mIsCanceled = false;
        this.VE = false;
        this.pBt = false;
        this.pBu = -1;
        this.pBv = -1;
        this.pBE = -1;
    }

    public void Pa(int i) {
        this.pBE = i;
    }

    public int etO() {
        return this.pBE;
    }

    public void ZC(@Nullable String str) {
        this.pBg = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pBj = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pBi = obj;
    }

    public void iD(long j) {
        this.pBl = j;
    }

    public void iE(long j) {
        this.pBm = j;
    }

    public void iF(long j) {
        this.pBn = j;
    }

    public void iG(long j) {
        this.pBo = j;
    }

    public void iH(long j) {
        this.pBp = j;
    }

    public void iI(long j) {
        this.pBq = j;
    }

    public void iJ(long j) {
        this.pBr = j;
    }

    public void Pb(int i) {
        this.pBs = i;
    }

    public void Bh(boolean z) {
        this.mIsCanceled = z;
    }

    public void Bi(boolean z) {
        this.VE = z;
    }

    public void Bj(boolean z) {
        this.pBt = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pBk = fVar;
    }

    public void Pc(int i) {
        this.pBu = i;
    }

    public void Pd(int i) {
        this.pBv = i;
    }

    public e etP() {
        return new e(this.pBg, this.mRequestId, this.pBj, this.pBi, this.pBk, this.pBl, this.pBm, this.pBn, this.pBo, this.pBp, this.pBq, this.pBr, this.pBs, this.mIsCanceled, this.VE, this.pBt, this.pBu, this.pBv);
    }
}
