package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
/* loaded from: classes.dex */
class SmoothScrollToPosition21below implements BackwardSupportUtil.SmoothScrollFactory.IScroll {
    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScroll(ListView listView) {
        listView.setSelection(0);
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScroll(ListView listView, int i) {
        listView.setSelection(i);
    }
}
