package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class f implements d {
    private final b lSZ;

    /* loaded from: classes10.dex */
    public interface b {
        List<Integer> doY();

        int doZ();
    }

    /* loaded from: classes10.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> doY() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int doZ() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.lSZ = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Ic(int i) {
        List<Integer> doY = this.lSZ.doY();
        if (doY == null || doY.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < doY.size()) {
                if (doY.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return doY.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Id(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.lSZ.doZ(), false);
    }
}
