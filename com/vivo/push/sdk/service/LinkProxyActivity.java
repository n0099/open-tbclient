package com.vivo.push.sdk.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.vivo.push.util.ag;
import com.vivo.push.util.u;
import java.util.List;
/* loaded from: classes8.dex */
public class LinkProxyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LinkProxyActivity() {
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

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5 A[Catch: Exception -> 0x00e7, TryCatch #2 {Exception -> 0x00e7, blocks: (B:27:0x0098, B:29:0x009e, B:31:0x00aa, B:33:0x00b0, B:35:0x00b8, B:38:0x00bf, B:40:0x00c7, B:42:0x00cb, B:47:0x00d5, B:48:0x00d9), top: B:62:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9 A[Catch: Exception -> 0x00e7, TRY_LEAVE, TryCatch #2 {Exception -> 0x00e7, blocks: (B:27:0x0098, B:29:0x009e, B:31:0x00aa, B:33:0x00b0, B:35:0x00b8, B:38:0x00bf, B:40:0x00c7, B:42:0x00cb, B:47:0x00d5, B:48:0x00d9), top: B:62:0x0098 }] */
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
                u.d("LinkProxyActivity", "enter RequestPermissionsActivity onCreate, intent is null, finish");
                finish();
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
                u.b("LinkProxyActivity", "enter onCreate error ", th);
            }
            String packageName = getPackageName();
            u.d("LinkProxyActivity", hashCode() + " enter onCreate " + packageName);
            if ("com.vivo.abe".equals(packageName)) {
                try {
                    if (intent == null) {
                        u.d("LinkProxyActivity", "adapterToService intent is null");
                    } else if (intent.getExtras() == null) {
                        u.d("LinkProxyActivity", "adapterToService getExtras() is null");
                    } else {
                        Intent intent2 = (Intent) intent.getExtras().get("previous_intent");
                        if (intent2 == null) {
                            u.d("LinkProxyActivity", "adapterToService proxyIntent is null");
                        } else {
                            ag.a(this, intent2);
                        }
                    }
                } catch (Exception e) {
                    u.a("LinkProxyActivity", e.toString(), e);
                }
            } else {
                try {
                    if (intent.getExtras() != null) {
                        Intent intent3 = (Intent) intent.getExtras().get("previous_intent");
                        if (intent3 != null && (packageManager = getPackageManager()) != null && (queryIntentServices = packageManager.queryIntentServices(intent3, 576)) != null && !queryIntentServices.isEmpty() && (resolveInfo = queryIntentServices.get(0)) != null && resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.exported) {
                            if (!z) {
                                startService(intent3);
                            } else {
                                u.b("LinkProxyActivity", "service's exported is ".concat(String.valueOf(z)));
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (Exception e2) {
                    u.a("LinkProxyActivity", e2.toString(), e2);
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            u.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
        }
    }
}
