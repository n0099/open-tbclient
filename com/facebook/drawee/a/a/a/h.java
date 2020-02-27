package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    @Nullable
    private String lKg;
    @Nullable
    private Object lKi;
    @Nullable
    private ImageRequest lKj;
    @Nullable
    private com.facebook.imagepipeline.g.f lKk;
    private boolean lKt;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean zA;
    private long lKl = -1;
    private long lKm = -1;
    private long lKn = -1;
    private long lKo = -1;
    private long lKp = -1;
    private long lKq = -1;
    private long lKr = -1;
    private int lKs = -1;
    private int lKu = -1;
    private int lKv = -1;
    private int lKE = -1;

    public void reset() {
        this.mRequestId = null;
        this.lKj = null;
        this.lKi = null;
        this.lKk = null;
        this.lKl = -1L;
        this.lKn = -1L;
        this.lKo = -1L;
        this.lKp = -1L;
        this.lKq = -1L;
        this.lKr = -1L;
        this.lKs = -1;
        this.mIsCanceled = false;
        this.zA = false;
        this.lKt = false;
        this.lKu = -1;
        this.lKv = -1;
        this.lKE = -1;
    }

    public void Hy(int i) {
        this.lKE = i;
    }

    public int dlO() {
        return this.lKE;
    }

    public void OX(@Nullable String str) {
        this.lKg = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lKj = imageRequest;
    }

    public void bd(@Nullable Object obj) {
        this.lKi = obj;
    }

    public void eY(long j) {
        this.lKl = j;
    }

    public void eZ(long j) {
        this.lKm = j;
    }

    public void fa(long j) {
        this.lKn = j;
    }

    public void fb(long j) {
        this.lKo = j;
    }

    public void fc(long j) {
        this.lKp = j;
    }

    public void fd(long j) {
        this.lKq = j;
    }

    public void fe(long j) {
        this.lKr = j;
    }

    public void Hz(int i) {
        this.lKs = i;
    }

    public void vb(boolean z) {
        this.mIsCanceled = z;
    }

    public void vc(boolean z) {
        this.zA = z;
    }

    public void vd(boolean z) {
        this.lKt = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lKk = fVar;
    }

    public void HA(int i) {
        this.lKu = i;
    }

    public void HB(int i) {
        this.lKv = i;
    }

    public e dlP() {
        return new e(this.lKg, this.mRequestId, this.lKj, this.lKi, this.lKk, this.lKl, this.lKm, this.lKn, this.lKo, this.lKp, this.lKq, this.lKr, this.lKs, this.mIsCanceled, this.zA, this.lKt, this.lKu, this.lKv);
    }
}
