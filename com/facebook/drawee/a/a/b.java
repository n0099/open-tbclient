package com.facebook.drawee.a.a;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b {
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> lLB;
    @Nullable
    private final g lLC;
    private final j<Boolean> lLD;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aU;
        if (aVar.lLE == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lLE);
        }
        this.lLB = immutableList;
        if (aVar.lLD == null) {
            aU = k.aU(false);
        } else {
            aU = aVar.lLD;
        }
        this.lLD = aU;
        this.lLC = aVar.lLC;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> dlR() {
        return this.lLB;
    }

    @Nullable
    public g dlS() {
        return this.lLC;
    }

    public static a dlT() {
        return new a();
    }

    public j<Boolean> dlU() {
        return this.lLD;
    }

    /* loaded from: classes13.dex */
    public static class a {
        private g lLC;
        private j<Boolean> lLD;
        private List<com.facebook.imagepipeline.f.a> lLE;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lLE == null) {
                this.lLE = new ArrayList();
            }
            this.lLE.add(aVar);
            return this;
        }

        public b dlV() {
            return new b(this);
        }
    }
}
