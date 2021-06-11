package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes7.dex */
public class bh implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ServiceClient f41785a;

    public bh(ServiceClient serviceClient) {
        this.f41785a = serviceClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f41785a) {
            this.f41785a.f832b = new Messenger(iBinder);
            this.f41785a.f833b = false;
            list = this.f41785a.f830a;
            for (Message message : list) {
                try {
                    messenger = this.f41785a.f832b;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            list2 = this.f41785a.f830a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f41785a.f832b = null;
        this.f41785a.f833b = false;
    }
}
