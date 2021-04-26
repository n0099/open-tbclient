package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f31565a;

    /* renamed from: b  reason: collision with root package name */
    public int f31566b;

    /* renamed from: c  reason: collision with root package name */
    public p f31567c;

    public q(p pVar, int i2, String str) {
        super(null);
        this.f31567c = pVar;
        this.f31566b = i2;
        this.f31565a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f31567c;
        if (pVar != null) {
            pVar.a(this.f31566b, this.f31565a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
