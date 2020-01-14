package com.facebook.drawee.a.a;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b {
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> lJb;
    @Nullable
    private final g lJc;
    private final j<Boolean> lJd;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aS;
        if (aVar.lJe == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lJe);
        }
        this.lJb = immutableList;
        if (aVar.lJd == null) {
            aS = k.aS(false);
        } else {
            aS = aVar.lJd;
        }
        this.lJd = aS;
        this.lJc = aVar.lJc;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> dke() {
        return this.lJb;
    }

    @Nullable
    public g dkf() {
        return this.lJc;
    }

    public static a dkg() {
        return new a();
    }

    public j<Boolean> dkh() {
        return this.lJd;
    }

    /* loaded from: classes12.dex */
    public static class a {
        private g lJc;
        private j<Boolean> lJd;
        private List<com.facebook.imagepipeline.f.a> lJe;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lJe == null) {
                this.lJe = new ArrayList();
            }
            this.lJe.add(aVar);
            return this;
        }

        public b dki() {
            return new b(this);
        }
    }
}
