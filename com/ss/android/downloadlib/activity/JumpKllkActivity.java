package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.e.c;
import com.ss.android.downloadlib.g.h;
/* loaded from: classes2.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JumpKllkActivity() {
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

    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (getIntent() == null) {
                c.a().a("handleIntent is null");
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
            String stringExtra = getIntent().getStringExtra("p");
            long longExtra = getIntent().getLongExtra("id", 0L);
            if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
                c.a().a("getPackage or id is null");
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
            int optInt = j.i().optInt("ab", 0);
            h.a(this, stringExtra, longExtra, optInt == 1);
            if (optInt != 1) {
                com.ss.android.socialbase.appdownloader.c.a((Activity) this);
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onPause();
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }
}
