package com.fun.openid.sdk;

import android.database.ContentObserver;
import android.util.Log;
/* loaded from: classes6.dex */
public class q extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f30630a;

    /* renamed from: b  reason: collision with root package name */
    public int f30631b;

    /* renamed from: c  reason: collision with root package name */
    public p f30632c;

    public q(p pVar, int i, String str) {
        super(null);
        this.f30632c = pVar;
        this.f30631b = i;
        this.f30630a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        p pVar = this.f30632c;
        if (pVar != null) {
            pVar.a(this.f30631b, this.f30630a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
