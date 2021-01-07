package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
/* loaded from: classes4.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private a f7832a;

    /* loaded from: classes4.dex */
    public interface a {
        void H();

        void I();
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
                    if (this.f7832a != null) {
                        this.f7832a.H();
                    }
                } else if ("recentapps".equals(stringExtra)) {
                    Log.i("HomeReceiver", "long press home key or activity switch");
                    if (this.f7832a != null) {
                        this.f7832a.I();
                    }
                } else if (Config.BAWU_TYPE_ASSIST.equals(stringExtra)) {
                    Log.i("HomeReceiver", Config.BAWU_TYPE_ASSIST);
                }
            }
        }
    }

    public void a(a aVar) {
        this.f7832a = aVar;
    }
}
