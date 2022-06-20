package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes8.dex */
public class bs implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.clientreport.processor.c f140a;

    public bs() {
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

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
        }
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f140a = cVar;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        bw a;
        String str;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.f140a != null) {
                    this.f140a.a();
                }
                com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
                if (this.f140a instanceof IEventProcessor) {
                    a = bw.a(this.a);
                    str = "event_last_upload_time";
                    currentTimeMillis = System.currentTimeMillis();
                } else if (!(this.f140a instanceof IPerfProcessor)) {
                    return;
                } else {
                    a = bw.a(this.a);
                    str = "perf_last_upload_time";
                    currentTimeMillis = System.currentTimeMillis();
                }
                a.m206a("sp_client_report_status", str, currentTimeMillis);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
