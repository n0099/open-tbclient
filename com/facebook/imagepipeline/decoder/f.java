package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b klF;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> cKK();

        int cKL();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> cKK() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int cKL() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.klF = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int DU(int i) {
        List<Integer> cKK = this.klF.cKK();
        if (cKK == null || cKK.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < cKK.size()) {
                if (cKK.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return cKK.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g DV(int i) {
        return com.facebook.imagepipeline.f.f.g(i, i >= this.klF.cKL(), false);
    }
}
