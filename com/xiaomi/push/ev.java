package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.eu;
/* loaded from: classes8.dex */
public class ev implements eu.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f1048a;

    /* renamed from: a  reason: collision with other field name */
    public Context f1049a;

    public ev(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1048a = null;
        this.f1049a = null;
        this.a = 0L;
        this.f1049a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{alarmManager, Long.valueOf(j), pendingIntent}) == null) {
            try {
                AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. " + e);
            }
        }
    }

    @Override // com.xiaomi.push.eu.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f1048a != null) {
                try {
                    ((AlarmManager) this.f1049a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f1048a);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f1048a = null;
                    com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                    this.a = 0L;
                    throw th;
                }
                this.f1048a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.a = 0L;
            }
            this.a = 0L;
        }
    }

    public void a(Intent intent, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, j) == null) {
            AlarmManager alarmManager = (AlarmManager) this.f1049a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.f1048a = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.f1049a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.f1049a, 0, intent, 0);
            if (Build.VERSION.SDK_INT >= 23) {
                bk.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f1048a);
            } else {
                a(alarmManager, j, this.f1048a);
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer " + j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r8.a < r4) goto L19;
     */
    @Override // com.xiaomi.push.eu.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            long m1601a = com.xiaomi.push.service.o.a(this.f1049a).m1601a();
            if (z || this.a != 0) {
                if (z) {
                    a();
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (!z && this.a != 0) {
                    if (this.a <= elapsedRealtime) {
                        this.a += m1601a;
                    }
                    Intent intent = new Intent(com.xiaomi.push.service.bk.p);
                    intent.setPackage(this.f1049a.getPackageName());
                    a(intent, this.a);
                }
                m1601a -= elapsedRealtime % m1601a;
                this.a = elapsedRealtime + m1601a;
                Intent intent2 = new Intent(com.xiaomi.push.service.bk.p);
                intent2.setPackage(this.f1049a.getPackageName());
                a(intent2, this.a);
            }
        }
    }

    @Override // com.xiaomi.push.eu.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a != 0 : invokeV.booleanValue;
    }
}
