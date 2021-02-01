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
    private String pAG;
    @Nullable
    private Object pAI;
    @Nullable
    private ImageRequest pAJ;
    @Nullable
    private com.facebook.imagepipeline.f.f pAK;
    private boolean pAT;
    private long pAL = -1;
    private long pAM = -1;
    private long pAN = -1;
    private long pAO = -1;
    private long pAP = -1;
    private long pAQ = -1;
    private long pAR = -1;
    private int pAS = -1;
    private int pAU = -1;
    private int pAV = -1;
    private int pBe = -1;

    public void reset() {
        this.mRequestId = null;
        this.pAJ = null;
        this.pAI = null;
        this.pAK = null;
        this.pAL = -1L;
        this.pAN = -1L;
        this.pAO = -1L;
        this.pAP = -1L;
        this.pAQ = -1L;
        this.pAR = -1L;
        this.pAS = -1;
        this.mIsCanceled = false;
        this.VE = false;
        this.pAT = false;
        this.pAU = -1;
        this.pAV = -1;
        this.pBe = -1;
    }

    public void OZ(int i) {
        this.pBe = i;
    }

    public int etG() {
        return this.pBe;
    }

    public void Zq(@Nullable String str) {
        this.pAG = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pAJ = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pAI = obj;
    }

    public void iD(long j) {
        this.pAL = j;
    }

    public void iE(long j) {
        this.pAM = j;
    }

    public void iF(long j) {
        this.pAN = j;
    }

    public void iG(long j) {
        this.pAO = j;
    }

    public void iH(long j) {
        this.pAP = j;
    }

    public void iI(long j) {
        this.pAQ = j;
    }

    public void iJ(long j) {
        this.pAR = j;
    }

    public void Pa(int i) {
        this.pAS = i;
    }

    public void Bh(boolean z) {
        this.mIsCanceled = z;
    }

    public void Bi(boolean z) {
        this.VE = z;
    }

    public void Bj(boolean z) {
        this.pAT = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pAK = fVar;
    }

    public void Pb(int i) {
        this.pAU = i;
    }

    public void Pc(int i) {
        this.pAV = i;
    }

    public e etH() {
        return new e(this.pAG, this.mRequestId, this.pAJ, this.pAI, this.pAK, this.pAL, this.pAM, this.pAN, this.pAO, this.pAP, this.pAQ, this.pAR, this.pAS, this.mIsCanceled, this.VE, this.pAT, this.pAU, this.pAV);
    }
}
