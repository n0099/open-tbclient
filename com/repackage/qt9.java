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
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class qt9 implements mp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Info f;
    public cs9 g;
    public eq9 h;
    public tt9 i;
    public long j;
    public Handler k;

    public qt9(Context context, String str) {
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
        this.k = new et9(this, Looper.getMainLooper());
        this.b = context;
        this.a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.repackage.it9.a(java.lang.Object):void] */
    public static /* synthetic */ void b(qt9 qt9Var, Info info) {
        qt9Var.a(info);
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.e = false;
            this.f = info;
            this.j = System.currentTimeMillis();
            if (e() && this.f.getType() == 41) {
                z = true;
            }
            if (z) {
                if (c()) {
                    this.h.onLoaded();
                    return;
                }
                cs9 cs9Var = new cs9(this.b);
                this.g = cs9Var;
                cs9Var.a = new mt9(this);
                this.g.a(this.f.getLoad(), this.f);
                this.k.sendEmptyMessageDelayed(11, this.f.getWt() * 1000);
                return;
            }
            this.h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // com.repackage.mp9
    public void a(String str, String str2, Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f.getId() + this.a)) {
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1398725913:
                        if (str2.equals("VIDEO_USER_EARNED_REWARD")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1122984843:
                        if (str2.equals("is_dismiss")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1122893139:
                        if (str2.equals("is_display")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -707154884:
                        if (str2.equals("VIDEO_SHOW_FAIL")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 109719091:
                        if (str2.equals("is_click")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    this.h.onClicked();
                } else if (c == 1) {
                    this.h.f();
                } else if (c == 2) {
                    this.h.g();
                } else if (c != 3) {
                } else {
                    if (!pp9.H(this.b) || obj == null) {
                        this.h.c(false, 0L);
                        return;
                    }
                    try {
                        j = ((Long) obj).longValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        j = 0;
                    }
                    if (j <= 0) {
                        this.h.c(false, j);
                    } else {
                        this.h.c(true, j);
                    }
                }
            }
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c && !this.e && e() && !this.f.isShown() && this.f.isEffective() : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f != null : invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? e() && this.f.getType() == 41 : invokeV.booleanValue;
    }
}
