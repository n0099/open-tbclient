package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean Ta;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String moA;
    @Nullable
    private Object moC;
    @Nullable
    private ImageRequest moD;
    @Nullable
    private com.facebook.imagepipeline.g.f moE;
    private boolean moN;
    private long moF = -1;
    private long moG = -1;
    private long moH = -1;
    private long moI = -1;
    private long moJ = -1;
    private long moK = -1;
    private long moL = -1;
    private int moM = -1;
    private int moO = -1;
    private int moP = -1;
    private int moY = -1;

    public void reset() {
        this.mRequestId = null;
        this.moD = null;
        this.moC = null;
        this.moE = null;
        this.moF = -1L;
        this.moH = -1L;
        this.moI = -1L;
        this.moJ = -1L;
        this.moK = -1L;
        this.moL = -1L;
        this.moM = -1;
        this.mIsCanceled = false;
        this.Ta = false;
        this.moN = false;
        this.moO = -1;
        this.moP = -1;
        this.moY = -1;
    }

    public void GT(int i) {
        this.moY = i;
    }

    public int dvL() {
        return this.moY;
    }

    public void PX(@Nullable String str) {
        this.moA = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.moD = imageRequest;
    }

    public void aY(@Nullable Object obj) {
        this.moC = obj;
    }

    public void fF(long j) {
        this.moF = j;
    }

    public void fG(long j) {
        this.moG = j;
    }

    public void fH(long j) {
        this.moH = j;
    }

    public void fI(long j) {
        this.moI = j;
    }

    public void fJ(long j) {
        this.moJ = j;
    }

    public void fK(long j) {
        this.moK = j;
    }

    public void fL(long j) {
        this.moL = j;
    }

    public void GU(int i) {
        this.moM = i;
    }

    public void vW(boolean z) {
        this.mIsCanceled = z;
    }

    public void vX(boolean z) {
        this.Ta = z;
    }

    public void vY(boolean z) {
        this.moN = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.moE = fVar;
    }

    public void GV(int i) {
        this.moO = i;
    }

    public void GW(int i) {
        this.moP = i;
    }

    public e dvM() {
        return new e(this.moA, this.mRequestId, this.moD, this.moC, this.moE, this.moF, this.moG, this.moH, this.moI, this.moJ, this.moK, this.moL, this.moM, this.mIsCanceled, this.Ta, this.moN, this.moO, this.moP);
    }
}
