package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.h;
import com.ss.android.socialbase.appdownloader.c;
/* loaded from: classes8.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        c.a((Activity) this);
    }

    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void a() {
        if (getIntent() == null) {
            com.ss.android.downloadlib.e.c.a().a("handleIntent is null");
            c.a((Activity) this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            com.ss.android.downloadlib.e.c.a().a("getPackage or id is null");
            c.a((Activity) this);
        }
        boolean z = false;
        int optInt = j.i().optInt(DI.AB_NAME, 0);
        if (optInt == 1) {
            z = true;
        }
        h.a(this, stringExtra, longExtra, z);
        if (optInt != 1) {
            c.a((Activity) this);
        }
    }
}
