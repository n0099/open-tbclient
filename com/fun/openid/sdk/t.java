package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes3.dex */
public class t extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f5253a;
    public int b;
    public r pRm;

    public t(r rVar, int i, String str) {
        super(null);
        this.pRm = rVar;
        this.b = i;
        this.f5253a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        r rVar = this.pRm;
        if (rVar != null) {
            rVar.a(this.b, this.f5253a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
