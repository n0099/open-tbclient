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
import com.win.opensdk.A;
import com.win.opensdk.E;
import com.win.opensdk.G;
import com.win.opensdk.H;
import com.win.opensdk.R;
import com.win.opensdk.core.Info;
import com.win.opensdk.s1;
import com.win.opensdk.w0;
import com.win.opensdk.x0;
import com.win.opensdk.y0;
import com.win.opensdk.z;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class WDownLoadService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a */
    public String f39567a;

    /* renamed from: b */
    public String f39568b;

    /* renamed from: c */
    public String f39569c;

    /* renamed from: d */
    public NotificationManager f39570d;

    /* renamed from: e */
    public Notification f39571e;

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

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.G.b():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.G.a():void, com.win.opensdk.G.c():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, info)) == null) ? PendingIntent.getActivity(this, 0, z.a(info, getApplicationContext(), this.f39567a), 134217728) : (PendingIntent) invokeL.objValue;
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
            this.f39571e = build;
            this.f39570d.notify(232, build);
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File file = new File(this.f39567a);
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
            new Handler().postDelayed(new H(this, info), 400L);
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, info) == null) {
            w0 a2 = x0.a(getApplicationContext());
            y0 y0Var = new y0(info);
            String str = this.f39568b;
            try {
                a2.f39697b = x0.a("wdst", y0Var);
                a2.a("msg", x0.a(str));
            } catch (JSONException unused) {
            }
            String str2 = this.f39567a;
            try {
                str2 = z.a(str2);
            } catch (Exception unused2) {
            }
            a2.a("desc", str2).a();
            try {
                z.a(info, 300, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                    z.g(info.getVv_downs_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            A a3 = A.f39315d;
            String str3 = this.f39568b;
            String str4 = this.f39567a;
            G g2 = new G(this, info);
            if (a3.f39318c) {
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
            E e4 = new E(str3, str4, g2);
            a3.f39317b = e4;
            new WeakReference(a3.f39316a.submit(e4));
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
            this.f39570d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            try {
                A.f39315d.f39318c = false;
                if (this.f39570d != null) {
                    this.f39570d.cancel(232);
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
                this.f39568b = intent.getStringExtra("down_load_apk_url");
                this.f39569c = intent.getStringExtra("down_load_pkg_name");
                this.f39567a = z.a(getApplicationContext()) + File.separator + "win" + File.separator + z.e(this.f39568b);
                File parentFile = new File(this.f39567a).getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    info = (Info) s1.b(getApplicationContext(), this.f39569c);
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
                    x0.a(getApplicationContext()).b(new y0(info), 3).a("desc", e3.getMessage()).a();
                }
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
