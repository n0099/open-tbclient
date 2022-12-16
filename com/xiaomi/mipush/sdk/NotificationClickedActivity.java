package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes8.dex */
public final class NotificationClickedActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BroadcastReceiver a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f69a;

    public NotificationClickedActivity() {
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

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, intent) == null) || intent == null) {
            return;
        }
        try {
            Intent intent2 = (Intent) intent.getParcelableExtra("mipush_serviceIntent");
            if (intent2 != null) {
                intent2.setComponent(new ComponentName(getPackageName(), "com.xiaomi.mipush.sdk.PushMessageHandler"));
                intent2.putExtra("is_clicked_activity_call", true);
                com.xiaomi.channel.commonutils.logger.b.b("clicked activity start service.");
                startService(intent2);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = 1;
            attributes.width = 1;
            attributes.gravity = BadgeDrawable.TOP_START;
            window.setAttributes(attributes);
            Handler handler = new Handler();
            this.f69a = handler;
            handler.postDelayed(new ac(this), 3000L);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_clicked_activity_finish");
            ad adVar = new ad(this);
            this.a = adVar;
            try {
                registerReceiver(adVar, intentFilter, d.a(this), null);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            this.f69a.removeCallbacksAndMessages(null);
            try {
                unregisterReceiver(this.a);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            a(getIntent());
        }
    }
}
