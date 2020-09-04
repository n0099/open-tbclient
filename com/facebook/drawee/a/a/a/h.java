package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class h {
    private boolean Ub;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String nmT;
    @Nullable
    private Object nmV;
    @Nullable
    private ImageRequest nmW;
    @Nullable
    private com.facebook.imagepipeline.g.f nmX;
    private boolean nng;
    private long nmY = -1;
    private long nmZ = -1;
    private long nna = -1;
    private long nnb = -1;
    private long nnc = -1;
    private long nnd = -1;
    private long nne = -1;
    private int nnf = -1;
    private int nnh = -1;
    private int nni = -1;
    private int nnr = -1;

    public void reset() {
        this.mRequestId = null;
        this.nmW = null;
        this.nmV = null;
        this.nmX = null;
        this.nmY = -1L;
        this.nna = -1L;
        this.nnb = -1L;
        this.nnc = -1L;
        this.nnd = -1L;
        this.nne = -1L;
        this.nnf = -1;
        this.mIsCanceled = false;
        this.Ub = false;
        this.nng = false;
        this.nnh = -1;
        this.nni = -1;
        this.nnr = -1;
    }

    public void KZ(int i) {
        this.nnr = i;
    }

    public int dPO() {
        return this.nnr;
    }

    public void Uz(@Nullable String str) {
        this.nmT = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.nmW = imageRequest;
    }

    public void bb(@Nullable Object obj) {
        this.nmV = obj;
    }

    public void gm(long j) {
        this.nmY = j;
    }

    public void gn(long j) {
        this.nmZ = j;
    }

    public void go(long j) {
        this.nna = j;
    }

    public void gp(long j) {
        this.nnb = j;
    }

    public void gq(long j) {
        this.nnc = j;
    }

    public void gr(long j) {
        this.nnd = j;
    }

    public void gs(long j) {
        this.nne = j;
    }

    public void La(int i) {
        this.nnf = i;
    }

    public void xQ(boolean z) {
        this.mIsCanceled = z;
    }

    public void xR(boolean z) {
        this.Ub = z;
    }

    public void xS(boolean z) {
        this.nng = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.nmX = fVar;
    }

    public void Lb(int i) {
        this.nnh = i;
    }

    public void Lc(int i) {
        this.nni = i;
    }

    public e dPP() {
        return new e(this.nmT, this.mRequestId, this.nmW, this.nmV, this.nmX, this.nmY, this.nmZ, this.nna, this.nnb, this.nnc, this.nnd, this.nne, this.nnf, this.mIsCanceled, this.Ub, this.nng, this.nnh, this.nni);
    }
}
