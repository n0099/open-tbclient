package com.vivo.push.c;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f36684a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f36685b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f36686c;

    public y(t tVar, Context context, Map map) {
        this.f36686c = tVar;
        this.f36684a = context;
        this.f36685b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f36684a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f36684a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(270532608);
                        t.b(intent, this.f36685b);
                        this.f36684a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f36684a.getPackageManager().getLaunchIntentForPackage(this.f36684a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            t.b(launchIntentForPackage, this.f36685b);
            this.f36684a.startActivity(launchIntentForPackage);
            return;
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
    }
}
