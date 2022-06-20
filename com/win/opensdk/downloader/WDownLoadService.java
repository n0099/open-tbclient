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
import com.kuaishou.weapon.un.w0;
import com.repackage.co9;
import com.repackage.in9;
import com.repackage.om9;
import com.repackage.sl9;
import com.repackage.um9;
import com.repackage.un9;
import com.repackage.vl9;
import com.repackage.xm9;
import com.repackage.yn9;
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

    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.um9.c():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.um9.a():void, com.repackage.um9.d():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, info)) == null) ? PendingIntent.getActivity(this, 0, sl9.d(info, getApplicationContext(), this.a), 134217728) : (PendingIntent) invokeL.objValue;
    }

    public void a(Info info, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info, str, str2, i) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
                if (Build.VERSION.SDK_INT >= 26) {
                    notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
                    builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(R.drawable.obfuscated_res_0x7f08127d).setTicker(str).setContentText(str2).build();
                    if (i <= 0 || i > 100) {
                        builder.setProgress(0, 0, false);
                        builder.setContentText(str2);
                    } else {
                        builder.setProgress(100, i, false);
                    }
                    builder.setContentIntent(i >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
                    notificationManager.notify(w0.c1, builder.build());
                    return;
                }
                return;
            }
            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this);
            builder2.setSmallIcon(R.drawable.obfuscated_res_0x7f08127d);
            builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.obfuscated_res_0x7f08127d));
            builder2.setContentTitle(str);
            if (i <= 0 || i >= 100) {
                builder2.setProgress(0, 0, false);
                builder2.setContentText(str2);
            } else {
                builder2.setProgress(100, i, false);
            }
            builder2.setWhen(System.currentTimeMillis());
            builder2.setTicker(str);
            builder2.setContentIntent(i >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
            Notification build = builder2.build();
            this.e = build;
            this.d.notify(w0.c1, build);
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
            new Handler().postDelayed(new xm9(this, info), 400L);
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, info) == null) {
            un9 a = yn9.a(getApplicationContext());
            co9 co9Var = new co9(info);
            String str = this.b;
            try {
                a.b = yn9.d("wdst", co9Var);
                a.l("msg", yn9.b(str));
            } catch (JSONException unused) {
            }
            String str2 = this.a;
            try {
                str2 = sl9.g(str2);
            } catch (Exception unused2) {
            }
            a.l("desc", str2);
            a.m();
            try {
                sl9.o(info, 300, "");
                if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                    sl9.K(info.getVv_downs_urls());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            vl9 vl9Var = vl9.d;
            String str3 = this.b;
            String str4 = this.a;
            um9 um9Var = new um9(this, info);
            if (vl9Var.c) {
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            om9 om9Var = new om9(str3, str4, um9Var);
            vl9Var.b = om9Var;
            new WeakReference(vl9Var.a.submit(om9Var));
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
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            try {
                vl9.d.c = false;
                if (this.d != null) {
                    this.d.cancel(w0.c1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
                this.a = sl9.e(getApplicationContext()) + File.separator + "win" + File.separator + sl9.G(this.b);
                File parentFile = new File(this.a).getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    info = (Info) in9.i(getApplicationContext(), this.c);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a(info, info != null ? info.getDl_name() : getString(R.string.obfuscated_res_0x7f0f15b7), getString(R.string.obfuscated_res_0x7f0f15b7), 0);
                c(info);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (info != null) {
                    un9 a = yn9.a(getApplicationContext());
                    a.q(new co9(info), 3);
                    a.l("desc", e2.getMessage());
                    a.m();
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
