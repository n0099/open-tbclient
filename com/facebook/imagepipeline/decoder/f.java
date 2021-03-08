package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements d {
    private final b pMF;

    /* loaded from: classes5.dex */
    public interface b {
        List<Integer> eyu();

        int eyv();
    }

    /* loaded from: classes5.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> eyu() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int eyv() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.pMF = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int PM(int i) {
        List<Integer> eyu = this.pMF.eyu();
        if (eyu == null || eyu.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < eyu.size()) {
                if (eyu.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return eyu.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h PN(int i) {
        return com.facebook.imagepipeline.f.g.k(i, i >= this.pMF.eyv(), false);
    }
}
