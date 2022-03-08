package com.win.opensdk.downloader;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.q.a.b3;
import c.q.a.h2;
import c.q.a.n1;
import c.q.a.r0;
import c.q.a.t1;
import c.q.a.t2;
import c.q.a.u0;
import c.q.a.w1;
import c.q.a.x2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.win.opensdk.core.Info;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class WDownLoadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b */
    public String f59396b;

    /* renamed from: c */
    public String f59397c;

    /* renamed from: d */
    public NotificationManager f59398d;

    /* renamed from: e */
    public Notification f59399e;

    public WDownLoadService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.t1.c():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.q.a.t1.a():void, c.q.a.t1.d():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, info)) == null) ? PendingIntent.getActivity(this, 0, r0.d(info, getApplicationContext(), this.a), 134217728) : (PendingIntent) invokeL.objValue;
    }

    public void a(Info info, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info, str, str2, i2) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
                if (Build.VERSION.SDK_INT >= 26) {
                    notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
                    builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(R.drawable.win_downloadicon).setTicker(str).setContentText(str2).build();
                    if (i2 <= 0 || i2 > 100) {
                        builder.setProgress(0, 0, false);
                        builder.setContentText(str2);
                    } else {
                        builder.setProgress(100, i2, false);
                    }
                    builder.setContentIntent(i2 >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
                    notificationManager.notify(w0.c1, builder.build());
                    return;
                }
                return;
            }
            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this);
            builder2.setSmallIcon(R.drawable.win_downloadicon);
            builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.win_downloadicon));
            builder2.setContentTitle(str);
            if (i2 <= 0 || i2 >= 100) {
                builder2.setProgress(0, 0, false);
                builder2.setContentText(str2);
            } else {
                builder2.setProgress(100, i2, false);
            }
            builder2.setWhen(System.currentTimeMillis());
            builder2.setTicker(str);
            builder2.setContentIntent(i2 >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
            Notification build = builder2.build();
            this.f59399e = build;
            this.f59398d.notify(w0.c1, build);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File file = new File(this.a);
            if (file.exists() && file.isFile()) {
                return file.delete();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, info) == null) {
            new Handler().postDelayed(new w1(this, info), 400L);
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, info) == null) {
            t2 a = x2.a(getApplicationContext());
            b3 b3Var = new b3(info);
            String str = this.f59396b;
            try {
                a.f29126b = x2.d("wdst", b3Var);
                a.l("msg", x2.b(str));
            } catch (JSONException unused) {
            }
            String str2 = this.a;
            try {
                str2 = r0.g(str2);
            } catch (Exception unused2) {
            }
            a.l("desc", str2);
            a.m();
            try {
                r0.o(info, 300, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                    r0.K(info.getVv_downs_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            u0 u0Var = u0.f29141d;
            String str3 = this.f59396b;
            String str4 = this.a;
            t1 t1Var = new t1(this, info);
            if (u0Var.f29143c) {
                return;
            }
            File file = new File(str4.substring(0, str4.lastIndexOf("/") + 1));
            File file2 = new File(str4);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            n1 n1Var = new n1(str3, str4, t1Var);
            u0Var.f29142b = n1Var;
            new WeakReference(u0Var.a.submit(n1Var));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f59398d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            try {
                u0.f29141d.f29143c = false;
                if (this.f59398d != null) {
                    this.f59398d.cancel(w0.c1);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent, i2, i3)) == null) {
            Info info = null;
            try {
                this.f59396b = intent.getStringExtra("down_load_apk_url");
                this.f59397c = intent.getStringExtra("down_load_pkg_name");
                this.a = r0.e(getApplicationContext()) + File.separator + "win" + File.separator + r0.G(this.f59396b);
                File parentFile = new File(this.a).getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    info = (Info) h2.i(getApplicationContext(), this.f59397c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                a(info, info != null ? info.getDl_name() : getString(R.string.win_wdownload_start), getString(R.string.win_wdownload_start), 0);
                c(info);
            } catch (Exception e3) {
                e3.printStackTrace();
                if (info != null) {
                    t2 a = x2.a(getApplicationContext());
                    a.q(new b3(info), 3);
                    a.l("desc", e3.getMessage());
                    a.m();
                }
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
