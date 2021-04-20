package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f30535a;

    /* renamed from: b  reason: collision with root package name */
    public int f30536b;

    /* renamed from: c  reason: collision with root package name */
    public p f30537c;

    public q(p pVar, int i, String str) {
        super(null);
        this.f30537c = pVar;
        this.f30536b = i;
        this.f30535a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f30537c;
        if (pVar != null) {
            pVar.a(this.f30536b, this.f30535a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
