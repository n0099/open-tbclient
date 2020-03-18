package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    @Nullable
    private String lLZ;
    @Nullable
    private Object lMb;
    @Nullable
    private ImageRequest lMc;
    @Nullable
    private com.facebook.imagepipeline.g.f lMd;
    private boolean lMm;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean zA;
    private long lMe = -1;
    private long lMf = -1;
    private long lMg = -1;
    private long lMh = -1;
    private long lMi = -1;
    private long lMj = -1;
    private long lMk = -1;
    private int lMl = -1;
    private int lMn = -1;
    private int lMo = -1;
    private int lMx = -1;

    public void reset() {
        this.mRequestId = null;
        this.lMc = null;
        this.lMb = null;
        this.lMd = null;
        this.lMe = -1L;
        this.lMg = -1L;
        this.lMh = -1L;
        this.lMi = -1L;
        this.lMj = -1L;
        this.lMk = -1L;
        this.lMl = -1;
        this.mIsCanceled = false;
        this.zA = false;
        this.lMm = false;
        this.lMn = -1;
        this.lMo = -1;
        this.lMx = -1;
    }

    public void HE(int i) {
        this.lMx = i;
    }

    public int dmo() {
        return this.lMx;
    }

    public void OX(@Nullable String str) {
        this.lLZ = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lMc = imageRequest;
    }

    public void bd(@Nullable Object obj) {
        this.lMb = obj;
    }

    public void eZ(long j) {
        this.lMe = j;
    }

    public void fa(long j) {
        this.lMf = j;
    }

    public void fb(long j) {
        this.lMg = j;
    }

    public void fc(long j) {
        this.lMh = j;
    }

    public void fd(long j) {
        this.lMi = j;
    }

    public void fe(long j) {
        this.lMj = j;
    }

    public void ff(long j) {
        this.lMk = j;
    }

    public void HF(int i) {
        this.lMl = i;
    }

    public void vi(boolean z) {
        this.mIsCanceled = z;
    }

    public void vj(boolean z) {
        this.zA = z;
    }

    public void vk(boolean z) {
        this.lMm = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lMd = fVar;
    }

    public void HG(int i) {
        this.lMn = i;
    }

    public void HH(int i) {
        this.lMo = i;
    }

    public e dmp() {
        return new e(this.lLZ, this.mRequestId, this.lMc, this.lMb, this.lMd, this.lMe, this.lMf, this.lMg, this.lMh, this.lMi, this.lMj, this.lMk, this.lMl, this.mIsCanceled, this.zA, this.lMm, this.lMn, this.lMo);
    }
}
