package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class h {
    @Nullable
    private String lFW;
    @Nullable
    private Object lFY;
    @Nullable
    private ImageRequest lFZ;
    @Nullable
    private com.facebook.imagepipeline.g.f lGa;
    private boolean lGj;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean ze;
    private long lGb = -1;
    private long lGc = -1;
    private long lGd = -1;
    private long lGe = -1;
    private long lGf = -1;
    private long lGg = -1;
    private long lGh = -1;
    private int lGi = -1;
    private int lGk = -1;
    private int lGl = -1;
    private int lGu = -1;

    public void reset() {
        this.mRequestId = null;
        this.lFZ = null;
        this.lFY = null;
        this.lGa = null;
        this.lGb = -1L;
        this.lGd = -1L;
        this.lGe = -1L;
        this.lGf = -1L;
        this.lGg = -1L;
        this.lGh = -1L;
        this.lGi = -1;
        this.mIsCanceled = false;
        this.ze = false;
        this.lGj = false;
        this.lGk = -1;
        this.lGl = -1;
        this.lGu = -1;
    }

    public void Ho(int i) {
        this.lGu = i;
    }

    public int djy() {
        return this.lGu;
    }

    public void OA(@Nullable String str) {
        this.lFW = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.lFZ = imageRequest;
    }

    public void bb(@Nullable Object obj) {
        this.lFY = obj;
    }

    public void eV(long j) {
        this.lGb = j;
    }

    public void eW(long j) {
        this.lGc = j;
    }

    public void eX(long j) {
        this.lGd = j;
    }

    public void eY(long j) {
        this.lGe = j;
    }

    public void eZ(long j) {
        this.lGf = j;
    }

    public void fa(long j) {
        this.lGg = j;
    }

    public void fb(long j) {
        this.lGh = j;
    }

    public void Hp(int i) {
        this.lGi = i;
    }

    public void uM(boolean z) {
        this.mIsCanceled = z;
    }

    public void uN(boolean z) {
        this.ze = z;
    }

    public void uO(boolean z) {
        this.lGj = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.lGa = fVar;
    }

    public void Hq(int i) {
        this.lGk = i;
    }

    public void Hr(int i) {
        this.lGl = i;
    }

    public e djz() {
        return new e(this.lFW, this.mRequestId, this.lFZ, this.lFY, this.lGa, this.lGb, this.lGc, this.lGd, this.lGe, this.lGf, this.lGg, this.lGh, this.lGi, this.mIsCanceled, this.ze, this.lGj, this.lGk, this.lGl);
    }
}
