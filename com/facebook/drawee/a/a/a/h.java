package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean SQ;
    @Nullable
    private ImageRequest lTA;
    @Nullable
    private com.facebook.imagepipeline.g.f lTB;
    private boolean lTK;
    @Nullable
    private String lTx;
    @Nullable
    private Object lTz;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private long lTC = -1;
    private long lTD = -1;
    private long lTE = -1;
    private long lTF = -1;
    private long lTG = -1;
    private long lTH = -1;
    private long lTI = -1;
    private int lTJ = -1;
    private int lTL = -1;
    private int lTM = -1;
    private int lTV = -1;

    public void reset() {
        this.mRequestId = null;
        this.lTA = null;
        this.lTz = null;
        this.lTB = null;
        this.lTC = -1L;
        this.lTE = -1L;
        this.lTF = -1L;
        this.lTG = -1L;
        this.lTH = -1L;
        this.lTI = -1L;
        this.lTJ = -1;
        this.mIsCanceled = false;
        this.SQ = false;
        this.lTK = false;
        this.lTL = -1;
        this.lTM = -1;
        this.lTV = -1;
    }

    public void Gf(int i) {
        this.lTV = i;
    }

    public int dof() {
        return this.lTV;
    }

    public void Oi(@Nullable String str) {
        this.lTx = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lTA = imageRequest;
    }

    public void aU(@Nullable Object obj) {
        this.lTz = obj;
    }

    public void fF(long j) {
        this.lTC = j;
    }

    public void fG(long j) {
        this.lTD = j;
    }

    public void fH(long j) {
        this.lTE = j;
    }

    public void fI(long j) {
        this.lTF = j;
    }

    public void fJ(long j) {
        this.lTG = j;
    }

    public void fK(long j) {
        this.lTH = j;
    }

    public void fL(long j) {
        this.lTI = j;
    }

    public void Gg(int i) {
        this.lTJ = i;
    }

    public void vw(boolean z) {
        this.mIsCanceled = z;
    }

    public void vx(boolean z) {
        this.SQ = z;
    }

    public void vy(boolean z) {
        this.lTK = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lTB = fVar;
    }

    public void Gh(int i) {
        this.lTL = i;
    }

    public void Gi(int i) {
        this.lTM = i;
    }

    public e dog() {
        return new e(this.lTx, this.mRequestId, this.lTA, this.lTz, this.lTB, this.lTC, this.lTD, this.lTE, this.lTF, this.lTG, this.lTH, this.lTI, this.lTJ, this.mIsCanceled, this.SQ, this.lTK, this.lTL, this.lTM);
    }
}
