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
    public String f77236a;

    /* renamed from: b  reason: collision with root package name */
    public Context f77237b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77238c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77239d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f77240e;

    /* renamed from: f  reason: collision with root package name */
    public Info f77241f;

    /* renamed from: g  reason: collision with root package name */
    public h0 f77242g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f77243h;

    /* renamed from: i  reason: collision with root package name */
    public m1 f77244i;

    /* renamed from: j  reason: collision with root package name */
    public long f77245j;
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
        this.f77237b = context;
        this.f77236a = str;
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f77240e = false;
            this.f77241f = info;
            this.f77245j = System.currentTimeMillis();
            if (b() && this.f77241f.getType() == 21) {
                z = true;
            }
            if (z) {
                if (a()) {
                    this.f77243h.onLoaded();
                    return;
                }
                h0 h0Var = new h0(this.f77237b);
                this.f77242g = h0Var;
                h0Var.f77390a = new R0(this);
                this.f77242g.a(this.f77241f.getLoad(), this.f77241f);
                this.k.sendEmptyMessageDelayed(11, this.f77241f.getWt() * 1000);
                return;
            }
            this.f77243h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // com.win.opensdk.G1
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f77241f.getId() + this.f77236a)) {
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
                    this.f77243h.onClicked();
                } else if (c2 == 1) {
                    this.f77243h.onInterstitialDismissed();
                } else if (c2 != 2) {
                } else {
                    this.f77243h.onInterstitialDisplayed();
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f77238c && !this.f77240e && b() && !this.f77241f.isShown() && this.f77241f.isEffective() : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f77241f != null : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b() && this.f77241f.getType() == 21 : invokeV.booleanValue;
    }
}
