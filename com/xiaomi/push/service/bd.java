package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class bd implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f8539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.f8539a = bbVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f8539a) {
            this.f8539a.b = new Messenger(iBinder);
            this.f8539a.f882b = false;
            list = this.f8539a.f880a;
            for (Message message : list) {
                try {
                    messenger = this.f8539a.b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f8539a.f880a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f8539a.b = null;
        this.f8539a.f882b = false;
    }
}
