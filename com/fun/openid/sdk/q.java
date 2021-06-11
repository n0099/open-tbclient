package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f30830a;

    /* renamed from: b  reason: collision with root package name */
    public int f30831b;

    /* renamed from: c  reason: collision with root package name */
    public p f30832c;

    public q(p pVar, int i2, String str) {
        super(null);
        this.f30832c = pVar;
        this.f30831b = i2;
        this.f30830a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f30832c;
        if (pVar != null) {
            pVar.a(this.f30831b, this.f30830a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
