package com.win.opensdk;

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
import com.win.opensdk.core.Info;
/* loaded from: classes8.dex */
public class q2 implements L1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Info f;
    public g0 g;
    public PBVideoListener h;
    public r1 i;
    public long j;
    public Handler k;

    public q2(Context context, String str) {
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
        this.k = new n2(this, Looper.getMainLooper());
        this.b = context;
        this.a = str;
    }

    @Override // com.win.opensdk.L1
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
                    this.h.onRewardedAdClosed();
                } else if (c == 2) {
                    this.h.onRewardedAdOpened();
                } else if (c != 3) {
                } else {
                    if (!M.e(this.b) || obj == null) {
                        this.h.onUserEarnedReward(false, 0L);
                        return;
                    }
                    try {
                        j = ((Long) obj).longValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        j = 0;
                    }
                    if (j <= 0) {
                        this.h.onUserEarnedReward(false, j);
                    } else {
                        this.h.onUserEarnedReward(true, j);
                    }
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c && !this.e && b() && !this.f.isShown() && this.f.isEffective() : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f != null : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b() && this.f.getType() == 41 : invokeV.booleanValue;
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.e = false;
            this.f = info;
            this.j = System.currentTimeMillis();
            if (b() && this.f.getType() == 41) {
                z = true;
            }
            if (z) {
                if (a()) {
                    this.h.onLoaded();
                    return;
                }
                g0 g0Var = new g0(this.b);
                this.g = g0Var;
                g0Var.a = new p2(this);
                this.g.a(this.f.getLoad(), this.f);
                this.k.sendEmptyMessageDelayed(11, this.f.getWt() * 1000);
                return;
            }
            this.h.onFail(PBError.PID_TYPE_ERROR);
        }
    }
}
