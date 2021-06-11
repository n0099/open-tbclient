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
    public final /* synthetic */ Context f40292a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f40293b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f40294c;

    public y(t tVar, Context context, Map map) {
        this.f40294c = tVar;
        this.f40292a = context;
        this.f40293b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f40292a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f40292a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    ComponentName componentName = runningTaskInfo.topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(270532608);
                        t.b(intent, this.f40293b);
                        this.f40292a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f40292a.getPackageManager().getLaunchIntentForPackage(this.f40292a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            t.b(launchIntentForPackage, this.f40293b);
            this.f40292a.startActivity(launchIntentForPackage);
            return;
        }
        com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
    }
}
