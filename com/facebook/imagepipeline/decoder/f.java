package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class f implements d {
    private final b lTe;

    /* loaded from: classes10.dex */
    public interface b {
        List<Integer> dpa();

        int dpb();
    }

    /* loaded from: classes10.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dpa() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dpb() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.lTe = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Ic(int i) {
        List<Integer> dpa = this.lTe.dpa();
        if (dpa == null || dpa.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dpa.size()) {
                if (dpa.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dpa.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Id(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.lTe.dpb(), false);
    }
}
