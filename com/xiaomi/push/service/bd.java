package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class bd implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f4846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.f4846a = bbVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f4846a) {
            this.f4846a.b = new Messenger(iBinder);
            this.f4846a.f883b = false;
            list = this.f4846a.f881a;
            for (Message message : list) {
                try {
                    messenger = this.f4846a.b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f4846a.f881a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4846a.b = null;
        this.f4846a.f883b = false;
    }
}
