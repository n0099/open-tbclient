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
import c.p.a.b2;
import c.p.a.c3;
import c.p.a.g3;
import c.p.a.j1;
import c.p.a.m1;
import c.p.a.m2;
import c.p.a.r0;
import c.p.a.s1;
import c.p.a.u0;
import c.p.a.y1;
import c.p.a.y2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
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
/* loaded from: classes4.dex */
public class WDownLoadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b */
    public String f63218b;

    /* renamed from: c */
    public String f63219c;

    /* renamed from: d */
    public NotificationManager f63220d;

    /* renamed from: e */
    public Notification f63221e;

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

    /* JADX DEBUG: Method not inlined, still used in: [c.p.a.y1.c():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [c.p.a.y1.a():void, c.p.a.y1.d():void] */
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
                    builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(j1.win_downloadicon).setTicker(str).setContentText(str2).build();
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
            builder2.setSmallIcon(j1.win_downloadicon);
            builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), j1.win_downloadicon));
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
            this.f63221e = build;
            this.f63220d.notify(w0.c1, build);
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
            new Handler().postDelayed(new b2(this, info), 400L);
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, info) == null) {
            y2 a = c3.a(getApplicationContext());
            g3 g3Var = new g3(info);
            String str = this.f63218b;
            try {
                a.f31377b = c3.d("wdst", g3Var);
                a.l("msg", c3.b(str));
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
            u0 u0Var = u0.f31323d;
            String str3 = this.f63218b;
            String str4 = this.a;
            y1 y1Var = new y1(this, info);
            if (u0Var.f31325c) {
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
            s1 s1Var = new s1(str3, str4, y1Var);
            u0Var.f31324b = s1Var;
            new WeakReference(u0Var.a.submit(s1Var));
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
            this.f63220d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            try {
                u0.f31323d.f31325c = false;
                if (this.f63220d != null) {
                    this.f63220d.cancel(w0.c1);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        String string;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent, i2, i3)) == null) {
            Info info = null;
            try {
                this.f63218b = intent.getStringExtra("down_load_apk_url");
                this.f63219c = intent.getStringExtra("down_load_pkg_name");
                this.a = r0.e(getApplicationContext()) + File.separator + "win" + File.separator + r0.G(this.f63218b);
                File parentFile = new File(this.a).getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    info = (Info) m2.i(getApplicationContext(), this.f63219c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (info != null) {
                    string = info.getDl_name();
                    i4 = m1.win_wdownload_start;
                } else {
                    string = getString(m1.win_wdownload_start);
                    i4 = m1.win_wdownload_start;
                }
                a(info, string, getString(i4), 0);
                c(info);
            } catch (Exception e3) {
                e3.printStackTrace();
                if (info != null) {
                    y2 a = c3.a(getApplicationContext());
                    a.q(new g3(info), 3);
                    a.l("desc", e3.getMessage());
                    a.m();
                }
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
