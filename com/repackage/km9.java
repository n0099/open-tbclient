package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.PBInterstitialListener;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class km9 implements pl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Info f;
    public fo9 g;
    public PBInterstitialListener h;
    public wp9 i;
    public long j;
    public Handler k;

    public km9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new wl9(this, Looper.getMainLooper());
        this.b = context;
        this.a = str;
    }

    @Override // com.repackage.pl9
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f.getId() + this.a)) {
                char c = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1122984843) {
                    if (hashCode != -1122893139) {
                        if (hashCode == 109719091 && str2.equals("is_click")) {
                            c = 0;
                        }
                    } else if (str2.equals("is_display")) {
                        c = 2;
                    }
                } else if (str2.equals("is_dismiss")) {
                    c = 1;
                }
                if (c == 0) {
                    this.h.onClicked();
                } else if (c == 1) {
                    this.h.onInterstitialDismissed();
                } else if (c != 2) {
                } else {
                    this.h.onInterstitialDisplayed();
                }
            }
        }
    }

    public final void c(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, info) == null) {
            boolean z = false;
            this.e = false;
            this.f = info;
            this.j = System.currentTimeMillis();
            if (f() && this.f.getType() == 21) {
                z = true;
            }
            if (z) {
                if (d()) {
                    this.h.onLoaded();
                    return;
                }
                fo9 fo9Var = new fo9(this.b);
                this.g = fo9Var;
                fo9Var.a = new im9(this);
                this.g.a(this.f.getLoad(), this.f);
                this.k.sendEmptyMessageDelayed(11, this.f.getWt() * 1000);
                return;
            }
            this.h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c && !this.e && f() && !this.f.isShown() && this.f.isEffective() : invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f != null : invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f() && this.f.getType() == 21 : invokeV.booleanValue;
    }
}
