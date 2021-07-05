package com.kwad.sdk.reward.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ap;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.reward.d implements ap.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f38820b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f38821c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f38822d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f38823e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38823e = new BroadcastReceiver(this) { // from class: com.kwad.sdk.reward.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f38824a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38824a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) {
                    String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    Message obtainMessage = this.f38824a.f38820b.obtainMessage(BaseActivity.DIALOG_LOADING);
                    obtainMessage.obj = schemeSpecificPart;
                    obtainMessage.sendToTarget();
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
            ((com.kwad.sdk.reward.d) this).f39062a.f38817g.registerReceiver(this.f38823e, intentFilter);
        }
    }

    private void f() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f39062a.f38817g) == null) {
            return;
        }
        activity.unregisterReceiver(this.f38823e);
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f38821c = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f39062a.f38816f);
            this.f38822d = ((com.kwad.sdk.reward.d) this).f39062a.f38819i;
            this.f38820b = new ap(this);
            e();
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 242 && (obj = message.obj) != null && obj.equals(this.f38821c.adBaseInfo.appPackageName)) {
            com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.d) this).f39062a.f38812b;
            if (bVar != null) {
                bVar.e();
            }
            this.f38822d.h();
            ((com.kwad.sdk.reward.d) this).f39062a.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            f();
        }
    }
}
