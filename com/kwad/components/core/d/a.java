package com.kwad.components.core.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.f;
import com.kwad.sdk.core.a.h;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.w;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
/* loaded from: classes5.dex */
public class a extends d implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String Et;
    public long Eu;
    public String Ev;
    public Context mContext;

    public a() {
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

    private void ai(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            b.i("EncryptComponentsImpl", "初次获取Gid: initGId");
            KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback(this) { // from class: com.kwad.components.core.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a Ew;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Ew = this;
                }

                @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
                public final void onFailed(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        b.e("EncryptComponentsImpl", "初次获取Gid: initGId onFailed errorCode:" + i + "errorMessage :" + str);
                    }
                }

                @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
                public final void onSuccess(String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                        b.d("SDKPrivateSafetyData", "deviceInfo：" + str2);
                        this.Ew.am(str2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, str) == null) || this.mContext == null || ax.dT(str) || ax.V(nf(), str)) {
            return;
        }
        this.Ev = str;
        w.K(this.mContext, str);
    }

    private void na() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            String co = w.co(this.mContext);
            String AE = az.AE();
            if (TextUtils.isEmpty(co)) {
                w.E(this.mContext, AE);
            } else if (TextUtils.equals(co, AE)) {
            } else {
                this.Et = "";
                this.Eu = 0L;
                this.Ev = "";
                w.D(this.mContext, "");
                w.f(this.mContext, this.Eu);
                w.K(this.mContext, this.Ev);
                w.E(this.mContext, AE);
            }
        }
    }

    private String nd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (TextUtils.isEmpty(this.Et)) {
                this.Et = w.cl(this.mContext);
            }
            return this.Et;
        }
        return (String) invokeV.objValue;
    }

    private long ne() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.Eu == 0) {
                this.Eu = w.cm(this.mContext);
            }
            return this.Eu;
        }
        return invokeV.longValue;
    }

    private String nf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (TextUtils.isEmpty(this.Ev)) {
                this.Ev = w.cp(this.mContext);
            }
            return this.Ev;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.f
    public final void an(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.mContext == null || ax.dT(str) || ax.V(nd(), str)) {
            return;
        }
        try {
            this.Et = str;
            w.D(this.mContext, str);
            KWEGIDDFP.instance().setEgid(this.mContext, str);
        } catch (Throwable th) {
            b.e("EncryptComponentsImpl", "setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sdkConfig) == null) {
            try {
                this.mContext = context;
                na();
                ai(context);
            } catch (Throwable th) {
                b.e("EncryptComponentsImpl", "initGId error : " + th);
            }
        }
    }

    @Override // com.kwad.sdk.components.f
    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.mContext == null || j <= 0 || j == ne()) {
            return;
        }
        this.Eu = j;
        w.f(this.mContext, j);
    }

    @Override // com.kwad.sdk.components.f
    public final String nb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (com.kwad.sdk.core.config.d.rW() || System.currentTimeMillis() >= ne() || TextUtils.isEmpty(nd())) ? nf() : "" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.f
    public final h nc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new com.kwad.sdk.core.a.a() : (h) invokeV.objValue;
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return -200;
        }
        return invokeV.intValue;
    }
}
