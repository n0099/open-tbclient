package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class f implements d {
    private final b lTL;

    /* loaded from: classes12.dex */
    public interface b {
        List<Integer> dqm();

        int dqn();
    }

    /* loaded from: classes12.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dqm() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dqn() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.lTL = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Ih(int i) {
        List<Integer> dqm = this.lTL.dqm();
        if (dqm == null || dqm.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dqm.size()) {
                if (dqm.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dqm.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Ii(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.lTL.dqn(), false);
    }
}
