package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean SL;
    private boolean lTG;
    @Nullable
    private String lTt;
    @Nullable
    private Object lTv;
    @Nullable
    private ImageRequest lTw;
    @Nullable
    private com.facebook.imagepipeline.g.f lTx;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private long lTy = -1;
    private long lTz = -1;
    private long lTA = -1;
    private long lTB = -1;
    private long lTC = -1;
    private long lTD = -1;
    private long lTE = -1;
    private int lTF = -1;
    private int lTH = -1;
    private int lTI = -1;
    private int lTR = -1;

    public void reset() {
        this.mRequestId = null;
        this.lTw = null;
        this.lTv = null;
        this.lTx = null;
        this.lTy = -1L;
        this.lTA = -1L;
        this.lTB = -1L;
        this.lTC = -1L;
        this.lTD = -1L;
        this.lTE = -1L;
        this.lTF = -1;
        this.mIsCanceled = false;
        this.SL = false;
        this.lTG = false;
        this.lTH = -1;
        this.lTI = -1;
        this.lTR = -1;
    }

    public void Gf(int i) {
        this.lTR = i;
    }

    public int doh() {
        return this.lTR;
    }

    public void Of(@Nullable String str) {
        this.lTt = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lTw = imageRequest;
    }

    public void aT(@Nullable Object obj) {
        this.lTv = obj;
    }

    public void fF(long j) {
        this.lTy = j;
    }

    public void fG(long j) {
        this.lTz = j;
    }

    public void fH(long j) {
        this.lTA = j;
    }

    public void fI(long j) {
        this.lTB = j;
    }

    public void fJ(long j) {
        this.lTC = j;
    }

    public void fK(long j) {
        this.lTD = j;
    }

    public void fL(long j) {
        this.lTE = j;
    }

    public void Gg(int i) {
        this.lTF = i;
    }

    public void vw(boolean z) {
        this.mIsCanceled = z;
    }

    public void vx(boolean z) {
        this.SL = z;
    }

    public void vy(boolean z) {
        this.lTG = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lTx = fVar;
    }

    public void Gh(int i) {
        this.lTH = i;
    }

    public void Gi(int i) {
        this.lTI = i;
    }

    public e doi() {
        return new e(this.lTt, this.mRequestId, this.lTw, this.lTv, this.lTx, this.lTy, this.lTz, this.lTA, this.lTB, this.lTC, this.lTD, this.lTE, this.lTF, this.mIsCanceled, this.SL, this.lTG, this.lTH, this.lTI);
    }
}
