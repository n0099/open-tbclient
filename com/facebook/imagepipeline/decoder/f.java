package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class f implements d {
    private final b myu;

    /* loaded from: classes12.dex */
    public interface b {
        List<Integer> dAo();

        int dAp();
    }

    /* loaded from: classes12.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dAo() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dAp() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.myu = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int HD(int i) {
        List<Integer> dAo = this.myu.dAo();
        if (dAo == null || dAo.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dAo.size()) {
                if (dAo.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dAo.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h HE(int i) {
        return com.facebook.imagepipeline.g.g.i(i, i >= this.myu.dAp(), false);
    }
}
