package com.kwai.video.ksvodplayerkit.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.hodor.VodAdaptivePreloadPriorityTask;
import com.kwai.video.ksvodplayerkit.b.m;
import com.kwai.video.ksvodplayerkit.i;
/* loaded from: classes7.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f39922h;

    /* renamed from: i  reason: collision with root package name */
    public VodAdaptivePreloadPriorityTask.VodAdaptiveInit f39923i;

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f39924a.a(false);
            if (this.f39924a.f() <= 0 || this.f39924a.e() || this.f39925b.get() >= i.a().e() || !this.f39924a.a()) {
                return null;
            }
            this.f39922h = m.a(this.f39924a.g());
            VodAdaptivePreloadPriorityTask vodAdaptivePreloadPriorityTask = new VodAdaptivePreloadPriorityTask(this.f39922h, this.f39923i);
            this.f39928e = vodAdaptivePreloadPriorityTask;
            return vodAdaptivePreloadPriorityTask;
        }
        return (AbstractHodorPreloadTask) invokeV.objValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            VodAdaptivePreloadPriorityTask.VodAdaptiveInit vodAdaptiveInit = new VodAdaptivePreloadPriorityTask.VodAdaptiveInit();
            this.f39923i = vodAdaptiveInit;
            vodAdaptiveInit.rateConfig = i.a().k();
            this.f39923i.lowDevice = i.a().l();
            this.f39923i.netType = com.kwai.video.ksvodplayerkit.c.a.d(context);
            this.f39923i.devResHeigh = com.kwai.video.ksvodplayerkit.c.c.b(context);
            this.f39923i.devResWidth = com.kwai.video.ksvodplayerkit.c.c.a(context);
        }
    }

    @Override // com.kwai.video.ksvodplayerkit.d.b
    public AbstractHodorPreloadTask b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f39928e == null) {
                this.f39928e = new VodAdaptivePreloadPriorityTask(this.f39922h, this.f39923i);
            }
            return this.f39928e;
        }
        return (AbstractHodorPreloadTask) invokeV.objValue;
    }
}
