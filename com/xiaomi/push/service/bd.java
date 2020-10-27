package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class bd implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f5074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.f5074a = bbVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f5074a) {
            this.f5074a.b = new Messenger(iBinder);
            this.f5074a.f880b = false;
            list = this.f5074a.f878a;
            for (Message message : list) {
                try {
                    messenger = this.f5074a.b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f5074a.f878a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f5074a.b = null;
        this.f5074a.f880b = false;
    }
}
