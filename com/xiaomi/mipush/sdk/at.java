package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class at implements ServiceConnection {
    final /* synthetic */ aq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(aq aqVar) {
        this.a = aqVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.a) {
            this.a.f59a = new Messenger(iBinder);
            this.a.c = false;
            list = this.a.f62a;
            for (Message message : list) {
                try {
                    messenger = this.a.f59a;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.a.f62a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.f59a = null;
        this.a.c = false;
    }
}
