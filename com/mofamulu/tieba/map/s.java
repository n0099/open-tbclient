package com.mofamulu.tieba.map;

import android.content.DialogInterface;
import com.baidu.tieba.write.bb;
/* loaded from: classes.dex */
class s implements DialogInterface.OnClickListener {
    final /* synthetic */ FreeNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FreeNearbyActivity freeNearbyActivity) {
        this.a = freeNearbyActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bb.a(this.a);
        } else if (i == 1) {
            bb.b(this.a);
        }
    }
}
