package com.ss.android.downloadlib.activity;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.d.b.l;
import d.l.a.d.f;
import d.l.a.d.h;
import d.l.a.e.a.d;
/* loaded from: classes7.dex */
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
                f.e.b().d("handleIntent is null");
                d.q(this);
            }
            String stringExtra = getIntent().getStringExtra("p");
            long longExtra = getIntent().getLongExtra("id", 0L);
            if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
                f.e.b().d("getPackage or id is null");
                d.q(this);
            }
            int optInt = l.v().optInt("ab", 0);
            h.n.i(this, stringExtra, longExtra, optInt == 1);
            if (optInt != 1) {
                d.q(this);
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onPause();
            d.q(this);
        }
    }
}
