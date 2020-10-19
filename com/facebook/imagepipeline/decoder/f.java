package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.g.h;
import java.util.Collections;
import java.util.List;
/* loaded from: classes18.dex */
public class f implements d {
    private final b nWd;

    /* loaded from: classes18.dex */
    public interface b {
        List<Integer> ebY();

        int ebZ();
    }

    /* loaded from: classes18.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> ebY() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int ebZ() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.nWd = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int MU(int i) {
        List<Integer> ebY = this.nWd.ebY();
        if (ebY == null || ebY.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < ebY.size()) {
                if (ebY.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return ebY.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public h MV(int i) {
        return com.facebook.imagepipeline.g.g.j(i, i >= this.nWd.ebZ(), false);
    }
}
