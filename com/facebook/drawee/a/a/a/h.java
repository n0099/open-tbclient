package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class h {
    private boolean VI;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String puY;
    @Nullable
    private Object pva;
    @Nullable
    private ImageRequest pvb;
    @Nullable
    private com.facebook.imagepipeline.f.f pvc;
    private boolean pvl;
    private long pvd = -1;
    private long pve = -1;
    private long pvf = -1;
    private long pvg = -1;
    private long pvh = -1;
    private long pvi = -1;
    private long pvj = -1;
    private int pvk = -1;
    private int pvm = -1;
    private int pvn = -1;
    private int pvw = -1;

    public void reset() {
        this.mRequestId = null;
        this.pvb = null;
        this.pva = null;
        this.pvc = null;
        this.pvd = -1L;
        this.pvf = -1L;
        this.pvg = -1L;
        this.pvh = -1L;
        this.pvi = -1L;
        this.pvj = -1L;
        this.pvk = -1;
        this.mIsCanceled = false;
        this.VI = false;
        this.pvl = false;
        this.pvm = -1;
        this.pvn = -1;
        this.pvw = -1;
    }

    public void Ql(int i) {
        this.pvw = i;
    }

    public int evh() {
        return this.pvw;
    }

    public void Zw(@Nullable String str) {
        this.puY = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pvb = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pva = obj;
    }

    public void iA(long j) {
        this.pvd = j;
    }

    public void iB(long j) {
        this.pve = j;
    }

    public void iC(long j) {
        this.pvf = j;
    }

    public void iD(long j) {
        this.pvg = j;
    }

    public void iE(long j) {
        this.pvh = j;
    }

    public void iF(long j) {
        this.pvi = j;
    }

    public void iG(long j) {
        this.pvj = j;
    }

    public void Qm(int i) {
        this.pvk = i;
    }

    public void AS(boolean z) {
        this.mIsCanceled = z;
    }

    public void AT(boolean z) {
        this.VI = z;
    }

    public void AU(boolean z) {
        this.pvl = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pvc = fVar;
    }

    public void Qn(int i) {
        this.pvm = i;
    }

    public void Qo(int i) {
        this.pvn = i;
    }

    public e evi() {
        return new e(this.puY, this.mRequestId, this.pvb, this.pva, this.pvc, this.pvd, this.pve, this.pvf, this.pvg, this.pvh, this.pvi, this.pvj, this.pvk, this.mIsCanceled, this.VI, this.pvl, this.pvm, this.pvn);
    }
}
