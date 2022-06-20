package com.repackage;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.nadcore.download.notification.NotificationReceiver;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class pi0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NotificationManager a;
    public NotificationCompat.Builder b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final pi0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-98685316, "Lcom/repackage/pi0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-98685316, "Lcom/repackage/pi0$b;");
                    return;
                }
            }
            a = new pi0(null);
        }
    }

    public /* synthetic */ pi0(a aVar) {
        this();
    }

    public static pi0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (pi0) invokeV.objValue;
    }

    public void a(int i) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        try {
            a(135637042);
            a(1743353008);
            a(-1276312226);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final NotificationCompat.Builder c() {
        InterceptResult invokeV;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context b2 = bh0.b();
            if (Build.VERSION.SDK_INT >= 26) {
                d();
                builder = new NotificationCompat.Builder(b2, "com.baidu.nadcore.notification.channel");
            } else {
                builder = new NotificationCompat.Builder(b2);
            }
            builder.setSmallIcon(hi0.a().a());
            builder.setWhen(System.currentTimeMillis());
            builder.setPriority(0);
            builder.setDefaults(-1);
            builder.setVisibility(1);
            builder.setVibrate(new long[]{0});
            builder.setSound(null);
            return builder;
        }
        return (NotificationCompat.Builder) invokeV.objValue;
    }

    @RequiresApi(api = 26)
    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("com.baidu.nadcore.notification.channel", "下载消息提示", 4);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setVibrationPattern(new long[]{0});
        notificationChannel.setSound(null, null);
        this.a.createNotificationChannel(notificationChannel);
    }

    public PendingIntent e(String str, ii0 ii0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, ii0Var)) == null) {
            if (TextUtils.isEmpty(str) || ii0Var == null) {
                return null;
            }
            Context b2 = bh0.b();
            Intent intent = new Intent(str);
            intent.setComponent(new ComponentName(b2.getPackageName(), NotificationReceiver.class.getName()));
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_PACKAGE_NAME, ii0Var.d);
            File file = ii0Var.h;
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_FILE_PATH, (file == null || !file.exists()) ? "" : ii0Var.h.getAbsolutePath());
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_NOTIFY_TYPE, ii0Var.q.l);
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_NOTIFICATION_ID, ii0Var.d().hashCode());
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_EXTRA_PARAM, ii0Var.p.a);
            return PendingIntent.getBroadcast(b2, ii0Var.d().hashCode(), intent, 134217728);
        }
        return (PendingIntent) invokeLL.objValue;
    }

    public void g(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.x(str);
            }
            if (!TextUtils.equals(str, ClogBuilder.LogType.DOWNLOAD_INSTALL.type) && !TextUtils.equals(str, ClogBuilder.LogType.OPEN_APP.type)) {
                clogBuilder.s(ClogBuilder.Page.AD_NOTIFICATION);
            } else {
                clogBuilder.s(ClogBuilder.Page.RETARGET);
            }
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.h(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.n(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                clogBuilder.i(str4);
            }
            vx0.c(clogBuilder);
        }
    }

    public void h(ii0 ii0Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, ii0Var, str) == null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = bh0.b();
            String str2 = ii0Var.p.h;
            String str3 = "";
            if (TextUtils.equals(str, "notify_type_pause")) {
                str3 = b2.getResources().getString(R.string.obfuscated_res_0x7f0f0b9c);
            } else if (TextUtils.equals(str, "notify_type_stop")) {
                str3 = b2.getResources().getString(R.string.obfuscated_res_0x7f0f0ba0);
            }
            NotificationCompat.Builder c = c();
            c.setTicker(str2 + str3);
            c.setContentTitle(str2);
            c.setContentText(str3);
            c.setAutoCancel(true);
            c.setOngoing(false);
            this.a.notify(1743353008, c.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void i(ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ii0Var) == null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = bh0.b();
            String str = ii0Var.p.h;
            String string = b2.getResources().getString(R.string.obfuscated_res_0x7f0f0ba1);
            NotificationCompat.Builder c = c();
            c.setTicker(string);
            c.setContentTitle(str);
            c.setContentText(string);
            c.setContentIntent(e(NotificationReceiver.RECEIVER_ACTION_DOWNLOAD_SUCCESS, ii0Var));
            c.setAutoCancel(true);
            c.setOngoing(false);
            this.a.notify(-1276312226, c.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void j(ii0 ii0Var) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ii0Var) == null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(1743353008);
            this.a.cancel(-1276312226);
            Context b2 = bh0.b();
            String str = ii0Var.p.h;
            String string = b2.getResources().getString(R.string.obfuscated_res_0x7f0f0ba2);
            int i = (int) (ii0Var.i * 100.0f);
            if (this.b == null) {
                NotificationCompat.Builder c = c();
                this.b = c;
                c.setAutoCancel(false);
                this.b.setOngoing(true);
                NotificationCompat.Builder builder = this.b;
                builder.setTicker(string + "：" + str);
                this.b.setContentTitle(str);
                this.b.setContentText(string);
            } else {
                NotificationCompat.Builder builder2 = this.b;
                builder2.setTicker(string + "：" + str);
                this.b.setContentTitle(str);
                this.b.setDefaults(4);
            }
            this.b.setProgress(100, i, false);
            this.a.notify(135637042, this.b.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public pi0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (NotificationManager) bh0.b().getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }
}
