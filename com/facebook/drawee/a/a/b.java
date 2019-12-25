package com.facebook.drawee.a.a;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class b {
    private final j<Boolean> lFA;
    @Nullable
    private final ImmutableList<com.facebook.imagepipeline.f.a> lFy;
    @Nullable
    private final g lFz;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aS;
        if (aVar.lFB == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lFB);
        }
        this.lFy = immutableList;
        if (aVar.lFA == null) {
            aS = k.aS(false);
        } else {
            aS = aVar.lFA;
        }
        this.lFA = aS;
        this.lFz = aVar.lFz;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> djb() {
        return this.lFy;
    }

    @Nullable
    public g djc() {
        return this.lFz;
    }

    public static a djd() {
        return new a();
    }

    public j<Boolean> dje() {
        return this.lFA;
    }

    /* loaded from: classes11.dex */
    public static class a {
        private j<Boolean> lFA;
        private List<com.facebook.imagepipeline.f.a> lFB;
        private g lFz;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lFB == null) {
                this.lFB = new ArrayList();
            }
            this.lFB.add(aVar);
            return this;
        }

        public b djf() {
            return new b(this);
        }
    }
}
