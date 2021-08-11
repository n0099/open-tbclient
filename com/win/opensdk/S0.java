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
public class S0 implements G1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76501a;

    /* renamed from: b  reason: collision with root package name */
    public Context f76502b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76503c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76504d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76505e;

    /* renamed from: f  reason: collision with root package name */
    public Info f76506f;

    /* renamed from: g  reason: collision with root package name */
    public h0 f76507g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f76508h;

    /* renamed from: i  reason: collision with root package name */
    public m1 f76509i;

    /* renamed from: j  reason: collision with root package name */
    public long f76510j;
    public Handler k;

    public S0(Context context, String str) {
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
        this.k = new P0(this);
        this.f76502b = context;
        this.f76501a = str;
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f76505e = false;
            this.f76506f = info;
            this.f76510j = System.currentTimeMillis();
            if (b() && this.f76506f.getType() == 21) {
                z = true;
            }
            if (z) {
                if (a()) {
                    this.f76508h.onLoaded();
                    return;
                }
                h0 h0Var = new h0(this.f76502b);
                this.f76507g = h0Var;
                h0Var.f76655a = new R0(this);
                this.f76507g.a(this.f76506f.getLoad(), this.f76506f);
                this.k.sendEmptyMessageDelayed(11, this.f76506f.getWt() * 1000);
                return;
            }
            this.f76508h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // com.win.opensdk.G1
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f76506f.getId() + this.f76501a)) {
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != -1122984843) {
                    if (hashCode != -1122893139) {
                        if (hashCode == 109719091 && str2.equals("is_click")) {
                            c2 = 0;
                        }
                    } else if (str2.equals("is_display")) {
                        c2 = 2;
                    }
                } else if (str2.equals("is_dismiss")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    this.f76508h.onClicked();
                } else if (c2 == 1) {
                    this.f76508h.onInterstitialDismissed();
                } else if (c2 != 2) {
                } else {
                    this.f76508h.onInterstitialDisplayed();
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f76503c && !this.f76505e && b() && !this.f76506f.isShown() && this.f76506f.isEffective() : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f76506f != null : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b() && this.f76506f.getType() == 21 : invokeV.booleanValue;
    }
}
