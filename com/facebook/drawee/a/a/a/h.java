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
    private com.facebook.imagepipeline.f.f pqA;
    private boolean pqJ;
    @Nullable
    private String pqw;
    @Nullable
    private Object pqy;
    @Nullable
    private ImageRequest pqz;
    private long pqB = -1;
    private long pqC = -1;
    private long pqD = -1;
    private long pqE = -1;
    private long pqF = -1;
    private long pqG = -1;
    private long pqH = -1;
    private int pqI = -1;
    private int pqK = -1;
    private int pqL = -1;
    private int pqU = -1;

    public void reset() {
        this.mRequestId = null;
        this.pqz = null;
        this.pqy = null;
        this.pqA = null;
        this.pqB = -1L;
        this.pqD = -1L;
        this.pqE = -1L;
        this.pqF = -1L;
        this.pqG = -1L;
        this.pqH = -1L;
        this.pqI = -1;
        this.mIsCanceled = false;
        this.VG = false;
        this.pqJ = false;
        this.pqK = -1;
        this.pqL = -1;
        this.pqU = -1;
    }

    public void OE(int i) {
        this.pqU = i;
    }

    public int ern() {
        return this.pqU;
    }

    public void Yo(@Nullable String str) {
        this.pqw = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.pqz = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.pqy = obj;
    }

    public void iA(long j) {
        this.pqB = j;
    }

    public void iB(long j) {
        this.pqC = j;
    }

    public void iC(long j) {
        this.pqD = j;
    }

    public void iD(long j) {
        this.pqE = j;
    }

    public void iE(long j) {
        this.pqF = j;
    }

    public void iF(long j) {
        this.pqG = j;
    }

    public void iG(long j) {
        this.pqH = j;
    }

    public void OF(int i) {
        this.pqI = i;
    }

    public void AO(boolean z) {
        this.mIsCanceled = z;
    }

    public void AP(boolean z) {
        this.VG = z;
    }

    public void AQ(boolean z) {
        this.pqJ = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.f.f fVar) {
        this.pqA = fVar;
    }

    public void OG(int i) {
        this.pqK = i;
    }

    public void OH(int i) {
        this.pqL = i;
    }

    public e ero() {
        return new e(this.pqw, this.mRequestId, this.pqz, this.pqy, this.pqA, this.pqB, this.pqC, this.pqD, this.pqE, this.pqF, this.pqG, this.pqH, this.pqI, this.mIsCanceled, this.VG, this.pqJ, this.pqK, this.pqL);
    }
}
