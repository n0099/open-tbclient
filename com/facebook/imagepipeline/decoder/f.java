package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b kjR;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> cHH();

        int cHI();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> cHH() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int cHI() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.kjR = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Cq(int i) {
        List<Integer> cHH = this.kjR.cHH();
        if (cHH == null || cHH.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < cHH.size()) {
                if (cHH.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return cHH.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g Cr(int i) {
        return com.facebook.imagepipeline.f.f.g(i, i >= this.kjR.cHI(), false);
    }
}
