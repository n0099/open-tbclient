package com.win.opensdk.downloader;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.M;
import com.win.opensdk.Z1;
import com.win.opensdk.core.Info;
import com.win.opensdk.d1;
import com.win.opensdk.e1;
import com.win.opensdk.f1;
import java.io.File;
import java.net.URI;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(Context context, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, info) == null) {
            try {
                File file = new File(M.a(context, info.getOpen()));
                if (file.exists()) {
                    file.delete();
                    e1.a(context).a(new f1(info), info.getDl_pkg(), info.getDl_vsc(), 2).a();
                    ((NotificationManager) context.getSystemService("notification")).cancel(232);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(Context context, Info info, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, info, str) == null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null) {
                    d1 a = e1.a(context);
                    f1 f1Var = new f1(info);
                    String open = info.getOpen();
                    try {
                        a.b = e1.a("wiop", f1Var);
                        a.a("msg", e1.a(open));
                    } catch (JSONException unused) {
                    }
                    a.a();
                    launchIntentForPackage.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    context.startActivity(launchIntentForPackage);
                    Z1.a(context, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String[] split;
        String schemeSpecificPart;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
            boolean z = false;
            if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                String dataString = intent.getDataString();
                if (dataString == null) {
                    schemeSpecificPart = "";
                } else {
                    schemeSpecificPart = URI.create(dataString).getSchemeSpecificPart();
                }
                if (!booleanExtra) {
                    d1 a = e1.a(context);
                    try {
                        a.b = e1.b();
                        int abs = Math.abs(M.a(a.a, schemeSpecificPart, "SHA1").hashCode());
                        d1 a2 = a.a("e", "ins");
                        try {
                            schemeSpecificPart = M.a(schemeSpecificPart);
                        } catch (Exception unused) {
                        }
                        a2.a("pkg", schemeSpecificPart).a("timeis", e1.a()).a("tp", booleanExtra ? 1L : 0L).a("pksg", abs);
                    } catch (JSONException unused2) {
                    }
                    a.a();
                }
            }
            if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction())) {
                String dataString2 = intent.getDataString();
                if (TextUtils.isEmpty(dataString2) || !dataString2.contains(":") || (split = dataString2.split(":")) == null || split.length <= 0) {
                    str = "";
                } else {
                    str = split[1];
                }
                try {
                    Info info = (Info) Z1.b(context, str);
                    if (info != null && !TextUtils.isEmpty(str)) {
                        try {
                            z = info.getDl_pkg().equals(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (z) {
                            d1 a3 = e1.a(context);
                            try {
                                a3.b = e1.a("wie", new f1(info));
                                a3.a("co", 200);
                            } catch (JSONException unused3) {
                            }
                            a3.a();
                            try {
                                M.a(info, 302, "");
                                if (!TextUtils.isEmpty(info.getVv_ins_urls())) {
                                    M.g(info.getVv_ins_urls());
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            a(context, info);
                            a(context, info, str);
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
