package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes14.dex */
public class bi implements com.fun.openid.sdk.c {
    public final /* synthetic */ bl qld;

    public bi(bl blVar) {
        this.qld = blVar;
    }

    @Override // com.fun.openid.sdk.c
    public void bc(String str) {
        Context context;
        if (!TextUtils.isEmpty(bl.c) || TextUtils.isEmpty(str) || (context = this.qld.f8118a) == null) {
            return;
        }
        bl.c = str;
        bp.g(context, str);
    }
}
