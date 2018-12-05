package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b iox;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> bXS();

        int bXT();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> bXS() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int bXT() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.iox = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int yl(int i) {
        List<Integer> bXS = this.iox.bXS();
        if (bXS == null || bXS.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < bXS.size()) {
                if (bXS.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return bXS.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g ym(int i) {
        return com.facebook.imagepipeline.f.f.e(i, i >= this.iox.bXT(), false);
    }
}
