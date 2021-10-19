package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes10.dex */
public class bp implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77761a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.clientreport.processor.c f162a;

    public bp() {
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

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f77761a = context;
        }
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f162a = cVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        bt a2;
        String str;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.f162a != null) {
                    this.f162a.a();
                }
                com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
                if (this.f162a instanceof IEventProcessor) {
                    a2 = bt.a(this.f77761a);
                    str = "event_last_upload_time";
                    currentTimeMillis = System.currentTimeMillis();
                } else if (!(this.f162a instanceof IPerfProcessor)) {
                    return;
                } else {
                    a2 = bt.a(this.f77761a);
                    str = "perf_last_upload_time";
                    currentTimeMillis = System.currentTimeMillis();
                }
                a2.m191a("sp_client_report_status", str, currentTimeMillis);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }
}
