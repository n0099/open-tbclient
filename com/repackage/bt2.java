package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public class bt2 extends vz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer M0;

    /* loaded from: classes5.dex */
    public class a extends s12 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt2 c;

        public a(bt2 bt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bt2Var;
        }

        @Override // com.repackage.s12, com.repackage.v12
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                hx1.k("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i);
            }
        }

        @Override // com.repackage.s12, com.repackage.v12
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    hx1.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                    a73.K("wechatH5Action", "intoPayment", 0);
                    this.c.M0.cancel();
                    this.c.M0 = null;
                    vz1.Y2();
                    return false;
                }
                return super.b(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.s12, com.repackage.v12
        public void c(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i + " description = " + str;
                hx1.k("SwanAppWxPayFragment", str3);
                a73.H(false, "wechatH5Action", a73.m(str2, str3));
            }
        }

        @Override // com.repackage.s12, com.repackage.v12
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                hx1.k("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // com.repackage.s12, com.repackage.v12
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                hx1.k("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // com.repackage.s12, com.repackage.v12
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                hx1.k("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt2 a;

        public b(bt2 bt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.k("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
                a73.K("wechatH5Action", "outOfTime", 0);
            }
        }
    }

    public bt2() {
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

    @Override // com.repackage.vz1, com.repackage.nz1
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.U1(view2);
            this.l0.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f01e7));
            x2(false);
        }
    }

    @Override // com.repackage.vz1
    public void W2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00dc, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.repackage.vz1
    public v12 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (v12) invokeV.objValue;
    }

    public Timer i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            hx1.k("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e) {
                if (vz1.L0) {
                    e.printStackTrace();
                }
                hx1.k("SwanAppWxPayFragment", e.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }

    @Override // com.repackage.vz1
    public qm1 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.M0 == null) {
                this.M0 = i3();
            }
            return b72.U().f0().i(getContext());
        }
        return (qm1) invokeV.objValue;
    }
}
