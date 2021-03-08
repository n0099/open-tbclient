package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
/* loaded from: classes6.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private a f5110a;

    /* loaded from: classes6.dex */
    public interface a {
        void I();

        void J();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Log.i("HomeReceiver", "onReceive: action: " + action);
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON);
                Log.i("HomeReceiver", "reason: " + stringExtra);
                if ("homekey".equals(stringExtra)) {
                    Log.i("HomeReceiver", "homekey");
                    if (this.f5110a != null) {
                        this.f5110a.I();
                    }
                } else if ("recentapps".equals(stringExtra)) {
                    Log.i("HomeReceiver", "long press home key or activity switch");
                    if (this.f5110a != null) {
                        this.f5110a.J();
                    }
                } else if (Config.BAWU_TYPE_ASSIST.equals(stringExtra)) {
                    Log.i("HomeReceiver", Config.BAWU_TYPE_ASSIST);
                }
            }
        }
    }

    public void a(a aVar) {
        this.f5110a = aVar;
    }
}
