package com.ss.android.downloadlib.activity;

import android.text.TextUtils;
import d.p.a.d.f.n;
import d.p.a.d.n.h;
import d.p.a.e.a.d;
/* loaded from: classes6.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void a() {
        if (getIntent() == null) {
            d.q(this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            d.q(this);
        }
        int optInt = n.s().optInt("ab", 0);
        h.h(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            d.q(this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        d.q(this);
    }
}
