package com.mofamulu.tieba.ch;

import android.view.View;
import android.widget.Toast;
/* loaded from: classes.dex */
class aj implements View.OnClickListener {
    final /* synthetic */ MoreNickActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MoreNickActivity moreNickActivity) {
        this.a = moreNickActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (as.a()) {
            Toast.makeText(this.a, "成功：本机缓存的称呼已经全部清空。", 1).show();
        } else {
            Toast.makeText(this.a, "失败：清除缓存失败，请稍候重试。", 1).show();
        }
    }
}
