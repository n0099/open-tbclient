package com.mofamulu.tieba.sign;

import android.util.Log;
import android.widget.CompoundButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ad implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MoreSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreSignActivity moreSignActivity) {
        this.a = moreSignActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.sign_more_notif_done) {
            this.a.x.f(z);
        } else if (compoundButton.getId() == R.id.sign_more_try_bouns) {
            this.a.x.c(z);
        } else if (compoundButton.getId() == R.id.sign_more_auto_start) {
            this.a.x.a(z);
        } else if (compoundButton.getId() == R.id.sign_more_zhidao) {
            this.a.x.d(z);
        } else if (compoundButton.getId() == R.id.sign_more_second_channel) {
            this.a.x.g(z);
        } else if (compoundButton.getId() == R.id.sign_more_bind_amx) {
            this.a.x.h(z);
        } else if (compoundButton.getId() == R.id.sign_no_limit) {
            this.a.x.b(z);
        } else {
            Log.e("tbhp_ss", "fatal error. unknown check event for:" + compoundButton);
        }
    }
}
