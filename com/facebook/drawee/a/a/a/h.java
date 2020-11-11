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
    private String oMY;
    @Nullable
    private Object oNa;
    @Nullable
    private ImageRequest oNb;
    @Nullable
    private com.facebook.imagepipeline.g.f oNc;
    private boolean oNl;
    private long oNd = -1;
    private long oNe = -1;
    private long oNf = -1;
    private long oNg = -1;
    private long oNh = -1;
    private long oNi = -1;
    private long oNj = -1;
    private int oNk = -1;
    private int oNm = -1;
    private int oNn = -1;
    private int oNw = -1;

    public void reset() {
        this.mRequestId = null;
        this.oNb = null;
        this.oNa = null;
        this.oNc = null;
        this.oNd = -1L;
        this.oNf = -1L;
        this.oNg = -1L;
        this.oNh = -1L;
        this.oNi = -1L;
        this.oNj = -1L;
        this.oNk = -1;
        this.mIsCanceled = false;
        this.UN = false;
        this.oNl = false;
        this.oNm = -1;
        this.oNn = -1;
        this.oNw = -1;
    }

    public void Ow(int i) {
        this.oNw = i;
    }

    public int elk() {
        return this.oNw;
    }

    public void Yg(@Nullable String str) {
        this.oMY = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.oNb = imageRequest;
    }

    public void bk(@Nullable Object obj) {
        this.oNa = obj;
    }

    public void hE(long j) {
        this.oNd = j;
    }

    public void hF(long j) {
        this.oNe = j;
    }

    public void hG(long j) {
        this.oNf = j;
    }

    public void hH(long j) {
        this.oNg = j;
    }

    public void hI(long j) {
        this.oNh = j;
    }

    public void hJ(long j) {
        this.oNi = j;
    }

    public void hK(long j) {
        this.oNj = j;
    }

    public void Ox(int i) {
        this.oNk = i;
    }

    public void zZ(boolean z) {
        this.mIsCanceled = z;
    }

    public void Aa(boolean z) {
        this.UN = z;
    }

    public void Ab(boolean z) {
        this.oNl = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.oNc = fVar;
    }

    public void Oy(int i) {
        this.oNm = i;
    }

    public void Oz(int i) {
        this.oNn = i;
    }

    public e ell() {
        return new e(this.oMY, this.mRequestId, this.oNb, this.oNa, this.oNc, this.oNd, this.oNe, this.oNf, this.oNg, this.oNh, this.oNi, this.oNj, this.oNk, this.mIsCanceled, this.UN, this.oNl, this.oNm, this.oNn);
    }
}
