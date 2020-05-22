package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class h {
    private boolean Ta;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    private boolean mnC;
    @Nullable
    private String mnp;
    @Nullable
    private Object mnr;
    @Nullable
    private ImageRequest mns;
    @Nullable
    private com.facebook.imagepipeline.g.f mnt;
    private long mnu = -1;
    private long mnv = -1;
    private long mnw = -1;
    private long mnx = -1;
    private long mny = -1;
    private long mnz = -1;
    private long mnA = -1;
    private int mnB = -1;
    private int mnD = -1;
    private int mnE = -1;
    private int mnN = -1;

    public void reset() {
        this.mRequestId = null;
        this.mns = null;
        this.mnr = null;
        this.mnt = null;
        this.mnu = -1L;
        this.mnw = -1L;
        this.mnx = -1L;
        this.mny = -1L;
        this.mnz = -1L;
        this.mnA = -1L;
        this.mnB = -1;
        this.mIsCanceled = false;
        this.Ta = false;
        this.mnC = false;
        this.mnD = -1;
        this.mnE = -1;
        this.mnN = -1;
    }

    public void GR(int i) {
        this.mnN = i;
    }

    public int dvx() {
        return this.mnN;
    }

    public void PW(@Nullable String str) {
        this.mnp = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.mns = imageRequest;
    }

    public void aY(@Nullable Object obj) {
        this.mnr = obj;
    }

    public void fF(long j) {
        this.mnu = j;
    }

    public void fG(long j) {
        this.mnv = j;
    }

    public void fH(long j) {
        this.mnw = j;
    }

    public void fI(long j) {
        this.mnx = j;
    }

    public void fJ(long j) {
        this.mny = j;
    }

    public void fK(long j) {
        this.mnz = j;
    }

    public void fL(long j) {
        this.mnA = j;
    }

    public void GS(int i) {
        this.mnB = i;
    }

    public void vU(boolean z) {
        this.mIsCanceled = z;
    }

    public void vV(boolean z) {
        this.Ta = z;
    }

    public void vW(boolean z) {
        this.mnC = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.mnt = fVar;
    }

    public void GT(int i) {
        this.mnD = i;
    }

    public void GU(int i) {
        this.mnE = i;
    }

    public e dvy() {
        return new e(this.mnp, this.mRequestId, this.mns, this.mnr, this.mnt, this.mnu, this.mnv, this.mnw, this.mnx, this.mny, this.mnz, this.mnA, this.mnB, this.mIsCanceled, this.Ta, this.mnC, this.mnD, this.mnE);
    }
}
