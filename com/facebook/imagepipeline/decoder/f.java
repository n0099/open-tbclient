package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes25.dex */
public class f implements d {
    private final b nGM;

    /* loaded from: classes25.dex */
    public interface b {
        List<Integer> dYn();

        int dYo();
    }

    /* loaded from: classes25.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dYn() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dYo() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.nGM = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Mo(int i) {
        List<Integer> dYn = this.nGM.dYn();
        if (dYn == null || dYn.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dYn.size()) {
                if (dYn.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dYn.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Mp(int i) {
        return com.facebook.imagepipeline.g.g.j(i, i >= this.nGM.dYo(), false);
    }
}
