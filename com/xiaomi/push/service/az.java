package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class az implements ServiceConnection {
    final /* synthetic */ ax a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.a = axVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.a) {
            this.a.b = new Messenger(iBinder);
            this.a.f881b = false;
            list = this.a.f879a;
            for (Message message : list) {
                try {
                    messenger = this.a.b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.a.f879a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.b = null;
        this.a.f881b = false;
    }
}
