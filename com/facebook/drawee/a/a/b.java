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
    private final ImmutableList<com.facebook.imagepipeline.f.a> lIW;
    @Nullable
    private final g lIX;
    private final j<Boolean> lIY;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aS;
        if (aVar.lIZ == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lIZ);
        }
        this.lIW = immutableList;
        if (aVar.lIY == null) {
            aS = k.aS(false);
        } else {
            aS = aVar.lIY;
        }
        this.lIY = aS;
        this.lIX = aVar.lIX;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> dkc() {
        return this.lIW;
    }

    @Nullable
    public g dkd() {
        return this.lIX;
    }

    public static a dke() {
        return new a();
    }

    public j<Boolean> dkf() {
        return this.lIY;
    }

    /* loaded from: classes12.dex */
    public static class a {
        private g lIX;
        private j<Boolean> lIY;
        private List<com.facebook.imagepipeline.f.a> lIZ;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lIZ == null) {
                this.lIZ = new ArrayList();
            }
            this.lIZ.add(aVar);
            return this;
        }

        public b dkg() {
            return new b(this);
        }
    }
}
