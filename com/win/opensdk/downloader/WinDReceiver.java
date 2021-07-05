package com.win.opensdk.downloader;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.s1;
import com.win.opensdk.w0;
import com.win.opensdk.x0;
import com.win.opensdk.y0;
import com.win.opensdk.z;
import java.io.File;
import org.json.JSONException;
/* loaded from: classes7.dex */
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
                File file = new File(z.a(context, info.getOpen()));
                if (file.exists()) {
                    file.delete();
                    x0.a(context).a(new y0(info), info.getDl_pkg(), info.getDl_vsc(), 2).a();
                    ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(232);
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
                Info info = (Info) s1.b(context, str);
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
                    w0 a2 = x0.a(context);
                    try {
                        a2.f42683b = x0.a("wie", new y0(info));
                        a2.a("co", 200);
                    } catch (JSONException unused) {
                    }
                    a2.a();
                    try {
                        z.a(info, 302, "");
                        if (!TextUtils.isEmpty(info.getVv_ins_urls())) {
                            z.g(info.getVv_ins_urls());
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
                    w0 a2 = x0.a(context);
                    y0 y0Var = new y0(info);
                    String open = info.getOpen();
                    try {
                        a2.f42683b = x0.a("wiop", y0Var);
                        a2.a("msg", x0.a(open));
                    } catch (JSONException unused) {
                    }
                    a2.a();
                    launchIntentForPackage.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    context.startActivity(launchIntentForPackage);
                    s1.a(context, str);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
