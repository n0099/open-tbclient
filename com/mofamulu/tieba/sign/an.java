package com.mofamulu.tieba.sign;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        ServiceConnection serviceConnection2;
        SignServiceBinder signServiceBinder;
        if (iBinder instanceof SignServiceBinder) {
            SignService.b = (SignServiceBinder) iBinder;
            if (SignService.a != null) {
                am amVar = SignService.a;
                SignService.a = null;
                signServiceBinder = SignService.b;
                signServiceBinder.a(amVar);
                amVar.a();
                return;
            }
            return;
        }
        Log.e("tbhp_ss", "sign service binded to unexpected binder:" + iBinder);
        try {
            serviceConnection = SignService.c;
            if (serviceConnection != null) {
                TiebaApplication f = TiebaApplication.f();
                serviceConnection2 = SignService.c;
                f.unbindService(serviceConnection2);
            }
        } catch (Throwable th) {
        }
        SignService.b = null;
        SignService.c = null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
