package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.i;
import com.huawei.hms.push.u;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
/* loaded from: classes10.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushMsgReceiver() {
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

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, context, intent) == null) && intent.hasExtra("selfshow_info")) {
            if (!u.a(context)) {
                HMSLog.i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
            }
            i.a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && context != null) {
            HMSLog.i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if (!"com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) && (!"com.huawei.intent.action.PUSH".equals(action) || HwBuildEx.VERSION.EMUI_SDK_INT >= 10)) {
                    HMSLog.i("PushMsgReceiver", "message can't be recognised.");
                } else {
                    a(context, intent);
                }
            } catch (Exception unused) {
                HMSLog.e("PushMsgReceiver", "intent has some error");
            }
        }
    }
}
