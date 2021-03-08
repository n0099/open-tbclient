package com.vivo.push.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.vivo.push.sdk.a;
import com.vivo.push.util.p;
/* loaded from: classes14.dex */
public class CommandService extends Service {
    @Override // android.app.Service
    public void onCreate() {
        p.c("CommandService", getClass().getSimpleName() + " -- oncreate " + getPackageName());
        super.onCreate();
        a.a().a(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf();
        } else if (!a(intent.getAction())) {
            p.a("CommandService", getPackageName() + " receive invalid action " + intent.getAction());
            stopSelf();
        } else {
            try {
                String stringExtra = intent.getStringExtra("command_type");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
                    a.a().a(intent);
                }
            } catch (Exception e) {
                p.a("CommandService", "onStartCommand -- error", e);
            }
            stopSelf();
        }
        return 2;
    }

    protected boolean a(String str) {
        return "com.vivo.pushservice.action.RECEIVE".equals(str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        p.c("CommandService", "onBind initSuc: ");
        return null;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
