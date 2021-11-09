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
import com.xiaomi.push.er;
/* loaded from: classes2.dex */
public class es implements er.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile long f70893a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f340a;

    /* renamed from: a  reason: collision with other field name */
    public Context f341a;

    public es(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f340a = null;
        this.f341a = null;
        this.f70893a = 0L;
        this.f341a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{alarmManager, Long.valueOf(j), pendingIntent}) == null) {
            try {
                AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    @Override // com.xiaomi.push.er.a
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? fr.b() : invokeV.longValue;
    }

    @Override // com.xiaomi.push.er.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f340a != null) {
                try {
                    ((AlarmManager) this.f341a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.f340a);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f340a = null;
                    com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
                    this.f70893a = 0L;
                    throw th;
                }
                this.f340a = null;
                com.xiaomi.channel.commonutils.logger.b.c("unregister timer");
                this.f70893a = 0L;
            }
            this.f70893a = 0L;
        }
    }

    public void a(Intent intent, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, intent, j) == null) {
            AlarmManager alarmManager = (AlarmManager) this.f341a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f341a, 0, intent, 0);
            this.f340a = broadcast;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                bh.a((Object) alarmManager, "setExactAndAllowWhileIdle", 0, Long.valueOf(j), this.f340a);
            } else if (i2 >= 19) {
                a(alarmManager, j, broadcast);
            } else {
                alarmManager.set(0, j, broadcast);
            }
            com.xiaomi.channel.commonutils.logger.b.c("register timer " + j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r7.f70893a < java.lang.System.currentTimeMillis()) goto L18;
     */
    @Override // com.xiaomi.push.er.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            long a2 = a();
            if (z || this.f70893a != 0) {
                if (z) {
                    a();
                }
                if (z || this.f70893a == 0) {
                    a2 -= SystemClock.elapsedRealtime() % a2;
                } else {
                    this.f70893a += a2;
                }
                this.f70893a = System.currentTimeMillis() + a2;
                Intent intent = new Intent(com.xiaomi.push.service.az.o);
                intent.setPackage(this.f341a.getPackageName());
                a(intent, this.f70893a);
            }
        }
    }

    @Override // com.xiaomi.push.er.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f70893a != 0 : invokeV.booleanValue;
    }
}
