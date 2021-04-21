package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class I extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J f40062a;

    public I(J j, L l) {
        this.f40062a = j;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f40062a.a(message);
    }
}
