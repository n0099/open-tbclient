package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class m extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40861a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PBSplash pBSplash, Looper looper) {
        super(looper);
        this.f40861a = pBSplash;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        PBSplash pBSplash;
        PBSplashListener pBSplashListener;
        if (message.what != 0 || (pBSplashListener = (pBSplash = this.f40861a).f40689e) == null || pBSplash.f40693i) {
            return;
        }
        pBSplashListener.onFail(PBError.LOAD_TIME_OUT);
        this.f40861a.j = true;
    }
}
