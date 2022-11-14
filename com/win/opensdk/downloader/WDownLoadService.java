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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.M;
import com.win.opensdk.N;
import com.win.opensdk.S;
import com.win.opensdk.U;
import com.win.opensdk.V;
import com.win.opensdk.Z1;
import com.win.opensdk.core.Info;
import com.win.opensdk.d1;
import com.win.opensdk.e1;
import com.win.opensdk.f1;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class WDownLoadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public NotificationManager d;
    public Notification e;

    public WDownLoadService() {
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

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.U.b():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.U.a():void, com.win.opensdk.U.c():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, info)) == null) ? PendingIntent.getActivity(this, 0, M.a(info, getApplicationContext(), this.a), 134217728) : (PendingIntent) invokeL.objValue;
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
            new Handler().postDelayed(new V(this, info), 400L);
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
            this.d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent, i, i2)) == null) {
            Info info = null;
            try {
                this.b = intent.getStringExtra("down_load_apk_url");
                this.c = intent.getStringExtra("down_load_pkg_name");
                this.a = M.a(getApplicationContext()) + File.separator + "win" + File.separator + M.e(this.b);
                File parentFile = new File(this.a).getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    info = (Info) Z1.b(getApplicationContext(), this.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a(info, info != null ? info.getDl_name() : getString(R.string.obfuscated_res_0x7f0f1616), getString(R.string.obfuscated_res_0x7f0f1616), 0);
                c(info);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (info != null) {
                    e1.a(getApplicationContext()).c(new f1(info), 3).a("desc", e2.getMessage()).a();
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }

    public void a(Info info, String str, String str2, int i) {
        PendingIntent activity;
        PendingIntent activity2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info, str, str2, i) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
                if (Build.VERSION.SDK_INT >= 26) {
                    notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
                    builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(R.drawable.obfuscated_res_0x7f0812ed).setTicker(str).setContentText(str2).build();
                    if (i > 0 && i <= 100) {
                        builder.setProgress(100, i, false);
                    } else {
                        builder.setProgress(0, 0, false);
                        builder.setContentText(str2);
                    }
                    if (i >= 100) {
                        activity2 = a(info);
                    } else {
                        activity2 = PendingIntent.getActivity(this, 0, new Intent(), 134217728);
                    }
                    builder.setContentIntent(activity2);
                    notificationManager.notify(232, builder.build());
                    return;
                }
                return;
            }
            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this);
            builder2.setSmallIcon(R.drawable.obfuscated_res_0x7f0812ed);
            builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f0812ed));
            builder2.setContentTitle(str);
            if (i > 0 && i < 100) {
                builder2.setProgress(100, i, false);
            } else {
                builder2.setProgress(0, 0, false);
                builder2.setContentText(str2);
            }
            builder2.setWhen(System.currentTimeMillis());
            builder2.setTicker(str);
            if (i >= 100) {
                activity = a(info);
            } else {
                activity = PendingIntent.getActivity(this, 0, new Intent(), 134217728);
            }
            builder2.setContentIntent(activity);
            Notification build = builder2.build();
            this.e = build;
            this.d.notify(232, build);
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, info) == null) {
            d1 a = e1.a(getApplicationContext());
            f1 f1Var = new f1(info);
            String str = this.b;
            try {
                a.b = e1.a("wdst", f1Var);
                a.a("msg", e1.a(str));
            } catch (JSONException unused) {
            }
            String str2 = this.a;
            try {
                str2 = M.a(str2);
            } catch (Exception unused2) {
            }
            a.a("desc", str2).a();
            try {
                M.a(info, 300, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                    M.g(info.getVv_downs_urls());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            N n = N.d;
            String str3 = this.b;
            String str4 = this.a;
            U u = new U(this, info);
            if (!n.c) {
                File file = new File(str4.substring(0, str4.lastIndexOf("/") + 1));
                File file2 = new File(str4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                S s = new S(str3, str4, u);
                n.b = s;
                new WeakReference(n.a.submit(s));
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            try {
                N.d.c = false;
                if (this.d != null) {
                    this.d.cancel(232);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
