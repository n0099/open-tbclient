package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class h {
    private boolean UN;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String oDF;
    @Nullable
    private Object oDH;
    @Nullable
    private ImageRequest oDI;
    @Nullable
    private com.facebook.imagepipeline.g.f oDJ;
    private boolean oDS;
    private long oDK = -1;
    private long oDL = -1;
    private long oDM = -1;
    private long oDN = -1;
    private long oDO = -1;
    private long oDP = -1;
    private long oDQ = -1;
    private int oDR = -1;
    private int oDT = -1;
    private int oDU = -1;
    private int oEd = -1;

    public void reset() {
        this.mRequestId = null;
        this.oDI = null;
        this.oDH = null;
        this.oDJ = null;
        this.oDK = -1L;
        this.oDM = -1L;
        this.oDN = -1L;
        this.oDO = -1L;
        this.oDP = -1L;
        this.oDQ = -1L;
        this.oDR = -1;
        this.mIsCanceled = false;
        this.UN = false;
        this.oDS = false;
        this.oDT = -1;
        this.oDU = -1;
        this.oEd = -1;
    }

    public void Ob(int i) {
        this.oEd = i;
    }

    public int ehv() {
        return this.oEd;
    }

    public void XC(@Nullable String str) {
        this.oDF = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.oDI = imageRequest;
    }

    public void bk(@Nullable Object obj) {
        this.oDH = obj;
    }

    public void hi(long j) {
        this.oDK = j;
    }

    public void hj(long j) {
        this.oDL = j;
    }

    public void hk(long j) {
        this.oDM = j;
    }

    public void hl(long j) {
        this.oDN = j;
    }

    public void hm(long j) {
        this.oDO = j;
    }

    public void hn(long j) {
        this.oDP = j;
    }

    public void ho(long j) {
        this.oDQ = j;
    }

    public void Oc(int i) {
        this.oDR = i;
    }

    public void zO(boolean z) {
        this.mIsCanceled = z;
    }

    public void zP(boolean z) {
        this.UN = z;
    }

    public void zQ(boolean z) {
        this.oDS = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.oDJ = fVar;
    }

    public void Od(int i) {
        this.oDT = i;
    }

    public void Oe(int i) {
        this.oDU = i;
    }

    public e ehw() {
        return new e(this.oDF, this.mRequestId, this.oDI, this.oDH, this.oDJ, this.oDK, this.oDL, this.oDM, this.oDN, this.oDO, this.oDP, this.oDQ, this.oDR, this.mIsCanceled, this.UN, this.oDS, this.oDT, this.oDU);
    }
}
