package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.tieba.pushdialog.PushDialogActivity;
/* loaded from: classes6.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public a f30352a;

    /* loaded from: classes6.dex */
    public interface a {
        void J();

        void K();
    }

    public void a(a aVar) {
        this.f30352a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        Log.i("HomeReceiver", "onReceive: action: " + action);
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
            String stringExtra = intent.getStringExtra("reason");
            Log.i("HomeReceiver", "reason: " + stringExtra);
            if ("homekey".equals(stringExtra)) {
                Log.i("HomeReceiver", "homekey");
                a aVar = this.f30352a;
                if (aVar != null) {
                    aVar.J();
                }
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS.equals(stringExtra)) {
                Log.i("HomeReceiver", "long press home key or activity switch");
                a aVar2 = this.f30352a;
                if (aVar2 != null) {
                    aVar2.K();
                }
            } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(stringExtra)) {
                Log.i("HomeReceiver", PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST);
            }
        }
    }
}
