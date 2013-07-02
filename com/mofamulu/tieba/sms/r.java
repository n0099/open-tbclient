package com.mofamulu.tieba.sms;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ SMSOutlineActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SMSOutlineActivity sMSOutlineActivity) {
        this.a = sMSOutlineActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.j.setFocusable(false);
        this.a.j.setClickable(false);
        this.a.k.setVisibility(0);
        ((TextView) this.a.j.findViewById(R.id.more)).setText(this.a.getString(R.string.loading));
        this.a.l.a(this.a.n);
    }
}
