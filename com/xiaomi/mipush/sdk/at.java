package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class at implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f4528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(aq aqVar) {
        this.f4528a = aqVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f4528a) {
            this.f4528a.f54a = new Messenger(iBinder);
            this.f4528a.c = false;
            list = this.f4528a.f57a;
            for (Message message : list) {
                try {
                    messenger = this.f4528a.f54a;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f4528a.f57a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4528a.f54a = null;
        this.f4528a.c = false;
    }
}
