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
/* loaded from: classes10.dex */
public class k2 implements G1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f77437a;

    /* renamed from: b  reason: collision with root package name */
    public Context f77438b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77439c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77440d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f77441e;

    /* renamed from: f  reason: collision with root package name */
    public Info f77442f;

    /* renamed from: g  reason: collision with root package name */
    public h0 f77443g;

    /* renamed from: h  reason: collision with root package name */
    public PBVideoListener f77444h;

    /* renamed from: i  reason: collision with root package name */
    public m1 f77445i;

    /* renamed from: j  reason: collision with root package name */
    public long f77446j;
    public Handler k;

    public k2(Context context, String str) {
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
        this.k = new h2(this);
        this.f77438b = context;
        this.f77437a = str;
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f77441e = false;
            this.f77442f = info;
            this.f77446j = System.currentTimeMillis();
            if (b() && this.f77442f.getType() == 41) {
                z = true;
            }
            if (z) {
                if (a()) {
                    this.f77444h.onLoaded();
                    return;
                }
                h0 h0Var = new h0(this.f77438b);
                this.f77443g = h0Var;
                h0Var.f77390a = new j2(this);
                this.f77443g.a(this.f77442f.getLoad(), this.f77442f);
                this.k.sendEmptyMessageDelayed(11, this.f77442f.getWt() * 1000);
                return;
            }
            this.f77444h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // com.win.opensdk.G1
    public void a(String str, String str2, Object obj) {
        long j2;
        PBVideoListener pBVideoListener;
        PBError pBError;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f77442f.getId() + this.f77437a)) {
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
                    this.f77444h.onClicked();
                } else if (c2 == 1) {
                    this.f77444h.onRewardedAdClosed();
                } else if (c2 == 2) {
                    this.f77444h.onRewardedAdOpened();
                } else if (c2 != 3) {
                    if (c2 != 4) {
                        return;
                    }
                    if (!N.e(this.f77438b)) {
                        pBVideoListener = this.f77444h;
                        pBError = PBError.NO_NETWORK;
                    } else if (obj != null) {
                        this.f77444h.onRewardedShowFail((String) obj);
                        return;
                    } else {
                        pBVideoListener = this.f77444h;
                        pBError = PBError.UNKNOWN;
                    }
                    pBVideoListener.onRewardedShowFail(pBError.getMsg());
                } else if (!N.e(this.f77438b) || obj == null) {
                    this.f77444h.onUserEarnedReward(false, 0L);
                } else {
                    try {
                        j2 = ((Long) obj).longValue();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        j2 = 0;
                    }
                    if (j2 <= 0) {
                        this.f77444h.onUserEarnedReward(false, j2);
                    } else {
                        this.f77444h.onUserEarnedReward(true, j2);
                    }
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f77439c && !this.f77441e && b() && !this.f77442f.isShown() && this.f77442f.isEffective() : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f77442f != null : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b() && this.f77442f.getType() == 41 : invokeV.booleanValue;
    }
}
