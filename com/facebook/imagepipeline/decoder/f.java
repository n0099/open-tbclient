package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes18.dex */
public class f implements d {
    private final b oWO;

    /* loaded from: classes18.dex */
    public interface b {
        List<Integer> epN();

        int epO();
    }

    /* loaded from: classes18.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> epN() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int epO() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.oWO = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Pg(int i) {
        List<Integer> epN = this.oWO.epN();
        if (epN == null || epN.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < epN.size()) {
                if (epN.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return epN.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Ph(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.oWO.epO(), false);
    }
}
