package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.eu;
import com.xiaomi.push.service.XMJobService;
@TargetApi(21)
/* loaded from: classes8.dex */
public class ew implements eu.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JobScheduler a;

    /* renamed from: a  reason: collision with other field name */
    public Context f323a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f324a;

    public ew(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f324a = false;
        this.f323a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.eu.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f324a = false;
            this.a.cancel(1);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f323a.getPackageName(), XMJobService.class.getName()));
            builder.setMinimumLatency(j);
            builder.setOverrideDeadline(j);
            builder.setRequiredNetworkType(1);
            builder.setPersisted(false);
            JobInfo build = builder.build();
            com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + build.getId() + " in " + j);
            this.a.schedule(builder.build());
        }
    }

    @Override // com.xiaomi.push.eu.a
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z || this.f324a) {
                long b = gc.b();
                if (z) {
                    a();
                    b -= SystemClock.elapsedRealtime() % b;
                }
                this.f324a = true;
                a(b);
            }
        }
    }

    @Override // com.xiaomi.push.eu.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f324a : invokeV.booleanValue;
    }
}
