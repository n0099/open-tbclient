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
    private final ImmutableList<com.facebook.imagepipeline.f.a> lJK;
    @Nullable
    private final g lJL;
    private final j<Boolean> lJM;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aU;
        if (aVar.lJN == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lJN);
        }
        this.lJK = immutableList;
        if (aVar.lJM == null) {
            aU = k.aU(false);
        } else {
            aU = aVar.lJM;
        }
        this.lJM = aU;
        this.lJL = aVar.lJL;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> dlt() {
        return this.lJK;
    }

    @Nullable
    public g dlu() {
        return this.lJL;
    }

    public static a dlv() {
        return new a();
    }

    public j<Boolean> dlw() {
        return this.lJM;
    }

    /* loaded from: classes13.dex */
    public static class a {
        private g lJL;
        private j<Boolean> lJM;
        private List<com.facebook.imagepipeline.f.a> lJN;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lJN == null) {
                this.lJN = new ArrayList();
            }
            this.lJN.add(aVar);
            return this;
        }

        public b dlx() {
            return new b(this);
        }
    }
}
