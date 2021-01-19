package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class h {
    private boolean VG;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private ImageRequest pqA;
    @Nullable
    private com.facebook.imagepipeline.f.f pqB;
    private boolean pqK;
    @Nullable
    private String pqx;
    @Nullable
    private Object pqz;
    private long pqC = -1;
    private long pqD = -1;
    private long pqE = -1;
    private long pqF = -1;
    private long pqG = -1;
    private long pqH = -1;
    private long pqI = -1;
    private int pqJ = -1;
    private int pqL = -1;
    private int pqM = -1;
    private int pqV = -1;

    public void reset() {
        this.mRequestId = null;
        this.pqA = null;
        this.pqz = null;
        this.pqB = null;
        this.pqC = -1L;
        this.pqE = -1L;
        this.pqF = -1L;
        this.pqG = -1L;
        this.pqH = -1L;
        this.pqI = -1L;
        this.pqJ = -1;
        this.mIsCanceled = false;
        this.VG = false;
        this.pqK = false;
        this.pqL = -1;
        this.pqM = -1;
        this.pqV = -1;
    }

    public void OE(int i) {
        this.pqV = i;
    }

    public int ern() {
        return this.pqV;
    }

    public void Yp(@Nullable String str) {
        this.pqx = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pqA = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pqz = obj;
    }

    public void iA(long j) {
        this.pqC = j;
    }

    public void iB(long j) {
        this.pqD = j;
    }

    public void iC(long j) {
        this.pqE = j;
    }

    public void iD(long j) {
        this.pqF = j;
    }

    public void iE(long j) {
        this.pqG = j;
    }

    public void iF(long j) {
        this.pqH = j;
    }

    public void iG(long j) {
        this.pqI = j;
    }

    public void OF(int i) {
        this.pqJ = i;
    }

    public void AO(boolean z) {
        this.mIsCanceled = z;
    }

    public void AP(boolean z) {
        this.VG = z;
    }

    public void AQ(boolean z) {
        this.pqK = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pqB = fVar;
    }

    public void OG(int i) {
        this.pqL = i;
    }

    public void OH(int i) {
        this.pqM = i;
    }

    public e ero() {
        return new e(this.pqx, this.mRequestId, this.pqA, this.pqz, this.pqB, this.pqC, this.pqD, this.pqE, this.pqF, this.pqG, this.pqH, this.pqI, this.pqJ, this.mIsCanceled, this.VG, this.pqK, this.pqL, this.pqM);
    }
}
