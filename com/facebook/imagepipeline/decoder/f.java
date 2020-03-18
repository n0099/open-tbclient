package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class f implements d {
    private final b lVE;

    /* loaded from: classes12.dex */
    public interface b {
        List<Integer> dqM();

        int dqN();
    }

    /* loaded from: classes12.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dqM() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dqN() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.lVE = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int In(int i) {
        List<Integer> dqM = this.lVE.dqM();
        if (dqM == null || dqM.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dqM.size()) {
                if (dqM.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dqM.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Io(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.lVE.dqN(), false);
    }
}
