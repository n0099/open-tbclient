package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
/* loaded from: classes.dex */
class SmoothScrollToPosition22 implements BackwardSupportUtil.SmoothScrollFactory.IScroll {
    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScroll(ListView listView) {
        if (listView.getFirstVisiblePosition() > 10) {
            listView.setSelection(10);
        }
        listView.smoothScrollToPosition(0);
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScroll(ListView listView, int i) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
            listView.setSelection(i + 10);
        } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
            listView.setSelection(i - 10);
        }
        listView.smoothScrollToPosition(i);
    }
}
