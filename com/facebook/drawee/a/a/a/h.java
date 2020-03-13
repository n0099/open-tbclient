package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean lKG;
    @Nullable
    private String lKt;
    @Nullable
    private Object lKv;
    @Nullable
    private ImageRequest lKw;
    @Nullable
    private com.facebook.imagepipeline.g.f lKx;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean zA;
    private long lKy = -1;
    private long lKz = -1;
    private long lKA = -1;
    private long lKB = -1;
    private long lKC = -1;
    private long lKD = -1;
    private long lKE = -1;
    private int lKF = -1;
    private int lKH = -1;
    private int lKI = -1;
    private int lKR = -1;

    public void reset() {
        this.mRequestId = null;
        this.lKw = null;
        this.lKv = null;
        this.lKx = null;
        this.lKy = -1L;
        this.lKA = -1L;
        this.lKB = -1L;
        this.lKC = -1L;
        this.lKD = -1L;
        this.lKE = -1L;
        this.lKF = -1;
        this.mIsCanceled = false;
        this.zA = false;
        this.lKG = false;
        this.lKH = -1;
        this.lKI = -1;
        this.lKR = -1;
    }

    public void Hy(int i) {
        this.lKR = i;
    }

    public int dlR() {
        return this.lKR;
    }

    public void OY(@Nullable String str) {
        this.lKt = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lKw = imageRequest;
    }

    public void bd(@Nullable Object obj) {
        this.lKv = obj;
    }

    public void eY(long j) {
        this.lKy = j;
    }

    public void eZ(long j) {
        this.lKz = j;
    }

    public void fa(long j) {
        this.lKA = j;
    }

    public void fb(long j) {
        this.lKB = j;
    }

    public void fc(long j) {
        this.lKC = j;
    }

    public void fd(long j) {
        this.lKD = j;
    }

    public void fe(long j) {
        this.lKE = j;
    }

    public void Hz(int i) {
        this.lKF = i;
    }

    public void vb(boolean z) {
        this.mIsCanceled = z;
    }

    public void vc(boolean z) {
        this.zA = z;
    }

    public void vd(boolean z) {
        this.lKG = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lKx = fVar;
    }

    public void HA(int i) {
        this.lKH = i;
    }

    public void HB(int i) {
        this.lKI = i;
    }

    public e dlS() {
        return new e(this.lKt, this.mRequestId, this.lKw, this.lKv, this.lKx, this.lKy, this.lKz, this.lKA, this.lKB, this.lKC, this.lKD, this.lKE, this.lKF, this.mIsCanceled, this.zA, this.lKG, this.lKH, this.lKI);
    }
}
