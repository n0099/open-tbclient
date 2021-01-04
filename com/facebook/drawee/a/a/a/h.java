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
    private String puR;
    @Nullable
    private Object puT;
    @Nullable
    private ImageRequest puU;
    @Nullable
    private com.facebook.imagepipeline.f.f puV;
    private boolean pve;
    private long puW = -1;
    private long puX = -1;
    private long puY = -1;
    private long puZ = -1;
    private long pva = -1;
    private long pvb = -1;
    private long pvc = -1;
    private int pvd = -1;
    private int pvf = -1;
    private int pvg = -1;
    private int pvp = -1;

    public void reset() {
        this.mRequestId = null;
        this.puU = null;
        this.puT = null;
        this.puV = null;
        this.puW = -1L;
        this.puY = -1L;
        this.puZ = -1L;
        this.pva = -1L;
        this.pvb = -1L;
        this.pvc = -1L;
        this.pvd = -1;
        this.mIsCanceled = false;
        this.VI = false;
        this.pve = false;
        this.pvf = -1;
        this.pvg = -1;
        this.pvp = -1;
    }

    public void Qg(int i) {
        this.pvp = i;
    }

    public int eva() {
        return this.pvp;
    }

    public void Zx(@Nullable String str) {
        this.puR = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.puU = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.puT = obj;
    }

    public void iA(long j) {
        this.puW = j;
    }

    public void iB(long j) {
        this.puX = j;
    }

    public void iC(long j) {
        this.puY = j;
    }

    public void iD(long j) {
        this.puZ = j;
    }

    public void iE(long j) {
        this.pva = j;
    }

    public void iF(long j) {
        this.pvb = j;
    }

    public void iG(long j) {
        this.pvc = j;
    }

    public void Qh(int i) {
        this.pvd = i;
    }

    public void AS(boolean z) {
        this.mIsCanceled = z;
    }

    public void AT(boolean z) {
        this.VI = z;
    }

    public void AU(boolean z) {
        this.pve = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.puV = fVar;
    }

    public void Qi(int i) {
        this.pvf = i;
    }

    public void Qj(int i) {
        this.pvg = i;
    }

    public e evb() {
        return new e(this.puR, this.mRequestId, this.puU, this.puT, this.puV, this.puW, this.puX, this.puY, this.puZ, this.pva, this.pvb, this.pvc, this.pvd, this.mIsCanceled, this.VI, this.pve, this.pvf, this.pvg);
    }
}
