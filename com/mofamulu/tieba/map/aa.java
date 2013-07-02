package com.mofamulu.tieba.map;

import android.view.View;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.a.d {
    final /* synthetic */ FreeNearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FreeNearbyPostActivity freeNearbyPostActivity) {
        this.a = freeNearbyPostActivity;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        ListView listView;
        ListView listView2;
        if (bVar != null) {
            listView = this.a.c;
            if (listView != null) {
                listView2 = this.a.c;
                View findViewWithTag = listView2.findViewWithTag(str);
                if (findViewWithTag != null) {
                    findViewWithTag.invalidate();
                }
            }
        }
    }
}
