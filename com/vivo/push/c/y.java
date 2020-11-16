package com.vivo.push.c;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4671a;
    final /* synthetic */ Map b;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, Context context, Map map) {
        this.c = tVar;
        this.f4671a = context;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f4671a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f4671a.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningTasks(100);
            if (runningTasks != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(270532608);
                        t.b(intent, this.b);
                        this.f4671a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e);
        }
        Intent launchIntentForPackage = this.f4671a.getPackageManager().getLaunchIntentForPackage(this.f4671a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268435456);
            t.b(launchIntentForPackage, this.b);
            this.f4671a.startActivity(launchIntentForPackage);
            return;
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
    }
}
