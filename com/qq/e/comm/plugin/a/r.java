package com.qq.e.comm.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
class r extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final a f11646a;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public r(a aVar) {
        this.f11646a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        if (this.f11646a == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            GDTLogger.d("连接到运营商网络");
            this.f11646a.b();
        } else if (type == 1 && activeNetworkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) {
            GDTLogger.d("连接到WIFI网络");
            this.f11646a.a();
        }
    }
}
