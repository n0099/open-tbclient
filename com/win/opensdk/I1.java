package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class I1 implements e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42360a;

    /* renamed from: b  reason: collision with root package name */
    public Context f42361b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42362c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42363d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42364e;

    /* renamed from: f  reason: collision with root package name */
    public Info f42365f;

    /* renamed from: g  reason: collision with root package name */
    public K f42366g;

    /* renamed from: h  reason: collision with root package name */
    public PBVideoListener f42367h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f42368i;
    public long j;
    public Handler k;

    public I1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new F1(this);
        this.f42361b = context;
        this.f42360a = str;
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f42364e = false;
            this.f42365f = info;
            this.j = System.currentTimeMillis();
            if (b() && this.f42365f.getType() == 41) {
                z = true;
            }
            if (z) {
                if (a()) {
                    this.f42367h.onLoaded();
                    return;
                }
                K k = new K(this.f42361b);
                this.f42366g = k;
                k.f42374a = new H1(this);
                this.f42366g.a(this.f42365f.getLoad(), this.f42365f);
                this.k.sendEmptyMessageDelayed(11, this.f42365f.getWt() * 1000);
                return;
            }
            this.f42367h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f42365f.getId() + this.f42360a)) {
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1398725913:
                        if (str2.equals("VIDEO_USER_EARNED_REWARD")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1122984843:
                        if (str2.equals("is_dismiss")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1122893139:
                        if (str2.equals("is_display")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -707154884:
                        if (str2.equals("VIDEO_SHOW_FAIL")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 109719091:
                        if (str2.equals("is_click")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    this.f42367h.onClicked();
                } else if (c2 == 1) {
                    this.f42367h.onRewardedAdClosed();
                } else if (c2 == 2) {
                    this.f42367h.onRewardedAdOpened();
                } else if (c2 != 3) {
                    if (c2 != 4) {
                        return;
                    }
                    if (!z.e(this.f42361b)) {
                        pBVideoListener = this.f42367h;
                        pBError = PBError.NO_NETWORK;
                    } else if (obj != null) {
                        this.f42367h.onRewardedShowFail((String) obj);
                        return;
                    } else {
                        pBVideoListener = this.f42367h;
                        pBError = PBError.UNKNOWN;
                    }
                    pBVideoListener.onRewardedShowFail(pBError.getMsg());
                } else if (!z.e(this.f42361b) || obj == null) {
                    this.f42367h.onUserEarnedReward(false, 0L);
                } else {
                    try {
                        j = ((Long) obj).longValue();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        j = 0;
                    }
                    if (j <= 0) {
                        this.f42367h.onUserEarnedReward(false, j);
                    } else {
                        this.f42367h.onUserEarnedReward(true, j);
                    }
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42362c && !this.f42364e && b() && !this.f42365f.isShown() && this.f42365f.isEffective() : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42365f != null : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b() && this.f42365f.getType() == 41 : invokeV.booleanValue;
    }
}
