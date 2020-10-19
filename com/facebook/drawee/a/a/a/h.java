package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class h {
    private boolean UM;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String nMm;
    @Nullable
    private Object nMo;
    @Nullable
    private ImageRequest nMp;
    @Nullable
    private com.facebook.imagepipeline.g.f nMq;
    private boolean nMz;
    private long nMr = -1;
    private long nMs = -1;
    private long nMt = -1;
    private long nMu = -1;
    private long nMv = -1;
    private long nMw = -1;
    private long nMx = -1;
    private int nMy = -1;
    private int nMA = -1;
    private int nMB = -1;
    private int nMK = -1;

    public void reset() {
        this.mRequestId = null;
        this.nMp = null;
        this.nMo = null;
        this.nMq = null;
        this.nMr = -1L;
        this.nMt = -1L;
        this.nMu = -1L;
        this.nMv = -1L;
        this.nMw = -1L;
        this.nMx = -1L;
        this.nMy = -1;
        this.mIsCanceled = false;
        this.UM = false;
        this.nMz = false;
        this.nMA = -1;
        this.nMB = -1;
        this.nMK = -1;
    }

    public void Mk(int i) {
        this.nMK = i;
    }

    public int dXx() {
        return this.nMK;
    }

    public void VP(@Nullable String str) {
        this.nMm = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.nMp = imageRequest;
    }

    public void bg(@Nullable Object obj) {
        this.nMo = obj;
    }

    public void gS(long j) {
        this.nMr = j;
    }

    public void gT(long j) {
        this.nMs = j;
    }

    public void gU(long j) {
        this.nMt = j;
    }

    public void gV(long j) {
        this.nMu = j;
    }

    public void gW(long j) {
        this.nMv = j;
    }

    public void gX(long j) {
        this.nMw = j;
    }

    public void gY(long j) {
        this.nMx = j;
    }

    public void Ml(int i) {
        this.nMy = i;
    }

    public void yG(boolean z) {
        this.mIsCanceled = z;
    }

    public void yH(boolean z) {
        this.UM = z;
    }

    public void yI(boolean z) {
        this.nMz = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.nMq = fVar;
    }

    public void Mm(int i) {
        this.nMA = i;
    }

    public void Mn(int i) {
        this.nMB = i;
    }

    public e dXy() {
        return new e(this.nMm, this.mRequestId, this.nMp, this.nMo, this.nMq, this.nMr, this.nMs, this.nMt, this.nMu, this.nMv, this.nMw, this.nMx, this.nMy, this.mIsCanceled, this.UM, this.nMz, this.nMA, this.nMB);
    }
}
