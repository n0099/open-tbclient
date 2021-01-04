package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bd implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f14567a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar) {
        this.f14567a = bbVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f14567a) {
            this.f14567a.f14565b = new Messenger(iBinder);
            this.f14567a.f961b = false;
            list = this.f14567a.f959a;
            for (Message message : list) {
                try {
                    messenger = this.f14567a.f14565b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f14567a.f959a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f14567a.f14565b = null;
        this.f14567a.f961b = false;
    }
}
