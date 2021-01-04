package com.facebook.imagepipeline.decoder;

import androidx.appcompat.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.f.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class f implements d {
    private final b pCL;

    /* loaded from: classes5.dex */
    public interface b {
        List<Integer> eza();

        int ezb();
    }

    /* loaded from: classes5.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> eza() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int ezb() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.pCL = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int QC(int i) {
        List<Integer> eza = this.pCL.eza();
        if (eza == null || eza.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < eza.size()) {
                if (eza.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return eza.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h QD(int i) {
        return com.facebook.imagepipeline.f.g.k(i, i >= this.pCL.ezb(), false);
    }
}
