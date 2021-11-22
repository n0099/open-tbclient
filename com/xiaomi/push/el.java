package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
/* loaded from: classes2.dex */
public class el {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile el f71801a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f326a;

    public el(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f326a = context;
    }

    public static el a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f71801a == null) {
                synchronized (el.class) {
                    if (f71801a == null) {
                        f71801a = new el(context);
                    }
                }
            }
            return f71801a;
        }
        return (el) invokeL.objValue;
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, aVar) == null) {
            if (aVar instanceof PerfClientReport) {
                ClientReportClient.reportPerf(this.f326a, (PerfClientReport) aVar);
            } else if (aVar instanceof EventClientReport) {
                ClientReportClient.reportEvent(this.f326a, (EventClientReport) aVar);
            }
        }
    }

    public void a(String str, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || i2 < 0 || j2 < 0 || j <= 0) {
            return;
        }
        PerfClientReport a2 = ek.a(this.f326a, i2, j, j2);
        a2.setAppPackageName(str);
        a2.setSdkVersion("3_8_5");
        a(a2);
    }

    public void a(String str, Intent intent, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, intent, i2, str2) == null) || intent == null) {
            return;
        }
        a(str, ek.m289a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID), i2, System.currentTimeMillis(), str2);
    }

    public void a(String str, Intent intent, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, intent, str2) == null) || intent == null) {
            return;
        }
        a(str, ek.m289a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID), 5001, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, int i2, long j, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Integer.valueOf(i2), Long.valueOf(j), str4}) == null) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport a2 = ek.a(this.f326a, str2, str3, i2, j, str4);
        a2.setAppPackageName(str);
        a2.setSdkVersion("3_8_5");
        a(a2);
    }

    public void a(String str, String str2, String str3, int i2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, Integer.valueOf(i2), str4}) == null) {
            a(str, str2, str3, i2, System.currentTimeMillis(), str4);
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
        }
    }

    public void c(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, str2, str3, str4) == null) {
            a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
        }
    }
}
