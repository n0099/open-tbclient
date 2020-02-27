package com.kascend.cstvsdk.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.kascend.chushou.b;
import com.kascend.chushou.b.a.a.j;
import kotlin.TypeCastException;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public final class CSTVWifiReceiver extends BroadcastReceiver {
    public static final a a = new a(null);

    @h
    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        q.j(context, "context");
        q.j(intent, "intent");
        if (q.h("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
            Object systemService = context.getSystemService("connectivity");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            boolean z = b.dBL().a;
            boolean z2 = b.dBL().b;
            if (networkInfo != null) {
                b.dBL().a = q.h(networkInfo.getState(), NetworkInfo.State.CONNECTED);
            }
            if (networkInfo2 != null) {
                b.dBL().b = q.h(networkInfo2.getState(), NetworkInfo.State.CONNECTED);
            }
            com.kascend.cstvsdk.utils.a.nkk.a(b.dBL().b ? 1 : 2);
            if (z != b.dBL().a || z2 != b.dBL().b) {
                if (b.dBL().a) {
                    com.kascend.chushou.toolkit.d.a.dEl().b();
                }
                tv.chushou.zues.a.a.post(new j(1));
            }
        }
    }
}
