package com.facebook.drawee.a.a.a;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class h {
    private boolean UO;
    private boolean mIsCanceled;
    @Nullable
    private String mRequestId;
    @Nullable
    private String oOC;
    @Nullable
    private Object oOE;
    @Nullable
    private ImageRequest oOF;
    @Nullable
    private com.facebook.imagepipeline.g.f oOG;
    private boolean oOP;
    private long oOH = -1;
    private long oOI = -1;
    private long oOJ = -1;
    private long oOK = -1;
    private long oOL = -1;
    private long oOM = -1;
    private long oON = -1;
    private int oOO = -1;
    private int oOQ = -1;
    private int oOR = -1;
    private int oPa = -1;

    public void reset() {
        this.mRequestId = null;
        this.oOF = null;
        this.oOE = null;
        this.oOG = null;
        this.oOH = -1L;
        this.oOJ = -1L;
        this.oOK = -1L;
        this.oOL = -1L;
        this.oOM = -1L;
        this.oON = -1L;
        this.oOO = -1;
        this.mIsCanceled = false;
        this.UO = false;
        this.oOP = false;
        this.oOQ = -1;
        this.oOR = -1;
        this.oPa = -1;
    }

    public void OZ(int i) {
        this.oPa = i;
    }

    public int eli() {
        return this.oPa;
    }

    public void XR(@Nullable String str) {
        this.oOC = str;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.oOF = imageRequest;
    }

    public void bl(@Nullable Object obj) {
        this.oOE = obj;
    }

    public void hH(long j) {
        this.oOH = j;
    }

    public void hI(long j) {
        this.oOI = j;
    }

    public void hJ(long j) {
        this.oOJ = j;
    }

    public void hK(long j) {
        this.oOK = j;
    }

    public void hL(long j) {
        this.oOL = j;
    }

    public void hM(long j) {
        this.oOM = j;
    }

    public void hN(long j) {
        this.oON = j;
    }

    public void Pa(int i) {
        this.oOO = i;
    }

    public void Ag(boolean z) {
        this.mIsCanceled = z;
    }

    public void Ah(boolean z) {
        this.UO = z;
    }

    public void Ai(boolean z) {
        this.oOP = z;
    }

    public void a(@Nullable com.facebook.imagepipeline.g.f fVar) {
        this.oOG = fVar;
    }

    public void Pb(int i) {
        this.oOQ = i;
    }

    public void Pc(int i) {
        this.oOR = i;
    }

    public e elj() {
        return new e(this.oOC, this.mRequestId, this.oOF, this.oOE, this.oOG, this.oOH, this.oOI, this.oOJ, this.oOK, this.oOL, this.oOM, this.oON, this.oOO, this.mIsCanceled, this.UO, this.oOP, this.oOQ, this.oOR);
    }
}
