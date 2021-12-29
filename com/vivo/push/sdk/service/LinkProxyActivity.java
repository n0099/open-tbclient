package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.vivo.push.util.aa;
import com.vivo.push.util.p;
import java.util.List;
/* loaded from: classes4.dex */
public class LinkProxyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LinkProxyActivity() {
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

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[Catch: Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:27:0x009d, B:29:0x00a3, B:31:0x00af, B:33:0x00b5, B:35:0x00bd, B:38:0x00c4, B:40:0x00cc, B:42:0x00d0, B:47:0x00da, B:48:0x00de), top: B:57:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de A[Catch: Exception -> 0x00ec, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ec, blocks: (B:27:0x009d, B:29:0x00a3, B:31:0x00af, B:33:0x00b5, B:35:0x00bd, B:38:0x00c4, B:40:0x00cc, B:42:0x00d0, B:47:0x00da, B:48:0x00de), top: B:57:0x009d }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        PackageManager packageManager;
        List<ResolveInfo> queryIntentServices;
        ResolveInfo resolveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            if (intent == null) {
                p.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            boolean z = true;
            try {
                Window window = getWindow();
                window.setGravity(BadgeDrawable.TOP_START);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.x = 0;
                attributes.y = 0;
                attributes.height = 1;
                attributes.width = 1;
                window.setAttributes(attributes);
            } catch (Throwable th) {
                p.b("LinkProxyActivity", "enter onCreate error ", th);
            }
            String packageName = getPackageName();
            p.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
            if ("com.vivo.abe".equals(packageName)) {
                try {
                    if (intent == null) {
                        p.d("LinkProxyActivity", "adapterToService intent is null");
                    } else if (intent.getExtras() == null) {
                        p.d("LinkProxyActivity", "adapterToService getExtras() is null");
                    } else {
                        Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                        if (intent2 == null) {
                            p.d("LinkProxyActivity", "adapterToService proxyIntent is null");
                        } else {
                            aa.a(this, intent2);
                        }
                    }
                } catch (Exception e2) {
                    p.a("LinkProxyActivity", e2.toString(), e2);
                }
            } else {
                try {
                    if (intent.getExtras() != null) {
                        Intent intent3 = (Intent) intent.getExtras().get("previous_intent");
                        if (intent3 != null && (packageManager = getPackageManager()) != null && (queryIntentServices = packageManager.queryIntentServices(intent3, 576)) != null && !queryIntentServices.isEmpty() && (resolveInfo = queryIntentServices.get(0)) != null && resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.exported) {
                            if (!z) {
                                startService(intent3);
                            } else {
                                p.b("LinkProxyActivity", "service's exported is ".concat(String.valueOf(z)));
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (Exception e3) {
                    p.a("LinkProxyActivity", e3.toString(), e3);
                }
            }
            finish();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
        }
    }
}
