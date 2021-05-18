package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f30810a;

    /* renamed from: b  reason: collision with root package name */
    public int f30811b;

    /* renamed from: c  reason: collision with root package name */
    public p f30812c;

    public q(p pVar, int i2, String str) {
        super(null);
        this.f30812c = pVar;
        this.f30811b = i2;
        this.f30810a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f30812c;
        if (pVar != null) {
            pVar.a(this.f30811b, this.f30810a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
