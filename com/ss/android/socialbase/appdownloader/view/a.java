package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.b.d.c;
import d.l.a.e.b.g.e;
/* loaded from: classes6.dex */
public class a extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static Intent d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new Intent("android.settings.APPLICATION_SETTINGS") : (Intent) invokeV.objValue;
    }

    private Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Context n = e.n();
            return (n != null || getActivity() == null || getActivity().isFinishing()) ? n : getActivity().getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    private Intent f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Context e2 = e();
            if (e2 == null) {
                return null;
            }
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            String packageName = e2.getPackageName();
            intent.putExtra(AsInstallService.SCHEME_PACKAGE_ADDED, packageName);
            intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
            intent.putExtra("app_package", packageName);
            int i2 = e2.getApplicationInfo().uid;
            intent.putExtra("uid", i2);
            intent.putExtra("app_uid", i2);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                try {
                    try {
                        startActivityForResult(f(), 1000);
                    } catch (Throwable unused) {
                        startActivityForResult(c(), 1000);
                    }
                } catch (Throwable unused2) {
                    startActivityForResult(d(), 1000);
                }
            } catch (Throwable unused3) {
                startActivityForResult(b(), 1000);
            }
        }
    }

    public Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context e2 = e();
            if (e2 == null) {
                return null;
            }
            String packageName = e2.getPackageName();
            if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
                String lowerCase = Build.MANUFACTURER.toLowerCase();
                if (lowerCase.contains(c.f72192c)) {
                    Intent intent = new Intent();
                    intent.putExtra("packageName", packageName);
                    intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                    return intent;
                } else if (lowerCase.contains(RomUtils.MANUFACTURER_VIVO)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("packagename", packageName);
                    if (Build.VERSION.SDK_INT >= 25) {
                        intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                    } else {
                        intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                    }
                    return intent2;
                } else if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                    Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                    intent3.putExtra("packageName", packageName);
                    intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                    return intent3;
                }
            }
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e2.getPackageName()));
        }
        return (Intent) invokeV.objValue;
    }

    public Intent c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context e2 = e();
            if (e2 == null) {
                return null;
            }
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + e2.getPackageName()));
        }
        return (Intent) invokeV.objValue;
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (d.l.a.e.a.f.c.d()) {
                d.l.a.e.a.f.c.c(true);
            } else {
                d.l.a.e.a.f.c.c(false);
            }
        }
    }
}
