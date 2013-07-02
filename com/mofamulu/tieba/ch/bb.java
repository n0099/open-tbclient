package com.mofamulu.tieba.ch;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.baidu.tieba.TiebaApplication;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder instanceof NickBinder) {
            NickService.b = (NickBinder) iBinder;
            Iterator it = NickService.c.iterator();
            while (it.hasNext()) {
                bc bcVar = (bc) it.next();
                if (NickService.b != null) {
                    NickService.b.a(bcVar.a, bcVar.b);
                }
            }
            try {
                if (NickService.b != null) {
                    NickService.b.a(bg.a());
                }
            } catch (Throwable th) {
            }
        } else {
            Log.e("tbhp_ns", "nick service binded to unexpected binder:" + iBinder);
            try {
                if (NickService.a != null) {
                    TiebaApplication.f().unbindService(NickService.a);
                }
            } catch (Throwable th2) {
            }
            NickService.b = null;
            NickService.a = null;
        }
        NickService.c.clear();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
