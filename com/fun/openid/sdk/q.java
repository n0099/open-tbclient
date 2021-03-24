package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f30861a;

    /* renamed from: b  reason: collision with root package name */
    public int f30862b;

    /* renamed from: c  reason: collision with root package name */
    public p f30863c;

    public q(p pVar, int i, String str) {
        super(null);
        this.f30863c = pVar;
        this.f30862b = i;
        this.f30861a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f30863c;
        if (pVar != null) {
            pVar.a(this.f30862b, this.f30861a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
