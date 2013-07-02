package com.mofamulu.tieba.tail;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ MoreTailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MoreTailActivity moreTailActivity) {
        this.a = moreTailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(R.id.tail_client_from_container);
    }
}
