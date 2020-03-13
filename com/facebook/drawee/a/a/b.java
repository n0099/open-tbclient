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
    private final ImmutableList<com.facebook.imagepipeline.f.a> lJV;
    @Nullable
    private final g lJW;
    private final j<Boolean> lJX;

    private b(a aVar) {
        ImmutableList<com.facebook.imagepipeline.f.a> immutableList;
        j<Boolean> aU;
        if (aVar.lJY == null) {
            immutableList = null;
        } else {
            immutableList = ImmutableList.copyOf(aVar.lJY);
        }
        this.lJV = immutableList;
        if (aVar.lJX == null) {
            aU = k.aU(false);
        } else {
            aU = aVar.lJX;
        }
        this.lJX = aU;
        this.lJW = aVar.lJW;
    }

    @Nullable
    public ImmutableList<com.facebook.imagepipeline.f.a> dlu() {
        return this.lJV;
    }

    @Nullable
    public g dlv() {
        return this.lJW;
    }

    public static a dlw() {
        return new a();
    }

    public j<Boolean> dlx() {
        return this.lJX;
    }

    /* loaded from: classes13.dex */
    public static class a {
        private g lJW;
        private j<Boolean> lJX;
        private List<com.facebook.imagepipeline.f.a> lJY;

        public a a(com.facebook.imagepipeline.f.a aVar) {
            if (this.lJY == null) {
                this.lJY = new ArrayList();
            }
            this.lJY.add(aVar);
            return this;
        }

        public b dly() {
            return new b(this);
        }
    }
}
