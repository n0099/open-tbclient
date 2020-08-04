package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements d {
    private final b ncH;

    /* loaded from: classes4.dex */
    public interface b {
        List<Integer> dIh();

        int dIi();
    }

    /* loaded from: classes4.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dIh() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dIi() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.ncH = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Jf(int i) {
        List<Integer> dIh = this.ncH.dIh();
        if (dIh == null || dIh.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dIh.size()) {
                if (dIh.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dIh.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Jg(int i) {
        return com.facebook.imagepipeline.g.g.i(i, i >= this.ncH.dIi(), false);
    }
}
