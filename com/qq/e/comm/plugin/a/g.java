package com.qq.e.comm.plugin.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final a f11917a;

    /* loaded from: classes3.dex */
    interface a {
        void c(String str);
    }

    public g(a aVar) {
        this.f11917a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
            String dataString = intent.getDataString();
            if (dataString != null && dataString.startsWith("package:")) {
                dataString = dataString.substring("package:".length());
            }
            GDTLogger.d("App被安装，包名: " + dataString);
            if (this.f11917a != null) {
                this.f11917a.c(dataString);
            }
        }
    }
}
