package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class f implements d {
    private final b mxk;

    /* loaded from: classes12.dex */
    public interface b {
        List<Integer> dAa();

        int dAb();
    }

    /* loaded from: classes12.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dAa() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dAb() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.mxk = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int HB(int i) {
        List<Integer> dAa = this.mxk.dAa();
        if (dAa == null || dAa.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dAa.size()) {
                if (dAa.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dAa.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h HC(int i) {
        return com.facebook.imagepipeline.g.g.i(i, i >= this.mxk.dAb(), false);
    }
}
