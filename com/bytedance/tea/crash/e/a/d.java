package com.bytedance.tea.crash.e.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.platform.comapi.map.MapBundleKey;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f7938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        try {
            a(context);
        } catch (Throwable th) {
        }
    }

    private void a(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int a() {
        return this.f7938a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                d.this.f7938a = (int) ((intent.getIntExtra(MapBundleKey.MapObjKey.OBJ_LEVEL, 0) * 100.0f) / intent.getIntExtra("scale", 100));
            }
        }
    }
}
