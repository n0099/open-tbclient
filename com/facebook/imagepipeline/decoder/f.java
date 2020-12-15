package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes15.dex */
public class f implements d {
    private final b pni;

    /* loaded from: classes15.dex */
    public interface b {
        List<Integer> evr();

        int evs();
    }

    /* loaded from: classes15.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> evr() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int evs() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.pni = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int QF(int i) {
        List<Integer> evr = this.pni.evr();
        if (evr == null || evr.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < evr.size()) {
                if (evr.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return evr.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h QG(int i) {
        return com.facebook.imagepipeline.f.g.k(i, i >= this.pni.evs(), false);
    }
}
