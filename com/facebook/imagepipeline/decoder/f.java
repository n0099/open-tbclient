package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements d {
    private final b pKA;

    /* loaded from: classes5.dex */
    public interface b {
        List<Integer> eyl();

        int eym();
    }

    /* loaded from: classes5.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> eyl() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int eym() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.pKA = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int PI(int i) {
        List<Integer> eyl = this.pKA.eyl();
        if (eyl == null || eyl.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < eyl.size()) {
                if (eyl.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return eyl.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h PJ(int i) {
        return com.facebook.imagepipeline.f.g.k(i, i >= this.pKA.eym(), false);
    }
}
