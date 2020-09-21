package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class h {
    private boolean Ut;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String nwT;
    @Nullable
    private Object nwV;
    @Nullable
    private ImageRequest nwW;
    @Nullable
    private com.facebook.imagepipeline.g.f nwX;
    private boolean nxg;
    private long nwY = -1;
    private long nwZ = -1;
    private long nxa = -1;
    private long nxb = -1;
    private long nxc = -1;
    private long nxd = -1;
    private long nxe = -1;
    private int nxf = -1;
    private int nxh = -1;
    private int nxi = -1;
    private int nxr = -1;

    public void reset() {
        this.mRequestId = null;
        this.nwW = null;
        this.nwV = null;
        this.nwX = null;
        this.nwY = -1L;
        this.nxa = -1L;
        this.nxb = -1L;
        this.nxc = -1L;
        this.nxd = -1L;
        this.nxe = -1L;
        this.nxf = -1;
        this.mIsCanceled = false;
        this.Ut = false;
        this.nxg = false;
        this.nxh = -1;
        this.nxi = -1;
        this.nxr = -1;
    }

    public void LE(int i) {
        this.nxr = i;
    }

    public int dTM() {
        return this.nxr;
    }

    public void Vb(@Nullable String str) {
        this.nwT = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.nwW = imageRequest;
    }

    public void bd(@Nullable Object obj) {
        this.nwV = obj;
    }

    public void gA(long j) {
        this.nwY = j;
    }

    public void gB(long j) {
        this.nwZ = j;
    }

    public void gC(long j) {
        this.nxa = j;
    }

    public void gD(long j) {
        this.nxb = j;
    }

    public void gE(long j) {
        this.nxc = j;
    }

    public void gF(long j) {
        this.nxd = j;
    }

    public void gG(long j) {
        this.nxe = j;
    }

    public void LF(int i) {
        this.nxf = i;
    }

    public void xZ(boolean z) {
        this.mIsCanceled = z;
    }

    public void ya(boolean z) {
        this.Ut = z;
    }

    public void yb(boolean z) {
        this.nxg = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.nwX = fVar;
    }

    public void LG(int i) {
        this.nxh = i;
    }

    public void LH(int i) {
        this.nxi = i;
    }

    public e dTN() {
        return new e(this.nwT, this.mRequestId, this.nwW, this.nwV, this.nwX, this.nwY, this.nwZ, this.nxa, this.nxb, this.nxc, this.nxd, this.nxe, this.nxf, this.mIsCanceled, this.Ut, this.nxg, this.nxh, this.nxi);
    }
}
