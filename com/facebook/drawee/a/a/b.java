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
    private final ImmutableList<com.facebook.imagepipeline.f.a> lJI;
    @Nullable
    private final g lJJ;
    private final j<Boolean> lJK;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aU;
        if (aVar.lJL == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lJL);
        }
        this.lJI = immutableList;
        if (aVar.lJK == null) {
            aU = k.aU(false);
        } else {
            aU = aVar.lJK;
        }
        this.lJK = aU;
        this.lJJ = aVar.lJJ;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> dlr() {
        return this.lJI;
    }

    @Nullable
    public g dls() {
        return this.lJJ;
    }

    public static a dlt() {
        return new a();
    }

    public j<Boolean> dlu() {
        return this.lJK;
    }

    /* loaded from: classes13.dex */
    public static class a {
        private g lJJ;
        private j<Boolean> lJK;
        private List<com.facebook.imagepipeline.f.a> lJL;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lJL == null) {
                this.lJL = new ArrayList();
            }
            this.lJL.add(aVar);
            return this;
        }

        public b dlv() {
            return new b(this);
        }
    }
}
