package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f30862a;

    /* renamed from: b  reason: collision with root package name */
    public int f30863b;

    /* renamed from: c  reason: collision with root package name */
    public p f30864c;

    public q(p pVar, int i, String str) {
        super(null);
        this.f30864c = pVar;
        this.f30863b = i;
        this.f30862a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f30864c;
        if (pVar != null) {
            pVar.a(this.f30863b, this.f30862a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
