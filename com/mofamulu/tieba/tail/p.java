package com.mofamulu.tieba.tail;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ MoreMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MoreMapActivity moreMapActivity) {
        this.a = moreMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.showDialog(R.id.map_op_posts_refresh_container);
    }
}
