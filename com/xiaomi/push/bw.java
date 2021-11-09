package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class bw extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bu f70732a;

    public bw(bu buVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70732a = buVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo187a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "10054" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        String c2;
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("exec== DbSizeControlJob");
            c2 = this.f70732a.c();
            context = this.f70732a.f165a;
            bz bzVar = new bz(c2, new WeakReference(context));
            context2 = this.f70732a.f165a;
            cg.a(context2).a(bzVar);
            this.f70732a.b("check_time");
        }
    }
}
