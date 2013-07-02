package com.mofamulu.tieba.tail;

import android.view.View;
import android.widget.Toast;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ MoreOthersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreOthersActivity moreOthersActivity) {
        this.a = moreOthersActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            com.mofamulu.tieba.ch.au.a(this.a, "http://book.mofamulu.com/api/android/new_version.jsp?v=" + this.a.getString(R.string.tbhp_version_num));
        } catch (Exception e) {
            Toast.makeText(this.a, "打开浏览器失败！", 1);
        }
    }
}
