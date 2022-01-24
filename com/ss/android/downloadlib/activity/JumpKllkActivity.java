package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.g.h;
/* loaded from: classes4.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void a() {
        if (getIntent() == null) {
            c.a().a("handleIntent is null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            c.a().a("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
        int optInt = j.i().optInt("ab", 0);
        h.a(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.c.a((Activity) this);
    }
}
