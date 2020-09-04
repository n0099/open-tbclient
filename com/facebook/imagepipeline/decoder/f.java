package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class f implements d {
    private final b nwP;

    /* loaded from: classes8.dex */
    public interface b {
        List<Integer> dUp();

        int dUq();
    }

    /* loaded from: classes8.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> dUp() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int dUq() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.nwP = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int LJ(int i) {
        List<Integer> dUp = this.nwP.dUp();
        if (dUp == null || dUp.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < dUp.size()) {
                if (dUp.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return dUp.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h LK(int i) {
        return com.facebook.imagepipeline.g.g.j(i, i >= this.nwP.dUq(), false);
    }
}
