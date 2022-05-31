package com.repackage;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ly2;
/* loaded from: classes7.dex */
public class ss3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ly2 a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ DialogInterface.OnClickListener e;
        public final /* synthetic */ ss3 f;

        public a(ss3 ss3Var, Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss3Var, activity, str, str2, Boolean.valueOf(z), onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ss3Var;
            this.a = activity;
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a != null && this.f.a.isShowing()) {
                    this.f.a.dismiss();
                }
                Activity activity = this.a;
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                ly2.a d = this.f.d(this.a, this.b, this.c, this.d, this.e);
                this.f.a = d.X();
            }
        }
    }

    public ss3() {
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

    public final ly2.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener})) == null) {
            ly2.a aVar = new ly2.a(activity);
            aVar.x(str);
            aVar.a();
            aVar.n(new pe3());
            aVar.m(z);
            aVar.Q(R.color.obfuscated_res_0x7f060a62);
            aVar.f(true);
            aVar.P(str2, onClickListener);
            return aVar;
        }
        return (ly2.a) invokeCommon.objValue;
    }

    public void e() {
        ly2 ly2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ly2Var = this.a) == null) {
            return;
        }
        if (ly2Var.isShowing()) {
            this.a.dismiss();
        }
        this.a = null;
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener}) == null) {
            bd3.a0(new a(this, activity, str, str2, z, onClickListener));
        }
    }
}
