package com.mofamulu.tieba.dslv.lock;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.aa;
/* loaded from: classes.dex */
public class UnLockFailedActivity extends aa {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tbhp_other_unlock_failed);
        b();
    }

    protected void b() {
        ((TextView) findViewById(R.id.psw_unlock_cancelled_tips)).setText(getResources().getString(R.string.psw_unlock_cancelled_tips, Integer.valueOf(getIntent().getIntExtra(LockPatternActivity.c, 0))));
    }
}
