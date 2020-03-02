package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class f implements d {
    private final b lTN;

    /* loaded from: classes12.dex */
    public interface b {
        List<Integer> dqo();

        int dqp();
    }

    /* loaded from: classes12.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dqo() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dqp() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.lTN = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Ih(int i) {
        List<Integer> dqo = this.lTN.dqo();
        if (dqo == null || dqo.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dqo.size()) {
                if (dqo.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dqo.get(i3).intValue();
                }
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Ii(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.lTN.dqp(), false);
    }
}
