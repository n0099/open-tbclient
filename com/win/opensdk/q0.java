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
public class q0 implements e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42621a;

    /* renamed from: b  reason: collision with root package name */
    public Context f42622b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f42623c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42624d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42625e;

    /* renamed from: f  reason: collision with root package name */
    public Info f42626f;

    /* renamed from: g  reason: collision with root package name */
    public K f42627g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f42628h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f42629i;
    public long j;
    public Handler k;

    public q0(Context context, String str) {
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
        this.k = new n0(this);
        this.f42622b = context;
        this.f42621a = str;
    }

    public final void a(Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, info) == null) {
            boolean z = false;
            this.f42625e = false;
            this.f42626f = info;
            this.j = System.currentTimeMillis();
            if (b() && this.f42626f.getType() == 21) {
                z = true;
            }
            if (z) {
                if (a()) {
                    this.f42628h.onLoaded();
                    return;
                }
                K k = new K(this.f42622b);
                this.f42627g = k;
                k.f42374a = new p0(this);
                this.f42627g.a(this.f42626f.getLoad(), this.f42626f);
                this.k.sendEmptyMessageDelayed(11, this.f42626f.getWt() * 1000);
                return;
            }
            this.f42628h.onFail(PBError.PID_TYPE_ERROR);
        }
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            if (TextUtils.equals(str, this.f42626f.getId() + this.f42621a)) {
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
                    this.f42628h.onClicked();
                } else if (c2 == 1) {
                    this.f42628h.onInterstitialDismissed();
                } else if (c2 != 2) {
                } else {
                    this.f42628h.onInterstitialDisplayed();
                }
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42623c && !this.f42625e && b() && !this.f42626f.isShown() && this.f42626f.isEffective() : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42626f != null : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b() && this.f42626f.getType() == 21 : invokeV.booleanValue;
    }
}
