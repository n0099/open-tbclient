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
    private String nmB;
    @Nullable
    private Object nmD;
    @Nullable
    private ImageRequest nmE;
    @Nullable
    private com.facebook.imagepipeline.g.f nmF;
    private boolean nmO;
    private long nmG = -1;
    private long nmH = -1;
    private long nmI = -1;
    private long nmJ = -1;
    private long nmK = -1;
    private long nmL = -1;
    private long nmM = -1;
    private int nmN = -1;
    private int nmP = -1;
    private int nmQ = -1;
    private int nmZ = -1;

    public void reset() {
        this.mRequestId = null;
        this.nmE = null;
        this.nmD = null;
        this.nmF = null;
        this.nmG = -1L;
        this.nmI = -1L;
        this.nmJ = -1L;
        this.nmK = -1L;
        this.nmL = -1L;
        this.nmM = -1L;
        this.nmN = -1;
        this.mIsCanceled = false;
        this.Ub = false;
        this.nmO = false;
        this.nmP = -1;
        this.nmQ = -1;
        this.nmZ = -1;
    }

    public void KZ(int i) {
        this.nmZ = i;
    }

    public int dPF() {
        return this.nmZ;
    }

    public void Uz(@Nullable String str) {
        this.nmB = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.nmE = imageRequest;
    }

    public void bb(@Nullable Object obj) {
        this.nmD = obj;
    }

    public void gk(long j) {
        this.nmG = j;
    }

    public void gl(long j) {
        this.nmH = j;
    }

    public void gm(long j) {
        this.nmI = j;
    }

    public void gn(long j) {
        this.nmJ = j;
    }

    public void go(long j) {
        this.nmK = j;
    }

    public void gp(long j) {
        this.nmL = j;
    }

    public void gq(long j) {
        this.nmM = j;
    }

    public void La(int i) {
        this.nmN = i;
    }

    public void xO(boolean z) {
        this.mIsCanceled = z;
    }

    public void xP(boolean z) {
        this.Ub = z;
    }

    public void xQ(boolean z) {
        this.nmO = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.nmF = fVar;
    }

    public void Lb(int i) {
        this.nmP = i;
    }

    public void Lc(int i) {
        this.nmQ = i;
    }

    public e dPG() {
        return new e(this.nmB, this.mRequestId, this.nmE, this.nmD, this.nmF, this.nmG, this.nmH, this.nmI, this.nmJ, this.nmK, this.nmL, this.nmM, this.nmN, this.mIsCanceled, this.Ub, this.nmO, this.nmP, this.nmQ);
    }
}
