package com.mofamulu.tieba.tail;

import android.util.Log;
import android.widget.CompoundButton;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class ad implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ MoreTailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MoreTailActivity moreTailActivity) {
        this.a = moreTailActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getId() == R.id.tail_active) {
            this.a.v.i(z);
        } else if (compoundButton.getId() == R.id.tail_active_in_lzl) {
            this.a.v.j(z);
        } else {
            Log.e("tbhp_t", "fatal error. unknown check event for:" + compoundButton);
        }
    }
}
