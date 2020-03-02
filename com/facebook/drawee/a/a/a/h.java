package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    @Nullable
    private String lKi;
    @Nullable
    private Object lKk;
    @Nullable
    private ImageRequest lKl;
    @Nullable
    private com.facebook.imagepipeline.g.f lKm;
    private boolean lKv;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean zA;
    private long lKn = -1;
    private long lKo = -1;
    private long lKp = -1;
    private long lKq = -1;
    private long lKr = -1;
    private long lKs = -1;
    private long lKt = -1;
    private int lKu = -1;
    private int lKw = -1;
    private int lKx = -1;
    private int lKG = -1;

    public void reset() {
        this.mRequestId = null;
        this.lKl = null;
        this.lKk = null;
        this.lKm = null;
        this.lKn = -1L;
        this.lKp = -1L;
        this.lKq = -1L;
        this.lKr = -1L;
        this.lKs = -1L;
        this.lKt = -1L;
        this.lKu = -1;
        this.mIsCanceled = false;
        this.zA = false;
        this.lKv = false;
        this.lKw = -1;
        this.lKx = -1;
        this.lKG = -1;
    }

    public void Hy(int i) {
        this.lKG = i;
    }

    public int dlQ() {
        return this.lKG;
    }

    public void OX(@Nullable String str) {
        this.lKi = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lKl = imageRequest;
    }

    public void bd(@Nullable Object obj) {
        this.lKk = obj;
    }

    public void eY(long j) {
        this.lKn = j;
    }

    public void eZ(long j) {
        this.lKo = j;
    }

    public void fa(long j) {
        this.lKp = j;
    }

    public void fb(long j) {
        this.lKq = j;
    }

    public void fc(long j) {
        this.lKr = j;
    }

    public void fd(long j) {
        this.lKs = j;
    }

    public void fe(long j) {
        this.lKt = j;
    }

    public void Hz(int i) {
        this.lKu = i;
    }

    public void vb(boolean z) {
        this.mIsCanceled = z;
    }

    public void vc(boolean z) {
        this.zA = z;
    }

    public void vd(boolean z) {
        this.lKv = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lKm = fVar;
    }

    public void HA(int i) {
        this.lKw = i;
    }

    public void HB(int i) {
        this.lKx = i;
    }

    public e dlR() {
        return new e(this.lKi, this.mRequestId, this.lKl, this.lKk, this.lKm, this.lKn, this.lKo, this.lKp, this.lKq, this.lKr, this.lKs, this.lKt, this.lKu, this.mIsCanceled, this.zA, this.lKv, this.lKw, this.lKx);
    }
}
