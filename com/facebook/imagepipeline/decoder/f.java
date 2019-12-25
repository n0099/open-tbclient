package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements d {
    private final b lPn;

    /* loaded from: classes9.dex */
    public interface b {
        List<Integer> dnS();

        int dnT();
    }

    /* loaded from: classes9.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dnS() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dnT() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.lPn = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int HT(int i) {
        List<Integer> dnS = this.lPn.dnS();
        if (dnS == null || dnS.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dnS.size()) {
                if (dnS.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dnS.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h HU(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.lPn.dnT(), false);
    }
}
