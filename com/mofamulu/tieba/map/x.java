package com.mofamulu.tieba.map;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.av;
import com.baidu.tieba.nearby.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ FreeNearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FreeNearbyPostActivity freeNearbyPostActivity) {
        this.a = freeNearbyPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        aq aqVar;
        av avVar;
        aqVar = this.a.d;
        switch (aqVar.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                avVar = this.a.b;
                if (avVar.c().f() != 0) {
                    this.a.a(1, null, true);
                    return;
                } else {
                    this.a.a(this.a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
