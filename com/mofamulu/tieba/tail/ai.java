package com.mofamulu.tieba.tail;

import android.content.Intent;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ MoreTailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MoreTailActivity moreTailActivity) {
        this.a = moreTailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.a, FrsActivity.class);
        intent.putExtra("name", "魔法书目录");
        this.a.startActivity(intent);
    }
}
