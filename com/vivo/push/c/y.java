package com.vivo.push.c;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class y implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f39152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f39153b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f39154c;

    public y(t tVar, Context context, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, context, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39154c = tVar;
        this.f39152a = context;
        this.f39153b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String packageName = this.f39152a.getPackageName();
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f39152a.getSystemService("activity")).getRunningTasks(100);
                if (runningTasks != null) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        ComponentName componentName = runningTaskInfo.topActivity;
                        if (componentName.getPackageName().equals(packageName)) {
                            com.vivo.push.util.p.d("OnNotificationClickTask", "topClassName=" + componentName.getClassName());
                            Intent intent = new Intent();
                            intent.setComponent(componentName);
                            intent.setFlags(270532608);
                            t.b(intent, this.f39153b);
                            this.f39152a.startActivity(intent);
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                com.vivo.push.util.p.a("OnNotificationClickTask", "start recentIntent is error", e2);
            }
            Intent launchIntentForPackage = this.f39152a.getPackageManager().getLaunchIntentForPackage(this.f39152a.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                t.b(launchIntentForPackage, this.f39153b);
                this.f39152a.startActivity(launchIntentForPackage);
                return;
            }
            com.vivo.push.util.p.a("OnNotificationClickTask", "LaunchIntent is null");
        }
    }
}
