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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.N;
import com.win.opensdk.O;
import com.win.opensdk.R;
import com.win.opensdk.T;
import com.win.opensdk.U1;
import com.win.opensdk.V;
import com.win.opensdk.W;
import com.win.opensdk.Y0;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.core.Info;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class WDownLoadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a */
    public String f77363a;

    /* renamed from: b */
    public String f77364b;

    /* renamed from: c */
    public String f77365c;

    /* renamed from: d */
    public NotificationManager f77366d;

    /* renamed from: e */
    public Notification f77367e;

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

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.V.b():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.V.a():void, com.win.opensdk.V.c():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, info)) == null) ? PendingIntent.getActivity(this, 0, N.a(info, getApplicationContext(), this.f77363a), 134217728) : (PendingIntent) invokeL.objValue;
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
                    notificationManager.notify(232, builder.build());
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
            this.f77367e = build;
            this.f77366d.notify(232, build);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File file = new File(this.f77363a);
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
            new Handler().postDelayed(new W(this, info), 400L);
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, info) == null) {
            Y0 a2 = Z0.a(getApplicationContext());
            a1 a1Var = new a1(info);
            String str = this.f77364b;
            try {
                a2.f77289b = Z0.a("wdst", a1Var);
                a2.a("msg", Z0.a(str));
            } catch (JSONException unused) {
            }
            String str2 = this.f77363a;
            try {
                str2 = N.a(str2);
            } catch (Exception unused2) {
            }
            a2.a("desc", str2).a();
            try {
                N.a(info, 300, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                    N.g(info.getVv_downs_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            O o = O.f77175d;
            String str3 = this.f77364b;
            String str4 = this.f77363a;
            V v = new V(this, info);
            if (o.f77178c) {
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
            T t = new T(str3, str4, v);
            o.f77177b = t;
            new WeakReference(o.f77176a.submit(t));
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
            this.f77366d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            try {
                O.f77175d.f77178c = false;
                if (this.f77366d != null) {
                    this.f77366d.cancel(232);
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
                this.f77364b = intent.getStringExtra("down_load_apk_url");
                this.f77365c = intent.getStringExtra("down_load_pkg_name");
                this.f77363a = N.a(getApplicationContext()) + File.separator + "win" + File.separator + N.e(this.f77364b);
                File parentFile = new File(this.f77363a).getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    info = (Info) U1.b(getApplicationContext(), this.f77365c);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (info != null) {
                    string = info.getDl_name();
                    i4 = R.string.win_wdownload_start;
                } else {
                    string = getString(R.string.win_wdownload_start);
                    i4 = R.string.win_wdownload_start;
                }
                a(info, string, getString(i4), 0);
                c(info);
            } catch (Exception e3) {
                e3.printStackTrace();
                if (info != null) {
                    Z0.a(getApplicationContext()).b(new a1(info), 3).a("desc", e3.getMessage()).a();
                }
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
