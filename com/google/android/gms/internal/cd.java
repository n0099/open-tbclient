package com.google.android.gms.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.ca;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
/* loaded from: classes.dex */
public class cd {
    private final ch a;
    private HashMap b;

    /* loaded from: classes.dex */
    class a extends Handler {
        private final LocationListener a;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.a(new Location((Location) message.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends ca.a {
        private final Handler a;

        @Override // com.google.android.gms.internal.ca
        public void a(Location location) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.a.sendMessage(obtain);
        }
    }

    public void a() {
        try {
            synchronized (this.b) {
                for (b bVar : this.b.values()) {
                    if (bVar != null) {
                        ((cc) this.a.b()).a(bVar);
                    }
                }
                this.b.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
