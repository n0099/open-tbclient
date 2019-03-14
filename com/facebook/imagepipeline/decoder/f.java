package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b jIJ;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> cyI();

        int cyJ();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> cyI() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int cyJ() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.jIJ = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Cn(int i) {
        List<Integer> cyI = this.jIJ.cyI();
        if (cyI == null || cyI.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < cyI.size()) {
                if (cyI.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return cyI.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g Co(int i) {
        return com.facebook.imagepipeline.f.f.f(i, i >= this.jIJ.cyJ(), false);
    }
}
