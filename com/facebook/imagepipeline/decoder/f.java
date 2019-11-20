package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b kja;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> cHF();

        int cHG();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> cHF() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int cHG() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.kja = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Cp(int i) {
        List<Integer> cHF = this.kja.cHF();
        if (cHF == null || cHF.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < cHF.size()) {
                if (cHF.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return cHF.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g Cq(int i) {
        return com.facebook.imagepipeline.f.f.g(i, i >= this.kja.cHG(), false);
    }
}
