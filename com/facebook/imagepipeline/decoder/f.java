package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes15.dex */
public class f implements d {
    private final b oYr;

    /* loaded from: classes15.dex */
    public interface b {
        List<Integer> epL();

        int epM();
    }

    /* loaded from: classes15.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> epL() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int epM() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.oYr = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int PJ(int i) {
        List<Integer> epL = this.oYr.epL();
        if (epL == null || epL.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < epL.size()) {
                if (epL.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return epL.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h PK(int i) {
        return com.facebook.imagepipeline.g.g.k(i, i >= this.oYr.epM(), false);
    }
}
