package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b irH;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> bYI();

        int bYJ();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> bYI() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int bYJ() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.irH = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int yy(int i) {
        List<Integer> bYI = this.irH.bYI();
        if (bYI == null || bYI.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < bYI.size()) {
                if (bYI.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return bYI.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g yz(int i) {
        return com.facebook.imagepipeline.f.f.e(i, i >= this.irH.bYJ(), false);
    }
}
