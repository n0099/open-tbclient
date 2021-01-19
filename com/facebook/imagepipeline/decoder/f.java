package com.facebook.imagepipeline.decoder;

import androidx.appcompat.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements d {
    private final b pzS;

    /* loaded from: classes3.dex */
    public interface b {
        List<Integer> evK();

        int evL();
    }

    /* loaded from: classes3.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> evK() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int evL() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.pzS = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Pm(int i) {
        List<Integer> evK = this.pzS.evK();
        if (evK == null || evK.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < evK.size()) {
                if (evK.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return evK.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h Pn(int i) {
        return com.facebook.imagepipeline.f.g.k(i, i >= this.pzS.evL(), false);
    }
}
