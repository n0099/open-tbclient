package com.win.opensdk.downloader;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.q.a.b3;
import c.q.a.h2;
import c.q.a.r0;
import c.q.a.t2;
import c.q.a.x2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.win.opensdk.core.Info;
import java.io.File;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class WinDReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WinDReceiver() {
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

    public final void a(Context context, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, info) == null) {
            try {
                File file = new File(r0.f(context, info.getOpen()));
                if (file.exists()) {
                    file.delete();
                    t2 a = x2.a(context);
                    a.j(new b3(info), info.getDl_pkg(), info.getDl_vsc(), 2);
                    a.m();
                    ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(w0.c1);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) && intent.getAction().equals(PackageChangedReceiver.ACTION_INSTALL)) {
            String dataString = intent.getDataString();
            String str = (TextUtils.isEmpty(dataString) || !dataString.contains(":") || (split = dataString.split(":")) == null || split.length <= 0) ? "" : split[1];
            try {
                Info info = (Info) h2.i(context, str);
                if (info == null || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    z = info.getDl_pkg().equals(str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z = false;
                }
                if (z) {
                    t2 a = x2.a(context);
                    try {
                        a.f29126b = x2.d("wie", new b3(info));
                        a.k("co", 200);
                    } catch (JSONException unused) {
                    }
                    a.m();
                    try {
                        r0.o(info, 302, "");
                        if (!TextUtils.isEmpty(info.getVv_ins_urls())) {
                            r0.K(info.getVv_ins_urls());
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    a(context, info);
                    a(context, info, str);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(Context context, Info info, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, info, str) == null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null) {
                    t2 a = x2.a(context);
                    b3 b3Var = new b3(info);
                    String open = info.getOpen();
                    try {
                        a.f29126b = x2.d("wiop", b3Var);
                        a.l("msg", x2.b(open));
                    } catch (JSONException unused) {
                    }
                    a.m();
                    launchIntentForPackage.setFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    h2.e(context, str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
