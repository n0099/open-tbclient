package com.facebook.imagepipeline.decoder;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements d {
    private final b kaV;

    /* loaded from: classes2.dex */
    public interface b {
        List<Integer> cGy();

        int cGz();
    }

    /* loaded from: classes2.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public List<Integer> cGy() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.b
        public int cGz() {
            return 0;
        }
    }

    public f() {
        this(new a());
    }

    public f(b bVar) {
        this.kaV = (b) g.checkNotNull(bVar);
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int Dh(int i) {
        List<Integer> cGy = this.kaV.cGy();
        if (cGy == null || cGy.isEmpty()) {
            return i + 1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < cGy.size()) {
                if (cGy.get(i3).intValue() <= i) {
                    i2 = i3 + 1;
                } else {
                    return cGy.get(i3).intValue();
                }
            } else {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
        }
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public com.facebook.imagepipeline.f.g Di(int i) {
        return com.facebook.imagepipeline.f.f.f(i, i >= this.kaV.cGz(), false);
    }
}
