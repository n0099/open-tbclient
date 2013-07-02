package com.mofamulu.tieba.map;

import android.location.LocationListener;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Handler.Callback {
    final /* synthetic */ FreeLocationService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FreeLocationService freeLocationService) {
        this.a = freeLocationService;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        switch (message.what) {
            case 1:
                this.a.j();
                return false;
            case 5:
                this.a.l();
                this.a.m = "定位服务连接超时";
                this.a.j();
                return false;
            case 10:
                this.a.l();
                this.a.m = "定位服务连接超时";
                return false;
            case 15:
                try {
                    if (this.a.b != null) {
                        LocationListener locationListener = this.a.b;
                        str = this.a.k;
                        locationListener.onProviderDisabled(str);
                        return false;
                    }
                    return false;
                } catch (Throwable th) {
                    return false;
                }
            default:
                return false;
        }
    }
}
