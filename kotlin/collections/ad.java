package kotlin.collections;

import android.support.v7.widget.ActivityChooserView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ad extends ac {
    public static final int yB(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (i / 3) + i;
        }
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }
}
