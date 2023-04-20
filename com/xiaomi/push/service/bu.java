package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes9.dex */
public class bu implements ServiceConnection {
    public final /* synthetic */ ServiceClient a;

    public bu(ServiceClient serviceClient) {
        this.a = serviceClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.a) {
            this.a.f838b = new Messenger(iBinder);
            this.a.f839b = false;
            list = this.a.f836a;
            for (Message message : list) {
                try {
                    messenger = this.a.f838b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.a.f836a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f838b = null;
        this.a.f839b = false;
    }
}
