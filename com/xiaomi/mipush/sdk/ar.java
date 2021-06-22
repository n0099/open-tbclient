package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes7.dex */
public class ar implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f41026a;

    public ar(an anVar) {
        this.f41026a = anVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f41026a) {
            this.f41026a.f67a = new Messenger(iBinder);
            this.f41026a.f41021c = false;
            list = this.f41026a.f70a;
            for (Message message : list) {
                try {
                    messenger = this.f41026a.f67a;
                    messenger.send(message);
                } catch (RemoteException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            list2 = this.f41026a.f70a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f41026a.f67a = null;
        this.f41026a.f41021c = false;
    }
}
