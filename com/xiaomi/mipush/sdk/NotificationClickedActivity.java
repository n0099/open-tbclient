package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes7.dex */
public final class NotificationClickedActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f40897a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f54a;

    private void a(Intent intent) {
        if (intent != null) {
            try {
                Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
                if (intent2 != null) {
                    intent2.putExtra("is_clicked_activity_call", true);
                    com.xiaomi.channel.commonutils.logger.b.b("clicked activity start service.");
                    startService(intent2);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = BadgeDrawable.TOP_START;
        window.setAttributes(attributes);
        Handler handler = new Handler();
        this.f54a = handler;
        handler.postDelayed(new ab(this), 3000L);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_clicked_activity_finish");
        ac acVar = new ac(this);
        this.f40897a = acVar;
        try {
            registerReceiver(acVar, intentFilter, d.a(this), null);
        } catch (Exception unused) {
        }
        a(getIntent());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f54a.removeCallbacksAndMessages(null);
        try {
            unregisterReceiver(this.f40897a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
