package com.kuaishou.weapon.p0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long a = 3600000;
    public static final long b = 60000;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65537, null, context, i, str, str2) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append("---- cancelRTCAlarm  action --- ");
                sb.append(str);
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent(str);
                intent.setData(Uri.parse(str2));
                intent.setPackage(context.getPackageName());
                alarmManager.cancel(PendingIntent.getBroadcast(context, i, intent, context.getApplicationInfo().targetSdkVersion >= 31 ? 201326592 : 134217728));
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, int i, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, Integer.valueOf(i), Long.valueOf(j), str2}) == null) {
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent(str);
                intent.setData(Uri.parse(str2));
                intent.setPackage(context.getPackageName());
                PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, context.getApplicationInfo().targetSdkVersion >= 31 ? 201326592 : 134217728);
                try {
                    alarmManager.cancel(broadcast);
                } catch (Throwable unused) {
                }
                alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
            } catch (Throwable unused2) {
            }
        }
    }
}
